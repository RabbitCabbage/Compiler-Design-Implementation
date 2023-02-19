package ast;

import ir.ValueUnit;
import util.Position;

public class BinaryExpressionNode extends ExpressionNode{
    public ExpressionNode lhs,rhs;

    public String opcode;

    public BinaryExpressionNode(ExpressionNode lhs, ExpressionNode rhs, String op, Position pos){
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        opcode = op;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public void calculate(){
        lhs.calculate();
        rhs.calculate();
        if(opcode.equals(">")||opcode.equals(">=")||opcode.equals("<")||opcode.equals("<=")||opcode.equals("==")||opcode.equals("!=")||opcode.equals("&&")||opcode.equals("||")){
            type = "bool";
            Boolean result = true;
            if(opcode.equals(">")){
                if(lhs.type.equals("int")) result = lhs.valueIR.values.get(0).number_value > rhs.valueIR.values.get(0).number_value;
                else if(lhs.type.equals("string")) result = (lhs.valueIR.values.get(0).string_value.compareTo(rhs.valueIR.values.get(0).string_value)>0);
            }
            else if(opcode.equals(">=")){
                if(lhs.type.equals("int")) result = lhs.valueIR.values.get(0).number_value >= rhs.valueIR.values.get(0).number_value;
                else if(lhs.type.equals("string")) result = (lhs.valueIR.values.get(0).string_value.compareTo(rhs.valueIR.values.get(0).string_value)>=0);
            }
            else if(opcode.equals("<")){
                if(lhs.type.equals("int")) result = lhs.valueIR.values.get(0).number_value < rhs.valueIR.values.get(0).number_value;
                else if(lhs.type.equals("string")) result = (lhs.valueIR.values.get(0).string_value.compareTo(rhs.valueIR.values.get(0).string_value)<0);
            }
            else if(opcode.equals("<=")){
                if(lhs.type.equals("int")) result = lhs.valueIR.values.get(0).number_value <= rhs.valueIR.values.get(0).number_value;
                else if(lhs.type.equals("string")) result = (lhs.valueIR.values.get(0).string_value.compareTo(rhs.valueIR.values.get(0).string_value)<=0);
            }
            else if(opcode.equals("==")){
                if(lhs.type.equals("int")) result = lhs.valueIR.values.get(0).number_value == rhs.valueIR.values.get(0).number_value;
                else if(lhs.type.equals("string")) result = (lhs.valueIR.values.get(0).string_value.compareTo(rhs.valueIR.values.get(0).string_value)==0);
                else if(lhs.type.equals("bool"))  result = lhs.valueIR.values.get(0).bool_value == rhs.valueIR.values.get(0).bool_value;
            }
            else if(opcode.equals("!=")){
                if(lhs.type.equals("int")) result = lhs.valueIR.values.get(0).number_value != rhs.valueIR.values.get(0).number_value;
                else if(lhs.type.equals("string")) result = (lhs.valueIR.values.get(0).string_value.compareTo(rhs.valueIR.values.get(0).string_value) != 0);
                else if(lhs.type.equals("bool"))  result = lhs.valueIR.values.get(0).bool_value != rhs.valueIR.values.get(0).bool_value;
            }
            else if(opcode.equals("&&"))result = lhs.valueIR.values.get(0).bool_value && rhs.valueIR.values.get(0).bool_value;
            else if(opcode.equals("||"))result = lhs.valueIR.values.get(0).bool_value || rhs.valueIR.values.get(0).bool_value;
            ValueUnit unit = new ValueUnit(null,null,result);
            this.valueIR.values.add(unit);
        }else{
            if(lhs.type.equals("int")){
                type = "int";//这里的type是继承自自己的父类，有一个type的类型。
                int result;
                if(opcode.equals("+"))result = lhs.valueIR.values.get(0).number_value+rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("-"))result = lhs.valueIR.values.get(0).number_value-rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("/"))result = lhs.valueIR.values.get(0).number_value/rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("*"))result = lhs.valueIR.values.get(0).number_value*rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("%"))result = lhs.valueIR.values.get(0).number_value%rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("<<"))result = lhs.valueIR.values.get(0).number_value<<rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals(">>"))result = lhs.valueIR.values.get(0).number_value>>rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("&"))result = lhs.valueIR.values.get(0).number_value&rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("|"))result = lhs.valueIR.values.get(0).number_value|rhs.valueIR.values.get(0).number_value;
                else if(opcode.equals("^"))result = lhs.valueIR.values.get(0).number_value^rhs.valueIR.values.get(0).number_value;
                else result = 0;
                ValueUnit unit  = new ValueUnit(result,null,null);
                this.valueIR.values.add(unit);
            } else if (lhs.type.equals("string")){
                type = "string";
                String result = new String();
                if(opcode.equals("+"))result = lhs.valueIR.values.get(0).string_value+rhs.valueIR.values.get(0).string_value;
                ValueUnit unit = new ValueUnit(null,result,null);
                this.valueIR.values.add(unit);
            }
        }
    }
}
