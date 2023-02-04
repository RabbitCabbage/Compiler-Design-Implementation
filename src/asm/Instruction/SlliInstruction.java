package asm.Instruction;

public class SlliInstruction extends InstructionASM{
    public String from_reg_name;
    public String to_reg_name;
    public int imm;
    public String imm_str;
    public SlliInstruction(String rs,String rd,int imm){
        from_reg_name = rs;
        to_reg_name = rd;
        this.imm = imm;
        imm_str = null;
    }
    public SlliInstruction(String rs,String rd,String imm_str){
        from_reg_name = rs;
        to_reg_name = rd;
        this.imm_str = imm_str;
    }
    @Override public String toString(){
        StringBuilder slli = new StringBuilder();
        if(imm_str == null) slli.append("\tslli\t").append(to_reg_name).append(",\t").append(from_reg_name).append(",\t").append(imm).append("\n");
        else slli.append("\tslli\t").append(to_reg_name).append(",\t").append(from_reg_name).append(",\t").append(imm_str).append("\n");
        return slli.toString();
    }
}
