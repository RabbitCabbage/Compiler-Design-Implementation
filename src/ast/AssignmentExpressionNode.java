package ast;

import util.Position;

public class AssignmentExpressionNode extends ExpressionNode{
    public ExpressionNode lhs,rhs;

    public AssignmentExpressionNode(ExpressionNode lhs,ExpressionNode rhs,Position pos){
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
