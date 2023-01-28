package IR.Instruction;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CallInstruction extends InstructionIR{
    public String func_name;
    public String return_type;
    public ArrayList<String> para;
    public int call_reg;

    public CallInstruction(String return_type,String func_name,int call_reg){
        super();
        this.func_name = func_name;
        this.return_type = return_type;
        this.para = new ArrayList<>();
        this.call_reg = call_reg;
    }

    @Override public String toString(){
        StringBuilder call = new StringBuilder();
        if(return_type.equals("void")) {
            call.append("\tcall void @");
        }else call.append("\t%call").append(call_reg).append(" = call ").append(return_type).append(" @");
        call.append(func_name).append("(");
        para.forEach(a->call.append(a).append(", "));
        if(!para.isEmpty()){
            call.deleteCharAt(call.length()-1);
            call.deleteCharAt(call.length()-1);
        }
        call.append(")\n");
        return call.toString();
    }
}
