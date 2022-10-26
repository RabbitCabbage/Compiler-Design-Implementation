package ast;

import util.Position;

public class MemberCallExpressionNode extends ExpressionNode{
    public ExpressionNode object;
    public String id;

    public MemberCallExpressionNode(Position pos, ExpressionNode obj, String id){
        super(pos);
        this.object = obj;
        this.id = id;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
