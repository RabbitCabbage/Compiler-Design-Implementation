package ast;

import util.Position;
//todo 计算出表达式的值，可能需要后来的相关实现。
public abstract class ExpressionNode extends ASTNode{
    public String type;
    public int dim;
    public boolean assignable = false;
    public boolean newed = false;
    public FunctionDefNode is_function = null;

    public boolean should_be_function = false;
    public ExpressionNode(Position pos){
        super(pos);
    }

    public boolean isAssignable(){
        return assignable;
    }
}
