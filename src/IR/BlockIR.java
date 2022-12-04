package IR;

import IR.Instruction.InstructionIR;

import java.util.ArrayList;
import java.util.Map;

public class BlockIR {
    public ArrayList<InstructionIR> instrs;
    public StringBuilder block_id;//block的名字
    public BlockIR(String blockid){
        instrs = new ArrayList<>();
        StringBuilder info = new StringBuilder();
        info.append(blockid);
        block_id = info;
    }
    public void addInstruction(InstructionIR instr){
        instrs.add(instr);
    }
}
