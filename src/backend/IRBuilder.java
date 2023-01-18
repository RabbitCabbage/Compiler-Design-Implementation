package backend;

import IR.*;
import IR.IRTypeGetter;
import IR.Instruction.*;
import ast.*;
import frontend.Symbols;
import parser.MxParser;

import java.util.Stack;

public class IRBuilder extends ASTVisitor {
    public LLVM llvm;
    public Symbols symbols;
    public IRTypeGetter getter;
    public int if_statement_count;
    public int loop_statement_count;
    public Stack<Integer> loop_stack;
    public int call_statement_count;
    public int binary_expression_count;
    public int string_constant_count;
    public int short_cut_count;
    public String last_expression_name;//记下的是上一个访问到的identifier的名字

    public IRBuilder(Symbols symbols) {
        this.symbols = symbols;
        llvm = new LLVM(symbols);
        getter = new IRTypeGetter(symbols,llvm);
        short_cut_count = 0;
        if_statement_count = 0;
        loop_statement_count = 0;
        call_statement_count = 0;
        binary_expression_count = 0;
        string_constant_count = 0;
        loop_stack = new Stack<>();
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
        String name = it.name;
        if (current_block == null) {
            if (it.init != null) it.init.accept(this);
            return;
        }
        if (it.init != null) {
            it.init.accept(this);
            String type = getter.getType(it.init.type,it.init.dim,it.init.get_reg);
            System.out.println(type);
            AllocaInstruction alloc = new AllocaInstruction(name, getter.getType(it.type,it.dim,null));
            current_block.addInstruction(alloc);
            if (it.init.get_value) {
                ValueUnit unit = it.init.valueIR.values.get(0);
                StoreInstruction store;
                if(it.type.equals("string")) {
                    StringBuilder resreg  = new StringBuilder();
                    resreg.append(current_function.reg_count++);
                    GetElementPtrInstruction gep = new GetElementPtrInstruction("i8",resreg.toString(),it.init.get_reg,it.init.valueIR.values.get(0).string_value);
                    current_block.addInstruction(gep);
                    store = new StoreInstruction(resreg.toString(), "i8*", name, getter.getType(it.type,it.dim,null),llvm.globalVars.containsKey(name)||llvm.stringConstants.containsKey(name));
                }
                else  store = new StoreInstruction(unit, type, name,llvm.globalVars.containsKey(name)||llvm.stringConstants.containsKey(name));
                current_block.addInstruction(store);
            } else {
                StoreInstruction store = new StoreInstruction(it.init.get_reg, type, name,getter.getType(it.type,it.dim,null),llvm.globalVars.containsKey(name)||llvm.stringConstants.containsKey(name));
                current_block.addInstruction(store);
            }
        } else {
            AllocaInstruction alloc = new AllocaInstruction(name, getter.getType(it.type,it.dim,null));
            current_block.addInstruction(alloc);
        }
    }

    @Override
    public void visit(FunctionDefNode it) {
        current_function = new FunctionIR(it);
        llvm.functions.put(it.name, current_function);//收集函数定义
        current_block = new BlockIR("entry");
        it.parameterlist.forEach(a -> {
            current_function.para_names.add(a.declare.name);
            AllocaInstruction alloca = new AllocaInstruction(a.declare.name + ".addr", getter.getType(a.type, a.dim,null));
            current_block.addInstruction(alloca);
        });
        it.parameterlist.forEach(a -> {
            StoreInstruction store = new StoreInstruction(a.declare.name, getter.getType(a.type, a.dim,null), a.declare.name + ".addr",getter.getType(a.type, a.dim,null),llvm.globalVars.containsKey(a.declare.name)||llvm.stringConstants.containsKey(a.declare.name));
            current_block.addInstruction(store);
        });
        it.stmts.accept(this);//访问每一个具体的语句，把它翻译成llvm
        //System.out.print("function statement end ");
        //System.out.println(current_block.block_id);
        current_function.blocks.add(current_block);
    }

    @Override
    public void visit(ClassDefNode it) {
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
    }
    @Override
    public void visit(SuiteNode it){
        it.stmts.forEach(a->a.accept(this));
    }
    //在visit的时候把function内部的块串好，串起来，并且把其中的具体的statement放进去
    @Override
    public void visit(IfStatementNode it) {
        //现在current_block还在if的外面
        it.condition.accept(this);
        String cond = it.condition.get_reg;
        StringBuilder count = new StringBuilder();
        count.append(if_statement_count);
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
        it.thenstmt.accept(this);
        if (!branch_is_returned) {
            BrInstruction then_br = new BrInstruction(null, "if.end" + count.toString(), null);
            current_block.addInstruction(then_br);
            current_function.blocks.add(current_block);
            //System.out.print(current_block.block_id);
        }

        if (it.elsestmt != null) {
            branch_is_returned = false;
            current_block = else_block;
            it.elsestmt.accept(this);
            if (!branch_is_returned) {
                BrInstruction else_br = new BrInstruction(null, "if.end" + count.toString(), null);
                current_block.addInstruction(else_br);
                current_function.blocks.add(current_block);
                //System.out.print(current_block.block_id);
            }
        }

        current_block = next_block;
        if_statement_count++;
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
    }

