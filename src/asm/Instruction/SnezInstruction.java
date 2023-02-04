package asm.Instruction;

public class SnezInstruction extends InstructionASM{
    public String to_reg_name;
    public String from_reg_name;
    public SnezInstruction(String rs,String rd){
        from_reg_name = rs;
        to_reg_name = rd;
    }
    public String toString(){
        StringBuilder seqz = new StringBuilder();
        seqz.append("\tsnez\t").append(to_reg_name).append(",\t").append(from_reg_name).append("\n");
        return seqz.toString();
    }
}
