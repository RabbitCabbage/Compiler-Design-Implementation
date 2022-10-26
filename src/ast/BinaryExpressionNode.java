package ast;

import util.Position;

public class BinaryExpressionNode extends ExpressionNode{
    public ExpressionNode lhs,rhs;

    public String opcode;

    public BinaryExpressionNode(ExpressionNode lhs, ExpressionNode rhs, String op, Position pos){
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        opcode = op;
        type = "int";//这里的type是继承自自己的父类，有一个type的类型。
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
