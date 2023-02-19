package ir.Instruction;

import asm.ASMBuilder;

public abstract class InstructionIR {
    public abstract String toString();
    abstract public void accept(ASMBuilder builder);
}
