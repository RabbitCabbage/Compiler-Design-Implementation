package asm.Instruction;

public class SwInstruction extends InstructionASM{
    public String from_reg_name;
    public int sp_offset;
    public SwInstruction(String rd, int offset){
        from_reg_name = rd;
        sp_offset = offset;
    }
    @Override
    public String toString(){
        StringBuilder sw = new StringBuilder();
        sw.append("\tsw\t").append(from_reg_name).append(",\t").append(sp_offset).append("(sp)\n");
        return sw.toString();
    }
}
