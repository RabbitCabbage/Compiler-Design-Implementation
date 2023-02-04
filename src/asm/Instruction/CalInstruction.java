package asm.Instruction;


public class CalInstruction extends InstructionASM{
    public String function_name;
    public CalInstruction(String name){
        function_name = name;
    }
    public String toString(){
        StringBuilder call = new StringBuilder();
        call.append("\tcall\t").append(function_name).append("\n");
        return call.toString();
    }
}
