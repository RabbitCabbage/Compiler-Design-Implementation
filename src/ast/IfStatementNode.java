package ast;

import util.Position;
import java.util.ArrayList;

public class IfStatementNode extends StatementNode{
    public ExpressionNode condition;
    public StatementNode thenstmt;
    public StatementNode elsestmt;

    public IfStatementNode(ExpressionNode cdt, StatementNode thenstmt, StatementNode elsestmt,Position pos){
        super(pos);
        this.condition = cdt;
        this.thenstmt = thenstmt;
        this.elsestmt = elsestmt;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
