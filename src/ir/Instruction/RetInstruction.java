package ir.Instruction;

import asm.ASMBuilder;

public class RetInstruction extends InstructionIR {
    String type;
    public String register;
    public boolean return_void = false;

    public RetInstruction(String reg,String type,boolean rv){
        this.register = reg;
        this.type = type;
        return_void = rv;
    }

    public String toString(){
        if(return_void) return "\tret void\n";
        StringBuilder ret_ = new StringBuilder();
        ret_.append("\tret ").append(type).append(" ").append(register).append("\n");
        return ret_.toString();
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
