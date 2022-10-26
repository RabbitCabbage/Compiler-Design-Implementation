package ast;

import util.Position;

public class ParenExpressionNode extends ExpressionNode{
    public ExpressionNode expr;

    public ParenExpressionNode(Position pos, ExpressionNode expr)
    {
        super(pos);
        this.expr = expr;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
