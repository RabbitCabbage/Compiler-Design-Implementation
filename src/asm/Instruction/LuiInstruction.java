package asm.Instruction;

public class LuiInstruction extends InstructionASM{
    public String to_reg_name;
    public String from_addr;
    public LuiInstruction(String rd, String from){
        to_reg_name = rd;
        from_addr = from;
    }
    public String toString(){
        StringBuilder lui = new StringBuilder();
        lui.append("\tlui\t").append(to_reg_name).append(",\t").append(from_addr).append("\n");
        return lui.toString();
    }
}
