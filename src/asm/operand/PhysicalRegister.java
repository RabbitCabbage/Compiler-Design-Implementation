package asm.operand;

import java.util.HashMap;
import java.util.HashSet;

public class PhysicalRegister extends Register{
    public String name;
    public PhysicalRegister(String name){this.name = name;}
    public static HashMap<String,PhysicalRegister> regMap = new HashMap<>();//表示的是从一个名字到这个static的reg
    public static HashSet<PhysicalRegister> callerSaved = new HashSet<>();//表示的是需要调用函数保存的
    public static HashSet<PhysicalRegister> calleeSaved = new HashSet<>();//表示的是被调用函数需要保存的
    public static HashSet<PhysicalRegister> assignable = new HashSet<>();//在图染色中可以使用的，包括ast三种

    //表示的是static的所有寄存器，放到regMap中去
    //并且按照caller callee 保存以及是否可以进行图染色进行分类
    static{
        PhysicalRegister zero = new PhysicalRegister("zero");
        PhysicalRegister ra = new PhysicalRegister("ra");
        PhysicalRegister sp = new PhysicalRegister("sp");
        regMap.put("zero",zero);
        regMap.put("ra",ra);
        regMap.put("sp",sp);
        for(int i = 0; i < 7;++i){
            PhysicalRegister t = new PhysicalRegister("t"+String.valueOf(i));
            regMap.put(t.name,t);
            callerSaved.add(t);
        }
        for(int i = 0; i < 8;++i){
            PhysicalRegister a = new PhysicalRegister("a"+String.valueOf(i));
            regMap.put(a.name,a);
            callerSaved.add(a);
        }
        for(int i = 0; i < 12;++i){
            PhysicalRegister s = new PhysicalRegister("s"+String.valueOf(i));
            regMap.put(s.name,s);
            calleeSaved.add(s);
        }
        assignable.addAll(callerSaved);
        assignable.addAll(calleeSaved);
        callerSaved.add(ra);//函数的调用者保存函数返回之后接着在哪里执行
        calleeSaved.add(sp);//被调用者移动和恢复sp
    }
    public static PhysicalRegister getPhysicalReg(String name){
        return regMap.get(name);
    }
    @Override
    public String toString(){
        return name;
    }
}
