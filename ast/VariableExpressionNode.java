package ast;

import util.Type;
import util.Position;

public class VariableExpressionNode extends ExpressionNode{
    public String name;

    public VariableExpressionNode(String name, Position pos){
        super(pos);
        this.name = name;
        type = null;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }

    @Override public boolean isAssignable(){
        return true;
    }
}
