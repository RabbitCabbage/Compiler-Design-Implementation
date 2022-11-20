package frontend;

import ast.*;
import util.Position;
import util.error.SemanticError;

public class SymbolCollector extends ASTVisitor {

    public Symbols symbols;
    public ClassDefNode currentClass = null;//正在处理的类定义

    public SymbolCollector(Symbols symbols) {
        this.symbols = symbols;

        ClassDefNode Int = new ClassDefNode(new Position(0, 0), "int");
        currentClass = Int;
        Int.accept(this);//为了收集到这个类
        currentClass = null;

        ClassDefNode Bool = new ClassDefNode(new Position(0, 0), "bool");
        currentClass = Bool;
        Bool.accept(this);
        currentClass = null;

        ClassDefNode String = new ClassDefNode(new Position(0, 0), "string");
        currentClass = String;

        FunctionDefNode length = new FunctionDefNode("int", 0, "length", null, String, new Position(0, 0));

        ParameterNode left = new ParameterNode(new Position(0, 0), "int", 0, new DeclarationNode("left", null, new Position(0, 0)));
        ParameterNode right = new ParameterNode(new Position(0, 0), "int", 0, new DeclarationNode("right", null, new Position(0, 0)));
        FunctionDefNode substring = new FunctionDefNode("string", 0, "substring", null, String, new Position(0, 0));
        substring.parameterlist.add(left);
        substring.parameterlist.add(right);

        FunctionDefNode parseint = new FunctionDefNode("int", 0, "parseInt", null, String, new Position(0, 0));

        ParameterNode pos = new ParameterNode(new Position(0, 0), "int", 0, new DeclarationNode("pos", null, new Position(0, 0)));
        FunctionDefNode ord = new FunctionDefNode("int", 0, "ord", null, String, new Position(0, 0));
        ord.parameterlist.add(pos);


        String.methoddefs.add(length);
        String.methoddefs.add(substring);
        String.methoddefs.add(parseint);
        String.methoddefs.add(ord);
        String.accept(this);
        currentClass = null;

        ClassDefNode Void = new ClassDefNode(new Position(0, 0), "void");
        currentClass = Void;
        Void.accept(this);
        currentClass = null;

        ParameterNode str = new ParameterNode(new Position(0, 0), "string", 0, new DeclarationNode("str", null, new Position(0, 0)));
        FunctionDefNode print = new FunctionDefNode("void", 0, "print", null, null, new Position(0, 0));
        print.parameterlist.add(str);
        print.accept(this);

        FunctionDefNode println = new FunctionDefNode("void", 0, "println", null, null, new Position(0, 0));
        println.parameterlist.add(str);
        println.accept(this);

        ParameterNode n = new ParameterNode(new Position(0, 0), "int", 0, new DeclarationNode("n", null, new Position(0, 0)));
        FunctionDefNode printint = new FunctionDefNode("void", 0, "printInt", null, null, new Position(0, 0));
        printint.parameterlist.add(n);
        printint.accept(this);

        FunctionDefNode printlnint = new FunctionDefNode("void", 0, "printlnInt", null, null, new Position(0, 0));
        printlnint.parameterlist.add(n);
        printlnint.accept(this);

        FunctionDefNode getstring = new FunctionDefNode("string", 0, "getString", null, null, new Position(0, 0));
        getstring.accept(this);

        FunctionDefNode getint = new FunctionDefNode("int", 0, "getInt", null, null, new Position(0, 0));
        getint.accept(this);

        ParameterNode i = new ParameterNode(new Position(0, 0), "int", 0, new DeclarationNode("i", null, new Position(0, 0)));
        FunctionDefNode tostring = new FunctionDefNode("string", 0, "toString", null, null, new Position(0, 0));
        tostring.parameterlist.add(i);
        tostring.accept(this);

        FunctionDefNode size = new FunctionDefNode("int", 0, "size", null, null, new Position(0, 0));
        size.accept(this);
    }

    @Override
    public void visit(RootNode it) {
        it.funcdefs.forEach(a -> a.accept(this));
        it.vardefs.forEach(a -> a.accept(this));
        it.classdefs.forEach(a -> a.accept(this));
    }

    @Override
    public void visit(VariableDefNode it) {
        if (currentClass != null) {
            for (DeclarationNode v : it.declarations) {
                if (currentClass.variablemap.containsKey(v.name))
                    throw new SemanticError("member variable " + v.name + " has been defined", it.pos);
                v.type = it.typename;
                currentClass.variablemap.put(v.name, v);
            }
        }
    }

    @Override
    public void visit(ClassDefNode it) {
        if (symbols.classTypeUsed(it.name))
            throw new SemanticError("class name " + it.name + " has been defined", it.pos);
        symbols.addClassType(it.name, it);
        currentClass = it;
        it.vardefs.forEach(a -> a.accept(this));
        it.methoddefs.forEach(a -> a.accept(this));
        currentClass = null;
    }

    @Override
    public void visit(FunctionDefNode it) {
        if (currentClass == null) {
            if (symbols.functionTypeUsed(it.name))
                throw new SemanticError("function " + it.name + " has been defined", it.pos);
            symbols.addFunctionType(it.name, it);
        } else {
            it.belong = currentClass;
            if (currentClass.methodmap.containsKey(it.name))
                throw new SemanticError("method " + it.name + " has been defined in class" + currentClass.name, it.pos);
            if (it.name.equals(currentClass.name)) {
                //说明这个是个构造函数
                if (it.returntype != null)
                    throw new SemanticError("constructor function should have no return", it.pos);
                else
                    it.returntype = currentClass.name;
            }
            currentClass.methodmap.put(it.name, it);
        }
    }
}
