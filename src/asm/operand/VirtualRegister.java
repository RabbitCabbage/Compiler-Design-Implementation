package asm.operand;

public class VirtualRegister extends Register{
    public String name;
    public VirtualRegister(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
