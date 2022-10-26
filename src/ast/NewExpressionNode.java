package ast;

import util.Position;

import java.util.ArrayList;

public class NewExpressionNode extends ExpressionNode{
    public ArrayList<ExpressionNode> expression = new ArrayList<>();
    public ClassDefNode class_ = null;

    public NewExpressionNode(Position pos, String type,int dim){
        super(pos);
        this.type = type;
        this.dim = dim;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
