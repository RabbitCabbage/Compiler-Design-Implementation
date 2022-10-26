package ast;

import util.Position;

public class BreakStatementNode extends StatementNode{
    public BreakStatementNode(Position pos){
        super(pos);
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
