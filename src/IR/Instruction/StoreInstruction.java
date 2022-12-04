package IR.Instruction;

import IR.Instruction.InstructionIR;
import IR.ValueUnit;

public class StoreInstruction extends InstructionIR {
    ValueUnit value;
    String type;
    String name;
    String reg = null;
    public StoreInstruction(ValueUnit value,String type,String name) {
        this.value = value;
        this.type  = type;
        this.name = name;
    }

    public StoreInstruction(String reg,String type,String name){
        this.reg = reg;
        this.type = type;
        this.name = name;
    }
    public String toString(){
        StringBuilder store = new StringBuilder();
        if(reg == null){
            if(type.equals("i32")) store.append("\tstore ").append(type).append(" ").append(value.number_value).append(", ").append(type).append("* %").append(name).append("\n");
            else if(type.equals("string")) store.append("\tstore ").append(type).append(" ").append(value.string_value).append(", ").append(type).append("* %").append(name).append("\n");
            else if(type.equals("bool")) store.append("\tstore ").append(type).append(" ").append(value.bool_value).append(", ").append(type).append("* %").append(name).append("\n");
        }else {
            if(type.equals("i32")) store.append("\tstore ").append(type).append(" ").append("%").append(reg).append(", ").append(type).append("* %").append(name).append("\n");
            else if(type.equals("string")) store.append("\tstore ").append(type).append(" ").append("%").append(reg).append(", ").append(type).append("* %").append(name).append("\n");
            else if(type.equals("bool")) store.append("\tstore ").append(type).append(" ").append("%").append(reg).append(", ").append(type).append("* %").append(name).append("\n");
        }
        return store.toString();
    }
}
