package ast;

import util.Position;


public class BuiltInFunctionExpressionNode extends ExpressionNode{
    public ExpressionNode expression;

    public enum functionType1{
        getstring, getint, tostring
    }

    functionType1 function;

    public BuiltInFunctionExpressionNode(ExpressionNode expression, functionType1 ft, Position pos){
        super(pos);
        this.expression = expression;
        this.function = ft;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
