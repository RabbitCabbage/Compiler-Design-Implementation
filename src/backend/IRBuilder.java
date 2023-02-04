package backend;

import IR.*;
import IR.IRTypeGetter;
import IR.Instruction.*;
import ast.*;
import frontend.Symbols;
import org.antlr.v4.runtime.misc.Pair;
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
    public Stack<Pair<String,Integer>> loop_stack;
    public int call_statement_count;
    public int binary_expression_count;
    public int string_constant_count;
    public int short_cut_count;
    public String last_identifier_expression_reg;//记下的是上一个访问到的identifier的名字
    public int bracket_count;
    public int new_alternative_count;
    public int new_loop_count;
    public HashMap<String, Integer> variable_name_to_count;

    public IRBuilder(Symbols symbols) {
        this.symbols = symbols;     
        llvm = new LLVM(symbols);
        llvm.functions = symbols.ir_function_names;
        getter = new IRTypeGetter(symbols,llvm);
        short_cut_count = 0;
        if_statement_count = 0;
        loop_statement_count = 0;
        call_statement_count = 0;
        binary_expression_count = 0;
        string_constant_count = 0;
        loop_stack = new Stack<>();
        bracket_count = 0;
        new_alternative_count = 0;
        new_loop_count = 0;
        this.current_scope = new Scope(null);
        global_scope = this.current_scope;
        variable_name_to_count = new HashMap<>();
    }

    public FunctionIR current_function;//用来记下现在正在处理的函数，以便于给这个函数加block
    public BlockIR current_block;

    @Override
    public void visit(RootNode it) {
        it.classdefs.forEach(a -> a.accept(this));
        it.vardefs.forEach(a -> a.accept(this));
        it.funcdefs.forEach(a -> a.accept(this));
        //System.out.println(llvm.functions.get("kunkun"));
        if(llvm.functions.get("kunkun").blocks.isEmpty()){
            BlockIR entry = new BlockIR("entry");
            entry.addInstruction(new RetInstruction(null,null,true));
            llvm.functions.get("kunkun").blocks.add(entry);
        }
        else  llvm.functions.get("kunkun").blocks.get(llvm.functions.get("kunkun").blocks.size()-1).addInstruction(new RetInstruction(null,null,true));
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
        if(variable_name_to_count.containsKey(it.name)){
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
            }
            //System.out.println(it.type);
            global_info.append(" = dso_local global ").append(getter.getType(it.type,it.dim,null)).append((!it.type.equals("int")&&!it.type.equals("bool")&&!it.type.equals("string"))?" zeroinitializer \n":((it.dim == 0&&!it.type.equals("string"))?" 0\n":" null\n"));
            it.info_for_global = global_info.toString();
            it.reg_name_for_global = reg_name.toString();
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
        if(it.belong!=null){
            //System.out.println(it.belong.name);
            DeclarationNode declaration = new DeclarationNode("this",null,it.pos);
            declaration.type = it.belong.name;
            declaration.dim = 0;
            ParameterNode self = new ParameterNode(it.pos,it.belong.name,0,declaration);
            it.parameterlist.add(0,self);
        }
        current_scope.function_paras_defined = true;
        current_function = new FunctionIR(it);
        String funcname = it.name;
        int reload = symbols.function_name_to_count.get(it.name);
        for(int i = 0;i<=reload;++i){
            String name = it.name+(i==0?"":String.valueOf(i));
            ClassDefNode cls1 = it.belong;
            ClassDefNode cls2 = llvm.functions.get(name).funcdef.belong;
            if((cls1==null&&cls2==null)||(cls1 != null && cls1.equals(cls2))){
                funcname=name;
                break;
            }
        }
        current_function.IR_name = funcname;
        current_block = new BlockIR("entry");
        if(!current_function.funcdef.returntype.equals("void")){
            AllocaInstruction alloca_ret = new AllocaInstruction("%retval", getter.getType(it.returntype,it.returndim,null));
            current_block.addInstruction(alloca_ret);
            if((current_function.funcdef.returntype.equals("int")||current_function.funcdef.returntype.equals("string")||current_function.funcdef.returntype.equals("bool"))&&current_function.funcdef.returndim==0){
                ValueUnit unit = new ValueUnit(0,null,false);
                StoreInstruction store_val = new StoreInstruction(unit,getter.getType(current_function.funcdef.returntype,current_function.funcdef.returndim,null),"%retval");
                current_block.addInstruction(store_val);
            }
        }
        it.parameterlist.forEach(a -> {
            StringBuilder reg_name = new StringBuilder();
            reg_name.append("%");
            //System.out.println(reg_name.toString());
            if(current_scope.containVariable(a.declare.name,true))reg_name.append(a.declare.name).append(variable_name_to_count.get(a.declare.name)+1);
            else reg_name.append(a.declare.name);
            current_function.para_names.add(reg_name.toString());
            AllocaInstruction alloca = new AllocaInstruction("%"+a.declare.name + ".addr", getter.getType(a.type, a.dim,null));
            current_block.addInstruction(alloca);
            StoreInstruction store = new StoreInstruction(reg_name.toString(), getter.getType(a.type, a.dim,null), "%"+a.declare.name + ".addr",getter.getType(a.type, a.dim,null));
            current_block.addInstruction(store);
            while(reg_name.length()>1){
                reg_name.deleteCharAt(reg_name.length()-1);
            }
            reg_name.append(a.declare.name);
            if(current_scope.containVariable(a.declare.name,true)){
                int last_max = variable_name_to_count.get(a.declare.name);
                variable_name_to_count.replace(a.declare.name,last_max+1);
                reg_name.append(".addr");
                current_scope.variable_name_to_reg_name.put(a.declare.name,reg_name.toString());
            }
            else {
                reg_name.append(".addr");
                current_scope.variable_name_to_reg_name.put(a.declare.name,reg_name.toString());
                variable_name_to_count.put(a.declare.name,0);
            }
            current_scope.defineVariable(a.declare.name,a.declare,a.declare.pos);
        });
        if(it.name.equals("main")){
            CallInstruction call_init_global = new CallInstruction("void","kunkun",0);
            current_block.addInstruction(call_init_global);
        }

        it.stmts.accept(this);//访问每一个具体的语句，把它翻译成llvm
        //System.out.print("function statement end ");
        //System.out.println(current_block.block_id);
        if(it.is_constructor && !it.has_return_statement){//如果说是构造函数且没有返回值，那么需要先把this存到retval
            LoadInstruction load_this = new LoadInstruction(current_function.reg_count++,"%this.addr", getter.getType(it.returntype,it.returndim,null));
            StoreInstruction store_this = new StoreInstruction("%"+String.valueOf(load_this.reg),getter.getType(it.returntype,it.returndim,null),"%retval",getter.getType(it.returntype,it.returndim,null));
            current_block.addInstruction(load_this);
            current_block.addInstruction(store_this);
        }
        BrInstruction br_exit = new BrInstruction(null,"exit",null);
        current_block.addInstruction(br_exit);
        current_function.blocks.add(current_block);
        current_block = new BlockIR("exit");
        if(current_function.funcdef.returntype.equals("void")){
            RetInstruction ret_void = new RetInstruction(null,null,true);
            current_block.addInstruction(ret_void);
        }else {
            LoadInstruction load_ret = new LoadInstruction(current_function.reg_count++,"%retval",getter.getType(current_function.funcdef.returntype,current_function.funcdef.returndim,null));
            RetInstruction ret_val = new RetInstruction("%"+String.valueOf(load_ret.reg), getter.getType(current_function.funcdef.returntype,current_function.funcdef.returndim,null), false);
            current_block.addInstruction(load_ret);
            current_block.addInstruction(ret_val);
        }
        current_function.blocks.add(current_block);
        current_scope = current_scope.parent;
        current_block = null;
        llvm.functions.replace(funcname, current_function);//替换函数定义
        current_function = null;
    }

    @Override
    public void visit(ClassDefNode it) {
        current_scope = new Scope(current_scope);
        current_scope.is_class = true;
        current_scope.class_name = it.name;
        ClassIR cls = new ClassIR(it);
        it.vardefs.forEach(a -> {
            //a.declarations.forEach(b -> b.accept(this));
            a.declarations.forEach(b -> {
                cls.element_names.add(b.name);
                cls.elements.add(b);
                //System.out.println(b.name);
                StringBuilder reg_name = new StringBuilder();
                if(current_scope.parent==null)reg_name.append("@");
                else reg_name.append("%");
                reg_name.append(b.name);
                if(variable_name_to_count.containsKey(b.name)){
                    int last_max = variable_name_to_count.get(b.name);
                    variable_name_to_count.replace(b.name,last_max+1);
                    reg_name.append(last_max+1);
                    current_scope.variable_name_to_reg_name.put(b.name,reg_name.toString());
                }
                else {
                    current_scope.variable_name_to_reg_name.put(b.name,reg_name.toString());
                    variable_name_to_count.put(b.name,0);
                }
                current_scope.defineVariable(b.name,b,b.pos);
            });
//            cls.elements.addAll(a.declarations);
        });
        llvm.classes.put(it.name, cls);//收集类定义
        it.methoddefs.forEach(a -> {
            //System.out.println(a.belong.name);
            a.accept(this);
            cls.methods.add(new FunctionIR(a));
        });
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
        String cond;
        if(it.condition.get_reg!=null)cond = it.condition.get_reg;
        else cond = it.condition.valueIR.values.get(0).bool_value.toString();
        System.out.println(cond);
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

        current_block = then_block;
        current_scope = new Scope(current_scope);
        it.thenstmt.accept(this);
        current_scope = current_scope.parent;
        if(current_block != null){
            BrInstruction then_br = new BrInstruction(null, "if.end" + count.toString(), null);
            current_block.addInstruction(then_br);
            //System.out.print(current_block.block_id);
            current_function.blocks.add(current_block);
        }

        if (it.elsestmt != null) {
            current_block = else_block;
            current_scope = new Scope(current_scope);
            it.elsestmt.accept(this);
            current_scope = current_scope.parent;
            if(current_block != null) {
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
        String IR_name = it.func.name;
        if(symbols.function_name_to_count.get(it.func.name)!=null){
            int reload = symbols.function_name_to_count.get(it.func.name);
            for(int i = 0;i<=reload;++i){
                String name = it.func.name+(i==0?"":String.valueOf(i));
                ClassDefNode cls1 = it.func.belong;
                ClassDefNode cls2 = llvm.functions.get(name).funcdef.belong;
                if((cls1==null&&cls2==null)||(cls1 != null && cls1.equals(cls2))){
                    IR_name=name;
                    break;
                }
            }
        }
        //System.out.println("function call");
        //System.out.println(it.func.name);
        //System.out.println(it.object);
        it.object.dot_function = it.func;
        it.object.accept(this);
        //System.out.println(it.object.get_reg);
        //it.object.struct_name.forEach(System.out::println);
        StringBuilder self = null;
        int call_reg;
        if (it.func.returntype.equals("void")) call_reg = 0;
        else call_reg = call_statement_count++;
        //System.out.println("NAME = " + it.func.name);
        CallInstruction call = new CallInstruction(getter.getType(it.func.returntype, it.func.returndim,null), IR_name, call_reg);
        //System.out.println(it.object.getClass());
        //System.out.println(((MemberCallExpressionNode)it.object).object.type);
        if(it.object.getClass().toString().equals("class ast.MemberCallExpressionNode")&&((MemberCallExpressionNode)it.object).object.type.equals("string")){
            if(IR_name.equals("substring"))call.func_name = "string_substring";
            else if(IR_name.equals("parseInt"))call.func_name = "string_parseInt";
            else if(IR_name.equals("length"))call.func_name = "string_length";
            else if(IR_name.equals("ord"))call.func_name = "string_ord";
            if(((MemberCallExpressionNode)it.object).object.get_reg == null) {
                ((MemberCallExpressionNode) it.object).object.dot_function = null;
                ((MemberCallExpressionNode) it.object).object.accept(this);
            }
            call.para.add("i8* "+((MemberCallExpressionNode)it.object).object.get_reg);
            call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,((MemberCallExpressionNode)it.object).object.get_reg)));
        }
        else if(it.object.getClass().toString().equals("class ast.MemberCallExpressionNode")&&((MemberCallExpressionNode)it.object).object.dim>0 && IR_name.equals("size")){
            //System.out.println(it.func.name);
            ((MemberCallExpressionNode) it.object).object.dot_function = null;
            ((MemberCallExpressionNode) it.object).object.accept(this);
            String array_type = getter.getType(((MemberCallExpressionNode)it.object).object.type,((MemberCallExpressionNode)it.object).object.dim,((MemberCallExpressionNode)it.object).object.get_reg);
            String array_reg = ((MemberCallExpressionNode)it.object).object.get_reg;
            //LoadInstruction load_array = new LoadInstruction(current_function.reg_count++,array_reg,array_type);
            BitcastInstruction bitcast = new BitcastInstruction(array_type,"i8*", array_reg,current_function.reg_count++);
            //current_block.addInstruction(load_array);
            current_block.addInstruction(bitcast);
            call.para.add("i8* "+bitcast.res_toString());
            call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,bitcast.res_toString())));
            call.func_name = "getArraySize";
        }
        else if(!it.object.struct_name.isEmpty()||!it.name_index_in_class.isEmpty()){
            String last_reg = it.object.get_reg;
            for(int i = 0;i<it.object.struct_name.size()-1;++i){
                LoadInstruction load_struct2 = new LoadInstruction(current_function.reg_count++,last_reg, getter.getType(it.object.struct_name.get(i),0,null));
                current_block.addInstruction(load_struct2);
                StringBuilder gep_reg = new StringBuilder();
                gep_reg.append("%").append(current_function.reg_count++);
                GetElementPtrInstruction gep = new GetElementPtrInstruction(it.object.struct_name.get(i),gep_reg.toString(),"%"+String.valueOf(load_struct2.reg),it.object.name_index_in_class.get(i));
                current_block.addInstruction(gep);
                last_reg = gep.res_toString();
                //System.out.println(it.object.name_index_in_class.get(i));
                //System.out.println(it.object.struct_name.get(i));
            }
            LoadInstruction load_struct = new LoadInstruction(current_function.reg_count++,last_reg,getter.getType(it.object.struct_name.get(it.object.struct_name.size()-1),0,null));
            last_reg = "%"+String.valueOf(load_struct.reg);
            current_block.addInstruction(load_struct);
            self = new StringBuilder();
            self.append(getter.getType(it.object.struct_name.get(it.object.struct_name.size()-1),0,null)).append(" ");
            self.append(last_reg);
            call.para_have_value_or_get_reg.add(0,new Pair<>(false,new Pair<>(null,last_reg)));
            //System.out.println(self.toString());
        }else if(it.func.belong != null){
            if(it.object.getClass().toString().equals("class ast.PrimaryExpressionNode")){
                self = new StringBuilder();
                LoadInstruction load_this = new LoadInstruction(current_function.reg_count++,"%this.addr",getter.getType(it.func.belong.name,0,null));
                current_block.addInstruction(load_this);
                self.append(getter.getType(it.func.belong.name,0,null)).append(" %"+String.valueOf(load_this.reg));
                call.para_have_value_or_get_reg.add(0,new Pair<>(false,new Pair<>(null," %"+String.valueOf(load_this.reg))));
            } else {
                self = new StringBuilder();
                self.append(getter.getType(it.func.belong.name,0,null)).append(" ").append(it.object.get_reg);
                call.para_have_value_or_get_reg.add(0,new Pair<>(false,new Pair<>(null,it.object.get_reg)));
            }
        }
        if(self!=null)call.class_belong_info = self.toString();
        it.auguments.forEach(a -> {
            a.accept(this);
            StringBuilder para = new StringBuilder();
            //System.out.println(llvm.stringConstants.get(a.get_reg)+"\t"+a.get_reg);
            if(a.type.equals("string")&&a.get_value) {
                para.append(getter.getType(a.type, a.dim, null)).append(" ").append(a.get_reg);
                call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,a.get_reg)));
            }
            else if(a.get_value) {
                para.append(getter.getType(a.type,a.dim,a.get_reg)).append(" ").append(a.type.equals("int")?a.valueIR.values.get(0).number_value:a.valueIR.values.get(0).bool_value);
                call.para_have_value_or_get_reg.add(new Pair<>(true,new Pair<>(a.type.equals("int")?a.valueIR.values.get(0).number_value:(a.valueIR.values.get(0).bool_value?1:0),null)));
            }
            else {
                para.append(getter.getType(a.type,a.dim,a.get_reg)).append(" ").append(a.get_reg);
                call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,a.get_reg)));
            }
            call.para.add(para.toString());
        });
        current_block.addInstruction(call);
        it.get_reg = "%" + "call" + call_reg;
    }

    @Override
    public void visit(WhileStatementNode it) {
        current_scope = new Scope(current_scope);
        current_scope.is_loop = true;
        loop_statement_count++;
        loop_stack.push(new Pair<>("while",loop_statement_count));
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BrInstruction br_to_condition = new BrInstruction(null,"while.cond"+count.toString(),null);
        current_block.addInstruction(br_to_condition);
        current_function.blocks.add(current_block);
        //System.out.println(current_block.block_id);
        BlockIR condition = new BlockIR("while.cond"+count.toString());
        current_block = condition;
        it.condition.accept(this);
        String cond;
        if(it.condition.get_reg!=null)cond = it.condition.get_reg;
        else cond = it.condition.valueIR.values.get(0).bool_value.toString();
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
        loop_stack.push(new Pair<>("for",loop_statement_count));
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
        String cond;
        if(it.condition.get_reg!=null)cond = it.condition.get_reg;
        else cond = it.condition.valueIR.values.get(0).bool_value.toString();
        BrInstruction br_to_loop = new BrInstruction(cond, "for.body"+count.toString(), "for.end"+count.toString());
        current_block.addInstruction(br_to_loop);
        current_function.blocks.add(current_block);
        BlockIR loopbody = new BlockIR("for.body" + count.toString());
        current_block = loopbody;
        it.stmts.accept(this);
        if(current_block != null){
            BrInstruction br_to_step = new BrInstruction(null, "for.inc" + count.toString(), null);
            current_block.addInstruction(br_to_step);
            current_function.blocks.add(current_block);
        }
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
        StringBuilder end_block = new StringBuilder();
        end_block.append(loop_stack.peek().a).append(".end").append(loop_stack.peek().b);
        BrInstruction br = new BrInstruction(null, end_block.toString(), null);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        current_block = null;
    }

    @Override
    public void visit(ContinueStatementNode it) {
        StringBuilder cond_block = new StringBuilder();
        cond_block.append(loop_stack.peek().a).append(".cond").append(loop_stack.peek().b);
        BrInstruction br = new BrInstruction(null, cond_block.toString(), null);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        current_block = null;
    }

    @Override
    public void visit(ReturnStatementNode it) {
        if (it.value != null) {
            it.value.accept(this);
            if (it.value.get_value) {
                StoreInstruction store = new StoreInstruction(it.value.valueIR.values.get(0), getter.getType(it.value.type, it.value.dim, it.value.get_reg), "%retval");
                current_block.addInstruction(store);
            } else {
                StoreInstruction store = new StoreInstruction(it.value.get_reg, getter.getType(it.value.type, it.value.dim, it.value.get_reg), "%retval", getter.getType(it.value.type, it.value.dim, it.value.get_reg));
                current_block.addInstruction(store);
            }
            //System.out.print(current_block.block_id);
        }
        BrInstruction br_to_exit = new BrInstruction(null,"exit",null);
        current_block.addInstruction(br_to_exit);
    }

    @Override
    public void visit(PrimaryExpressionNode it) {
        if(it.dot_function!=null){
            return;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.identifierExpr) {
            Scope destination = current_scope.findScopeContaining(it.primaryExpression);
            String reg_name = destination.variable_name_to_reg_name.get(it.primaryExpression);//本身含有% @
            if(destination.is_class){
                PrimaryExpressionNode object_this = new PrimaryExpressionNode(it.pos,"this");
                object_this.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
                object_this.type = destination.class_name;
                MemberCallExpressionNode membercall = new MemberCallExpressionNode(it.pos,object_this,it.primaryExpression);
                membercall.visited_as_lhs = it.visited_as_lhs;
                membercall.accept(this);
                it.get_reg = membercall.get_reg;
                return;
            }
            if (!it.visited_as_lhs) {
                LoadInstruction load = new LoadInstruction(current_function.reg_count++, (current_function.para_names.contains("%"+it.primaryExpression) ? ("%"+it.primaryExpression + ".addr") : reg_name.toString()), getter.getType(it.type, it.dim,null));
                current_block.addInstruction(load);
                StringBuilder tmp = new StringBuilder();
                tmp.append(current_function.reg_count - 1);
                //tmp.append("IDENTIFIER");
                it.get_reg = "%"+tmp.toString();
                last_identifier_expression_reg = (current_function.para_names.contains(it.primaryExpression) ? ("%"+it.primaryExpression + ".addr") : reg_name.toString());
            } else {
                if(it.primaryExpression.equals("this")){
                    LoadInstruction load_from_this = new LoadInstruction(current_function.reg_count++, "%this.addr",getter.getType(it.type,it.dim,null));
                    current_block.addInstruction(load_from_this);
                    it.get_reg = "%"+String.valueOf(load_from_this.reg);
                    last_identifier_expression_reg = "%this.addr";
                }else {
                    it.get_reg = reg_name;
                    last_identifier_expression_reg = (current_function.para_names.contains(it.primaryExpression) ? ("%" + it.primaryExpression + ".addr") : reg_name.toString());
                }
            }
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.stringLiteralExpr) {
            StringBuilder str = new StringBuilder();
            str.append(it.primaryExpression);
            str.deleteCharAt(0);
            str.deleteCharAt(str.length() - 1);
            it.primaryExpression = str.toString()+"\00";
            StringBuilder reg = new StringBuilder();
            reg.append("@.str").append(string_constant_count++);
            it.primaryExpression = it.primaryExpression.replace("\\\"","\"");
            it.primaryExpression = it.primaryExpression.replace("\\n","\n");
            it.primaryExpression = it.primaryExpression.replace("\\0","\0");
            it.primaryExpression = it.primaryExpression.replace("\\t","\t");
            it.primaryExpression = it.primaryExpression.replace("\\\\","\\");
            llvm.stringConstants.put(reg.toString(), it.primaryExpression);

            StringBuilder resreg  = new StringBuilder();
            resreg.append("%").append(current_function.reg_count++);
            GetElementPtrInstruction gep = new GetElementPtrInstruction("i8",resreg.toString(),reg.toString(),it.primaryExpression);
            current_block.addInstruction(gep);

            it.get_reg = resreg.toString();
            ValueUnit unit = new ValueUnit(null,it.primaryExpression,null);
            //System.out.println(it.primaryExpression);
            //System.out.println(unit.number_value);
            it.valueIR.values.add(unit);
            it.get_value = false;
            if(current_function== null){
                StringBuilder info = new StringBuilder();
                info.append("i8* getelementptr inbounds ([").append(it.primaryExpression.length()).append(" x i8], [").append(it.primaryExpression.length()).append(" x i8]* ").append(it.get_reg).append(", i32 0,i32 0)");
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
        if(false){//todo it.type -> it.lhs.type
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
        }//常量传播， opt用
        if(it.opcode.equals("&&")){
            // bool flag;
            // if(lhs) flag = rhs;
            // else flag = false;
            DeclarationNode declare_flag = new DeclarationNode("flag"+String.valueOf(short_cut_count++),null,it.pos);
            declare_flag.type = "bool";
            declare_flag.dim = 0;
            declare_flag.accept(this);
            PrimaryExpressionNode flag = new PrimaryExpressionNode(it.pos, declare_flag.name);
            flag.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
            flag.type = "bool";
            flag.dim = 0;
            AssignmentExpressionNode then_expr = new AssignmentExpressionNode(flag,it.rhs,it.pos);
            PrimaryExpressionNode false_unit = new PrimaryExpressionNode(it.pos,"false");
            false_unit.exprtype = PrimaryExpressionNode.ExpressionType.boolLiteralExpr;
            false_unit.type = "bool";
            false_unit.dim =0;
            AssignmentExpressionNode else_expr = new AssignmentExpressionNode(flag,false_unit,it.pos);
            IfStatementNode andand = new IfStatementNode(it.lhs,new ExpressionStatementNode(then_expr,it.pos),new ExpressionStatementNode(else_expr,it.pos),it.pos);
            andand.accept(this);
            flag.accept(this);
            it.get_reg  = flag.get_reg;
        }
        else if(it.opcode.equals("||")){
            // bool flag;
            // if(lhs) flag = true;
            // else flag = rhs;
            DeclarationNode declare_flag = new DeclarationNode("flag"+String.valueOf(short_cut_count++),null,it.pos);
            declare_flag.type = "bool";
            declare_flag.dim = 0;
            declare_flag.accept(this);
            PrimaryExpressionNode flag = new PrimaryExpressionNode(it.pos, declare_flag.name);
            flag.exprtype = PrimaryExpressionNode.ExpressionType.identifierExpr;
            flag.type = "bool";
            flag.dim = 0;
            PrimaryExpressionNode true_unit = new PrimaryExpressionNode(it.pos,"true");
            true_unit.exprtype = PrimaryExpressionNode.ExpressionType.boolLiteralExpr;
            true_unit.type = "bool";
            true_unit.dim =0;
            AssignmentExpressionNode then_expr = new AssignmentExpressionNode(flag,true_unit,it.pos);
            AssignmentExpressionNode else_expr = new AssignmentExpressionNode(flag,it.rhs,it.pos);
            IfStatementNode oror = new IfStatementNode(it.lhs,new ExpressionStatementNode(then_expr,it.pos),new ExpressionStatementNode(else_expr,it.pos),it.pos);
            oror.accept(this);
            flag.accept(this);
            it.get_reg  = flag.get_reg;
        }
        else {
            it.lhs.accept(this);
            String lhs_reg;
            if (it.lhs.get_value) {
                if (it.lhs.type.equals("int")) lhs_reg = it.lhs.valueIR.values.get(0).number_value.toString();
                else if (it.lhs.type.equals("string"))
                    lhs_reg = it.lhs.get_reg;
                else lhs_reg = it.lhs.valueIR.values.get(0).bool_value.toString();
            } else {
                lhs_reg = it.lhs.get_reg;
                //System.out.println(lhs_reg);
            }
            it.rhs.accept(this);
            String rhs_reg;
            if (it.rhs.get_value) {
                if (it.rhs.type.equals("int")) rhs_reg = it.rhs.valueIR.values.get(0).number_value.toString();
                else if (it.rhs.type.equals("string"))
                    rhs_reg = it.rhs.get_reg;
                else rhs_reg = it.rhs.valueIR.values.get(0).bool_value.toString();
            } else {
                rhs_reg = it.rhs.get_reg;
            }
            int res_reg = binary_expression_count++;
            String type = getter.getType(it.lhs.type, it.lhs.dim,it.lhs.get_reg);
            //System.out.println(lhs_reg);
            //System.out.println(rhs_reg);
            if(it.lhs.type.equals("int")||it.lhs.type.equals("bool")){
                BinaryInstruction binary = new BinaryInstruction(it.opcode, lhs_reg, rhs_reg, type, res_reg);
                it.get_reg = binary.res_toString();
                //System.out.println(it.get_reg);
                current_block.addInstruction(binary);
            } else if(it.lhs.type.equals("string")){
                CallInstruction call = new CallInstruction("","",call_statement_count++);
                if(it.opcode.equals("+")){
                    call.func_name = "string_concat";
                    call.return_type = "i8*";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                } else if(it.opcode.equals("==")){
                    call.func_name = "string_equal";
                    call.return_type = "i1";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                }else if(it.opcode.equals("!=")){
                    call.func_name = "string_nequal";
                    call.return_type = "i1";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                }else if(it.opcode.equals("<")){
                    call.func_name = "string_lessthan";
                    call.return_type = "i1";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                }else if(it.opcode.equals(">")){
                    call.func_name = "string_greaterthan";
                    call.return_type = "i8*";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                }else if(it.opcode.equals("<=")){
                    call.func_name = "string_notgreaterthan";
                    call.return_type = "i1";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                }else if(it.opcode.equals(">=")){
                    call.func_name = "string_notlessthan";
                    call.return_type = "i1";
                    StringBuilder para_lhs = new StringBuilder();
                    para_lhs.append("i8* ").append(it.lhs.get_reg);
                    StringBuilder para_rhs = new StringBuilder();
                    para_rhs.append("i8* ").append(it.rhs.get_reg);
                    call.para.add(para_lhs.toString());
                    call.para.add(para_rhs.toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.lhs.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,it.rhs.get_reg)));
                }
                current_block.addInstruction(call);
                it.get_reg = call.res_toString();
            }
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
            current_function = llvm.functions.get("kunkun");
            if(!current_function.blocks.isEmpty()){
                current_block = current_function.blocks.get(current_function.blocks.size()-1);
                current_function.blocks.remove(current_function.blocks.size()-1);
            }
            else current_block = new BlockIR("entry");
            current_scope = new Scope(current_scope);
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
            current_function.blocks.add(current_block);
            current_block = null;
            current_function = null;
            current_scope = current_scope.parent;
        }
    }

    @Override
    public void visit(MemberCallExpressionNode it) {
        if(it.dot_function != null){
            it.object.dot_function = it.dot_function;
            it.object.accept(this);
            //System.out.print("type\t");
             //System.out.println(it.object.type);
             //System.out.print("id\t");
             //System.out.println(it.id);
             //System.out.print("index\t");
            ClassIR object_class = llvm.classes.get(it.object.type);
            if(object_class!=null) {
                 //System.out.println(object_class.element_names.indexOf(it.id));
                it.object.name_index_in_class.add(object_class.element_names.indexOf(it.id));
                it.object.struct_name.add(it.object.type);
                //System.out.println(object_class.element_names.indexOf(it.id));
                 //it.struct_name.forEach(System.out::println);
                 //it.name_index_in_class.forEach(System.out::println);
                 //System.out.print("\n");
            }
            //System.out.println(it.object.getClass().toString());
            if((it.object.getClass().toString()).equals("class ast.PrimaryExpressionNode")){
                Scope destination = current_scope.findScopeContaining(((PrimaryExpressionNode)it.object).primaryExpression);
                it.object.get_reg = destination.variable_name_to_reg_name.get(((PrimaryExpressionNode)it.object).primaryExpression);
                //System.out.println("Hello "+ it.get_reg);
            }
            it.name_index_in_class.addAll(it.object.name_index_in_class);
            it.struct_name.addAll(it.object.struct_name);
            it.get_reg = it.object.get_reg;
        }
        else{
            //System.out.println("member call");
            ClassIR object_class = llvm.classes.get(it.object.type);
            //System.out.println(it.object.type);
            int index = object_class.element_names.indexOf(it.id);
            //System.out.println(index);
            // if(it.object.getClass().toString().equals("class ast.PrimaryExpressionNode")&&((PrimaryExpressionNode)it.object).primaryExpression.equals("this"))it.visited_as_lhs = false;
            // it.object.visited_as_lhs = it.visited_as_lhs;
            it.object.dot_function = null;
            it.object.accept(this);
            it.object.visited_as_lhs = false;
            StringBuilder resreg = new StringBuilder();
            resreg.append("%");
            resreg.append(current_function.reg_count++);
            GetElementPtrInstruction gep = new GetElementPtrInstruction(object_class.classdef.name, resreg.toString(), it.object.get_reg, index);
            current_block.addInstruction(gep);//get a pointer to pointer, that is pointer2
            if(!it.visited_as_lhs){
                LoadInstruction load_ptr1 = new LoadInstruction(current_function.reg_count++, resreg.toString(), getter.getType(object_class.elements.get(index).type,object_class.elements.get(index).dim,null));
                current_block.addInstruction(load_ptr1);
                StringBuilder ptr1reg = new StringBuilder();
                ptr1reg.append("%");
                ptr1reg.append(current_function.reg_count-1);
                it.get_reg = ptr1reg.toString();
            }else it.get_reg = gep.res_toString();
        }
    }

    @Override
    public void visit(PrefixExpressionNode it){
        if(it.op.equals("++")){
            it.object.accept(this);
            BinaryInstruction add = new BinaryInstruction("+", (it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) : it.object.get_reg), "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(add);
            it.object.visited_as_lhs = true;
            it.object.accept(this);
            StoreInstruction store = new StoreInstruction(add.res_toString(),getter.getType(it.object.type,it.object.dim,null),  it.object.get_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
            it.get_reg = add.res_toString();
        } else if(it.op.equals("--")) {
            it.object.accept(this);
            BinaryInstruction sub = new BinaryInstruction("-", (it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg), "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(sub);
            it.object.visited_as_lhs = true;
            it.object.accept(this);
            StoreInstruction store = new StoreInstruction(sub.res_toString(),getter.getType(it.object.type,it.object.dim,null),  it.object.get_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
            it.get_reg = sub.res_toString();
        }else if (it.op.equals("~")){
            it.object.accept(this);
            BinaryInstruction xor = new BinaryInstruction("^",(it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg),"-1",getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(xor);
            it.get_reg = xor.res_toString();
        } else if (it.op.equals("!")){
            it.object.accept(this);
            BinaryInstruction xor = new BinaryInstruction("^",(it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg),"1",getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(xor);
            it.get_reg = xor.res_toString();
        } else if(it.op.equals("+")){
            it.object.accept(this);
            BinaryInstruction add = new BinaryInstruction("+",(it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg),"0",getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(add);
            it.get_reg = add.res_toString();
        } else if(it.op.equals("-")){
            it.object.accept(this);
            BinaryInstruction sub = new BinaryInstruction("-","0",(it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg),getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(sub);
            it.get_reg = sub.res_toString();
        }
    }

    @Override
    public void visit(SuffixExpressionNode it){
        if(it.op.equals("++")){
            it.object.accept(this);
            if(!it.object.get_value)it.get_reg = it.object.get_reg;
            else {
                it.get_value = true;
                it.valueIR = it.object.valueIR;
            }
            BinaryInstruction add = new BinaryInstruction("+", (it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg), "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg),binary_expression_count++);
            current_block.addInstruction(add);
            it.object.visited_as_lhs = true;
            it.object.accept(this);
            StoreInstruction store = new StoreInstruction(add.res_toString(),getter.getType(it.object.type,it.object.dim,null),  it.object.get_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
        } else if(it.op.equals("--")) {
            it.object.accept(this);
            if(!it.object.get_value)it.get_reg = it.object.get_reg;
            else {
                it.get_value = true;
                it.valueIR = it.object.valueIR;
            }
            BinaryInstruction sub = new BinaryInstruction("-", (it.object.get_value? String.valueOf(it.object.valueIR.values.get(0).number_value) :it.object.get_reg), "1", getter.getType(it.object.type,it.object.dim,it.object.get_reg), binary_expression_count++);
            current_block.addInstruction(sub);
            it.object.visited_as_lhs = true;
            it.object.accept(this);
            StoreInstruction store = new StoreInstruction(sub.res_toString(),getter.getType(it.object.type,it.object.dim,null),  it.object.get_reg,getter.getType(it.object.type,it.object.dim,null));
            current_block.addInstruction(store);
        }
    }
    @Override
    public void visit(NewExpressionNode it) {
//        if(current_function != null) {//从assign把相关的init就截断下来了，不会再出现current_function == null，
            if(it.expression.size()==1){
                ExpressionNode first = it.expression.get(0);
                first.accept(this);
                CallInstruction call = new CallInstruction("i8*", "malloc_", call_statement_count++);
                StringBuilder para_size = new StringBuilder();
                StringBuilder para_length = new StringBuilder();
                if(first.get_value){
                    para_size.append("i32 ").append(first.valueIR.values.get(0).number_value);
                    para_length.append("i32 ").append(first.valueIR.values.get(0).number_value*getter.getSize(it.type,it.dim));
                    call.para_have_value_or_get_reg.add(new Pair<>(true,new Pair<>(first.valueIR.values.get(0).number_value,null)));
                    call.para_have_value_or_get_reg.add(new Pair<>(true,new Pair<>(first.valueIR.values.get(0).number_value*getter.getSize(it.type,it.dim),null)));
                }
                else {
                    BinaryInstruction mul = new BinaryInstruction("*",first.get_reg,String.valueOf(getter.getSize(it.type,it.dim)),"i32",binary_expression_count++);
                    current_block.addInstruction(mul);
                    para_size.append("i32 ").append(first.get_reg);
                    para_length.append("i32 ").append(mul.res_toString());
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,first.get_reg)));
                    call.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,mul.res_toString())));
                }
                call.para.add(para_size.toString());
                call.para.add(para_length.toString());
                current_block.addInstruction(call);
                StringBuilder call_reg = new StringBuilder();
                call_reg.append("%call").append(call.call_reg);
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
            }else {
                CallInstruction call = new CallInstruction("i8*", "malloc_", call_statement_count++);
                StringBuilder para_size = new StringBuilder();
                StringBuilder para_length = new StringBuilder();
                para_size.append( "i32 0");
                para_length.append( "i32 ").append(String.valueOf(getter.getSize(it.type,it.dim)));
                call.para.add(para_size.toString());
                call.para.add(para_length.toString());
                call.para_have_value_or_get_reg.add(new Pair<>(true,new Pair<>(0,null)));
                call.para_have_value_or_get_reg.add(new Pair<>(true,new Pair<>(getter.getSize(it.type,it.dim),null)));
                //System.out.println(para_length);
                BitcastInstruction bitcast = new BitcastInstruction("i8*",getter.getType(it.type,it.dim,null),call.res_toString(),current_function.reg_count++);
                current_block.addInstruction(call);
                current_block.addInstruction(bitcast);
                ClassDefNode cls = symbols.classTypes.get(it.type);
                if(cls.methodmap.containsKey(it.type)) {
                    CallInstruction construct = new CallInstruction(getter.getType(it.type, it.dim, null), it.type, call_statement_count++);
                    construct.para.add(getter.getType(it.type, it.dim, null) + " " + bitcast.res_toString());
                    construct.para_have_value_or_get_reg.add(new Pair<>(false,new Pair<>(null,bitcast.res_toString())));
                    current_block.addInstruction(construct);
                    it.get_reg = construct.res_toString();
                }else it.get_reg = bitcast.res_toString();
            }

//        } else {//并且mx的所有数组都是先alloca一个指针,这种写法不能适应mx的可变长数组，比如一个二维数组int[3][]，我的三个一维数组的维度是可以不相同的。
//            StringBuilder info = new StringBuilder();
//            it.expression.forEach(a-> {
//                info.append(" [");
//                a.accept(this);
//                String[]  strs=a.info_for_global_var.split(" ");
//                StringBuilder value = new StringBuilder();
//                for(int i=1,len=strs.length;i<len;i++){
//                    value.append(strs[i].toString());
//                }
//                info.append(value).append(" x ");
//                it.sizes.add(a.valueIR.values.get(0).number_value);
//            });
//            info.append(getter.getType(it.type, it.dim - it.expression.size(), null));
//            for(int i=0;i<it.expression.size();++i)info.append("]");
//            info.append(" zeroinitializer");
//            it.info_for_global_var = info.toString();
//            //it.sizes.forEach(System.out::println);
//        }
    }
    @Override
    public void visit(ParenExpressionNode it){
        it.expression.accept(this);
        it.get_reg = it.expression.get_reg;
    }

    @Override
    public void visit(ArrayIndexExpressionNode it){
        it.offset.accept(this);
        it.object.accept(this);
        //System.out.println(it.object.dim);
        String offset_reg;
        int offset_number = 0;
        if(it.offset.get_value){
            offset_reg = String.valueOf(it.offset.valueIR.values.get(0).number_value);
            offset_number = it.offset.valueIR.values.get(0).number_value;
        }else {
            offset_reg = it.offset.get_reg;
        }
        //System.out.println(it.object.dim);
        //System.out.println(getter.getType(it.object.type,it.object.dim, it.object.get_reg));
        GetElementPtrInstruction gep = new GetElementPtrInstruction(it.object.get_reg,offset_reg, getter.getType(it.object.type,it.object.dim, it.object.get_reg),it.object.dim,bracket_count++);
        gep.offset_number = offset_number;
        current_block.addInstruction(gep);
        if(it.visited_as_lhs){
            it.get_reg = gep.res_toString();
        }
        else {
            LoadInstruction load = new LoadInstruction(current_function.reg_count++,gep.res_toString(),getter.getType(it.type,it.dim,null));
            current_block.addInstruction(load);
            StringBuilder res = new StringBuilder();
            res.append("%");
            res.append(current_function.reg_count-1);
            it.get_reg = res.toString();
        }
    }
}
