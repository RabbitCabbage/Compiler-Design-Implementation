package IR.Instruction;

import IR.Instruction.InstructionIR;
import IR.ValueUnit;
import asm.ASMBuilder;

public class RetInstruction extends InstructionIR {
    String type;
    public String register;
    public ValueUnit value;
    boolean return_void = false;

    public RetInstruction(String reg,String type,boolean rv){
        this.register = reg;
        this.type = type;
        return_void = rv;
    }
    public RetInstruction(ValueUnit value,String type){
        this.value = value;
        this.type = type;
    }
    public String toString(){
        if(return_void) return "\tret void\n";
        if(value == null){
            StringBuilder ret_ = new StringBuilder();
            ret_.append("\tret ").append(type).append(" ").append(register).append("\n");
            return ret_.toString();
        }
        else {
            StringBuilder ret_ = new StringBuilder();
            ret_.append("\tret "+type+" ").append((type.equals("i32")?value.number_value:(type.equals("string")?value.string_value:value.bool_value))+"\n");
            return ret_.toString();
        }
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
