package asm;

import asm.operand.Operand;

public class GlobalVar extends Operand {
    public String global_var_name;
    public GlobalVar(String name){
        global_var_name = name;
    }
    @Override
    public String toString(){
        return global_var_name;
    }
}
