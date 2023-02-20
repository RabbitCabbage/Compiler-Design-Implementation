package asm;

import asm.operand.Operand;

public class StringConstant extends Operand {
    public String name;
    public String content;
    public StringConstant(String name,String content){
        this.name = name;
        this.content = content;
    }
    @Override
    public String toString(){
        return content;
    }
}
