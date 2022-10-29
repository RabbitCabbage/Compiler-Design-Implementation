package ast;

import java.util.ArrayList;
import util.Position;

public class CallExpressionNode extends ExpressionNode{
    public ExpressionNode object;
    public FunctionDefNode func = null;
    public ArrayList<ExpressionNode> auguments = new ArrayList<>();

    public CallExpressionNode(Position pos, ExpressionNode obj){
        super(pos);
        this.object = obj;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
