package util;
//一般的scope里面只不过是定义了一些变量，
//但是全局scope中会有class定义，也就是增加新的type
//会有函数的定义，同时要完成函数名和形式（参数&返回值）的比较
//todo 函数的查重怎么做

import java.util.HashMap;
import java.util.Set;
import util.error.SemanticError;

public class GlobalScope extends Scope{
    //global scope具有基类的定义一个变量，查询一个变量的存在以及类型
    //另外还定义了一个typename的set，方便查询class定义的名称
    //由于用户自己定义类型名称的存在，必须将查询的map设置成string到string。
    private Set<String> classtypes;

    public GlobalScope(Scope parentscope){
        super(parentscope);
    }

    public void addType(String typename, Position pos){
        if(classtypes.contains(typename)){
            throw new SemanticError("redifiniton class "+ typename, pos);
        }
        classtypes.add(typename);
    }
}
