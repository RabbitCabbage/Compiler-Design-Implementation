package asm.Instruction;

public class AddiInstruction extends InstructionASM{
    public String from_reg_name;
    public String to_reg_name;
    public int imm;
    public AddiInstruction(String rs,String rd,int imm){
        from_reg_name = rs;
        to_reg_name = rd;
        this.imm = imm;
    }
    @Override public String toString(){
        StringBuilder addi = new StringBuilder();
        addi.append("\taddi\t").append(to_reg_name).append(",\t").append(from_reg_name).append(",\t").append(imm).append("\n");
        return addi.toString();
    }
}
