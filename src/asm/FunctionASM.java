package asm;

import asm.graph.ControlFlowGraph;
import asm.operand.StackPointer;
import asm.operand.VirtualRegister;
import ir.FunctionIR;

import java.util.LinkedHashMap;

public class FunctionASM {
    public int stack_pointer;
    public int function_count;
    public String ir_func_name;
    public ControlFlowGraph cfg;
    public LinkedHashMap<String, GlobalVar> global;
    public LinkedHashMap<String, StackPointer> spilledVars = new LinkedHashMap<>();
    public LinkedHashMap<String, VirtualRegister> virtualVar = new LinkedHashMap<>();
    public FunctionASM(FunctionIR ir_func){
        stack_pointer = 0;
        cfg = new ControlFlowGraph();
        ir_func_name = ir_func.IR_name;
    }
}
