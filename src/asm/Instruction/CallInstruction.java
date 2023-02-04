package asm.Instruction;

public class CallInstruction extends InstructionASM{
    public String function_name;
    public String toString(){
        StringBuilder call = new StringBuilder();
        call.append("\tcall\t").append(function_name).append("\n");
        return call.toString();
    }
}
