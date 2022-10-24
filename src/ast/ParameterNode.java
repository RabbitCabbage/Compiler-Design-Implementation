package ast;

import util.Position;

import java.util.HashMap;

public class ParameterNode extends ASTNode{
    public HashMap<String,String> paralist;

    public ParameterNode(Position pos){
        super(pos);
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
