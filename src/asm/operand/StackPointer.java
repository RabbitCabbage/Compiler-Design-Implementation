package asm.operand;

public class StackPointer extends Operand{
    public int sp;
    public StackPointer(int sp){
        this.sp = sp;
    }
    @Override
    public String toString(){
        return String.valueOf(sp);
    }
}
