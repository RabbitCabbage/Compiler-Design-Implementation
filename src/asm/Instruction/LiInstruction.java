package asm.Instruction;

public class LiInstruction extends InstructionASM{
    public String to_reg_name;
    public int imm;
    public LiInstruction(String rd,int i){
        to_reg_name = rd;
        imm = i;
    }
    public String toString(){
        StringBuilder li = new StringBuilder();
        li.append("\tli\t").append(to_reg_name).append("\t").append(imm).append("\n");
        return li.toString();
    }
}
