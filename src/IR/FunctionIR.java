package IR;

import ast.FunctionDefNode;

import java.util.ArrayList;

public class FunctionIR {
    public FunctionDefNode funcdef;
    public ArrayList<BlockIR> blocks;
    public int reg_count = 0;
    // todo parameters and scope
    public FunctionIR(FunctionDefNode fc){
        funcdef = fc;
        blocks = new ArrayList<>();
    }
}
