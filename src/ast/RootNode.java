package ast;
import util.Position;
import java.util.ArrayList;

public class RootNode extends ASTNode{
    public ArrayList<FunctionDefNode> funcdefs;
    public ArrayList<ClassDefNode> classdefs;
    public ArrayList<BaseVariableDefNode> vardefs;

    public ArrayList<ArrayVariableDefNode> arraydefs;

    public RootNode(Position pos){
        super(pos);
        funcdefs = new ArrayList<>();
        classdefs = new ArrayList<>();
        vardefs = new ArrayList<>();
        arraydefs = new ArrayList<>();
        //之后会在处理programSection的时候把相应的元素都加到对应的Arraylist中。
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
