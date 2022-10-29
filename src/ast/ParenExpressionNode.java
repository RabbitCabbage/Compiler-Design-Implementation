package ast;

import util.Position;

public class ParenExpressionNode extends ExpressionNode{
    public ExpressionNode expression;

    public ParenExpressionNode(Position pos, ExpressionNode expr)
    {
        super(pos);
        this.expression = expr;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
