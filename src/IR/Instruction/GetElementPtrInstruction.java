package IR.Instruction;

public class GetElementPtrInstruction extends InstructionIR{
    public String type;
    public String result_reg;//目标在的reg
    public String instance_reg;
    int index;
    public  GetElementPtrInstruction(String type,String resreg,String instreg,int ind){
        this.type = type;
        result_reg = resreg;
        instance_reg = instreg;
        index = ind;
    }
    public String toString(){
        StringBuilder gep = new StringBuilder();
        gep.append("\t%"+result_reg+" = getelementptr inbounds %struct."+type+", %struct."+type+"* %"+instance_reg+", i32 0, i32 ").append(index).append("\n");
        //System.out.println("HELLO"+gep.toString());
        return gep.toString();
    }
}
