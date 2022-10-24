package ast;

import util.Position;

import java.util.ArrayList;

public class BaseVariableDefNode extends StatementNode{
    public String typename;
    public ArrayList<DeclarationNode> declarations;

    public BaseVariableDefNode(String tn, Position pos){
        super(pos);
        declarations = new ArrayList<>();
        typename = tn;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
