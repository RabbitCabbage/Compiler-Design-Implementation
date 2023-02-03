package asm;

import IR.FunctionIR;
import asm.Instruction.InstructionASM;

import java.util.ArrayList;

public class FunctionASM {
    public int stack_pointer = 0;
    public String IR_name;

    public ArrayList<InstructionASM> instrs;
    FunctionASM(FunctionIR ir_func){
        instrs = new ArrayList<>();
        IR_name = ir_func.IR_name;
    }
}
