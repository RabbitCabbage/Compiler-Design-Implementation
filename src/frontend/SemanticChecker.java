package frontend;

import ast.*;
import util.Scope;
import util.error.SemanticError;

import java.util.Stack;

public class SemanticChecker extends ASTVisitor {
    public Symbols symbols;
    public Scope currentScope;
    public ClassDefNode currentClass = null;
    public Stack<FunctionDefNode> currentFunction = new Stack<>();

    public SemanticChecker(Symbols symbols) {
        super();
        this.symbols = symbols;
        this.currentScope = new Scope(null);
    }

    public void visit(RootNode it) {
        //检查是不是有main函数
        boolean have_main = false;
        for (FunctionDefNode funcdef : it.funcdefs) {
            if (funcdef.name.equals("main") && have_main) {
                throw new SemanticError("main function has been defined before", it.pos);
            } else if (funcdef.name.equals("main")) {
                have_main = true;
            }
        }
        if (!have_main)
            throw new SemanticError("no main function defined in the program", it.pos);
        it.vardefs.forEach(a -> a.accept(this));
        it.classdefs.forEach(a -> a.accept(this));
        it.funcdefs.forEach(a -> a.accept(this));
    }

    public void visit(VariableDefNode it) {
        //System.out.println(it.pos.toString());
        //System.out.println("variable def node");
        //System.out.println(it.typename);
        //System.out.println(it.dim);
        if (!symbols.classTypeUsed(it.typename)) {
            throw new SemanticError("the type of the variable " + it.typename + " has not been defined", it.pos);
        }
        if (it.typename.equals("void"))
            throw new SemanticError("variable cannot be defined as void", it.pos);
        it.declarations.forEach(a -> {
            a.type = it.typename;
            a.dim = it.dim;
            a.accept(this);
            //在这里把declaration的信息补充完整
        });
    }

    public void visit(DeclarationNode it) {
        //System.out.println(it.name);
        //System.out.println("declaration node");
        //System.out.println(it.name);
        //System.out.println(it.type);
        //System.out.println(it.dim);
        if (symbols.classTypes.containsKey(it.name))
            throw new SemanticError("variable name " + it.name + "collide with class name", it.pos);
        if (currentScope.containVariable(it.name, false))
            throw new SemanticError("redefine variable " + it.name, it.pos);
        if (it.init != null) {
            it.init.accept(this);
            if (!it.init.type.equals("null") && !it.init.type.equals(it.type))
                throw new SemanticError("expression is of a wrong type which cannot be assigned to the variable defined", it.pos);
            //System.out.println(it.init.dim);
            //System.out.println(it.dim);
            if (!it.init.type.equals("null") && it.init.dim != it.dim)
                throw new SemanticError("expression is of a wrong dimension which cannot be assigned to the variable defined", it.pos);
        }
        //System.out.println(it.name);
        currentScope.defineVariable(it.name, it, it.pos);
        if (currentClass != null && currentFunction.empty()) {
            it.belong = currentClass;
        }
    }

    public void visit(FunctionDefNode it) {
        //System.out.println(it.name);
        //System.out.println(it.returntype);
        if (it.name.equals("main") && !it.returntype.equals("int"))
            throw new SemanticError("main function must return int value", it.pos);
        if (it.name.equals("main") && !it.parameterlist.isEmpty())
            throw new SemanticError("main function should not have parameters", it.pos);
        if (symbols.classTypes.containsKey((it.name)) && !it.name.equals(currentClass.name))
            throw new SemanticError("function name " + it.name + "collides with class name", it.pos);
        if (!symbols.classTypeUsed(it.returntype))
            throw new SemanticError("the return type of function " + it.name + " has not been defined", it.pos);
        if (!currentFunction.empty() && !it.is_lambda)
            throw new SemanticError("function cannot be defined in function", it.pos);
        currentFunction.push(it);
        currentScope = new Scope(currentScope);
        it.parameterlist.forEach(a -> a.accept(this));
        if (it.stmts != null) it.stmts.accept(this);
        //这时就会得到函数是否被return的信息
        if (it.returntype != null) {
            if (!it.returntype.equals("void") && !it.has_been_returned && !it.name.equals("main") && !it.is_constructor)
                throw new SemanticError("function with non-void return type has no return statement", it.pos);
        }
        currentScope = currentScope.parent;
        currentFunction.pop();
    }


