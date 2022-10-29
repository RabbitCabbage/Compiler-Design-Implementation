package ast;

import util.Position;

public class WhileStatementNode extends StatementNode{
    public ExpressionNode condition= null;
    public StatementNode stmt;

    public WhileStatementNode(ExpressionNode expr, StatementNode st, Position pos){
        super(pos);
        this.condition = expr;
        this.stmt = st;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
