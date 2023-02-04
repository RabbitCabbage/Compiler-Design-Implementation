package asm.Instruction;

public class MvInstruction extends InstructionASM{
    public String destination_reg_name;
    public String from_where;
    public int sp_offset;
    public MvInstruction(String rd, int offset){
        destination_reg_name = rd;
        sp_offset = offset;
        from_where = null;
    }
    public MvInstruction(String rd,String rs){
        from_where = rs;
        destination_reg_name = rd;
    }
    @Override
    public String toString(){
        StringBuilder mv = new StringBuilder();
        if(from_where == null)mv.append("\tmv\t").append(destination_reg_name).append(",\t").append(sp_offset).append("(sp)\n");
        else mv.append("\tmv\t").append(destination_reg_name).append(",\t").append(from_where).append("\n");
        return mv.toString();
    }
}
