package IR;

import IR.Instruction.InstructionIR;

import java.util.ArrayList;

public class BlockIR {
    public ArrayList<InstructionIR> instrs;
    public StringBuilder block_id;//block的名字
    public BlockIR(int count){
        instrs = new ArrayList<>();
        StringBuilder info = new StringBuilder();
        info.append(count);
        block_id = info;
    }
    public void addInstruction(InstructionIR instr){
        instrs.add(instr);
    }
}
