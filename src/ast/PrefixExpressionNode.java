package ast;

import frontend.ASTBuilder;
import util.Position;

public class PrefixExpressionNode extends ExpressionNode{
    public String op;
    public ExpressionNode object;

    public PrefixExpressionNode(Position pos, ExpressionNode obj, String op){
        super(pos);
        this.op = op;
        this.object = obj;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public void calculate(){
       //todo
    }
}
