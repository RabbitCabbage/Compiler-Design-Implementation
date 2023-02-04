package asm.Instruction;

public class SeqzInstruction extends InstructionASM{
    public String to_reg_name;
    public String from_reg_name;
    public SeqzInstruction(String rs,String rd){
        from_reg_name = rs;
        to_reg_name = rd;
    }
    public String toString(){
        StringBuilder seqz = new StringBuilder();
        seqz.append("\tseqz\t").append(to_reg_name).append(",\t").append(from_reg_name).append("\n");
        return seqz.toString();
    }
}
