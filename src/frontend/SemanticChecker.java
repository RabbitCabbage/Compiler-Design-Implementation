package frontend;

import ast.*;
import util.Scope;
import util.Type;
import util.error.SemanticError;
import util.GlobalScope;

public class SemanticChecker implements ASTVisitor{
    private Scope currentScope;
    @Override
    public void visit(RootNode it) {

    }

    @Override
    public void visit(BaseVariableDefNode it) {

    }

    @Override
    public void visit(FunctionDefNode it) {

    }

    @Override
    public void visit(BlockStatementNode it) {

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
    public void visit(BuiltInFunctionExpressionNode it) {

    }

    @Override
    public void visit(ParameterNode parameterNode) {

    }

    @Override
    public void visit(BuiltInFunctionStatementNode it) {

    }

    @Override
    public void visit(ClassDefNode it) {

    }

    @Override
    public void visit(ArrayVariableDefNode it) {

    }

    @Override
    public void visit(DeclarationNode it) {

    }
}
