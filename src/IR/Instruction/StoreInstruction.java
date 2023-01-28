package IR.Instruction;

import IR.Instruction.InstructionIR;
import IR.ValueUnit;

public class StoreInstruction extends InstructionIR {
    ValueUnit value;
    String from_type;
    String to_type;
    String to_reg_name;
    String reg = null;
    boolean get_value;
    public StoreInstruction(ValueUnit value,String to_type,String to_reg_name) {
        this.value = value;
        this.to_type  = to_type;
        this.to_reg_name = to_reg_name;
        get_value = true;
    }

    public StoreInstruction(String reg,String reg_type,String to_reg_name,String name_type){
        this.reg = reg;
        from_type = reg_type;
        to_type = name_type;
        this.to_reg_name = to_reg_name;
        get_value = false;
    }
    public String toString(){
        StringBuilder store = new StringBuilder();
        if(get_value){
            if(to_type.equals("i32")) store.append("\tstore ").append(to_type).append(" ").append(value.number_value).append(", ").append(to_type);
            else if(to_type.equals("string")||to_type.equals("i8*")) store.append("\tstore ").append(to_type).append(" ").append(value.string_value).append(", ").append(to_type);
            else if(to_type.equals("i1")) store.append("\tstore ").append(to_type).append(" ").append(value.bool_value).append(", ").append(to_type);
        }else {
            // System.out.println(reg.substring(0,4));
            if(reg.length()>=5 && reg.substring(0,4).equals(".str"))store.append("\tstore ").append(from_type).append(" ").append(reg).append(", ").append(to_type);
            else store.append("\tstore ").append(from_type).append(" ").append(reg).append(", ").append(to_type);
        }
        store.append("* ").append(to_reg_name).append("\n");
        return store.toString();
    }
}
