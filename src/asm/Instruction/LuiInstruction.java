package asm.instruction;

import asm.operand.Operand;
import asm.operand.PhysicalRegister;
import asm.operand.Register;
import asm.operand.VirtualRegister;

public class LuiInstruction extends InstructionASM{
    Operand from_operand;
    Operand to_operand;
    public LuiInstruction(Operand from, Operand to){
        from_operand = from;
        to_operand = to;
        if(from_operand instanceof Register)
            this.use_value.add((Register) from_operand);
        if(to_operand instanceof Register)
            this.def_value.add((Register) to_operand);
    }
    @Override
    public String toString(){
        StringBuilder lui = new StringBuilder();
        return lui.toString();
    }
}
