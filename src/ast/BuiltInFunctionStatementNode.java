package ast;

import util.Position;

public class BuiltInFunctionStatementNode extends StatementNode{
    public ExpressionNode parameter;
    public enum functionType2{
        print, printint, printlnint,println
    }
    functionType2 function;

    public BuiltInFunctionStatementNode(Position pos, functionType2 type){
        super(pos);
        function = type;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