    @Override
    public void visit(ForStatementNode it) {
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
            // todo if there is a var of the same name shadowing the parameters
            // todo global variables should be referenced to by @
            if (!it.visited_as_lhs) {
                LoadInstruction load = new LoadInstruction(current_function.reg_count++, (current_function.para_names.contains(it.primaryExpression) ? (it.primaryExpression + ".addr") : it.primaryExpression), getter.getType(it.type, it.dim,null),llvm.globalVars.containsKey(it.primaryExpression)||llvm.stringConstants.containsKey(it.primaryExpression));
                current_block.addInstruction(load);
                StringBuilder tmp = new StringBuilder();
                tmp.append(current_function.reg_count - 1);
                //tmp.append("IDENTIFIER");
                it.get_reg = tmp.toString();
                last_expression_name = (current_function.para_names.contains(it.primaryExpression) ? (it.primaryExpression + ".addr") : it.primaryExpression);
            } else {
                it.get_reg = it.primaryExpression;
                last_expression_name = (current_function.para_names.contains(it.primaryExpression) ? (it.primaryExpression + ".addr") : it.primaryExpression);
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
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.integerLiteralExpr) {
            ValueUnit unit = new ValueUnit(Integer.parseInt(it.primaryExpression), null, null);
            //System.out.println(it.primaryExpression);
            //System.out.println(unit.number_value);
            it.valueIR.values.add(unit);
            it.get_value = true;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.boolLiteralExpr) {
            ValueUnit unit = new ValueUnit(null, null, Boolean.parseBoolean(it.primaryExpression));
            it.valueIR.values.add(unit);
            it.get_value = true;
        }
    }

    @Override
    public void visit(BinaryExpressionNode it) {
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
                if (it.lhs.type.equals("int")) lhs_reg = it.lhs.valueIR.values.get(0).number_value.toString();
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
        it.lhs.visited_as_lhs = true;//说明是被用作左值，不用load等等
        it.lhs.accept(this);
        it.lhs.visited_as_lhs = false;
        it.rhs.accept(this);
        if (it.rhs.get_value) {
            //System.out.println("Store the value");
            StoreInstruction store = new StoreInstruction(it.rhs.valueIR.values.get(0), getter.getType(it.rhs.type,it.rhs.dim,it.rhs.get_reg), it.lhs.get_reg,llvm.globalVars.containsKey(it.lhs.get_reg)||llvm.stringConstants.containsKey(it.lhs.get_reg));
            current_block.addInstruction(store);
        } else {
            //System.out.println("Store the reg");
            //System.out.println(it.rhs.get_reg);
            StoreInstruction store = new StoreInstruction(it.rhs.get_reg, getter.getType(it.rhs.type, it.rhs.dim,it.rhs.get_reg), it.lhs.get_reg,getter.getType(it.lhs.type, it.lhs.dim,it.lhs.get_reg),llvm.globalVars.containsKey(it.lhs.get_reg)||llvm.stringConstants.containsKey(it.lhs.get_reg));
            //System.out.println(current_block.instrs.size());
            current_block.addInstruction(store);
            //System.out.println(current_block.instrs.size());
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
        resreg.append(current_function.reg_count++);
        GetElementPtrInstruction gep = new GetElementPtrInstruction(it.object.type, resreg.toString(), it.object.get_reg, index);
        current_block.addInstruction(gep);//get a pointer to pointer, that is pointer2
        LoadInstruction load_ptr1 = new LoadInstruction(current_function.reg_count++, resreg.toString(), object_class.elements.get(index).type,llvm.globalVars.containsKey(resreg.toString())||llvm.stringConstants.containsKey(resreg.toString()));
        current_block.addInstruction(load_ptr1);
        StringBuilder ptr1reg = new StringBuilder();
        ptr1reg.append(current_function.reg_count);
        LoadInstruction load_element = new LoadInstruction(current_function.reg_count++, ptr1reg.toString(), object_class.elements.get(index).type,llvm.globalVars.containsKey(ptr1reg.toString())||llvm.stringConstants.containsKey(ptr1reg.toString()));
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
            StoreInstruction store = new StoreInstruction(add.res_toString(),getter.getType(it.object.type,it.object.dim,null),last_expression_name,getter.getType(it.object.type,it.object.dim,null),llvm.globalVars.containsKey(last_expression_name)||llvm.stringConstants.containsKey(last_expression_name));
            current_block.addInstruction(store);
            it.get_reg = add.res_toString();
        } else if(it.op.equals("--")) {
            it.object.accept(this);
            BinaryInstruction add = new BinaryInstruction("-", "%" + it.object.get_reg, "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(add);
            StoreInstruction store = new StoreInstruction(add.res_toString(), getter.getType(it.object.type,it.object.dim,null), last_expression_name,getter.getType(it.object.type,it.object.dim,null),llvm.globalVars.containsKey(last_expression_name)||llvm.stringConstants.containsKey(last_expression_name));
            current_block.addInstruction(store);
            it.get_reg = add.res_toString();
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
            StoreInstruction store = new StoreInstruction(add.res_toString(),getter.getType(it.object.type,it.object.dim,null),last_expression_name,getter.getType(it.object.type,it.object.dim,null),llvm.globalVars.containsKey(last_expression_name)||llvm.stringConstants.containsKey(last_expression_name));
            current_block.addInstruction(store);
        } else if(it.op.equals("--")) {
            it.object.accept(this);
            it.get_reg = it.object.get_reg;
            BinaryInstruction add = new BinaryInstruction("-", "%" + it.object.get_reg, "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(add);
            StoreInstruction store = new StoreInstruction(add.res_toString(), getter.getType(it.object.type,it.object.dim,null), last_expression_name,getter.getType(it.object.type,it.object.dim,null),llvm.globalVars.containsKey(last_expression_name)||llvm.stringConstants.containsKey(last_expression_name));
            current_block.addInstruction(store);
        }
    }
    @Override
    public void visit(NewExpressionNode it) {
        CallInstruction call = new CallInstruction(getter.getType(it.type, it.dim,null), "malloc_", current_function.reg_count++);
        current_block.addInstruction(call);
    }
}
