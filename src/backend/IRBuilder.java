package backend;

import IR.*;
import IR.IRTypeGetter;
import IR.Instruction.*;
import ast.*;
import frontend.Symbols;

public class IRBuilder extends ASTVisitor {
    public LLVM llvm;
    public Symbols symbols;
    public IRTypeGetter getter;

    public IRBuilder(Symbols symbols) {
        this.symbols = symbols;
        llvm = new LLVM(symbols);
        getter = new IRTypeGetter(symbols);
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
        if (it.is_global) it.declarations.forEach(a -> llvm.globalVars.put(a.name, new GlobalVarIR(a)));//收集变量定义
        it.declarations.forEach(a -> {
            a.type = it.typename;
            a.dim = it.dim;
            a.accept(this);
        });
    }

    @Override
    public void visit(DeclarationNode it) {
        int reg = current_function.reg_count++;
        String type = getter.getType(it.type);
        int align = getter.getAlign(it.type);
        AllocaInstruction alloc = new AllocaInstruction(reg, type, align);
        current_block.addInstruction(alloc);
        if (it.init != null) {
            it.init.accept(this);
            int value = 0;//todo
            StoreInstruction store = new StoreInstruction(value, type, reg, align);
            current_block.addInstruction(store);
        }
    }

    @Override
    public void visit(FunctionDefNode it) {
        current_function = new FunctionIR(it);
        llvm.functions.put(it.name, current_function);//收集函数定义
        current_block = new BlockIR(current_function.reg_count++);
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
        BlockIR then_block = new BlockIR(current_function.reg_count++);
        BlockIR else_block = new BlockIR(current_function.reg_count++);
        BlockIR next_block = new BlockIR(current_function.reg_count++);
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
        System.out.print(current_block.block_id);

        branch_is_returned = false;
        current_block = then_block;
        it.thenstmt.accept(this);
        if (!branch_is_returned) {
            BrInstruction then_br = new BrInstruction(-1, next_index, 0);
            current_block.addInstruction(then_br);
            current_function.blocks.add(current_block);
            System.out.print(current_block.block_id);
        }

        if (it.elsestmt != null) {
            branch_is_returned = false;
            current_block = else_block;
            it.elsestmt.accept(this);
            if (!branch_is_returned) {
                BrInstruction else_br = new BrInstruction(-1, next_index, 0);
                current_block.addInstruction(else_br);
                current_function.blocks.add(current_block);
                System.out.print(current_block.block_id);
            }
        }

        current_block = next_block;
    }

    @Override
    public void visit(WhileStatementNode it) {
        BlockIR loopbody = new BlockIR(current_function.reg_count++);
        BlockIR next_block = new BlockIR(current_function.reg_count++);
        int loop_index = current_function.reg_count - 2;
        int next_index = current_function.reg_count - 1;

        it.condition.accept(this);
        int cond = current_function.reg_count - 1;

        BrInstruction br_in = new BrInstruction(cond, loop_index, next_index);
        current_block.addInstruction(br_in);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);

        current_block = loopbody;
        current_loop_index = loop_index;
        it.stmt.accept(this);
        BrInstruction br_out = new BrInstruction(cond, loop_index, next_index);
        current_block.addInstruction(br_out);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);

        current_block = next_block;
    }

    @Override
    public void visit(ForStatementNode it) {
        if (it.var != null) it.var.accept(this);
        it.condition.accept(this);
        int cond = current_function.reg_count - 1;
        BlockIR for_step = new BlockIR(current_function.reg_count++);
        BlockIR loopbody = new BlockIR(current_function.reg_count++);
        BlockIR next = new BlockIR(current_function.reg_count++);
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
        System.out.print(current_block.block_id);

        current_block = loopbody;
        current_loop_index = loop_index;
        it.stmts.accept(this);
        current_block.addInstruction(br_out);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);

        current_block = for_step;
        it.next.accept(this);
        current_block.addInstruction(br_after_step);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);

        current_block = next;
    }

    @Override
    public void visit(BreakStatementNode it) {
        BlockIR next = new BlockIR(current_function.reg_count++);
        BrInstruction br = new BrInstruction(-1, current_function.reg_count - 1, 0);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);
        current_block = next;
    }

    @Override
    public void visit(ContinueStatementNode it) {
        BrInstruction br = new BrInstruction(-1, current_loop_index, 0);
        current_block.addInstruction(br);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);
        current_block = new BlockIR(current_function.reg_count++);
    }

    @Override
    public void visit(ReturnStatementNode it) {
        branch_is_returned = true;
        it.value.accept(this);
        int return_reg = current_function.reg_count - 1;
        RetInstruction ret = new RetInstruction(return_reg, getter.getType(it.value.type));
        current_block.addInstruction(ret);
        current_function.blocks.add(current_block);
        System.out.print(current_block.block_id);
    }
    @Override
    public void visit(PrimaryExpressionNode it){}

    @Override
    public void visit(BinaryExpressionNode it){
        it.lhs.accept(this);
        int lhs_reg = current_function.reg_count-1;
        it.rhs.accept(this);
        int rhs_reg = current_function.reg_count-1;
        int res_reg = current_function.reg_count++;
        String type = getter.getType(it.lhs.type);
        BinaryInstruction binary = new BinaryInstruction(it.opcode,lhs_reg,rhs_reg,type,res_reg);
        current_block.addInstruction(binary);
    }

    @Override
    public void visit(AssignmentExpressionNode it){}
}
