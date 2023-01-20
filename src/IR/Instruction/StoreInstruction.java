package IR.Instruction;

import IR.Instruction.InstructionIR;
import IR.ValueUnit;

public class StoreInstruction extends InstructionIR {
    ValueUnit value;
    String from_type;
    String to_type;
    String name;
    String reg = null;
    boolean destination_global;
    public StoreInstruction(ValueUnit value,String to_type,String name,boolean global) {
        this.value = value;
        this.to_type  = to_type;
        this.name = name;
        this.destination_global = global;
    }

    public StoreInstruction(String reg,String reg_type,String name,String name_type, boolean global){
        this.reg = reg;
        from_type = reg_type;
        to_type = name_type;
        this.name = name;
        this.destination_global = global;
    }
    public String toString(){
        StringBuilder store = new StringBuilder();
        if(reg == null){
            if(to_type.equals("i32")) store.append("\tstore ").append(to_type).append(" ").append(value.number_value).append(", ").append(to_type);
            else if(to_type.equals("string")||to_type.equals("i8*")) store.append("\tstore ").append(to_type).append(" ").append(value.string_value).append(", ").append(to_type);
            else if(to_type.equals("i1")) store.append("\tstore ").append(to_type).append(" ").append(value.bool_value).append(", ").append(to_type);
        }else {
            // System.out.println(reg.substring(0,4));
            if(reg.length()>=5 && reg.substring(0,4).equals(".str"))store.append("\tstore ").append(from_type).append(" ").append("@").append(reg).append(", ").append(to_type);
            else store.append("\tstore ").append(from_type).append(" ").append("%").append(reg).append(", ").append(to_type);
        }
        if(destination_global)store.append("* @").append(name).append("\n");
        else store.append("* %").append(name).append("\n");
        return store.toString();
    }
}
