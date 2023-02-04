package asm.Instruction;

public class JumpInstruction extends InstructionASM{
    public String direct_jump = null;
    public JumpInstruction(String j){
        direct_jump = j;
    }
    public String toString(){
        StringBuilder jump = new StringBuilder();
        if(direct_jump != null)jump.append("\tj\t").append(direct_jump).append("\n");
        return jump.toString();
    }
}
