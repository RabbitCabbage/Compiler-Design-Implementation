package asm;

import asm.Instruction.InstructionASM;

import java.util.ArrayList;

public class BlockASM {
    public ArrayList<InstructionASM> instrs;
    public String block_id;

    public BlockASM(String block_name, int func_count){
        block_id = block_name +"."+ String.valueOf(func_count);
        instrs = new ArrayList<>();
    }
}
