package asm.Instruction;

public class MvInstruction extends InstructionASM{
    public String destination_reg_name;
    public int sp_offset;
    public MvInstruction(String rd, int offset){
        destination_reg_name = rd;
        sp_offset = offset;
    }
    @Override
    public String toString(){
        StringBuilder mv = new StringBuilder();
        mv.append("\tmv\t").append(destination_reg_name).append(",\t").append(sp_offset).append("(sp)\n");
        return mv.toString();
    }
}
