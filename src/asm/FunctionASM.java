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
    public HashMap<String, String> para_to_areg_sp;//指的是这个函数的参数分别对应到a0~a7，或者有一部分spill到栈上，我的想法是按顺序，a0~a7,多出来的spill到0，4……
    public ArrayList<BlockASM> blocks;
    FunctionASM(FunctionIR ir_func){
        blocks = new ArrayList<>();
        IR_name = ir_func.IR_name;
        vreg_to_sp  = new HashMap<>();
        para_to_areg_sp = new HashMap<>();
    }
}
