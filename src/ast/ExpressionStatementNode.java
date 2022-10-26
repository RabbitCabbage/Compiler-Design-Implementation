package ast;

import util.Position;

public class ExpressionStatementNode extends StatementNode{
    public ExpressionNode expression;

    public ExpressionStatementNode(ExpressionNode expr, Position pos){
        super(pos);
        expression = expr;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
