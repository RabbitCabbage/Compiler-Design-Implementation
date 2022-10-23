package ast;

public interface ASTVisitor {
    void visit(RootNode node);//我调用visit就会visit程序根节点
    //对应的在根节点上有一个函数accept就是让visitor来visit自己
    //会在每一个节点visit它所有可能往下的子节点，这里返回的

    void visit(MainFunctionNode node);

    void visit(VariableDefNode node);

    void visit(FunctionDefNode node);

    void visit(BlockStatementNode node);

    void visit(IfStatementNode node);

    void visit(ReturnStatementNode node);

    void visit(ExpressionStatementNode node);

    void visit(BinaryExpressionNode node);

    void visit(LogicExpressionNode node);

    void visit(AssignmentExpressionNode node);

    void visit(VariableExpressionNode node);

    void visit(BuiltInFunctionExpressionNode node);

    void visit(ParameterNode parameterNode);

    void visit(BuiltInFunctionStatementNode node);
}
