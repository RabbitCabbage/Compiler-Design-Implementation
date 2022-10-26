package ast;

import util.Position;

import java.util.HashMap;

public class ParameterNode extends ASTNode{
    public String type;
    public int dim;
    public DeclarationNode declare;

    public ParameterNode(Position pos,String type, int dim, DeclarationNode decl)
    {
        super(pos);
        this.type = type;
        this.dim = dim;
        this.declare = decl;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
