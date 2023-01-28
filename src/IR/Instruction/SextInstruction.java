package IR.Instruction;

public class SextInstruction extends InstructionIR{
    public int result_reg;
    public String reg_to_change;
    public int value;
    public boolean get_value = false;
    public SextInstruction(String change,int res){
        reg_to_change = change;
        result_reg = res;
    }
    public SextInstruction(int value, int res){
        this.value = value;
        this.result_reg = res;
        get_value = true;
    }
    public String res_toString(){
        StringBuilder sext = new StringBuilder();
        sext.append("%idxprom").append(result_reg);
        return sext.toString();
    }
    @Override
    public String toString(){
        StringBuilder sext = new StringBuilder();
        sext.append("\t%idxprom").append(result_reg).append(" = sext i32 ");
        if(get_value){
            sext.append(value);
        }else{
            sext.append(reg_to_change);
        }
        sext.append(" to i64\n");
        return sext.toString();
    }
}
