package ast;

import util.Position;


public class BuiltInFunctionExpressionNode extends ExpressionNode{
    public ExpressionNode expression;

    public enum functionType{
        getstring, getint, tostring
    }

    functionType function;

    public BuiltInFunctionExpressionNode(ExpressionNode expression, functionType ft, Position pos){
        super(pos);
        this.expression = expression;
        this.function = ft;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
