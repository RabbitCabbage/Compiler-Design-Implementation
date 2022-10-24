package ast;

import util.Position;
import java.util.ArrayList;

public class ClassDefNode extends ASTNode{
    public ArrayList<BaseVariableDefNode> vardefs;
    public ArrayList<ArrayVariableDefNode> arraydefs;
    public ArrayList<FunctionDefNode> methoddefs;
    public String name;

    public ClassDefNode(Position pos, String name){
        super(pos);
        this.name = name;
        vardefs = new ArrayList<>();
        methoddefs = new ArrayList<>();
        arraydefs = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
