package ast;

import util.Position;

public class BuiltInFunctionStatementNode extends StatementNode{
    public ExpressionNode parameter;
    public enum functionType{
        print, printint, printlnint
    }
    functionType function;

    public BuiltInFunctionStatementNode(Position pos, functionType type){
        super(pos);
        function = type;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
