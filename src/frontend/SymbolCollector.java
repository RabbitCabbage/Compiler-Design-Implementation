package frontend;

import ast.*;
import util.Position;
import util.error.SemanticError;

public class SymbolCollector extends ASTVisitor {

    public Symbols symbols;
    public ClassDefNode currentClass = null;//正在处理的类定义

    public SymbolCollector(Symbols symbols){
        this.symbols = symbols;

        ClassDefNode Int = new ClassDefNode(new Position(0,0),"int");
        currentClass = Int;
        Int.accept(this);//todo what for
        currentClass = null;

        ClassDefNode Bool = new ClassDefNode(new Position(0,0),"bool");
        currentClass = Bool;
        Bool.accept(this);
        currentClass = null;

        ClassDefNode String = new ClassDefNode(new Position(0,0),"String");
        currentClass = String;
        ParameterNode para_length = new ParameterNode(new Position(0,0));
        para_length.paralist.put("s","string");
        FunctionDefNode length = new FunctionDefNode("int","length",para_length,String,new Position(0,0));
        ParameterNode para_substring = new ParameterNode(new Position(0,0));
        para_substring.paralist.put("left","int");
        para_substring.paralist.put("right","int");
        FunctionDefNode substring = new FunctionDefNode("string","substring",para_substring,String,new Position(0,0));
        FunctionDefNode parseint = new FunctionDefNode("int","parseInt",new ParameterNode(new Position(0,0)),String,new Position(0,0));
        ParameterNode para_ord = new ParameterNode(new Position(0,0));
        para_ord.paralist.put("pos","int");
        FunctionDefNode ord = new FunctionDefNode("int","ord",para_ord,String,new Position(0,0));
        String.methoddefs.add(length);
        String.methoddefs.add(substring);
        String.methoddefs.add(parseint);
        String.methoddefs.add(ord);
        String.accept(this);
        currentClass = null;

        ClassDefNode Void = new ClassDefNode(new Position(0,0),"void");
        currentClass = Void;
        Void.accept(this);
        currentClass = null;

        ParameterNode para_print = new ParameterNode(new Position(0,0));
        para_print.paralist.put("str","string");
        FunctionDefNode print = new FunctionDefNode("void","print",para_print,null,new Position(0,0));
        print.accept(this);

        ParameterNode para_println = new ParameterNode(new Position(0,0));
        para_println.paralist.put("str","string");
        FunctionDefNode println = new FunctionDefNode("void","println",para_println,null,new Position(0,0));
        println.accept(this);

        ParameterNode para_printint = new ParameterNode(new Position(0,0));
        para_printint.paralist.put("n","int");
        FunctionDefNode printint = new FunctionDefNode("void","printInt",para_printint,null,new Position(0,0));
        printint.accept(this);

        ParameterNode para_printlnint = new ParameterNode(new Position(0,0));
        para_printlnint.paralist.put("n","int");
        FunctionDefNode printlnint = new FunctionDefNode("void","printlnInt",para_printlnint,null,new Position(0,0));
        printlnint.accept(this);

        FunctionDefNode getstring = new FunctionDefNode("void","getString",null,null,new Position(0,0));
        getstring.accept(this);

        FunctionDefNode getint = new FunctionDefNode("void","getInt",null,null,new Position(0,0));
        getint.accept(this);

        ParameterNode para_tostring = new ParameterNode(new Position(0,0));
        para_tostring.paralist.put("i","int");
        FunctionDefNode tostring = new FunctionDefNode("string","toString",para_tostring,null,new Position(0,0));
        tostring.accept(this);

        FunctionDefNode size = new FunctionDefNode("int","size",null,null,new Position(0,0));
        size.accept(this);
    }

    @Override
    public void visit(RootNode it) {
        it.funcdefs.forEach(a->a.accept(this));
        it.vardefs.forEach(a->a.accept(this));
        it.classdefs.forEach(a->a.accept(this));
    }

    @Override
    public void visit(VariableDefNode it) {
        for(DeclarationNode v:it.declarations){
            if(currentClass.vardefs.contains(v.name))
                throw new SemanticError("member variable " + v.name + " has been defined");
            v.type = it.typename;
            currentClass.variablemap.put()
        }
    }

    @Override
    public void visit(ClassDefNode it) {

    }

    @Override
    public void visit(DeclarationNode it) {

    }
}
