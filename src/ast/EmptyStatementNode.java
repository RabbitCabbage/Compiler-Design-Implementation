package ast;

import util.Position;

public class EmptyStatementNode extends StatementNode{
    public EmptyStatementNode(Position pos){
        super(pos);
    }
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
