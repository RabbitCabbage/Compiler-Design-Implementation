package ast;

import IR.ValueIR;
import util.Position;

import java.util.ArrayList;
import java.util.HashMap;

//todo 计算出表达式的值，可能需要后来的相关实现。
public abstract class ExpressionNode extends ASTNode{
    public String type;
    public int dim;
    public boolean assignable = false;
    public boolean newed = false;
    public FunctionDefNode is_function = null;
    public FunctionDefNode dot_function = null;

    public boolean should_be_function = false;
    public ValueIR valueIR = new ValueIR();
    public boolean get_value = false;//表示的是这个expressionNode在访问之后有没有得到这个表达式的值
    public String get_reg;//如果没有得到表达式的值，就应当记下这个表达式最后的结果在哪一个虚拟寄存器
    public boolean visited_as_lhs = false;
    public String info_for_global_var = null;
    public ArrayList<String> struct_name;
    public ArrayList<Integer> name_index_in_class;//指的是这个expression最终找到的时候经历了哪些class内部indexing


    public ExpressionNode(Position pos){
        super(pos);
        name_index_in_class = new ArrayList<>();
        struct_name = new ArrayList<>();
    }

    public boolean isAssignable(){
        return assignable;
    }

    public void calculate(){};
}
