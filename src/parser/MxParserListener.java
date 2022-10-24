// Generated from D:/Desktop/Compiler-Design-Implementation/parser\MxParser.g4 by ANTLR 4.10.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#programSection}.
	 * @param ctx the parse tree
	 */
	void enterProgramSection(MxParser.ProgramSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#programSection}.
	 * @param ctx the parse tree
	 */
	void exitProgramSection(MxParser.ProgramSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(MxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(MxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#builtInFunctionReturnVoid}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInFunctionReturnVoid(MxParser.BuiltInFunctionReturnVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#builtInFunctionReturnVoid}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInFunctionReturnVoid(MxParser.BuiltInFunctionReturnVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#baseVariableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterBaseVariableDefinition(MxParser.BaseVariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#baseVariableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitBaseVariableDefinition(MxParser.BaseVariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#arrayVariableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariableDefinition(MxParser.ArrayVariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#arrayVariableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariableDefinition(MxParser.ArrayVariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakSstatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakSstatement(MxParser.BreakSstatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakSstatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakSstatement(MxParser.BreakSstatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continyeSstatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinyeSstatement(MxParser.ContinyeSstatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continyeSstatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinyeSstatement(MxParser.ContinyeSstatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInitStatement(MxParser.ForInitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInitStatement(MxParser.ForInitStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code calculationExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCalculationExpression(MxParser.CalculationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code calculationExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCalculationExpression(MxParser.CalculationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBasicExpression(MxParser.BasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBasicExpression(MxParser.BasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObjectExpression}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewObjectExpression(MxParser.NewObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObjectExpression}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewObjectExpression(MxParser.NewObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpression(MxParser.NewArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpression(MxParser.NewArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(MxParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(MxParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberCallExpression(MxParser.MemberCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberCallExpression(MxParser.MemberCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(MxParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(MxParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixIncrementDecrementExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixIncrementDecrementExpression(MxParser.PrefixIncrementDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixIncrementDecrementExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixIncrementDecrementExpression(MxParser.PrefixIncrementDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpression(MxParser.LogicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpression(MxParser.LogicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(MxParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(MxParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(MxParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(MxParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code builtinfunctionCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinfunctionCallExpression(MxParser.BuiltinfunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code builtinfunctionCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinfunctionCallExpression(MxParser.BuiltinfunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayIndexingExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexingExpression(MxParser.ArrayIndexingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayIndexingExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexingExpression(MxParser.ArrayIndexingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExression(MxParser.PrefixExressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExression(MxParser.PrefixExressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixIncrementDecrementExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixIncrementDecrementExpression(MxParser.SuffixIncrementDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixIncrementDecrementExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixIncrementDecrementExpression(MxParser.SuffixIncrementDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue_Dot}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInFunctionWithReturnValue_Dot(MxParser.BuiltInFunctionWithReturnValue_DotContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue_Dot}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInFunctionWithReturnValue_Dot(MxParser.BuiltInFunctionWithReturnValue_DotContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInFunctionWithReturnValue(MxParser.BuiltInFunctionWithReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInFunctionWithReturnValue(MxParser.BuiltInFunctionWithReturnValueContext ctx);
}