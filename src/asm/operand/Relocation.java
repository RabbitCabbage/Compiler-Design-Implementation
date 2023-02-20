package asm.operand;

public class Relocation extends Operand{
    public enum RelocationType{
        hi,lo
    }
    public String global_var_name;
    public RelocationType type;
    public Relocation(String global,RelocationType type){
        global_var_name = global;
        this.type = type;
    }
    @Override
    public String toString(){
        if(this.type.equals(RelocationType.hi))return "%hi("+global_var_name+")";
        else return "%lo("+global_var_name+")";
    }
}
