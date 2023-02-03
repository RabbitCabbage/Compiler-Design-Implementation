package IR.Instruction;

import asm.ASMBuilder;

public class AllocaInstruction extends InstructionIR {
    String name;
    String type;
    public AllocaInstruction(String name,String type){
        this.name = name;
        this.type = type;
    }
    public String toString(){
        StringBuilder alloc = new StringBuilder();
        alloc.append("\t").append(name).append(" = alloca ").append(type).append("\n");
        return alloc.toString();
    }
    public String res_toString(){
        return name;
    }
    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
