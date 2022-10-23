package ast;

import util.Position;
import java.util.ArrayList;

public class ClassDefNode extends ASTNode{
    public ArrayList<VariableDefNode> vardefs;
    public ArrayList<FunctionDefNode> methoddefs;
    public String name;

    public ClassDefNode(Position pos, String name){
        super(pos);
        this.name = name;
        vardefs = new ArrayList<>();
        methoddefs = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
