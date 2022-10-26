package ast;

import java.util.ArrayList;
import util.Position;

public class FunctionCallExpressionNode extends ExpressionNode{
    public ExpressionNode object;
    public FunctionDefNode func = null;
    public ArrayList<ExpressionNode> auguments = new ArrayList<>();

    public FunctionCallExpressionNode(Position pos,ExpressionNode obj){
        super(pos);
        this.object = obj;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
