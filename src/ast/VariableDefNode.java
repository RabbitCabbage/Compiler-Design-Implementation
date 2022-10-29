package ast;

import util.Position;

import java.util.ArrayList;

public class VariableDefNode extends StatementNode{
    public String typename;
    public int dim;//如果是数组，表示的是数组的维度。
    public ArrayList<DeclarationNode> declarations;

    public VariableDefNode(String tn, Position pos, int dim){
        super(pos);
        declarations = new ArrayList<>();
        typename = tn;
        this.dim = dim;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