    public void visit(IfStatementNode it) {
        it.condition.accept(this);
        if (!it.condition.type.equals("bool"))
            throw new SemanticError("the type of condition expression in if statement is not bool", it.pos);
        if (it.elsestmt != null) {
            currentScope = new Scope(currentScope);
            it.elsestmt.accept(this);
            currentScope = currentScope.parent;
        }
        if (it.thenstmt != null) {
            currentScope = new Scope(currentScope);
            it.thenstmt.accept(this);
            currentScope = currentScope.parent;
        }
    }

    public void visit(ReturnStatementNode it) {
        if (currentFunction.empty())
            throw new SemanticError("return statement is not in a function", it.pos);
        if (it.value != null) {
            if (currentFunction.peek().is_constructor)
                throw new SemanticError("constructor function should have no return", it.pos);
            it.value.accept(this);
            if (currentFunction.peek().is_lambda) {
                currentFunction.peek().returntype = it.value.type;
                currentFunction.peek().returndim = it.value.dim;
            }
            if (!it.value.type.equals("null") && !it.value.type.equals(currentFunction.peek().returntype))
                throw new SemanticError("the value returned is of a wrong type, requiring " + currentFunction.peek().returntype + " returning " + it.value.type, it.pos);
            if (it.value.dim != currentFunction.peek().returndim)
                throw new SemanticError("the value returned is of a wrong dimension", it.pos);
            if (currentFunction.peek().name.equals("main") && !it.value.type.equals("int"))
                throw new SemanticError("main function must return int type", it.pos);
        } else {
            if (currentFunction.peek().returntype != null && !currentFunction.peek().returntype.equals("void") && !currentFunction.peek().is_constructor) {
                throw new SemanticError("function needs an expression returned", it.pos);
            }
            if (currentFunction.peek().is_lambda) {
                currentFunction.peek().returndim = 0;
                currentFunction.peek().returntype = "void";
            }
        }
        currentFunction.peek().has_been_returned = true;
    }

    public void visit(ParameterNode it) {
        if (!symbols.classTypes.containsKey(it.type))
            throw new SemanticError("the type of the parameter" + it.type + "has not been defined", it.pos);
        it.declare.accept(this);
        it.declare.type = it.type;
        it.declare.dim = it.dim;
    }

    public void visit(ClassDefNode it) {
        if (!currentFunction.empty())
            throw new SemanticError("class cannot be defined in function", it.pos);
        if (currentClass != null)
            throw new SemanticError("class cannot be defined in class", it.pos);
        currentClass = it;
        currentScope = new Scope(currentScope);
        it.vardefs.forEach(a -> a.accept(this));
        it.methoddefs.forEach(a -> a.accept(this));
        currentScope = currentScope.parent;
        currentClass = null;
    }

    public void visit(SuiteNode it) {
        currentScope = new Scope(currentScope);
        if (it.stmts != null) it.stmts.forEach(a -> a.accept(this));
        currentScope = currentScope.parent;
    }

    public void visit(WhileStatementNode it) {
        currentScope = new Scope(currentScope);
        currentScope.is_loop = true;

        it.condition.accept(this);
        if (!it.condition.type.equals("bool"))
            throw new SemanticError("the type of condition expression in while statement is not bool", it.pos);
        it.stmt.accept(this);

        currentScope = currentScope.parent;
    }

    public void visit(ForStatementNode it) {
        currentScope = new Scope(currentScope);
        currentScope.is_loop = true;

        if (it.init != null) it.init.accept(this);
        if (it.var != null) it.var.accept(this);
        if (it.condition != null) {
            it.condition.accept(this);
            if (!it.condition.type.equals("bool")) {
                throw new SemanticError("the type of condition expression in for statement is not bool", it.pos);
            }
        }
        if (it.next != null) it.next.accept(this);
        //System.out.println(it.pos.toString());
        it.stmts.accept(this);
        currentScope = currentScope.parent;
    }


    public void visit(ExpressionStatementNode it) {
        it.expression.accept(this);
    }

