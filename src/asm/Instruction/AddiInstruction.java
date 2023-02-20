package asm.instruction;

import asm.operand.Immediate;
import asm.operand.Register;

public class AddiInstruction extends InstructionASM{
    public Immediate imm;
    public Register from_reg;
    public Register to_reg;
    public AddiInstruction(Register to,Register from, Operand imm){
        from_reg = from;
        to_reg = to;
        this.imm = imm;
        this.use_value.add(from);
        this.def_value.add(to);
    }
    @Override
    public String toString(){
        StringBuilder addi = new StringBuilder();
        return addi.toString();
    }
}
