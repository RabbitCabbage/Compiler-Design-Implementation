package ast;

import util.Position;

public class ReturnStatementNode extends StatementNode{
    public ExpressionNode value;

    public ReturnStatementNode(ExpressionNode value, Position pos){
        super(pos);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
