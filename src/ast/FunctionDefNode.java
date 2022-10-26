package ast;

import util.Position;
import java.util.ArrayList;

public class FunctionDefNode extends ASTNode{
    public StatementNode stmts;
    public ClassDefNode belong = null;
    public String name;
    public ArrayList<ParameterNode> parameterlist;
    String returntype;
    int returndim;

    public FunctionDefNode(String type,int dim, String name, StatementNode st,ClassDefNode belong,Position pos){
        super(pos);
        returndim = dim;
        stmts = st;
        this.returntype = type;
        this.belong = belong;
        parameterlist = new ArrayList<>();
        this.name = name;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
