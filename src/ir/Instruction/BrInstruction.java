package ir.Instruction;

import asm.ASMBuilder;

public class BrInstruction extends InstructionIR {
    public String condition;
    public String label1;
    public String label2;
    public BrInstruction(String condition, String label1, String label2){
        this.condition = condition;
        this.label1 = label1;
        this.label2 = label2;
    }
    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();
        br.append("\tbr ");
        if(condition != null){
            br.append("i1 ").append(condition).append(", label %").append(label1).append(", label %").append(label2).append("\n");
            return br.toString();
        }else {
            br.append("label %").append(label1).append("\n");
            return br.toString();
        }
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
