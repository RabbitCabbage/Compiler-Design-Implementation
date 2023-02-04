package IR.Instruction;

import asm.ASMBuilder;

import java.util.ArrayList;

public class GetElementPtrInstruction extends InstructionIR{
    public String type;
    public String result_reg;//目标在的reg
    public String instance_reg;
    public int index;
    public boolean for_struct;
    public boolean for_array;
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
    public int offset_number;
    public int dim;
    public int res_count;
    public ArrayList<Integer> sizes;
    //for globally newed array, a complex type name
    //[2 x [3 x [4 x i32]]]
    public GetElementPtrInstruction(String arr_reg, String ofs_reg, String type, int dim, int res_count){
        array_reg = arr_reg;
        offset_reg = ofs_reg;
        this.dim = dim;
        this.type = type;
        this.res_count = res_count;
        this.for_array = true;
        this.for_struct = false;
    }
    //for non-globally newed array, using typename like pointer

    public String toString(){
        StringBuilder gep = new StringBuilder();
        if(for_array){
            gep.append("\t%arrayidx").append(res_count).append(" = getelementptr inbounds ");
            gep.append(type);
            gep.deleteCharAt(gep.length()-1);
            gep.append(", ").append(type).append(" ");
            gep.append(array_reg).append(", i32 ").append(offset_reg);
            gep.append("\n");
        }
        else if(for_struct)
            gep.append("\t").append(result_reg).append(" = getelementptr inbounds %struct.").append(type).append(", %struct.").append(type).append("* ").append(instance_reg).append(", i32 0, i32 ").append(index).append("\n");
        else gep.append("\t").append(result_reg).append(" = getelementptr inbounds [").append(length).append(" x i8], [").append(length).append(" x i8]* ").append(instance_reg).append(", i32 0, i32 0\n");
        //System.out.println("HELLO"+gep.toString());
        return gep.toString();
    }
    public String res_toString(){
        StringBuilder gep_res = new StringBuilder();
        if(for_array){
            gep_res.append("%");
            gep_res.append("arrayidx").append(res_count);
        } else {
            gep_res.append(result_reg);
        }
        return gep_res.toString();
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
