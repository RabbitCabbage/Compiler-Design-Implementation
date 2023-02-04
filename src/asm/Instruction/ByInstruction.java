package asm.Instruction;

public class ByInstruction extends InstructionASM{
    public String opcode;
    public String reg_1;
    public String reg_2;
    public String to_reg_name;
    public ByInstruction(String op,String rs1,String rs2,String rd){
        opcode = op;
        reg_1 = rs1;
        reg_2 = rs2;
        to_reg_name = rd;
    }
    public String toString(){
        StringBuilder by = new StringBuilder();
        if(opcode.equals("+"))by.append("\tadd\t").append(to_reg_name).append(",\t").append(reg_1).append(",\t").append(reg_2).append("\n");
        return by.toString();
    }
}
