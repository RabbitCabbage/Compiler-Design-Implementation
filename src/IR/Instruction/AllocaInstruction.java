package IR.Instruction;

public class AllocaInstruction extends InstructionIR {
    int register;
    String type;
    int align;
    public AllocaInstruction(int reg,String type,int align){
        this.register = reg;
        this.type = type;
        this.align = align;
    }
    public String toString(){
        StringBuilder alloc = new StringBuilder();
        alloc.append("\t%").append(register).append(" = alloca ").append(type).append(", align ").append(align).append("\n");
        return alloc.toString();
    }
}
