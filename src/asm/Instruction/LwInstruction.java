package asm.Instruction;

public class LwInstruction extends InstructionASM{
    public String from_addr;
    public String to_reg_name;
    public int stack_pointer;
    public LwInstruction(String rd, String from){
        to_reg_name = rd;
        from_addr = from;
    }
    public LwInstruction(String rd, int sp){
        to_reg_name = rd;
        stack_pointer = sp;
        from_addr = null;
    }
    public String toString(){
        StringBuilder lw = new StringBuilder();
        if(from_addr!=null)lw.append("\tlw\t").append(to_reg_name).append(",\t").append(from_addr).append("\n");
        else lw.append("\tlw\t").append(to_reg_name).append(",\t").append(stack_pointer).append("(sp)\n");
        return lw.toString();
    }
}
