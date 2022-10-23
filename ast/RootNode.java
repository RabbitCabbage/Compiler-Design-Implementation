package ast;
import util.Position;
import java.util.ArrayList;
import parser.MxParser;
public class RootNode extends ASTNode{
    public MainFunctionNode mainfunc;
    public ArrayList<FunctionDefNode> funcdefs;
    public ArrayList<ClassDefNode> classdefs;
    public ArrayList<VariableDefNode> vardefs;

    public RootNode(Position pos, MainFunctionNode mfn){
        super(pos);
        mainfunc = mfn;
        funcdefs = new ArrayList<FunctionDefNode>();
        classdefs = new ArrayList<ClassDefNode>();
        //之后会在处理programSection的时候把相应的元素都加到对应的Arraylist中。
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
