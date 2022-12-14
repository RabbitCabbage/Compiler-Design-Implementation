package IR.Instruction;

public class BrInstruction extends InstructionIR {
    public int condition=-1;
    public int label1;
    public int label2;
    public BrInstruction(int condition, int label1,int label2){
        this.condition = condition;
        this.label1 = label1;
        this.label2 = label2;
    }
    @Override
    public String toString() {
        StringBuilder br = new StringBuilder();
        br.append("\tbr ");
        if(condition != -1){
            br.append("i1 %").append(condition).append(", lable %").append(label1).append(", label %").append(label2).append("\n");
            return br.toString();
        }else {
            br.append("label %").append(label1).append("\n");
            return br.toString();
        }
    }
}
