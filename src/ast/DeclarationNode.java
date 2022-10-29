package ast;
import util.Position;

public class DeclarationNode extends ASTNode{
    public ExpressionNode init = null;
    public String name;
    public String type;
    public int dim;//如果是数组将具有这个int作为维度。
    public ClassDefNode belong = null;

    public DeclarationNode(String name,ExpressionNode expr,Position pos){
        super(pos);
        this.name = name;
        init = expr;
    }

    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}
