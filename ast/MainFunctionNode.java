package ast;

import util.Position;
import java.util.ArrayList;

public class MainFunctionNode extends ASTNode{
    public ArrayList<StatementNode> stmts;

    public MainFunctionNode(Position pos){
        super(pos);
        stmts = new ArrayList<StatementNode>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
