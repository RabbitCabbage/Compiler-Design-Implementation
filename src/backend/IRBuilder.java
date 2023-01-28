package backend;

import IR.*;
import IR.IRTypeGetter;
import IR.Instruction.*;
import ast.*;
import frontend.Symbols;
import util.Position;
import util.Scope;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class IRBuilder extends ASTVisitor {
    public LLVM llvm;
    public Symbols symbols;
    public Scope current_scope;
    Scope global_scope;
    public IRTypeGetter getter;
    public int if_statement_count;
    public int loop_statement_count;
    public Stack<Integer> loop_stack;
    public int call_statement_count;
    public int binary_expression_count;
    public int string_constant_count;
    public int short_cut_count;
    public String last_identifier_expression_reg;//记下的是上一个访问到的identifier的名字
    public int sext_instr_count;
    public int bracket_count;
    public int new_alternative_count;
    public int new_loop_count;
    public HashMap<String, Integer> variable_name_to_count;

    public IRBuilder(Symbols symbols) {
        this.symbols = symbols;     
        llvm = new LLVM(symbols);
        //增加一个处理global
        SuiteNode func_body = new SuiteNode(new Position(0,0));
        FunctionDefNode init_global_func = new FunctionDefNode("void",0,"kunkun_initialize_global_declarations",func_body,null,new Position(0,0));
        FunctionIR init_global = new FunctionIR(init_global_func);
        BlockIR entry_block = new BlockIR("entry");
        init_global.blocks.add(entry_block);
        llvm.functions.put("kunkun_initialize_global_declarations",init_global);

        getter = new IRTypeGetter(symbols,llvm);
        short_cut_count = 0;
        if_statement_count = 0;
        loop_statement_count = 0;
        call_statement_count = 0;
        binary_expression_count = 0;
        string_constant_count = 0;
        loop_stack = new Stack<>();
        sext_instr_count = 0;
        bracket_count = 0;
        new_alternative_count = 0;
        new_loop_count = 0;
        this.current_scope = new Scope(null);
        global_scope = this.current_scope;
        variable_name_to_count = new HashMap<>();
    }

    public FunctionIR current_function;//用来记下现在正在处理的函数，以便于给这个函数加block
    public BlockIR current_block;
    public boolean branch_is_returned = false;

    @Override
    public void visit(RootNode it) {
        it.classdefs.forEach(a -> a.accept(this));
        it.vardefs.forEach(a -> a.accept(this));
        it.funcdefs.forEach(a -> a.accept(this));
    }

    @Override
    public void visit(VariableDefNode it) {
        it.declarations.forEach(a -> {
            a.type = it.typename;
            a.dim = it.dim;
            a.accept(this);
        });
        if (it.is_global) {
            it.declarations.forEach(a -> {
                llvm.globalVars.put(a.name, new GlobalVarIR(a));
                //System.out.println(a.init.valueIR.values.get(0).number_value);
            });//收集变量定义
        }
    }

    @Override
    public void visit(DeclarationNode it) {
        StringBuilder reg_name = new StringBuilder();
        if(current_scope.parent==null)reg_name.append("@");
        else reg_name.append("%");
        reg_name.append(it.name);
        if(current_scope.containVariable(it.name,true)){
            int last_max = variable_name_to_count.get(it.name);
            variable_name_to_count.replace(it.name,last_max+1);
            reg_name.append(last_max+1);
            current_scope.variable_name_to_reg_name.put(it.name,reg_name.toString());
        }
        else {
            current_scope.variable_name_to_reg_name.put(it.name,reg_name.toString());
            variable_name_to_count.put(it.name,0);
        }
        current_scope.defineVariable(it.name,it,it.pos);
        if (current_block == null) {
            StringBuilder global_info = new StringBuilder();
            global_info.append(reg_name.toString());
            if (it.init != null) {
                PrimaryExpressionNode lhs = new PrimaryExpressionNode(it.pos,it.name);
                lhs.type = it.type;
                lhs.dim = it.dim;
                lhs.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
                AssignmentExpressionNode assign = new AssignmentExpressionNode(lhs,it.init,it.pos);
                assign.accept(this);
//                if(it.init.info_for_global_var!=null)global_info.append(" = dso_local global ").append(it.init.info_for_global_var).append("\n");
//                else {
                    global_info.append(" = dso_local global ").append(getter.getType(it.type,it.dim,null)).append(" 0\n");
//                }
            }else{
                global_info.append(" = dso_local global ").append(getter.getType(it.type,it.dim,null)).append(" 0\n");
            }
            it.info_for_global = global_info.toString();
            return;
        }
        if (it.init != null) {
            it.init.accept(this);
            String type = getter.getType(it.init.type,it.init.dim,it.init.get_reg);
            //System.out.println(type);
            AllocaInstruction alloc = new AllocaInstruction(reg_name.toString(), getter.getType(it.type,it.dim,null));
            current_block.addInstruction(alloc);
            if (it.init.get_value) {
                ValueUnit unit = it.init.valueIR.values.get(0);
                StoreInstruction store;
                if(it.type.equals("string")) {
                    StringBuilder resreg  = new StringBuilder();
                    resreg.append("%").append(current_function.reg_count++);
                    GetElementPtrInstruction gep = new GetElementPtrInstruction("i8",resreg.toString(),it.init.get_reg,it.init.valueIR.values.get(0).string_value);
                    current_block.addInstruction(gep);
                    store = new StoreInstruction(resreg.toString(), "i8*", reg_name.toString(), getter.getType(it.type,it.dim,null));
                }
                else  store = new StoreInstruction(unit, type, reg_name.toString());
                current_block.addInstruction(store);
            } else {
                //System.out.println(it.init.get_reg);
                StoreInstruction store = new StoreInstruction(it.init.get_reg, type, reg_name.toString(),getter.getType(it.type,it.dim,null));
                current_block.addInstruction(store);
            }
        } else {
            AllocaInstruction alloc = new AllocaInstruction(reg_name.toString(), getter.getType(it.type,it.dim,null));
            current_block.addInstruction(alloc);
        }
    }

    @Override
    public void visit(FunctionDefNode it) {
        current_scope = new Scope(current_scope);
        current_scope.function_paras_defined = true;
        current_function = new FunctionIR(it);
        llvm.functions.put(it.name, current_function);//收集函数定义
        current_block = new BlockIR("entry");
        StringBuilder reg_name = new StringBuilder();
        reg_name.append("%");
        it.parameterlist.forEach(a -> {
            reg_name.append(a.declare.name);
            if(current_scope.containVariable(a.declare.name,true)){
                int last_max = variable_name_to_count.get(a.declare.name);
                variable_name_to_count.replace(a.declare.name,last_max+1);
                reg_name.append(last_max+1);
                current_scope.variable_name_to_reg_name.put(a.declare.name,reg_name.toString());
            }
            else {
                current_scope.variable_name_to_reg_name.put(a.declare.name,reg_name.toString());
                variable_name_to_count.put(a.declare.name,0);
            }
            current_scope.defineVariable(a.declare.name,a.declare,a.declare.pos);
            current_function.para_names.add(reg_name.toString());
            AllocaInstruction alloca = new AllocaInstruction(a.declare.name + ".addr", getter.getType(a.type, a.dim,null));
            current_block.addInstruction(alloca);
            StoreInstruction store = new StoreInstruction(reg_name.toString(), getter.getType(a.type, a.dim,null), "%"+a.declare.name + ".addr",getter.getType(a.type, a.dim,null));
            current_block.addInstruction(store);
        });
        if(it.name.equals("main")){
            CallInstruction call_init_global = new CallInstruction("void","kunkun_initialize_global_declarations",0);
            current_block.addInstruction(call_init_global);
        }
        it.stmts.accept(this);//访问每一个具体的语句，把它翻译成llvm
        //System.out.print("function statement end ");
        //System.out.println(current_block.block_id);
        current_function.blocks.add(current_block);
        current_scope = current_scope.parent;
    }

    @Override
    public void visit(ClassDefNode it) {
        current_scope = new Scope(current_scope);
        ClassIR cls = new ClassIR(it);
        it.methoddefs.forEach(a -> {
            a.accept(this);
            cls.methods.add(new FunctionIR(a));
        });
        it.vardefs.forEach(a -> {
            //a.declarations.forEach(b -> b.accept(this));
            a.declarations.forEach(b -> cls.element_names.add(b.name));
            cls.elements.addAll(a.declarations);
        });
        llvm.classes.put(it.name, cls);//收集类定义
        current_scope = current_scope.parent;
    }
    @Override
    public void visit(SuiteNode it){
        boolean newed = false;
        if(!current_scope.function_paras_defined){
            current_scope = new Scope(current_scope);
            newed = true;
        } else current_scope.function_paras_defined = false;
        it.stmts.forEach(a->a.accept(this));
        if(newed)current_scope = current_scope.parent;
    }
    //在visit的时候把function内部的块串好，串起来，并且把其中的具体的statement放进去
    @Override
    public void visit(IfStatementNode it) {
        //现在current_block还在if的外面
        it.condition.accept(this);
        String cond = it.condition.get_reg;
        StringBuilder count = new StringBuilder();
        count.append(if_statement_count);
        if_statement_count++;
        BlockIR then_block = new BlockIR("if.then" + count.toString());
        BlockIR else_block = new BlockIR("if.else" + count.toString());
        BlockIR next_block = new BlockIR("if.end" + count.toString());
        BrInstruction br;
        if (it.elsestmt != null) {
            BrInstruction br_1 = new BrInstruction(cond, "if.then" + count.toString(), "if.else" + count.toString());
            br = br_1;
        } else {
            BrInstruction br_2 = new BrInstruction(cond, "if.then" + count.toString(), "if.end" + count.toString());
            br = br_2;
        }
        current_block.addInstruction(br);//现在if外面的块已经结束，下面是then，else和next
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        branch_is_returned = false;
        current_block = then_block;
        current_scope = new Scope(current_scope);
        it.thenstmt.accept(this);
        current_scope = current_scope.parent;
        if (!branch_is_returned) {
            BrInstruction then_br = new BrInstruction(null, "if.end" + count.toString(), null);
            current_block.addInstruction(then_br);
            current_function.blocks.add(current_block);
            //System.out.print(current_block.block_id);
        }

        if (it.elsestmt != null) {
            branch_is_returned = false;
            current_block = else_block;
            current_scope = new Scope(current_scope);
            it.elsestmt.accept(this);
            current_scope = current_scope.parent;
            if (!branch_is_returned) {
                BrInstruction else_br = new BrInstruction(null, "if.end" + count.toString(), null);
                current_block.addInstruction(else_br);
                current_function.blocks.add(current_block);
                //System.out.print(current_block.block_id);
            }
        }

        current_block = next_block;
    }

    @Override
    public void visit(CallExpressionNode it) {
        int call_reg;
        if (it.func.returntype.equals("void")) call_reg = 0;
        else call_reg = call_statement_count++;
        //System.out.println("NAME = " + it.func.name);
        CallInstruction call = new CallInstruction(getter.getType(it.func.returntype, it.func.returndim,null), it.func.name, call_reg);
        it.auguments.forEach(a -> {
            a.accept(this);
            StringBuilder para = new StringBuilder();
            //System.out.println(llvm.stringConstants.get(a.get_reg)+"\t"+a.get_reg);
            if(a.type.equals("string")&&a.get_value)para.append(getter.getType(a.type,a.dim,null)+" ").append(getter.getStringPointer(llvm.stringConstants.get(a.get_reg),a.get_reg));
            else para.append(getter.getType(a.type,a.dim,a.get_reg)).append(" %").append(a.get_reg);
            call.para.add(para.toString());
        });
        current_block.addInstruction(call);
        StringBuilder callx = new StringBuilder();
        callx.append("call").append(call_reg);
        it.get_reg = callx.toString();
    }

    @Override
    public void visit(WhileStatementNode it) {
        current_scope = new Scope(current_scope);
        current_scope.is_loop = true;
        loop_statement_count++;
        loop_stack.push(loop_statement_count);
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BrInstruction br_to_condition = new BrInstruction(null,"while.cond"+count.toString(),null);
        current_block.addInstruction(br_to_condition);
        current_function.blocks.add(current_block);
        BlockIR condition = new BlockIR("while.cond"+count.toString());
        it.condition.accept(this);
        String cond = it.condition.get_reg;
        BrInstruction cond_br_body = new BrInstruction(cond, "while.body" + count.toString(), "while.end" + count.toString());
        current_block.addInstruction(cond_br_body);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        BlockIR loopbody = new BlockIR("while.body" + count.toString());
        current_block = loopbody;
        it.stmt.accept(this);
        BrInstruction br_out = new BrInstruction(null, "while.cond" + count.toString(), null);
        current_block.addInstruction(br_out);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        BlockIR next_block = new BlockIR("while.end" + count.toString());
        current_block = next_block;
        loop_stack.pop();
        current_scope = current_scope.parent;
    }

    @Override
    public void visit(ForStatementNode it) {
        current_scope = new Scope(current_scope);
        current_scope.is_loop = true;
        loop_statement_count++;
        loop_stack.push(loop_statement_count);
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);

        if (it.var != null) it.var.accept(this);
        if(it.init != null) it.init.accept(this);

        BlockIR for_condition_block = new BlockIR("for.cond"+count.toString());
        BrInstruction br_to_for_condition = new BrInstruction(null,"for.cond"+count.toString(),null);
        current_block.addInstruction(br_to_for_condition);
        current_function.blocks.add(current_block);
        current_block = for_condition_block;
        it.condition.accept(this);
        String cond = it.condition.get_reg;
        BrInstruction br_to_loop = new BrInstruction(cond, "for.body"+count.toString(), "for.end"+count.toString());
        current_block.addInstruction(br_to_loop);
        current_function.blocks.add(current_block);
        BlockIR loopbody = new BlockIR("for.body" + count.toString());
        current_block = loopbody;
        it.stmts.accept(this);
        BrInstruction br_to_step = new BrInstruction(null, "for.inc" + count.toString(), null);
        current_block.addInstruction(br_to_step);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        BlockIR for_step = new BlockIR("for.inc" + count.toString());
        current_block = for_step;
        it.next.accept(this);
        BrInstruction step_br_to_cond = new BrInstruction(null,"for.cond"+count.toString(),null);
        current_block.addInstruction(step_br_to_cond);
        //System.out.print(current_block.block_id);
        //如果满足条件就去执行循环体，不满足条件就去执行后面的指令
        //执行完循环体直接就去执行for的step，执行完step再做检查
        BlockIR next = new BlockIR("for.end" + count.toString());
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        current_block = next;
        loop_stack.pop();
        current_scope = current_scope.parent;
    }

    @Override
    public void visit(BreakStatementNode it) {
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BlockIR next = new BlockIR("next_block_after_loop" + count.toString());
        BrInstruction br = new BrInstruction(null, "next_block_after_loop" + count.toString(), null);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        current_block = next;
    }

    @Override
    public void visit(ContinueStatementNode it) {
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BrInstruction br = new BrInstruction(null, "loop_body" + count.toString(), null);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        current_block = new BlockIR("loop_body" + count.toString());
    }

    @Override
    public void visit(ReturnStatementNode it) {
        branch_is_returned = true;
        if (it.value == null) {
            RetInstruction ret = new RetInstruction(null, null, true);
            current_block.addInstruction(ret);
            //current_function.blocks.add(current_block);
            return;
        }
        it.value.accept(this);
        if (it.value.get_value) {
            RetInstruction ret = new RetInstruction(it.value.valueIR.values.get(0), getter.getType(it.value.type, it.value.dim,it.value.get_reg));
            current_block.addInstruction(ret);
            //current_function.blocks.add(current_block);
        } else {
            RetInstruction ret = new RetInstruction(it.value.get_reg, getter.getType(it.value.type, it.value.dim,it.value.get_reg), false);
            current_block.addInstruction(ret);
            //current_function.blocks.add(current_block);
        }
        //System.out.print(current_block.block_id);
    }

    @Override
    public void visit(PrimaryExpressionNode it) {
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.identifierExpr) {
            Scope destination = current_scope.findScopeContaining(it.primaryExpression);
            String reg_name = destination.variable_name_to_reg_name.get(it.primaryExpression);//本身含有% @
            if (!it.visited_as_lhs) {
                LoadInstruction load = new LoadInstruction(current_function.reg_count++, (current_function.para_names.contains(it.primaryExpression) ? ("%"+it.primaryExpression + ".addr") : reg_name.toString()), getter.getType(it.type, it.dim,null));
                current_block.addInstruction(load);
                StringBuilder tmp = new StringBuilder();
                tmp.append(current_function.reg_count - 1);
                //tmp.append("IDENTIFIER");
                it.get_reg = "%"+tmp.toString();
                  last_identifier_expression_reg = (current_function.para_names.contains(it.primaryExpression) ? ("%"+it.primaryExpression + ".addr") : reg_name.toString());
            } else {
                it.get_reg = reg_name;
                  last_identifier_expression_reg = (current_function.para_names.contains(it.primaryExpression) ? ("%"+it.primaryExpression + ".addr") : reg_name.toString());
            }
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.stringLiteralExpr) {
            StringBuilder str = new StringBuilder();
            str.append(it.primaryExpression);
            str.deleteCharAt(0);
            str.deleteCharAt(str.length() - 1);
            it.primaryExpression = str.toString()+"\00";
            StringBuilder reg = new StringBuilder();
            reg.append(".str").append(string_constant_count++);
            llvm.stringConstants.put(reg.toString(), it.primaryExpression);
            it.get_reg = reg.toString();
            ValueUnit unit = new ValueUnit(null,it.primaryExpression,null);
            //System.out.println(it.primaryExpression);
            //System.out.println(unit.number_value);
            it.valueIR.values.add(unit);
            it.get_value = true;
            if(current_function== null){
                StringBuilder info = new StringBuilder();
                info.append("i8* getelementptr inbounds ([").append(it.primaryExpression.length()).append(" x i8], [").append(it.primaryExpression.length()).append(" x i8]* @").append(it.get_reg).append(", i32 0,i32 0)");
                it.info_for_global_var = info.toString();
            }
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.integerLiteralExpr) {
            ValueUnit unit = new ValueUnit(Integer.parseInt(it.primaryExpression), null, null);
            //System.out.println(it.primaryExpression);
            //System.out.println(unit.number_value);
            it.valueIR.values.add(unit);
            it.get_value = true;
            if(current_function == null){
                StringBuilder info = new StringBuilder();
                info.append("i32 ").append(it.primaryExpression);
                it.info_for_global_var = info.toString();
            }
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.boolLiteralExpr) {
            ValueUnit unit = new ValueUnit(null, null, Boolean.parseBoolean(it.primaryExpression));
            it.valueIR.values.add(unit);
            it.get_value = true;
            it.valueIR.values.add(unit);
            if(current_function == null){
                StringBuilder info = new StringBuilder();
                info.append("i1 ").append(it.primaryExpression);
            }
        }
    }
    @Override
    public void visit(BinaryExpressionNode it) {
        if(current_function == null){
            it.lhs.accept(this);
            it.rhs.accept(this);
            it.get_value = true;
            StringBuilder info = new StringBuilder();
            if(it.opcode.equals("/")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value/it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value/it.rhs.valueIR.values.get(0).number_value);
            } else if(it.opcode.equals("*")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value*it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value*it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("%")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value%it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value%it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("+")) {
                if(it.type.equals("int")){
                   ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value+it.rhs.valueIR.values.get(0).number_value,null,null);
                   it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value+it.rhs.valueIR.values.get(0).number_value);
               }
               else if(it.type.equals("string")){
                   ValueUnit unit = new ValueUnit(null,it.lhs.valueIR.values.get(0).string_value+it.rhs.valueIR.values.get(0).string_value,null);
                   it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value).append(it.rhs.valueIR.values.get(0).string_value);
               }
            }else if(it.opcode.equals("-")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value-it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value-it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("<<")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value<<it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value<<it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals(">>")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value>>it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value>>it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("&")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value&it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value&it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("|")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value|it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value|it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("^")) {
                ValueUnit unit = new ValueUnit(it.lhs.valueIR.values.get(0).number_value^it.rhs.valueIR.values.get(0).number_value,null,null);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value^it.rhs.valueIR.values.get(0).number_value);
            }else if(it.opcode.equals("<")) {
                if(it.type.equals("int")) {
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).number_value < it.rhs.valueIR.values.get(0).number_value);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value<it.rhs.valueIR.values.get(0).number_value);
                }else if(it.type.equals("string")){
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)<0);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)<0);
                }
            }else if(it.opcode.equals(">")) {
                if(it.type.equals("int")) {
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).number_value > it.rhs.valueIR.values.get(0).number_value);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value>it.rhs.valueIR.values.get(0).number_value);
                }else if(it.type.equals("string")){
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)>0);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)>0);
                }
            }else if(it.opcode.equals("<=")) {
                if(it.type.equals("int")) {
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).number_value <= it.rhs.valueIR.values.get(0).number_value);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value<=it.rhs.valueIR.values.get(0).number_value);
                }else if(it.type.equals("string")){
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)<=0);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)<=0);
                }
            }else if(it.opcode.equals(">=")) {
                if(it.type.equals("int")) {
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).number_value >= it.rhs.valueIR.values.get(0).number_value);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).number_value>=it.rhs.valueIR.values.get(0).number_value);
                }else if(it.type.equals("string")){
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)>=0);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)>=0);
                }
            }else if(it.opcode.equals("==")) {
                if(it.type.equals("int")) {
                    ValueUnit unit = new ValueUnit(null, null, Objects.equals(it.lhs.valueIR.values.get(0).number_value, it.rhs.valueIR.values.get(0).number_value));
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(Objects.equals(it.lhs.valueIR.values.get(0).number_value, it.rhs.valueIR.values.get(0).number_value));
                }else if(it.type.equals("string")){
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)==0);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)==0);
                }else if(it.type.equals("bool")){
                    ValueUnit unit = new ValueUnit(null,null,it.lhs.valueIR.values.get(0).bool_value==it.rhs.valueIR.values.get(0).bool_value);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).bool_value==it.rhs.valueIR.values.get(0).bool_value);
                }
            }else if(it.opcode.equals("!=")) {
                if(it.type.equals("int")) {
                    ValueUnit unit = new ValueUnit(null, null, !Objects.equals(it.lhs.valueIR.values.get(0).number_value, it.rhs.valueIR.values.get(0).number_value));
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(!Objects.equals(it.lhs.valueIR.values.get(0).number_value, it.rhs.valueIR.values.get(0).number_value));
                }else if(it.type.equals("string")){
                    ValueUnit unit = new ValueUnit(null, null, it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)!=0);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).string_value.compareTo(it.rhs.valueIR.values.get(0).string_value)!=0);
                }if(it.type.equals("bool")){
                    ValueUnit unit = new ValueUnit(null,null,it.lhs.valueIR.values.get(0).bool_value!=it.rhs.valueIR.values.get(0).bool_value);
                    it.valueIR.values.add(unit);
                    info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).bool_value!=it.rhs.valueIR.values.get(0).bool_value);
                }
            }else if(it.opcode.equals("&&")) {
                ValueUnit unit = new ValueUnit(null,null,it.lhs.valueIR.values.get(0).bool_value&&it.rhs.valueIR.values.get(0).bool_value);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).bool_value&&it.rhs.valueIR.values.get(0).bool_value);
            }else if(it.opcode.equals("||")) {
                ValueUnit unit = new ValueUnit(null,null,it.lhs.valueIR.values.get(0).bool_value||it.rhs.valueIR.values.get(0).bool_value);
                it.valueIR.values.add(unit);
                info.append(getter.getType(it.type,it.dim,null)).append(" ").append(it.lhs.valueIR.values.get(0).bool_value||it.rhs.valueIR.values.get(0).bool_value);
            }
            it.info_for_global_var = info.toString();
            return ;
        }
        if(it.opcode.equals("&&")){
            StringBuilder count = new StringBuilder();
            count.append(short_cut_count++);
            it.lhs.accept(this);
            BrInstruction short_cut_to_rhs = new BrInstruction(it.lhs.get_reg, "land.rhs"+count.toString(),"land.end"+count.toString());
            BlockIR rhs = new BlockIR("land.rhs"+count.toString());
            BlockIR next = new BlockIR("land.end"+count.toString());
            String former_block = current_block.block_id.toString();
            current_block.addInstruction(short_cut_to_rhs);
            current_function.blocks.add(current_block);
            current_block = rhs;
            it.rhs.accept(this);
            BrInstruction short_cut_end = new BrInstruction(null,"land.end"+count.toString(),null);
            current_block.addInstruction(short_cut_end);
            current_function.blocks.add(current_block);
            current_block = next;
            PhiInstruction short_cut_phi = new PhiInstruction(current_function.reg_count++,former_block,"false","land.rhs"+count.toString(),"%"+it.rhs.get_reg);
            it.get_reg = short_cut_phi.res_toString();
            current_block.addInstruction(short_cut_phi);
        }
        else if(it.opcode.equals("||")){
            StringBuilder count = new StringBuilder();
            count.append(short_cut_count++);
            it.lhs.accept(this);
            BrInstruction short_cut_to_rhs = new BrInstruction(it.lhs.get_reg, "land.end"+count.toString(),"land.rhs"+count.toString());
            BlockIR rhs = new BlockIR("land.rhs"+count.toString());
            BlockIR next = new BlockIR("land.end"+count.toString());
            String former_block = current_block.block_id.toString();
            current_block.addInstruction(short_cut_to_rhs);
            current_function.blocks.add(current_block);
            current_block = rhs;
            it.rhs.accept(this);
            BrInstruction short_cut_end = new BrInstruction(null,"land.end"+count.toString(),null);
            current_block.addInstruction(short_cut_end);
            current_function.blocks.add(current_block);
            current_block = next;
            PhiInstruction short_cut_phi = new PhiInstruction(current_function.reg_count++,former_block,"true","land.rhs"+count.toString(),"%"+it.rhs.get_reg);
            it.get_reg = short_cut_phi.res_toString();
            current_block.addInstruction(short_cut_phi);
        }
        else {
            it.lhs.accept(this);
            String lhs_reg;
            if (it.lhs.get_value) {
                if (it.lhs.type.equals("int")) lhs_reg = it.lhs.valueIR.values.get(0).toString();
                else if (it.lhs.type.equals("string"))
                    lhs_reg = "\"" + it.lhs.valueIR.values.get(0).string_value.toString() + "\"";
                else lhs_reg = it.lhs.valueIR.values.get(0).bool_value.toString();
            } else {
                lhs_reg = "%" + it.lhs.get_reg;
            }
            it.rhs.accept(this);
            String rhs_reg;
            if (it.rhs.get_value) {
                if (it.rhs.type.equals("int")) rhs_reg = it.rhs.valueIR.values.get(0).number_value.toString();
                else if (it.rhs.type.equals("string"))
                    rhs_reg = "\"" + it.rhs.valueIR.values.get(0).string_value.toString() + "\"";
                else rhs_reg = it.rhs.valueIR.values.get(0).bool_value.toString();
            } else {
                rhs_reg = "%" + it.rhs.get_reg;
            }
            int res_reg = binary_expression_count++;
            String type = getter.getType(it.lhs.type, it.lhs.dim,it.lhs.get_reg);
            BinaryInstruction binary = new BinaryInstruction(it.opcode, lhs_reg, rhs_reg, type, res_reg);
            it.get_reg = binary.res_toString();
            current_block.addInstruction(binary);
        }
    }

    @Override
    public void visit(ExpressionStatementNode it) {
        it.expression.accept(this);
    }

    @Override
    public void visit(AssignmentExpressionNode it) {
        boolean use_init_global = false;
        if(current_function == null){
            current_function = llvm.functions.get("kunkun_initialize_global_declarations");
            current_block = current_function.blocks.get(0);
            use_init_global = true;
        }
        it.lhs.visited_as_lhs = true;//说明是被用作左值，不用load等等
        it.lhs.accept(this);
        it.lhs.visited_as_lhs = false;
        it.rhs.accept(this);
        if (it.rhs.get_value) {
            //System.out.println("Store the value");
            StoreInstruction store = new StoreInstruction(it.rhs.valueIR.values.get(0), getter.getType(it.rhs.type,it.rhs.dim,it.rhs.get_reg),it.lhs.get_reg);
            current_block.addInstruction(store);
        } else {
            //System.out.println("Store the reg");
            //System.out.println(it.rhs.get_reg);
            StoreInstruction store = new StoreInstruction(it.rhs.get_reg, getter.getType(it.rhs.type, it.rhs.dim,it.rhs.get_reg), it.lhs.get_reg,getter.getType(it.lhs.type, it.lhs.dim,it.lhs.get_reg));
            //System.out.println(current_block.instrs.size());
            current_block.addInstruction(store);
            //System.out.println(current_block.instrs.size());
        }
        if(use_init_global){
            current_block = null;
            current_function = null;
        }
    }

    @Override
    public void visit(MemberCallExpressionNode it) {
        ClassIR object_class = llvm.classes.get(it.object.type);
        int index = object_class.element_names.indexOf(it.id);
        it.object.visited_as_lhs = true;
        it.object.accept(this);
        it.object.visited_as_lhs = false;
        StringBuilder resreg = new StringBuilder();
        resreg.append("%");
        resreg.append(current_function.reg_count++);
        GetElementPtrInstruction gep = new GetElementPtrInstruction(it.object.type, resreg.toString(), it.object.get_reg, index);
        current_block.addInstruction(gep);//get a pointer to pointer, that is pointer2
        LoadInstruction load_ptr1 = new LoadInstruction(current_function.reg_count++, resreg.toString(), object_class.elements.get(index).type);
        current_block.addInstruction(load_ptr1);
        StringBuilder ptr1reg = new StringBuilder();
        ptr1reg.append("%");
        ptr1reg.append(current_function.reg_count);
        LoadInstruction load_element = new LoadInstruction(current_function.reg_count++, ptr1reg.toString(), object_class.elements.get(index).type);
        current_block.addInstruction(load_element);
        StringBuilder elementreg = new StringBuilder();
        elementreg.append(current_function.reg_count);
        it.get_reg = elementreg.toString();
    }

    @Override
    public void visit(PrefixExpressionNode it){
        if(it.op.equals("++")){
            it.object.accept(this);
            BinaryInstruction add = new BinaryInstruction("+", "%"+it.object.get_reg, "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(add);
            StoreInstruction store = new StoreInstruction(add.res_toString(),getter.getType(it.object.type,it.object.dim,null),  last_identifier_expression_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
            it.get_reg = add.res_toString();
        } else if(it.op.equals("--")) {
            it.object.accept(this);
            BinaryInstruction sub = new BinaryInstruction("-", "%" + it.object.get_reg, "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(sub);
            StoreInstruction store = new StoreInstruction(sub.res_toString(), getter.getType(it.object.type,it.object.dim,null),   last_identifier_expression_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
            it.get_reg = sub.res_toString();
        }else if (it.op.equals("~")){
            it.object.accept(this);
            BinaryInstruction xor = new BinaryInstruction("^",it.object.get_reg,"-1",getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(xor);
            it.get_reg = xor.res_toString();
        } else if (it.op.equals("!")){
            it.object.accept(this);
            BinaryInstruction xor = new BinaryInstruction("^",it.object.get_reg,"1",getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(xor);
            it.get_reg = xor.res_toString();
        } else if(it.op.equals("+")){
            it.object.accept(this);
            BinaryInstruction add = new BinaryInstruction("+",it.object.get_reg,"0",getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(add);
            it.get_reg = add.res_toString();
        } else if(it.op.equals("-")){
            it.object.accept(this);
            BinaryInstruction sub = new BinaryInstruction("-","0",it.object.get_reg,getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(sub);
            it.get_reg = sub.res_toString();
        }
    }

    @Override
    public void visit(SuffixExpressionNode it){
        if(it.op.equals("++")){
            it.object.accept(this);
            it.get_reg = it.object.get_reg;
            BinaryInstruction add = new BinaryInstruction("+", "%"+it.object.get_reg, "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(add);
            StoreInstruction store = new StoreInstruction(add.res_toString(), getter.getType(it.object.type,it.object.dim,null),   last_identifier_expression_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
        } else if(it.op.equals("--")) {
            it.object.accept(this);
            it.get_reg = it.object.get_reg;
            BinaryInstruction sub = new BinaryInstruction("-", "%" + it.object.get_reg, "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(sub);
            StoreInstruction store = new StoreInstruction(sub.res_toString(), getter.getType(it.object.type,it.object.dim,null),   last_identifier_expression_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
        }
    }
    @Override
    public void visit(NewExpressionNode it) {
        if(current_function != null) {
            if(it.expression.size()==1){
                ExpressionNode first = it.expression.get(0);
                first.accept(this);
                CallInstruction call = new CallInstruction("i8*", "malloc_", call_statement_count++);
                StringBuilder para = new StringBuilder();
                para.append("i32 ").append(first.valueIR.values.get(0).number_value*getter.getSize(it.type,it.dim));
                call.para.add(para.toString());
                current_block.addInstruction(call);
                StringBuilder call_reg = new StringBuilder();
                call_reg.append("call").append(call.call_reg);
                BitcastInstruction bitcast = new BitcastInstruction("i8*",getter.getType(it.type, it.dim, null),call_reg.toString(),current_function.reg_count++);
                it.get_reg = bitcast.res_toString();
                current_block.addInstruction(bitcast);
                //System.out.println(bitcast.res_toString());
            } else if(it.expression.size()>1){
                    Position pos = it.expression.get(0).pos;//记下位置
                    StringBuilder alter_name = new StringBuilder();
                    alter_name.append("alter").append(new_alternative_count++);
                    DeclarationNode alter = new DeclarationNode(alter_name.toString(),null,pos);
                    alter.type = it.type;
                    alter.dim = it.dim;
                    // int*** alter
                    PrimaryExpressionNode array = new PrimaryExpressionNode(it.pos,alter_name.toString());
                    array.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
                    array.type = alter.type;
                    array.dim = alter.dim;//新建一个数组对象，并且把这一维给它new好
                    NewExpressionNode first_nnew = new NewExpressionNode(pos,alter.type,alter.dim);
                    first_nnew.expression.add(it.expression.get(0));
                    AssignmentExpressionNode first_ass = new AssignmentExpressionNode(array,first_nnew,pos);
                    // alter = new int** [3]
                StringBuilder counter_name = new StringBuilder();
                counter_name.append("count").append(new_loop_count++);//新建一个计数变量的名称

                VariableDefNode vardef = new VariableDefNode("int",pos,0);
                vardef.is_global = false;
                vardef.typename = "int";
                vardef.dim = 0;
                PrimaryExpressionNode zero = new PrimaryExpressionNode(pos,"0");
                zero.exprtype = PrimaryExpressionNode.ExpressionType.integerLiteralExpr;
                zero.type = "int";
                zero.dim = 0;
                DeclarationNode dec = new DeclarationNode(counter_name.toString(),zero,pos);
                dec.type = "int";
                dec.dim = 0;
                vardef.declarations.add(dec);
                // int counter = 0;

                ExpressionNode init = null;

                PrimaryExpressionNode lhs = new PrimaryExpressionNode(pos,counter_name.toString());
                lhs.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
                lhs.type = "int";
                lhs.dim = 0;
                BinaryExpressionNode cond = new BinaryExpressionNode(lhs,it.expression.get(0),"<",pos);
                // counter < size

                SuffixExpressionNode suf = new SuffixExpressionNode(pos,lhs,"++");
                // counter++;

                SuiteNode suite = new SuiteNode(pos);

                PrimaryExpressionNode offset = new PrimaryExpressionNode(pos,counter_name.toString());
                offset.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
                offset.type = "int";
                offset.dim = 0;
                ArrayIndexExpressionNode arridx = new ArrayIndexExpressionNode(pos,array,offset);
                arridx.type = array.type;
                arridx.dim = array.dim - 1;
                //System.out.println(it.dim);
                //System.out.println(arridx.dim);
                NewExpressionNode nnew = new NewExpressionNode(pos,it.type,it.dim-1);
                for(int j = 1;j < it.expression.size();++j){
                    nnew.expression.add(it.expression.get(j));
                }
                AssignmentExpressionNode ass_new = new AssignmentExpressionNode(arridx,nnew,pos);
                // alter[counter] = new int[][]递归的
                ExpressionStatementNode ass_nnew = new ExpressionStatementNode(ass_new,pos);
                //CallExpressionNode call_print = new CallExpressionNode(pos,null);
                //call_print.func = llvm.symbols.functionTypes.get("printInt");
                //call_print.auguments.add(lhs);
                //ExpressionStatementNode print_stmt = new ExpressionStatementNode(call_print,pos);
                //suite.stmts.add(print_stmt);
                suite.stmts.add(ass_nnew);

                ForStatementNode loop = new ForStatementNode(vardef,init,cond,suf,pos,suite);
                alter.accept(this);
                first_ass.accept(this);
                loop.accept(this);
                array.accept(this);
                it.get_reg = array.get_reg;
            }

        } else {
            StringBuilder info = new StringBuilder();
            it.expression.forEach(a-> {
                info.append(" [");
                a.accept(this);
                String[]  strs=a.info_for_global_var.split(" ");
                StringBuilder value = new StringBuilder();
                for(int i=1,len=strs.length;i<len;i++){
                    value.append(strs[i].toString());
                }
                info.append(value).append(" x ");
                it.sizes.add(a.valueIR.values.get(0).number_value);
            });
            info.append(getter.getType(it.type, it.dim - it.expression.size(), null));
            for(int i=0;i<it.expression.size();++i)info.append("]");
            info.append(" zeroinitializer");
            it.info_for_global_var = info.toString();
            //it.sizes.forEach(System.out::println);
        }
    }
    @Override
    public void visit(ParenExpressionNode it){
        it.expression.accept(this);
    }

    @Override
    public void visit(ArrayIndexExpressionNode it){
        it.offset.accept(this);
        it.object.accept(this);
        System.out.println(it.object.dim);
        String sext_res_reg;
        if(it.offset.get_value){
            SextInstruction sext = new SextInstruction(it.offset.valueIR.values.get(0).number_value,sext_instr_count++);
            current_block.addInstruction(sext);
            sext_res_reg = sext.res_toString();
        }else {
            SextInstruction sext = new SextInstruction(it.offset.get_reg,sext_instr_count++);
            current_block.addInstruction(sext);
            sext_res_reg = sext.res_toString();
        }
        //System.out.println(it.object.dim);
        //System.out.println(getter.getType(it.object.type,it.object.dim, it.object.get_reg));
        GetElementPtrInstruction gep = new GetElementPtrInstruction(it.object.get_reg, sext_res_reg, getter.getType(it.object.type,it.object.dim, it.object.get_reg),it.object.dim,bracket_count++);
        current_block.addInstruction(gep);
        if(it.visited_as_lhs){
            it.get_reg = gep.res_toString();
        }
        else {
            LoadInstruction load = new LoadInstruction(current_function.reg_count++,gep.res_toString(),getter.getType(it.type,it.dim,null));
            current_block.addInstruction(load);
            StringBuilder res = new StringBuilder();
            res.append(current_function.reg_count-1);
            it.get_reg = res.toString();
        }
    }
}
