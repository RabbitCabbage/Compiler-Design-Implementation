package ast;
import util.Position;

public class DeclarationNode extends ASTNode{
    public ExpressionNode init;
    public String name;

    public DeclarationNode(String name,ExpressionNode expr,Position pos){
        super(pos);
        this.name = name;
        init = expr;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
