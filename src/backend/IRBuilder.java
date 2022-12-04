package backend;

import IR.*;
import IR.IRTypeGetter;
import IR.Instruction.*;
import ast.*;
import frontend.Symbols;
import parser.MxParser;

public class IRBuilder extends ASTVisitor {
    public LLVM llvm;
    public Symbols symbols;
    public IRTypeGetter getter;
    public int if_statement_count;
    public int loop_statement_count;
    public int call_statement_count;
    public int binary_expression_count;

    public IRBuilder(Symbols symbols) {
        this.symbols = symbols;
        llvm = new LLVM(symbols);
        getter = new IRTypeGetter(symbols);
        if_statement_count = 0;
        loop_statement_count = 0;
        call_statement_count = 0;
        binary_expression_count = 0;
    }

    public FunctionIR current_function;//用来记下现在正在处理的函数，以便于给这个函数加block
    public BlockIR current_block;
    public int current_loop_index;
    public boolean branch_is_returned = false;

    @Override
    public void visit(RootNode it) {
        it.vardefs.forEach(a -> a.accept(this));
        it.funcdefs.forEach(a -> a.accept(this));
        it.classdefs.forEach(a -> a.accept(this));
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
        String type = getter.getType(it.type);
        if(current_block == null){
            it.init.accept(this);
            return;
        }
        AllocaInstruction alloc = new AllocaInstruction(name, type);
        current_block.addInstruction(alloc);
        if (it.init != null) {
            it.init.accept(this);
            if(it.init.get_value){
                ValueUnit unit = it.init.valueIR.values.get(0);
                StoreInstruction store = new StoreInstruction(unit, type, name);
                current_block.addInstruction(store);
            }else {
                StoreInstruction store = new StoreInstruction(it.init.get_reg,type,name);
                current_block.addInstruction(store);
            }
        }
    }

    @Override
    public void visit(FunctionDefNode it) {
        current_function = new FunctionIR(it);
        llvm.functions.put(it.name, current_function);//收集函数定义
        current_block = new BlockIR("entry");
        it.parameterlist.forEach(a->{
            current_function.para_names.add(a.declare.name);
            AllocaInstruction alloca = new AllocaInstruction(a.declare.name+".addr",getter.getType(a.type));
            current_block.addInstruction(alloca);
        });
        it.parameterlist.forEach(a -> {
            StoreInstruction store = new StoreInstruction(a.declare.name,getter.getType(a.type),a.declare.name+".addr");
            current_block.addInstruction(store);
        });
        it.stmts.stmts.forEach(a -> a.accept(this));//访问每一个具体的语句，把它翻译成llvm
    }

    @Override
    public void visit(ClassDefNode it) {
        llvm.classes.put(it.name, new ClassIR(it));//收集类定义
        it.methoddefs.forEach(a -> a.accept(this));
        it.vardefs.forEach(a -> a.declarations.forEach(b -> b.accept(this)));
    }

    //在visit的时候把function内部的块串好，串起来，并且把其中的具体的statement放进去
    @Override
    public void visit(IfStatementNode it) {
        //现在current_block还在if的外面
        it.condition.accept(this);
        int cond = current_function.reg_count - 1;
        if_statement_count++;
        StringBuilder count = new StringBuilder();
        count.append(if_statement_count);
        BlockIR then_block = new BlockIR("then_block"+count.toString());
        BlockIR else_block = new BlockIR("else_block"+count.toString());
        BlockIR next_block = new BlockIR("next_block_after_if"+count.toString());
        int then_index = current_function.reg_count - 3;
        int else_index = current_function.reg_count - 2;
        int next_index = current_function.reg_count - 1;

        BrInstruction br;
        if (it.elsestmt == null) {
            BrInstruction br_1 = new BrInstruction(cond, then_index, else_index);
            br = br_1;
        } else {
            BrInstruction br_2 = new BrInstruction(cond, then_index, next_index);
            br = br_2;
        }
        current_block.addInstruction(br);//现在if外面的块已经结束，下面是then，else和next
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        branch_is_returned = false;
        current_block = then_block;
        it.thenstmt.accept(this);
        if (!branch_is_returned) {
            BrInstruction then_br = new BrInstruction(-1, next_index, 0);
            current_block.addInstruction(then_br);
            current_function.blocks.add(current_block);
            //System.out.print(current_block.block_id);
        }

        if (it.elsestmt != null) {
            branch_is_returned = false;
            current_block = else_block;
            it.elsestmt.accept(this);
            if (!branch_is_returned) {
                BrInstruction else_br = new BrInstruction(-1, next_index, 0);
                current_block.addInstruction(else_br);
                current_function.blocks.add(current_block);
                //System.out.print(current_block.block_id);
            }
        }

        current_block = next_block;
    }

    @Override
    public void visit(CallExpressionNode it){
        int call_reg;
        if(it.func.returntype.equals("void"))call_reg = 0;
        else call_reg = call_statement_count++;
        //System.out.println("NAME = " + it.func.name);
        CallInstruction call = new CallInstruction(getter.getType(it.func.returntype),it.func.name,call_reg);
        it.auguments.forEach(a->{
            a.accept(this);
            if(a.get_value){
                StringBuilder para = new StringBuilder();
                para.append(getter.getType(a.type)).append(" ").append(a.type.equals("int")?a.valueIR.values.get(0).number_value:(a.type.equals("string")?a.valueIR.values.get(0).string_value:a.valueIR.values.get(0).bool_value));
                call.para.add(para.toString());
            }
            else {
                StringBuilder para = new StringBuilder();
                para.append(getter.getType(a.type)).append(" %").append(a.get_reg);
                call.para.add(para.toString());
            }
        });
        current_block.addInstruction(call);
        StringBuilder callx = new StringBuilder();
        callx.append("call").append(call_reg);
        it.get_reg = callx.toString();
    }

