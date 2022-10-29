package ast;

import util.Position;
import java.util.ArrayList;

public class FunctionDefNode extends ASTNode{
    public SuiteNode stmts;
    public ClassDefNode belong = null;
    public String name;
    public ArrayList<ParameterNode> parameterlist;
    public String returntype = null;
    public int returndim;
    public boolean is_constructor = false;

    public boolean has_been_returned = false;
    public boolean is_lambda = false;

    public FunctionDefNode(String type,int dim, String name, SuiteNode st,ClassDefNode belong,Position pos){
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
