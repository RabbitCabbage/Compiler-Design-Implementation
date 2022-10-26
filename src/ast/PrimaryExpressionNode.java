package ast;

import util.Position;

public class PrimaryExpressionNode extends ExpressionNode{
    public int type;
    public String primaryExpression;

    public PrimaryExpressionNode(Position pos,int t,String s){
        super(pos);
        type = t;
        primaryExpression = s;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
