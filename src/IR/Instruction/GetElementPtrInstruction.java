package IR.Instruction;

public class GetElementPtrInstruction extends InstructionIR{
    public String type;
    public String result_reg;//目标在的reg
    public String instance_reg;
    int index;
    boolean for_struct;
    int length;
    public  GetElementPtrInstruction(String type,String resreg,String instreg,int ind){
        this.type = type;
        result_reg = resreg;
        instance_reg = instreg;
        index = ind;
        this.for_struct = true;
    }
    public GetElementPtrInstruction(String type,String resreg,String instreg,String str){
        this.type = type;
        result_reg = resreg;
        instance_reg = instreg;
        length = str.length();
        this.for_struct = false;
    }
    public String toString(){
        StringBuilder gep = new StringBuilder();
        if(for_struct)
            gep.append("\t%").append(result_reg).append(" = getelementptr inbounds %struct.").append(type).append(", %struct.").append(type).append("* %").append(instance_reg).append(", i32 0, i32 ").append(index).append("\n");
        else gep.append("\t%").append(result_reg).append(" = getelementptr inbounds [").append(length).append(" x i8], [").append(length).append(" x i8]* @").append(instance_reg).append(", i32 0, i32 0\n");
        //System.out.println("HELLO"+gep.toString());
        return gep.toString();
    }
}