    public void visit(BinaryExpressionNode it) {
        //System.out.println(it.opcode);
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.is_function != null || it.rhs.is_function != null)
            throw new SemanticError("one of the operands is function", it.pos);
        if (it.lhs.type.equals("void") || it.rhs.type.equals("void"))
            throw new SemanticError("type void cannot be calculated", it.pos);
        if (it.lhs.dim != 0 || it.rhs.dim != 0) {
            //说明这是个数组对象
            if (!it.opcode.equals("!=") && !it.opcode.equals("=="))
                throw new SemanticError("array object can only be calculated by == and !=", it.pos);
            if ((it.lhs.dim != 0 && !it.rhs.type.equals("null")) || (it.rhs.dim != 0 && !it.lhs.type.equals("null")))
                throw new SemanticError("array object can only be calculated with null type", it.pos);
        } else {
            //Systemtem.out.println(it.lhs.type);
            if (!it.lhs.type.equals(it.rhs.type)) {
                if (it.opcode.equals("==") || it.opcode.equals("!=")) {
                    if (!it.lhs.type.equals("null") && !it.rhs.type.equals("null"))
                        throw new SemanticError("the binary expression has different types in lhs and rhs", it.pos);
                } else throw new SemanticError("the binary expression has different types in lhs and rhs", it.pos);
            }
            if (it.lhs.type.equals("bool")
                    && (!it.opcode.equals("==") && !it.opcode.equals("!=")
                    && !it.opcode.equals("&&") && !it.opcode.equals("||")))
                throw new SemanticError("bool type cannot be calculated by " + it.opcode, it.pos);
            else if (it.lhs.type.equals("string")
                    && (!it.opcode.equals("+")
                    && !it.opcode.equals("<")
                    && !it.opcode.equals(">")
                    && !it.opcode.equals("<=")
                    && !it.opcode.equals(">=")
                    && !it.opcode.equals("==")
                    && !it.opcode.equals("!=")))
                throw new SemanticError("string type cannot be calculated by " + it.opcode, it.pos);
            if (!it.lhs.type.equals("int") && !it.lhs.type.equals("bool") && !it.lhs.type.equals("string")) {
                if (!it.opcode.equals("==") && !it.opcode.equals("!=")) {
                    //System.out.println(it.lhs.type);
                    //System.out.println(it.rhs.type);
                    //System.out.println(it.opcode);
                    throw new SemanticError("class object cannot be calculated by this operator", it.pos);
                }
            }
        }
        if (it.opcode.equals("==")
                || it.opcode.equals("!=")
                || it.opcode.equals("&&")
                || it.opcode.equals("||")
                || it.opcode.equals("<")
                || it.opcode.equals(">")
                || it.opcode.equals(">=")
                || it.opcode.equals("<=")
                || it.opcode.equals("!")) {
            it.type = "bool";
            it.dim = 0;
            it.assignable = false;
        } else {
            it.type = it.lhs.type;
            it.dim = it.lhs.dim;
            it.assignable = false;
        }
    }

    public void visit(AssignmentExpressionNode it) {
        it.lhs.accept(this);
        //这中间有对lhs的检查，如果说lhs出现问题就不用递归访问rhs了
        //System.out.println("assign");
        if (!it.lhs.isAssignable())
            throw new SemanticError("expression is not assignable", it.pos);
        if (it.lhs.is_function != null)
            throw new SemanticError("the lhs of the assignment is a function", it.pos);
        it.rhs.accept(this);
        if (it.rhs.is_function != null)
            throw new SemanticError("the rhs of the assignment is a function", it.pos);
        //System.out.println(it.lhs.type);
        //System.out.println(it.rhs.type);
        //System.out.println(it.lhs.dim);
        //System.out.println(it.rhs.dim);
        if (it.rhs.type.equals("null") && it.lhs.dim == 0 && it.lhs.type.equals("string")&& it.lhs.type.equals("int")&& it.lhs.type.equals("bool")) {
            throw new SemanticError("null type cannot be assigned to primitive type", it.pos);
        } else {
            //System.out.println(it.lhs.dim);
            //System.out.println(it.rhs.dim);
            if (!it.rhs.type.equals("null") && it.lhs.dim != it.rhs.dim)
                throw new SemanticError("lhs ans rhs have different dimensions", it.pos);
            if (!it.rhs.type.equals("null") && !it.lhs.type.equals(it.rhs.type))
                throw new SemanticError("lhs ans rhs have different types", it.pos);
        }
        it.type = it.lhs.type;
        it.dim = it.lhs.dim;
        it.assignable = false;
    }


    public void visit(PrefixExpressionNode it) {
        it.object.accept(this);
        if (it.op.equals("++") || it.op.equals("--")) {
            if (!it.object.assignable)
                throw new SemanticError("the object of suffix expression is not assignable", it.pos);
            if (!it.object.type.equals("int"))
                throw new SemanticError("the expression is not an integer to decrement or increment", it.pos);
            it.assignable = true;
        }
        if (!it.object.type.equals("bool") && !it.object.type.equals("int"))
            throw new SemanticError("only bool and int type can be calculated by prefix operator", it.pos);
        it.type = it.object.type;
        it.dim = it.object.dim;
    }

    public void visit(SuffixExpressionNode it) {
        it.object.accept(this);
        if (!it.object.assignable)
            throw new SemanticError("the object of suffix expression is not assignable", it.pos);
        if (!it.object.type.equals("int"))
            throw new SemanticError("the expression is not an integer to decrement or increment", it.pos);
        it.type = "int";
        it.dim = 0;
        it.assignable = false;//返回的是一个构造，不可以赋值
    }

    public void visit(CallExpressionNode it) {
        it.object.accept(this);
        if (it.object.is_function == null)
            throw new SemanticError("the object of the expression is not function", it.pos);
        FunctionDefNode func = it.object.is_function;
        //System.out.println(func.name);
        //System.out.println(func.parameterlist.size());
        //System.out.println(it.auguments.size());
        if (it.auguments.size() != func.parameterlist.size())
            throw new SemanticError("the number of the auguments is wrong", it.pos);
        it.auguments.forEach(a -> a.accept(this));
        it.func = func;
        int k = 0;
        for (ParameterNode i : func.parameterlist) {
            if (!it.auguments.get(k).type.equals("null") && !i.type.equals(it.auguments.get(k).type)) {
                //System.out.println(it.auguments.get(k).type);
                //System.out.println(i.type);
                throw new SemanticError("the type of the auguments " + it.auguments.get(k).type + " is wrong", it.pos);
            }
            if (i.dim != it.auguments.get(k).dim) {
                throw new SemanticError("the dimension of the auguments " + it.auguments.get(k).dim + " is wrong", it.pos);
            }
            k++;
        }
        //System.out.println(it.object.type);
        //System.out.println(func.name);
        //System.out.println(func.returntype);
        it.type = func.returntype;
        it.dim = func.returndim;
        it.is_function = null;//调用完函数这个表达式就不再是一个函数了
    }

    public void visit(LambdaExpressionNode it) {
        if (it.auguments.size() != it.parameters.size())
            throw new SemanticError("the number of the auguments is wrong", it.pos);
        currentScope = new Scope(currentScope);
        it.auguments.forEach(a -> a.accept(this));
        it.parameters.forEach(a -> a.accept(this));
        for (int k = 0; k < it.parameters.size(); ++k) {
            if (it.parameters.get(k).dim != it.auguments.get(k).dim)
                throw new SemanticError("the dimension of the auguments " + it.auguments.get(k) + " is wrong", it.pos);
            if (!it.auguments.get(k).type.equals("null") && !it.parameters.get(k).type.equals(it.auguments.get(k).type))
                throw new SemanticError("the type of the augument " + it.auguments.get(k) + " is wrong", it.pos);
        }
        FunctionDefNode lambda_func = new FunctionDefNode(null, 0, "lambda" + it.pos.toString(), it.stmts, null, it.pos);
        lambda_func.is_lambda = true;
        currentFunction.push(lambda_func);
        it.stmts.accept(this);
        //这时候就会在return中推断出这个函数的返回值类型和维数
        it.is_function = currentFunction.peek();
        it.type = it.is_function.returntype;
        it.dim = it.is_function.returndim;
        it.is_function = null;
        currentFunction.pop();
        currentScope = currentScope.parent;
    }

    public void visit(ArrayIndexExpressionNode it) {
        it.object.accept(this);
        if (it.object.dim == 0)
            throw new SemanticError("the expression " + it.object.type + " is not an array", it.pos);
        it.offset.accept(this);
        if (it.is_function != null || !it.offset.type.equals("int") || it.offset.dim != 0)
            throw new SemanticError("the index of array addressing " + it.offset.toString() + " is not an integer", it.pos);
        it.type = it.object.type;//访问之后就变成了整体的expression
        it.dim = it.object.dim - 1;
        it.assignable = it.object.assignable;
        //应该是给了几位的index整个表达式的维度数就可以减少几位,这里就是1位
    }

    public void visit(ParenExpressionNode it) {
        it.expression.accept(this);
        it.type = it.expression.type;
        it.dim = it.expression.dim;
        it.assignable = it.expression.assignable;
        if (it.expression.newed) it.assignable = true;
    }

    public void visit(PrimaryExpressionNode it) {
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.boolLiteralExpr) {
            it.assignable = false;
            it.type = "bool";
            it.dim = 0;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.integerLiteralExpr) {
            it.assignable = false;
            it.type = "int";
            it.dim = 0;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.nullLiteralExpr) {
            it.assignable = false;
            it.type = "null";
            it.dim = 0;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.stringLiteralExpr) {
            it.assignable = false;
            it.type = "string";
            it.dim = 0;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.thisExpr) {
            it.assignable = false;
            if (currentClass == null) throw new SemanticError("this cannot be used outside a class", it.pos);
            it.type = currentClass.name;
            it.dim = 0;
        }
        if (it.exprtype == PrimaryExpressionNode.ExpressionType.identifierExpr) {
            if (!currentScope.containVariable(it.primaryExpression, true)) {//没找到变量
                if (currentClass != null && currentClass.methodmap.containsKey(it.primaryExpression)) {
                    it.is_function = currentClass.methodmap.get(it.primaryExpression);
                    return;
                } else if (symbols.functionTypes.containsKey(it.primaryExpression)) {//但是找到了这个函数
                    it.is_function = symbols.functionTypes.get(it.primaryExpression);
                    //System.out.println(it.is_function.name);
                    return;
                } else {
                    //System.out.println(it.primaryExpression);
                    //System.out.println(currentClass.name);
                    if (currentClass != null && currentClass.variablemap.containsKey(it.primaryExpression)) {
                        it.type = currentClass.variablemap.get(it.primaryExpression).type;
                        it.dim = currentClass.variablemap.get(it.primaryExpression).dim;
                        it.assignable = true;
                        return;
                    } else
                        throw new SemanticError("this variable " + it.primaryExpression + " has not been defined", it.pos);
                }
            }
            it.assignable = true;
            it.type = currentScope.findVariable(it.primaryExpression, true).type;
            it.dim = currentScope.findVariable(it.primaryExpression, true).dim;
            //System.out.print(it.type);
            //System.out.print(it.dim);
        }
    }

    public void visit(MemberCallExpressionNode it) {
        it.object.accept(this);
        //it是想用object来dot那个member
        if (!symbols.classTypeUsed(it.object.type))
            throw new SemanticError("no such class has been defined", it.pos);
        if (!symbols.classTypes.get(it.object.type).variablemap.containsKey(it.id) && !symbols.classTypes.get(it.object.type).methodmap.containsKey(it.id)) {
            if (!it.id.equals("size") && !it.id.equals("this"))//也不是size函数或者this指针
                throw new SemanticError("no member or method named " + it.id + " in class " + it.object.type, it.pos);
            if (it.id.equals("size")) {
                if (it.object.dim != 0) {
                    it.is_function = symbols.functionTypes.get("size");
                    return;
                } else throw new SemanticError("only array object can call size function", it.pos);
            }
        }
        if (symbols.classTypes.get(it.object.type).methodmap.containsKey(it.id)) {
            it.is_function = symbols.classTypes.get(it.object.type).methodmap.get(it.id);
        }
        if (symbols.classTypes.get(it.object.type).variablemap.containsKey(it.id)) {
            DeclarationNode declaration = symbols.classTypes.get(it.object.type).variablemap.get(it.id);
            it.type = declaration.type;
            it.dim = declaration.dim;
            it.assignable = true;
        }
    }

    public void visit(NewExpressionNode it) {
        //System.out.println(it.dim);
        if (it.type.equals("void"))
            throw new SemanticError("new expression cannot apply to void", it.pos);
        it.class_ = symbols.classTypes.get(it.type);//先找到这个定义的类
        if (it.class_ == null)
            throw new SemanticError("the class of the new expression has not been defined", it.pos);
        for (ExpressionNode i : it.expression) {
            i.accept(this);
            if (it.is_function != null || !i.type.equals("int") || i.dim != 0)
                throw new SemanticError("the expression in new should be an integer", it.pos);
        }
        it.newed = true;
    }

    public void visit(BreakStatementNode it) {
        if (!currentScope.is_loop)
            throw new SemanticError("break statement can only appear in loop", it.pos);
    }

    public void visit(ContinueStatementNode it) {
        if (!currentScope.is_loop)
            throw new SemanticError("break statement can only appear in loop", it.pos);
    }
}
