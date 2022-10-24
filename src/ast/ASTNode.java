package ast;
import util.Position;

abstract public class ASTNode {
    public Position pos;

    public ASTNode(Position p){pos=p;}

    abstract public void accept(ASTVisitor visitor);//表示的是这个类的节点被访问（怎么extend)
}
