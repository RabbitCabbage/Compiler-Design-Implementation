package ast;

public interface ASTVisitor {
    void visit(RootNode it);//我调用visit就会visit程序根节点
    //对应的在根节点上有一个函数accept就是让visitor来visit自己
    //会在每一个节点visit它所有可能往下的子节点，这里返回的
    void visit(BaseVariableDefNode it);

    void visit(FunctionDefNode it);

    void visit(BlockStatementNode it);

    void visit(IfStatementNode it);

    void visit(ReturnStatementNode it);

    void visit(ExpressionStatementNode it);

    void visit(BinaryExpressionNode it);

    void visit(LogicExpressionNode it);

    void visit(AssignmentExpressionNode it);

    void visit(VariableExpressionNode it);

    void visit(BuiltInFunctionExpressionNode it);

    void visit(ParameterNode parameterNode);

    void visit(BuiltInFunctionStatementNode it);

    void visit(ClassDefNode it);

    void visit(ArrayVariableDefNode it);

    void visit(DeclarationNode it);
}
