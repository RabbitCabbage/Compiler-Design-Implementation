package frontend;

import ast.*;
import util.Scope;
import util.GlobalScope;

public class SemanticChecker extends ASTVisitor{
    private Scope currentScope;
    private GlobalScope gScope;

    public SemanticChecker(GlobalScope g){
        currentScope = g;
        gScope = g;
    }
    @Override
    public void visit(RootNode it) {

    }

    @Override
    public void visit(VariableDefNode it) {

    }

    @Override
    public void visit(FunctionDefNode it) {

    }

    @Override
    public void visit(IfStatementNode it) {

    }

    @Override
    public void visit(ReturnStatementNode it) {

    }

    @Override
    public void visit(ExpressionStatementNode it) {

    }

    @Override
    public void visit(BinaryExpressionNode it) {

    }

    @Override
    public void visit(LogicExpressionNode it) {

    }

    @Override
    public void visit(AssignmentExpressionNode it) {

    }

    @Override
    public void visit(VariableExpressionNode it) {

    }


    @Override
    public void visit(ParameterNode parameterNode) {

    }


    @Override
    public void visit(ClassDefNode it) {

    }


    @Override
    public void visit(DeclarationNode it) {

    }
}
