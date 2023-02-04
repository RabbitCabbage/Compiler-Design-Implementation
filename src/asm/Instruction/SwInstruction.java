package asm.Instruction;

public class SwInstruction extends InstructionASM{
    public String from_reg_name;
    public int sp_offset;
    public String destination;
    public SwInstruction(String rs, int offset){
        from_reg_name = rs;
        sp_offset = offset;
        destination = null;
    }
    public SwInstruction(String rs, String desti){
        from_reg_name = rs;
        destination = desti;
    }
    @Override
    public String toString(){
        StringBuilder sw = new StringBuilder();
        if(destination == null)sw.append("\tsw\t").append(from_reg_name).append(",\t").append(sp_offset).append("(sp)\n");
        else sw.append("\tsw\t").append(from_reg_name).append(",\t").append(destination).append("\n");
        return sw.toString();
    }
}
