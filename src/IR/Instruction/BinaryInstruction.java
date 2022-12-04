package IR.Instruction;

import ast.BinaryExpressionNode;

public class BinaryInstruction extends InstructionIR{
    public String opcode;
    public String lhs_reg;
    public String rhs_reg;
    public int result_reg;
    public String type;
    public BinaryInstruction(String opcode, String lhs_reg,String rhs_reg,String t,int result){
        this.opcode = opcode;
        this.lhs_reg = lhs_reg;
        this.rhs_reg = rhs_reg;
        result_reg = result;
        type = t;
    }
    public String toString(){
        StringBuilder binary = new StringBuilder();
        if(opcode.equals("+"))binary.append("\t%").append("add").append(result_reg).append(" = add ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("-"))binary.append("\t%").append("sub").append(result_reg).append(" = sub ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("*"))binary.append("\t%").append("mul").append(result_reg).append(" = mul ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("/"))binary.append("\t%").append("sdiv").append(result_reg).append(" = sdiv ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("%"))binary.append("\t%").append("srem").append(result_reg).append(" = srem ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("<<"))binary.append("\t%").append("shl").append(result_reg).append(" = shl ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals(">>"))binary.append("\t%").append("ashr").append(result_reg).append(" = ashr ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("&"))binary.append("\t%").append("and").append(result_reg).append(" = and ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("|"))binary.append("\t%").append("or").append(result_reg).append(" = or ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        else if(opcode.equals("^"))binary.append("\t%").append("xor").append(result_reg).append(" = xor ").append(type).append(" %").append(lhs_reg).append(", %").append(rhs_reg).append("\n");
        return binary.toString();
    }
}
