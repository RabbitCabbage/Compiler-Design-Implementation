package IR;

import asm.ASMBuilder;
import ast.FunctionDefNode;

import java.util.ArrayList;

public class FunctionIR {
    public FunctionDefNode funcdef;
    public ArrayList<String> para_names;
    public ArrayList<BlockIR> blocks;
    public int reg_count = 0;
    public String IR_name;
    public FunctionIR(FunctionDefNode fc){
        funcdef = fc;
        blocks = new ArrayList<>();
        para_names = new ArrayList<>();
    }
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
