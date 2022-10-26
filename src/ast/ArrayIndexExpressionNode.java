package ast;

import util.Position;

public class ArrayIndexExpressionNode extends ExpressionNode{
    public ExpressionNode object,offset;

    public ArrayIndexExpressionNode(Position pos, ExpressionNode obj,ExpressionNode os){
        super(pos);
        this.object = obj;
        this.offset = os;
    }

    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
