package ast;

import util.Position;

public class SuffixExpressionNode extends ExpressionNode{
    public String op;
    public ExpressionNode object;

    public SuffixExpressionNode(Position pos, ExpressionNode obj,String op){
        super(pos);
        this.object = obj;
        this.op = op;
    }
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
