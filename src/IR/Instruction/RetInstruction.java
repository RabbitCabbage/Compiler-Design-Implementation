package IR.Instruction;

import IR.Instruction.InstructionIR;

public class RetInstruction extends InstructionIR {
    String type;
    public int register;

    public RetInstruction(int reg,String type){
        this.register = reg;
        this.type = type;
    }
    public String toString(){
        StringBuilder ret_ = new StringBuilder();
        ret_.append("\tret ").append(type).append(" %").append(register).append("\n");
        return ret_.toString();
    }
}
