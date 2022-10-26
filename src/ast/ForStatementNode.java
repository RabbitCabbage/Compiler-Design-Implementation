package ast;

import util.Position;

public class ForStatementNode extends StatementNode{
    public VariableDefNode var;
    public ExpressionNode init,condition,next;
    public StatementNode stmts;

    public ForStatementNode(VariableDefNode var, ExpressionNode init, ExpressionNode condition, ExpressionNode next, Position pos,StatementNode stmts){
        super(pos);
        this.var = var;
        this.stmts = stmts;
        this.condition = condition;
        this.next = next;
        this.init = init;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
