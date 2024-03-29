package ir.Instruction;

import ir.ValueUnit;
import asm.ASMBuilder;

public class StoreInstruction extends InstructionIR {
    ValueUnit value;
    public int number;
    String from_type;
    String to_type;
    public String to_reg_name;
    public String reg = null;
    public boolean get_value;
    public boolean asm_visited = false;
    public StoreInstruction(ValueUnit value,String to_type,String to_reg_name) {
        this.value = value;
        this.to_type  = to_type;
        this.to_reg_name = to_reg_name;
        get_value = true;
        if(to_type.equals("i32"))number = value.number_value;
        else number = value.bool_value? 1:0;
    }

    public StoreInstruction(String reg,String reg_type,String to_reg_name,String name_type){
        this.reg = reg;
        from_type = reg_type;
        if(from_type.equals("null"))from_type = name_type;
        to_type = name_type;
        this.to_reg_name = to_reg_name;
        get_value = false;
    }
    public String toString(){
        StringBuilder store = new StringBuilder();
        if(get_value){
            if(to_type.equals("i32")) store.append("\tstore ").append(to_type).append(" ").append(value.number_value).append(", ").append(to_type);
            else if(to_type.equals("i1")) store.append("\tstore ").append(to_type).append(" ").append(value.bool_value).append(", ").append(to_type);
        }else {
            //System.out.println(reg);
            if(reg.length()>=5 && reg.substring(0,4).equals(".str"))store.append("\tstore ").append(from_type).append(" ").append(reg).append(", ").append(to_type);
            else store.append("\tstore ").append(from_type).append(" ").append(reg).append(", ").append(to_type);
        }
        store.append("* ").append(to_reg_name).append("\n");
        return store.toString();
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
