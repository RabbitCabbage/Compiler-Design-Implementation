package ast;

import util.Position;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassDefNode extends ASTNode{
    public String name;
    //这个里面记下了定义了那些变量函数，以node 的方式
    public ArrayList<FunctionDefNode> methoddefs;
    public ArrayList<VariableDefNode> vardefs;

    //这个里面要记下这些变量的映射，从名字到node
    public HashMap<String,FunctionDefNode> methodmap;
    public HashMap<String,VariableDefNode> variablemap;

    public ClassDefNode(Position pos, String name){
        super(pos);
        this.name = name;
        vardefs = new ArrayList<>();
        methoddefs = new ArrayList<>();
        methodmap = new HashMap<>();
        variablemap = new HashMap<>();
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
