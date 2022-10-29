package ast;


public class ASTVisitor{
    public void visit(RootNode it){}//我调用visit就会visit程序根节点
    //对应的在根节点上有一个函数accept就是让visitor来visit自己
    //会在每一个节点visit它所有可能往下的子节点，这里返回的
    public void visit(VariableDefNode it){}

    public void visit(FunctionDefNode it){}


    public void visit(IfStatementNode it){}

    public void visit(ReturnStatementNode it){}

    public void visit(ExpressionStatementNode it){}

    public void visit(BinaryExpressionNode it){}

    public void visit(AssignmentExpressionNode it){}

    public void visit(ParameterNode parameterNode){}

    public void visit(ClassDefNode it){}

    public void visit(DeclarationNode it){}

    public void visit(SuiteNode it) {}

    public void visit(WhileStatementNode it) {}

    public void visit(ForStatementNode it) {}

    public void visit(PrefixExpressionNode it) {}

    public void visit(SuffixExpressionNode it) {}

    public void visit(CallExpressionNode it) {}

    public void visit(LambdaExpressionNode it) {}

    public void visit(ArrayIndexExpressionNode it) {}

    public void visit(ParenExpressionNode it) {}

    public void visit(PrimaryExpressionNode it) {}

    public void visit(MemberCallExpressionNode it) {}

    public void visit(NewExpressionNode it) {}

    public void visit(BreakStatementNode it) {}

    public void visit(ContinueStatementNode it) {}
}
