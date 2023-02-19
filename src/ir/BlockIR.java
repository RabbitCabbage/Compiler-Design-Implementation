package ir;

import ir.Instruction.BrInstruction;
import ir.Instruction.InstructionIR;

import java.util.ArrayList;

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
        if(!instrs.isEmpty() && instrs.get(instrs.size()-1).getClass().toString().equals("class IR.Instruction.BrInstruction")&&((BrInstruction)instrs.get(instrs.size()-1)).label1.equals("exit")){
            return;
        } else {
            instrs.add(instr);
        }
    }
}
