package ast;

import util.Position;
import java.util.ArrayList;

public class FunctionDefNode extends ASTNode{
    public ArrayList<StatementNode> stmts;
    public String name;
    public ParameterNode parameterlist;
    String returntype;

    public FunctionDefNode(String type, String name,ParameterNode para,Position pos){
        super(pos);
        returntype = type;
        stmts = new ArrayList<>();
        parameterlist = para;
        this.name = name;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
