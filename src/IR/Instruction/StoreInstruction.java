package IR.Instruction;

import IR.Instruction.InstructionIR;

public class StoreInstruction extends InstructionIR {
    int value;
    String type;
    int register;
    int align;
    public StoreInstruction(int value,String type,int reg,int align) {
        this.value = value;
        this.type  = type;
        this.align = align;
        this.register = reg;
    }
    public String toString(){
        StringBuilder store = new StringBuilder();
        store.append("\tstore ").append(type).append(" ").append(value).append(", ").append(type).append("* %").append(register).append(", align ").append(align).append("\n");
        return store.toString();
    }
}
