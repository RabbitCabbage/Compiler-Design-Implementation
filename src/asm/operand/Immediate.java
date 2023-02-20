package asm.operand;

public class Immediate extends Operand{
    public int imm;
    public Immediate(int imm){
        this.imm = imm;
    }
    @Override
    public String toString(){
        return String.valueOf(imm);
    }
}
