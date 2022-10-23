package ast;

import util.Position;
import util.Type;

public class BinaryExpressionNode extends ExpressionNode{
    public ExpressionNode lhs,rhs;

    public enum binaryOp{
        add, sub, mul, div, mod, leftshift, rightshift, and, caret, or
    }

    public binaryOp opcode;

    public BinaryExpressionNode(ExpressionNode lhs, ExpressionNode rhs, binaryOp op, Type inttype, Position pos){
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        opcode = op;
        type = inttype;//这里的type是继承自自己的父类，有一个type的类型。
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
