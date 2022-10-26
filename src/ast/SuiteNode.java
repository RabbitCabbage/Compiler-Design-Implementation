package ast;

import util.Position;

import java.util.ArrayList;

public class SuiteNode extends StatementNode{
    public ArrayList<StatementNode> stmts;

    public SuiteNode(Position pos){
        super(pos);
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
