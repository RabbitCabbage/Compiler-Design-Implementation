package IR.Instruction;

import asm.ASMBuilder;

public class PhiInstruction extends InstructionIR{
    public int result_reg;
    String block1;
    String result1;
    String block2;
    String result2;
    public PhiInstruction(int res,String block1,String res1,String block2,String res2){
        this.block1= block1;
        this.block2 = block2;
        result1 = res1;
        result2 = res2;
        result_reg = res;
    }
    public String res_toString(){
        StringBuilder res = new StringBuilder();
        res.append("%");
        res.append(result_reg);
        return  res.toString();
    }
    @Override public String toString(){
        StringBuilder phi = new StringBuilder();
        phi.append("\t%").append(result_reg).append(" = phi i1 [ ").append(result1).append(", %").append(block1).append(" ], [ ").append(result2).append(", %").append(block2).append("]\n");
        return phi.toString();
    }

    @Override
    public void accept(ASMBuilder builder){
        builder.visit(this);
    }
}
