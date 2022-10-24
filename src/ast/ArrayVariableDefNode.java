package ast;

import java.util.ArrayList;
import util.Position;

public class ArrayVariableDefNode extends ASTNode {
    public String typename;
    public ArrayList<DeclarationNode> declarations;

    public ArrayVariableDefNode(String tn,Position pos){
        super(pos);
        typename = tn;
        declarations = new ArrayList<>();
    }

   public void accept(ASTVisitor visitor){
       visitor.visit(this);
   }
}