    @Override
    public void visit(WhileStatementNode it) {
        loop_statement_count++;
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BlockIR loopbody = new BlockIR("loop_body"+count.toString());
        BlockIR next_block = new BlockIR("next_block_after_loop"+count.toString());
        int loop_index = current_function.reg_count - 2;
        int next_index = current_function.reg_count - 1;

        it.condition.accept(this);
        int cond = current_function.reg_count - 1;

        BrInstruction br_in = new BrInstruction(cond, loop_index, next_index);
        current_block.addInstruction(br_in);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        current_block = loopbody;
        current_loop_index = loop_index;
        it.stmt.accept(this);
        BrInstruction br_out = new BrInstruction(cond, loop_index, next_index);
        current_block.addInstruction(br_out);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        current_block = next_block;
    }

    @Override
    public void visit(ForStatementNode it) {
        if (it.var != null) it.var.accept(this);
        it.condition.accept(this);
        int cond = current_function.reg_count - 1;
        loop_statement_count++;
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BlockIR for_step = new BlockIR("for_step"+count.toString());
        BlockIR loopbody = new BlockIR("loop_body"+count.toString());
        BlockIR next = new BlockIR("next_block_after_loop"+count.toString());
        int step_index = current_function.reg_count - 3;
        int loop_index = current_function.reg_count - 2;
        int next_index = current_function.reg_count - 1;
        BrInstruction br_in = new BrInstruction(cond, loop_index, next_index);
        //如果满足条件就去执行循环体，不满足条件就去执行后面的指令
        BrInstruction br_out = new BrInstruction(-1, step_index, 0);
        //执行完循环体直接就去执行for的step，执行完step再做检查
        BrInstruction br_after_step = new BrInstruction(cond, loop_index, next_index);

        current_block.addInstruction(br_in);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        current_block = loopbody;
        current_loop_index = loop_index;
        it.stmts.accept(this);
        current_block.addInstruction(br_out);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        current_block = for_step;
        it.next.accept(this);
        current_block.addInstruction(br_after_step);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);

        current_block = next;
    }

    @Override
    public void visit(BreakStatementNode it) {
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BlockIR next = new BlockIR("next_block_after_loop"+count.toString());
        BrInstruction br = new BrInstruction(-1, current_function.reg_count - 1, 0);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        current_block = next;
    }

    @Override
    public void visit(ContinueStatementNode it) {
        StringBuilder count = new StringBuilder();
        count.append(loop_statement_count);
        BrInstruction br = new BrInstruction(-1, current_loop_index, 0);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
        current_block = new BlockIR("loop_body"+count.toString());
    }

    @Override
    public void visit(ReturnStatementNode it) {
        branch_is_returned = true;
        if(it.value == null){
            RetInstruction ret = new RetInstruction(0,null,true);
            current_block.addInstruction(ret);
            current_function.blocks.add(current_block);
            return;
        }
        it.value.accept(this);
        int return_reg = current_function.reg_count - 1;
        RetInstruction ret = new RetInstruction(return_reg, getter.getType(it.value.type),false);
        current_block.addInstruction(ret);
        current_function.blocks.add(current_block);
        //System.out.print(current_block.block_id);
    }
    @Override
    public void visit(PrimaryExpressionNode it){
        if(it.exprtype == PrimaryExpressionNode.ExpressionType.identifierExpr){
            // todo if there is a var of the same name shadowing the parameters
            // todo global variables should be referenced to by @
            LoadInstruction load = new LoadInstruction(current_function.reg_count++,(current_function.para_names.contains(it.primaryExpression)?(it.primaryExpression+".addr"):it.primaryExpression),getter.getType(it.type));
            current_block.addInstruction(load);
            StringBuilder tmp = new StringBuilder();
            tmp.append(current_function.reg_count - 1);
            it.get_reg = tmp.toString();
        }if(it.exprtype == PrimaryExpressionNode.ExpressionType.stringLiteralExpr){
            StringBuilder str = new StringBuilder();
            str.append(it.primaryExpression);
            str.deleteCharAt(0);
            str.deleteCharAt(str.length()-1);
            it.primaryExpression = str.toString();
            ValueUnit unit = new ValueUnit(null,it.primaryExpression,null);
            it.valueIR.values.add(unit);
            it.get_value = true;
        }if(it.exprtype == PrimaryExpressionNode.ExpressionType.integerLiteralExpr){
            ValueUnit unit = new ValueUnit(Integer.parseInt(it.primaryExpression),null,null);
            //System.out.println(it.primaryExpression);
            //System.out.println(unit.number_value);
            it.valueIR.values.add(unit);
            it.get_value = true;
        }if(it.exprtype == PrimaryExpressionNode.ExpressionType.boolLiteralExpr){
            ValueUnit unit = new ValueUnit(null,null,Boolean.parseBoolean(it.primaryExpression));
            it.valueIR.values.add(unit);
            it.get_value = true;
        }
    }

    @Override
    public void visit(BinaryExpressionNode it){
        it.lhs.accept(this);
        String lhs_reg = it.lhs.get_reg;
        it.rhs.accept(this);
        String rhs_reg = it.rhs.get_reg;
        int res_reg = binary_expression_count++;
        String type = getter.getType(it.lhs.type);
        BinaryInstruction binary = new BinaryInstruction(it.opcode,lhs_reg,rhs_reg,type,res_reg);
        current_block.addInstruction(binary);
    }

    @Override
    public void visit(ExpressionStatementNode it){
        it.expression.accept(this);
    }
    @Override
    public void visit(AssignmentExpressionNode it){
        it.rhs.accept(this);
        it.lhs.accept(this);
    }
}
