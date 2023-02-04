package asm.Instruction;

public class BeqzInstruction extends InstructionASM{
    public String judge_reg;
    public String jump_to_block;
    public BeqzInstruction(String reg,String block){
        judge_reg = reg;
        jump_to_block = block;
    }
    public String toString(){
        StringBuilder beqz = new StringBuilder();
        beqz.append("\tbeqz\t").append(judge_reg).append(",\t").append(jump_to_block).append("\n");
        return  beqz.toString();
    }
}
