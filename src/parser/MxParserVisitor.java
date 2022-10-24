// Generated from D:/Desktop/Compiler-Design-Implementation/parser\MxParser.g4 by ANTLR 4.10.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#programSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramSection(MxParser.ProgramSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(MxParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(MxParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(MxParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(MxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(MxParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#builtInFunctionReturnVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionReturnVoid(MxParser.BuiltInFunctionReturnVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#baseVariableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseVariableDefinition(MxParser.BaseVariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#arrayVariableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVariableDefinition(MxParser.ArrayVariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MxParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakSstatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakSstatement(MxParser.BreakSstatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continyeSstatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinyeSstatement(MxParser.ContinyeSstatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MxParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStatement}
	 * labeled alternative in {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forInitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitStatement(MxParser.ForInitStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code calculationExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculationExpression(MxParser.CalculationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(MxParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExpression(MxParser.BasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(MxParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObjectExpression}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObjectExpression(MxParser.NewObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExpression(MxParser.NewArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(MxParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberCallExpression(MxParser.MemberCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(MxParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixIncrementDecrementExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixIncrementDecrementExpression(MxParser.PrefixIncrementDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpression(MxParser.LogicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(MxParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(MxParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code builtinfunctionCallExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinfunctionCallExpression(MxParser.BuiltinfunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayIndexingExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndexingExpression(MxParser.ArrayIndexingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExression(MxParser.PrefixExressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixIncrementDecrementExpression}
	 * labeled alternative in {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixIncrementDecrementExpression(MxParser.SuffixIncrementDecrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue_Dot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionWithReturnValue_Dot(MxParser.BuiltInFunctionWithReturnValue_DotContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#builtInFunctionWithReturnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInFunctionWithReturnValue(MxParser.BuiltInFunctionWithReturnValueContext ctx);
}