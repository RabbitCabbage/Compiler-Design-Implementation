package ast;


import util.Position;

public class ContinueStatementNode extends StatementNode{
    public ContinueStatementNode(Position pos){
        super(pos);
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
