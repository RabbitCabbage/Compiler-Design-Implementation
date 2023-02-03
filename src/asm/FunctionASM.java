package asm;

import IR.FunctionIR;
import asm.Instruction.InstructionASM;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionASM {
    public int stack_pointer = 0;
    public int function_count;
    public String IR_name;

    public HashMap<String, Integer> vreg_to_sp;
    public ArrayList<BlockASM> blocks;
    FunctionASM(FunctionIR ir_func){
        blocks = new ArrayList<>();
        IR_name = ir_func.IR_name;
        vreg_to_sp  = new HashMap<>();
    }
}
