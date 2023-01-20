package IR.Instruction;

public class GetElementPtrInstruction extends InstructionIR{
    public String type;
    public String result_reg;//目标在的reg
    public String instance_reg;
    int index;
    boolean for_struct;
    boolean for_array;
    int length;
    public  GetElementPtrInstruction(String type,String resreg,String instreg,int ind){
        this.type = type;
        result_reg = resreg;
        instance_reg = instreg;
        index = ind;
        this.for_struct = true;
        for_array = false;
    }
    public GetElementPtrInstruction(String type,String resreg,String instreg,String str){
        this.type = type;
        result_reg = resreg;
        instance_reg = instreg;
        length = str.length();
        this.for_struct = false;
        this.for_array = false;
    }
    public String array_reg;
    public String offset_reg;
    public int array_size;
    public int res_count;
    public boolean array_global;
    public GetElementPtrInstruction(String array_reg,String type,String offset_reg, int size,int res,boolean array_global){
        this.array_reg = array_reg;
        this.offset_reg = offset_reg;
        this.type = type;
        for_array = true;
        for_struct = false;
        this.array_size = size;
        this.res_count = res;
        this.array_global = array_global;
    }
    public String toString(){
        StringBuilder gep = new StringBuilder();
        if(for_array){
            gep.append("\t%arrayidx").append(res_count).append(" = getelementptr inbounds [");
            gep.append(array_size).append(" x ").append(type).append("], [").append(array_size).append(" x ").append(type);
            gep.append("]* ").append(array_global?"@":"%").append(array_reg).append(", i64 0, i64 ").append(offset_reg).append("\n");
        }
        else if(for_struct)
            gep.append("\t%").append(result_reg).append(" = getelementptr inbounds %struct.").append(type).append(", %struct.").append(type).append("* %").append(instance_reg).append(", i32 0, i32 ").append(index).append("\n");
        else gep.append("\t%").append(result_reg).append(" = getelementptr inbounds [").append(length).append(" x i8], [").append(length).append(" x i8]* @").append(instance_reg).append(", i32 0, i32 0\n");
        //System.out.println("HELLO"+gep.toString());
        return gep.toString();
    }
    public String res_toString(){
        StringBuilder gep_res = new StringBuilder();
        if(for_array){
            gep_res.append("arrayidx").append(res_count);
        } else {
            gep_res.append(result_reg);
        }
        return gep_res.toString();
    }

}
