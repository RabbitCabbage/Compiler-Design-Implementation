// Generated from D:/Desktop/Compiler-Design-Implementation/grammar\MxParser.g4 by ANTLR 4.10.1
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
	 * Enter a parse tree produced by {@link MxParser#programSections}.
	 * @param ctx the parse tree
	 */
	void enterProgramSections(MxParser.ProgramSectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#programSections}.
	 * @param ctx the parse tree
	 */
	void exitProgramSections(MxParser.ProgramSectionsContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#globalVariableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVariableDefinition(MxParser.GlobalVariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#globalVariableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVariableDefinition(MxParser.GlobalVariableDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(MxParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(MxParser.VariableDefinitionContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(MxParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(MxParser.JumpStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 */
	void enterCirculationStatement(MxParser.CirculationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#circulationStatement}.
	 * @param ctx the parse tree
	 */
	void exitCirculationStatement(MxParser.CirculationStatementContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(MxParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void enterComplexExpression(MxParser.ComplexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#complexExpression}.
	 * @param ctx the parse tree
	 */
	void exitComplexExpression(MxParser.ComplexExpressionContext ctx);
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