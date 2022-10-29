package ast;

import util.Position;

public class PrimaryExpressionNode extends ExpressionNode{
    public enum ExpressionType{
        boolLiteralExpr,integerLiteralExpr,stringLiteralExpr,nullLiteralExpr,thisExpr,identifierExpr
    }
    public String primaryExpression;
    public ExpressionType exprtype;

    public PrimaryExpressionNode(Position pos,String s){
        super(pos);
        primaryExpression = s;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
