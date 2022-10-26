package ast;

import util.Position;
//todo 计算出表达式的值，可能需要后来的相关实现。
public abstract class ExpressionNode extends ASTNode{
    public String type;
    int dim;
    public ExpressionNode(Position pos){
        super(pos);
    }

    public boolean isAssignable(){
        return false;
    }
}
