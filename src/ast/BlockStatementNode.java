package ast;

import java.util.ArrayList;
import util.Position;

public class BlockStatementNode extends StatementNode{
    public ArrayList<StatementNode> stmts;
    public BlockStatementNode(Position pos){
        super(pos);
        stmts = new ArrayList<>();
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
