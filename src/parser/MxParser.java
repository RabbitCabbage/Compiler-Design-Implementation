// Generated from D:/Desktop/Compiler-Design-Implementation/src/parser\MxParser.g4 by ANTLR 4.10.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Literal=1, BooleanLiteral=2, IntegerLiteral=3, StringLiteral=4, NullLiteral=5, 
		Bool=6, Int=7, Void=8, String=9, False_=10, True_=11, New=12, Class=13, 
		Public=14, This=15, NULL=16, If=17, Else=18, For=19, While=20, Break=21, 
		Continue=22, Return=23, DecimalLiteral=24, LeftParen=25, RightParen=26, 
		LeftBracket=27, RightBracket=28, LeftBrace=29, RightBrace=30, Plus=31, 
		Minus=32, Star=33, Div=34, Mod=35, Caret=36, And=37, Or=38, Tilde=39, 
		Not=40, Assign=41, Less=42, Greater=43, Equal=44, NotEqual=45, LessEqual=46, 
		GreaterEqual=47, AndAnd=48, OrOr=49, PlusPlus=50, MinusMinus=51, Comma=52, 
		Colon=53, Semicolon=54, LessLess=55, GreaterGreater=56, Dot=57, RightArrow=58, 
		Identifier=59, Whitespacetoskip=60, Newline=61, LineComment=62, BlockComment=63;
	public static final int
		RULE_program = 0, RULE_programSection = 1, RULE_classDefinition = 2, RULE_functionDefinition = 3, 
		RULE_constructFunctionDef = 4, RULE_basicType = 5, RULE_variableType = 6, 
		RULE_newType = 7, RULE_parameter = 8, RULE_suite = 9, RULE_statement = 10, 
		RULE_emptyStatement = 11, RULE_variableDefinition = 12, RULE_declaration = 13, 
		RULE_expressionStatement = 14, RULE_jumpStatement = 15, RULE_ifStatement = 16, 
		RULE_circulationStatement = 17, RULE_forInitStatement = 18, RULE_expression = 19, 
		RULE_basicExpression = 20, RULE_lambdaExpression = 21, RULE_newExpression = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programSection", "classDefinition", "functionDefinition", 
			"constructFunctionDef", "basicType", "variableType", "newType", "parameter", 
			"suite", "statement", "emptyStatement", "variableDefinition", "declaration", 
			"expressionStatement", "jumpStatement", "ifStatement", "circulationStatement", 
			"forInitStatement", "expression", "basicExpression", "lambdaExpression", 
			"newExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'bool'", "'int'", "'void'", "'string'", 
			"'false'", "'true'", "'new'", "'class'", "'public'", "'this'", "'null'", 
			"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'^'", "'&'", "'|'", "'~'", "'!'", "'='", "'<'", "'>'", 
			"'=='", "'!='", "'<='", "'>='", "'&&'", "'||'", "'++'", "'--'", "','", 
			"':'", "';'", "'<<'", "'>>'", "'.'", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Literal", "BooleanLiteral", "IntegerLiteral", "StringLiteral", 
			"NullLiteral", "Bool", "Int", "Void", "String", "False_", "True_", "New", 
			"Class", "Public", "This", "NULL", "If", "Else", "For", "While", "Break", 
			"Continue", "Return", "DecimalLiteral", "LeftParen", "RightParen", "LeftBracket", 
			"RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", "Star", "Div", 
			"Mod", "Caret", "And", "Or", "Tilde", "Not", "Assign", "Less", "Greater", 
			"Equal", "NotEqual", "LessEqual", "GreaterEqual", "AndAnd", "OrOr", "PlusPlus", 
			"MinusMinus", "Comma", "Colon", "Semicolon", "LessLess", "GreaterGreater", 
			"Dot", "RightArrow", "Identifier", "Whitespacetoskip", "Newline", "LineComment", 
			"BlockComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MxParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<ProgramSectionContext> programSection() {
			return getRuleContexts(ProgramSectionContext.class);
		}
		public ProgramSectionContext programSection(int i) {
			return getRuleContext(ProgramSectionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				programSection();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0) );
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramSectionContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ClassDefinitionContext classDefinition() {
			return getRuleContext(ClassDefinitionContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public ProgramSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterProgramSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitProgramSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitProgramSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramSectionContext programSection() throws RecognitionException {
		ProgramSectionContext _localctx = new ProgramSectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programSection);
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				classDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				variableDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefinitionContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<ConstructFunctionDefContext> constructFunctionDef() {
			return getRuleContexts(ConstructFunctionDefContext.class);
		}
		public ConstructFunctionDefContext constructFunctionDef(int i) {
			return getRuleContext(ConstructFunctionDefContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitClassDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitClassDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(Class);
			setState(59);
			match(Identifier);
			setState(60);
			match(LeftBrace);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(61);
					variableDefinition();
					}
					break;
				case 2:
					{
					setState(62);
					constructFunctionDef();
					}
					break;
				case 3:
					{
					setState(63);
					functionDefinition();
					}
					break;
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(RightBrace);
			setState(70);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			variableType();
			setState(73);
			match(Identifier);
			setState(74);
			match(LeftParen);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(75);
				parameter();
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(78);
				match(Comma);
				setState(79);
				parameter();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(RightParen);
			setState(86);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructFunctionDefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ConstructFunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFunctionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterConstructFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitConstructFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitConstructFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructFunctionDefContext constructFunctionDef() throws RecognitionException {
		ConstructFunctionDefContext _localctx = new ConstructFunctionDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constructFunctionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(Identifier);
			setState(89);
			match(LeftParen);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(90);
				parameter();
				}
			}

			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(93);
				match(Comma);
				setState(94);
				parameter();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(RightParen);
			setState(101);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableTypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public VariableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterVariableType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitVariableType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVariableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableTypeContext variableType() throws RecognitionException {
		VariableTypeContext _localctx = new VariableTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			basicType();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LeftBracket) {
				{
				{
				setState(106);
				match(LeftBracket);
				setState(107);
				match(RightBracket);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewTypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxParser.LeftBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxParser.RightBracket, i);
		}
		public NewTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterNewType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitNewType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitNewType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTypeContext newType() throws RecognitionException {
		NewTypeContext _localctx = new NewTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_newType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			basicType();
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					match(LeftBracket);
					setState(115);
					expression(0);
					setState(116);
					match(RightBracket);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(LeftBracket);
					setState(124);
					match(RightBracket);
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			variableType();
			setState(131);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LeftBrace);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << New) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << LeftParen) | (1L << LeftBracket) | (1L << LeftBrace) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Semicolon) | (1L << Identifier))) != 0)) {
				{
				{
				setState(134);
				statement();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public CirculationStatementContext circulationStatement() {
			return getRuleContext(CirculationStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				suite();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				variableDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				expressionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				ifStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				jumpStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				circulationStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(148);
				emptyStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public VariableTypeContext variableType() {
			return getRuleContext(VariableTypeContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			variableType();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(154);
				declaration();
				}
			}

			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(157);
				match(Comma);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(158);
					declaration();
					}
				}

				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(Identifier);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(169);
				match(Assign);
				setState(170);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBracket) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Identifier))) != 0)) {
				{
				setState(173);
				expression(0);
				}
			}

			setState(176);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	 
		public JumpStatementContext() { }
		public void copyFrom(JumpStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BreakStatementContext extends JumpStatementContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public BreakStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatementContext extends JumpStatementContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public ContinueStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends JumpStatementContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jumpStatement);
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Break:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(Break);
				setState(179);
				match(Semicolon);
				}
				break;
			case Continue:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(Continue);
				setState(181);
				match(Semicolon);
				}
				break;
			case Return:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(Return);
				{
				setState(183);
				expression(0);
				}
				setState(184);
				match(Semicolon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public StatementContext trueStatement;
		public StatementContext falseStatement;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> Else() { return getTokens(MxParser.Else); }
		public TerminalNode Else(int i) {
			return getToken(MxParser.Else, i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(If);
			setState(189);
			match(LeftParen);
			setState(190);
			expression(0);
			setState(191);
			match(RightParen);
			setState(192);
			((IfStatementContext)_localctx).trueStatement = statement();
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					match(Else);
					setState(194);
					((IfStatementContext)_localctx).falseStatement = statement();
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CirculationStatementContext extends ParserRuleContext {
		public CirculationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circulationStatement; }
	 
		public CirculationStatementContext() { }
		public void copyFrom(CirculationStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileStatementContext extends CirculationStatementContext {
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(CirculationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatementContext extends CirculationStatementContext {
		public ExpressionContext condition;
		public ExpressionContext next;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitStatementContext forInitStatement() {
			return getRuleContext(ForInitStatementContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MxParser.Semicolon, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(CirculationStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CirculationStatementContext circulationStatement() throws RecognitionException {
		CirculationStatementContext _localctx = new CirculationStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_circulationStatement);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(While);
				setState(201);
				match(LeftParen);
				setState(202);
				expression(0);
				setState(203);
				match(RightParen);
				setState(204);
				statement();
				}
				break;
			case For:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(For);
				setState(207);
				match(LeftParen);
				{
				setState(208);
				forInitStatement();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBracket) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Identifier))) != 0)) {
					{
					setState(209);
					((ForStatementContext)_localctx).condition = expression(0);
					}
				}

				setState(212);
				match(Semicolon);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBracket) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Identifier))) != 0)) {
					{
					setState(213);
					((ForStatementContext)_localctx).next = expression(0);
					}
				}

				}
				setState(216);
				match(RightParen);
				setState(217);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitStatementContext extends ParserRuleContext {
		public VariableDefinitionContext vardef;
		public ExpressionContext init;
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterForInitStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitForInitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitForInitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitStatementContext forInitStatement() throws RecognitionException {
		ForInitStatementContext _localctx = new ForInitStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forInitStatement);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				((ForInitStatementContext)_localctx).vardef = variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				((ForInitStatementContext)_localctx).init = expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimaryExpressionContext extends ExpressionContext {
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public PrimaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitPrimaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPrimaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Star() { return getToken(MxParser.Star, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(MxParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public TerminalNode LessLess() { return getToken(MxParser.LessLess, 0); }
		public TerminalNode GreaterGreater() { return getToken(MxParser.GreaterGreater, 0); }
		public TerminalNode Greater() { return getToken(MxParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(MxParser.GreaterEqual, 0); }
		public TerminalNode Less() { return getToken(MxParser.Less, 0); }
		public TerminalNode LessEqual() { return getToken(MxParser.LessEqual, 0); }
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(MxParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public TerminalNode Caret() { return getToken(MxParser.Caret, 0); }
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(MxParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(MxParser.OrOr, 0); }
		public BinaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberCallExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(MxParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public MemberCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterMemberCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitMemberCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitMemberCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(MxParser.Tilde, 0); }
		public TerminalNode PlusPlus() { return getToken(MxParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(MxParser.MinusMinus, 0); }
		public TerminalNode Plus() { return getToken(MxParser.Plus, 0); }
		public PrefixExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterPrefixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitPrefixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPrefixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(MxParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(MxParser.MinusMinus, 0); }
		public SuffixExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterSuffixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitSuffixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitSuffixExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayIndexingExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public ArrayIndexingExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterArrayIndexingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitArrayIndexingExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitArrayIndexingExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public PrefixExressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterPrefixExression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitPrefixExression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitPrefixExression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Literal:
			case New:
			case This:
			case LeftBracket:
			case Identifier:
				{
				_localctx = new PrimaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(226);
				basicExpression();
				}
				break;
			case LeftParen:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(LeftParen);
				setState(228);
				expression(0);
				setState(229);
				match(RightParen);
				}
				break;
			case Not:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				((PrefixExpressionContext)_localctx).op = match(Not);
				setState(232);
				expression(17);
				}
				break;
			case Tilde:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				((PrefixExpressionContext)_localctx).op = match(Tilde);
				setState(234);
				expression(16);
				}
				break;
			case PlusPlus:
			case MinusMinus:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				((PrefixExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PlusPlus || _la==MinusMinus) ) {
					((PrefixExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(236);
				expression(14);
				}
				break;
			case Minus:
				{
				_localctx = new PrefixExressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				((PrefixExressionContext)_localctx).op = match(Minus);
				setState(238);
				expression(13);
				}
				break;
			case Plus:
				{
				_localctx = new PrefixExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				((PrefixExpressionContext)_localctx).op = match(Plus);
				setState(240);
				expression(12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(299);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(244);
						((BinaryExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Star) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(246);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(247);
						((BinaryExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(250);
						((BinaryExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LessLess || _la==GreaterGreater) ) {
							((BinaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(253);
						((BinaryExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << Greater) | (1L << LessEqual) | (1L << GreaterEqual))) != 0)) ) {
							((BinaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(255);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(256);
						((BinaryExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((BinaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(257);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(259);
						((BinaryExpressionContext)_localctx).op = match(And);
						setState(260);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(261);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(262);
						((BinaryExpressionContext)_localctx).op = match(Caret);
						setState(263);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(265);
						((BinaryExpressionContext)_localctx).op = match(Or);
						setState(266);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(268);
						((BinaryExpressionContext)_localctx).op = match(AndAnd);
						setState(269);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						((BinaryExpressionContext)_localctx).op = match(OrOr);
						setState(272);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new AssignmentExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(274);
						match(Assign);
						setState(275);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new ArrayIndexingExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(277);
						match(LeftBracket);
						setState(278);
						expression(0);
						setState(279);
						match(RightBracket);
						}
						break;
					case 13:
						{
						_localctx = new FunctionCallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(281);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(282);
						match(LeftParen);
						setState(284);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBracket) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Identifier))) != 0)) {
							{
							setState(283);
							expression(0);
							}
						}

						setState(290);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(286);
							match(Comma);
							setState(287);
							expression(0);
							}
							}
							setState(292);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(293);
						match(RightParen);
						}
						break;
					case 14:
						{
						_localctx = new MemberCallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(295);
						match(Dot);
						setState(296);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new SuffixExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(297);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(298);
						((SuffixExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PlusPlus || _la==MinusMinus) ) {
							((SuffixExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BasicExpressionContext extends ParserRuleContext {
		public TerminalNode Literal() { return getToken(MxParser.Literal, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public BasicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicExpressionContext basicExpression() throws RecognitionException {
		BasicExpressionContext _localctx = new BasicExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_basicExpression);
		try {
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				match(Literal);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(Identifier);
				}
				break;
			case This:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				match(This);
				}
				break;
			case LeftBracket:
				enterOuterAlt(_localctx, 4);
				{
				setState(307);
				lambdaExpression();
				}
				break;
			case New:
				enterOuterAlt(_localctx, 5);
				{
				setState(308);
				newExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaExpressionContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(MxParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxParser.RightBracket, 0); }
		public TerminalNode RightArrow() { return getToken(MxParser.RightArrow, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_lambdaExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(LeftBracket);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==And) {
				{
				setState(312);
				match(And);
				}
			}

			setState(315);
			match(RightBracket);
			{
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << Void) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(316);
				parameter();
				}
			}

			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(319);
				match(Comma);
				setState(320);
				parameter();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(326);
			match(RightArrow);
			setState(327);
			suite();
			setState(328);
			match(LeftParen);
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBracket) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Identifier))) != 0)) {
				{
				setState(329);
				expression(0);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(330);
					match(Comma);
					setState(331);
					expression(0);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(339);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public NewTypeContext newType() {
			return getRuleContext(NewTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxParserListener ) ((MxParserListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(New);
			setState(342);
			newType();
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(343);
				match(LeftParen);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Literal) | (1L << New) | (1L << This) | (1L << LeftParen) | (1L << LeftBracket) | (1L << Plus) | (1L << Minus) | (1L << Tilde) | (1L << Not) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << Identifier))) != 0)) {
					{
					setState(344);
					expression(0);
					}
				}

				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(347);
					match(Comma);
					setState(348);
					expression(0);
					}
					}
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(354);
				match(RightParen);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 20);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u0166\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0004\u00000\b\u0000\u000b\u0000"+
		"\f\u00001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00019\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003M\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"Q\b\u0003\n\u0003\f\u0003T\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004`\b\u0004\n\u0004\f\u0004c\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006m\b\u0006\n\u0006\f\u0006p\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007w\b\u0007"+
		"\n\u0007\f\u0007z\t\u0007\u0001\u0007\u0001\u0007\u0005\u0007~\b\u0007"+
		"\n\u0007\f\u0007\u0081\t\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0005\t\u0088\b\t\n\t\f\t\u008b\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0096\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0003\f\u009c\b\f\u0001\f\u0001\f\u0003\f\u00a0"+
		"\b\f\u0005\f\u00a2\b\f\n\f\f\f\u00a5\t\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00ac\b\r\u0001\u000e\u0003\u000e\u00af\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00bb\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00c4\b\u0010\n\u0010\f\u0010\u00c7\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00d3\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00d7\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00dc\b\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u00e0\b"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00f2"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u011d\b\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0121\b\u0013"+
		"\n\u0013\f\u0013\u0124\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u012c\b\u0013\n\u0013\f\u0013"+
		"\u012f\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0136\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u013a\b"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u013e\b\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0142\b\u0015\n\u0015\f\u0015\u0145\t\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015"+
		"\u014d\b\u0015\n\u0015\f\u0015\u0150\t\u0015\u0003\u0015\u0152\b\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u015a\b\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u015e\b"+
		"\u0016\n\u0016\f\u0016\u0161\t\u0016\u0001\u0016\u0003\u0016\u0164\b\u0016"+
		"\u0001\u0016\u0000\u0001&\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0007\u0002\u0000"+
		"\u0006\t;;\u0001\u000023\u0001\u0000!#\u0001\u0000\u001f \u0001\u0000"+
		"78\u0002\u0000*+./\u0001\u0000,-\u0191\u0000/\u0001\u0000\u0000\u0000"+
		"\u00028\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006H"+
		"\u0001\u0000\u0000\u0000\bX\u0001\u0000\u0000\u0000\ng\u0001\u0000\u0000"+
		"\u0000\fi\u0001\u0000\u0000\u0000\u000eq\u0001\u0000\u0000\u0000\u0010"+
		"\u0082\u0001\u0000\u0000\u0000\u0012\u0085\u0001\u0000\u0000\u0000\u0014"+
		"\u0095\u0001\u0000\u0000\u0000\u0016\u0097\u0001\u0000\u0000\u0000\u0018"+
		"\u0099\u0001\u0000\u0000\u0000\u001a\u00a8\u0001\u0000\u0000\u0000\u001c"+
		"\u00ae\u0001\u0000\u0000\u0000\u001e\u00ba\u0001\u0000\u0000\u0000 \u00bc"+
		"\u0001\u0000\u0000\u0000\"\u00db\u0001\u0000\u0000\u0000$\u00df\u0001"+
		"\u0000\u0000\u0000&\u00f1\u0001\u0000\u0000\u0000(\u0135\u0001\u0000\u0000"+
		"\u0000*\u0137\u0001\u0000\u0000\u0000,\u0155\u0001\u0000\u0000\u0000."+
		"0\u0003\u0002\u0001\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000034\u0005\u0000\u0000\u00014\u0001\u0001\u0000\u0000\u0000"+
		"59\u0003\u0006\u0003\u000069\u0003\u0004\u0002\u000079\u0003\u0018\f\u0000"+
		"85\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000087\u0001\u0000\u0000"+
		"\u00009\u0003\u0001\u0000\u0000\u0000:;\u0005\r\u0000\u0000;<\u0005;\u0000"+
		"\u0000<B\u0005\u001d\u0000\u0000=A\u0003\u0018\f\u0000>A\u0003\b\u0004"+
		"\u0000?A\u0003\u0006\u0003\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000EF\u0005\u001e\u0000\u0000FG\u00056\u0000\u0000"+
		"G\u0005\u0001\u0000\u0000\u0000HI\u0003\f\u0006\u0000IJ\u0005;\u0000\u0000"+
		"JL\u0005\u0019\u0000\u0000KM\u0003\u0010\b\u0000LK\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MR\u0001\u0000\u0000\u0000NO\u00054\u0000\u0000"+
		"OQ\u0003\u0010\b\u0000PN\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000UV\u0005\u001a\u0000\u0000VW\u0003\u0012"+
		"\t\u0000W\u0007\u0001\u0000\u0000\u0000XY\u0005;\u0000\u0000Y[\u0005\u0019"+
		"\u0000\u0000Z\\\u0003\u0010\b\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\a\u0001\u0000\u0000\u0000]^\u00054\u0000\u0000^`\u0003"+
		"\u0010\b\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000de\u0005\u001a\u0000\u0000ef\u0003\u0012\t\u0000"+
		"f\t\u0001\u0000\u0000\u0000gh\u0007\u0000\u0000\u0000h\u000b\u0001\u0000"+
		"\u0000\u0000in\u0003\n\u0005\u0000jk\u0005\u001b\u0000\u0000km\u0005\u001c"+
		"\u0000\u0000lj\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\r\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000qx\u0003\n\u0005\u0000rs\u0005\u001b\u0000\u0000"+
		"st\u0003&\u0013\u0000tu\u0005\u001c\u0000\u0000uw\u0001\u0000\u0000\u0000"+
		"vr\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y\u007f\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000{|\u0005\u001b\u0000\u0000|~\u0005\u001c\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u000f\u0001"+
		"\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0003"+
		"\f\u0006\u0000\u0083\u0084\u0003\u001a\r\u0000\u0084\u0011\u0001\u0000"+
		"\u0000\u0000\u0085\u0089\u0005\u001d\u0000\u0000\u0086\u0088\u0003\u0014"+
		"\n\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0005\u001e\u0000\u0000\u008d\u0013\u0001\u0000\u0000"+
		"\u0000\u008e\u0096\u0003\u0012\t\u0000\u008f\u0096\u0003\u0018\f\u0000"+
		"\u0090\u0096\u0003\u001c\u000e\u0000\u0091\u0096\u0003 \u0010\u0000\u0092"+
		"\u0096\u0003\u001e\u000f\u0000\u0093\u0096\u0003\"\u0011\u0000\u0094\u0096"+
		"\u0003\u0016\u000b\u0000\u0095\u008e\u0001\u0000\u0000\u0000\u0095\u008f"+
		"\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000\u0000\u0095\u0091"+
		"\u0001\u0000\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0015"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u00056\u0000\u0000\u0098\u0017\u0001"+
		"\u0000\u0000\u0000\u0099\u009b\u0003\f\u0006\u0000\u009a\u009c\u0003\u001a"+
		"\r\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000"+
		"\u0000\u009c\u00a3\u0001\u0000\u0000\u0000\u009d\u009f\u00054\u0000\u0000"+
		"\u009e\u00a0\u0003\u001a\r\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1"+
		"\u009d\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u00056\u0000\u0000\u00a7\u0019\u0001\u0000\u0000\u0000\u00a8\u00ab"+
		"\u0005;\u0000\u0000\u00a9\u00aa\u0005)\u0000\u0000\u00aa\u00ac\u0003&"+
		"\u0013\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u001b\u0001\u0000\u0000\u0000\u00ad\u00af\u0003&\u0013"+
		"\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u00056\u0000\u0000"+
		"\u00b1\u001d\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0015\u0000\u0000"+
		"\u00b3\u00bb\u00056\u0000\u0000\u00b4\u00b5\u0005\u0016\u0000\u0000\u00b5"+
		"\u00bb\u00056\u0000\u0000\u00b6\u00b7\u0005\u0017\u0000\u0000\u00b7\u00b8"+
		"\u0003&\u0013\u0000\u00b8\u00b9\u00056\u0000\u0000\u00b9\u00bb\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b2\u0001\u0000\u0000\u0000\u00ba\u00b4\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000\u00bb\u001f\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0005\u0011\u0000\u0000\u00bd\u00be\u0005\u0019"+
		"\u0000\u0000\u00be\u00bf\u0003&\u0013\u0000\u00bf\u00c0\u0005\u001a\u0000"+
		"\u0000\u00c0\u00c5\u0003\u0014\n\u0000\u00c1\u00c2\u0005\u0012\u0000\u0000"+
		"\u00c2\u00c4\u0003\u0014\n\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6!\u0001\u0000\u0000\u0000\u00c7\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0014\u0000\u0000\u00c9\u00ca"+
		"\u0005\u0019\u0000\u0000\u00ca\u00cb\u0003&\u0013\u0000\u00cb\u00cc\u0005"+
		"\u001a\u0000\u0000\u00cc\u00cd\u0003\u0014\n\u0000\u00cd\u00dc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0005\u0013\u0000\u0000\u00cf\u00d0\u0005\u0019"+
		"\u0000\u0000\u00d0\u00d2\u0003$\u0012\u0000\u00d1\u00d3\u0003&\u0013\u0000"+
		"\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u00056\u0000\u0000\u00d5"+
		"\u00d7\u0003&\u0013\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9"+
		"\u0005\u001a\u0000\u0000\u00d9\u00da\u0003\u0014\n\u0000\u00da\u00dc\u0001"+
		"\u0000\u0000\u0000\u00db\u00c8\u0001\u0000\u0000\u0000\u00db\u00ce\u0001"+
		"\u0000\u0000\u0000\u00dc#\u0001\u0000\u0000\u0000\u00dd\u00e0\u0003\u0018"+
		"\f\u0000\u00de\u00e0\u0003&\u0013\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0%\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0006\u0013\uffff\uffff\u0000\u00e2\u00f2\u0003(\u0014\u0000"+
		"\u00e3\u00e4\u0005\u0019\u0000\u0000\u00e4\u00e5\u0003&\u0013\u0000\u00e5"+
		"\u00e6\u0005\u001a\u0000\u0000\u00e6\u00f2\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0005(\u0000\u0000\u00e8\u00f2\u0003&\u0013\u0011\u00e9\u00ea\u0005"+
		"\'\u0000\u0000\u00ea\u00f2\u0003&\u0013\u0010\u00eb\u00ec\u0007\u0001"+
		"\u0000\u0000\u00ec\u00f2\u0003&\u0013\u000e\u00ed\u00ee\u0005 \u0000\u0000"+
		"\u00ee\u00f2\u0003&\u0013\r\u00ef\u00f0\u0005\u001f\u0000\u0000\u00f0"+
		"\u00f2\u0003&\u0013\f\u00f1\u00e1\u0001\u0000\u0000\u0000\u00f1\u00e3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00e7\u0001\u0000\u0000\u0000\u00f1\u00e9"+
		"\u0001\u0000\u0000\u0000\u00f1\u00eb\u0001\u0000\u0000\u0000\u00f1\u00ed"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u012d"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\n\u000b\u0000\u0000\u00f4\u00f5\u0007"+
		"\u0002\u0000\u0000\u00f5\u012c\u0003&\u0013\f\u00f6\u00f7\n\n\u0000\u0000"+
		"\u00f7\u00f8\u0007\u0003\u0000\u0000\u00f8\u012c\u0003&\u0013\u000b\u00f9"+
		"\u00fa\n\t\u0000\u0000\u00fa\u00fb\u0007\u0004\u0000\u0000\u00fb\u012c"+
		"\u0003&\u0013\n\u00fc\u00fd\n\b\u0000\u0000\u00fd\u00fe\u0007\u0005\u0000"+
		"\u0000\u00fe\u012c\u0003&\u0013\t\u00ff\u0100\n\u0007\u0000\u0000\u0100"+
		"\u0101\u0007\u0006\u0000\u0000\u0101\u012c\u0003&\u0013\b\u0102\u0103"+
		"\n\u0006\u0000\u0000\u0103\u0104\u0005%\u0000\u0000\u0104\u012c\u0003"+
		"&\u0013\u0007\u0105\u0106\n\u0005\u0000\u0000\u0106\u0107\u0005$\u0000"+
		"\u0000\u0107\u012c\u0003&\u0013\u0006\u0108\u0109\n\u0004\u0000\u0000"+
		"\u0109\u010a\u0005&\u0000\u0000\u010a\u012c\u0003&\u0013\u0005\u010b\u010c"+
		"\n\u0003\u0000\u0000\u010c\u010d\u00050\u0000\u0000\u010d\u012c\u0003"+
		"&\u0013\u0004\u010e\u010f\n\u0002\u0000\u0000\u010f\u0110\u00051\u0000"+
		"\u0000\u0110\u012c\u0003&\u0013\u0003\u0111\u0112\n\u0001\u0000\u0000"+
		"\u0112\u0113\u0005)\u0000\u0000\u0113\u012c\u0003&\u0013\u0001\u0114\u0115"+
		"\n\u0014\u0000\u0000\u0115\u0116\u0005\u001b\u0000\u0000\u0116\u0117\u0003"+
		"&\u0013\u0000\u0117\u0118\u0005\u001c\u0000\u0000\u0118\u012c\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\n\u0013\u0000\u0000\u011a\u011c\u0005\u0019\u0000"+
		"\u0000\u011b\u011d\u0003&\u0013\u0000\u011c\u011b\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u0122\u0001\u0000\u0000\u0000"+
		"\u011e\u011f\u00054\u0000\u0000\u011f\u0121\u0003&\u0013\u0000\u0120\u011e"+
		"\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0125"+
		"\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u012c"+
		"\u0005\u001a\u0000\u0000\u0126\u0127\n\u0012\u0000\u0000\u0127\u0128\u0005"+
		"9\u0000\u0000\u0128\u012c\u0005;\u0000\u0000\u0129\u012a\n\u000f\u0000"+
		"\u0000\u012a\u012c\u0007\u0001\u0000\u0000\u012b\u00f3\u0001\u0000\u0000"+
		"\u0000\u012b\u00f6\u0001\u0000\u0000\u0000\u012b\u00f9\u0001\u0000\u0000"+
		"\u0000\u012b\u00fc\u0001\u0000\u0000\u0000\u012b\u00ff\u0001\u0000\u0000"+
		"\u0000\u012b\u0102\u0001\u0000\u0000\u0000\u012b\u0105\u0001\u0000\u0000"+
		"\u0000\u012b\u0108\u0001\u0000\u0000\u0000\u012b\u010b\u0001\u0000\u0000"+
		"\u0000\u012b\u010e\u0001\u0000\u0000\u0000\u012b\u0111\u0001\u0000\u0000"+
		"\u0000\u012b\u0114\u0001\u0000\u0000\u0000\u012b\u0119\u0001\u0000\u0000"+
		"\u0000\u012b\u0126\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000"+
		"\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\'\u0001\u0000\u0000\u0000"+
		"\u012f\u012d\u0001\u0000\u0000\u0000\u0130\u0136\u0005\u0001\u0000\u0000"+
		"\u0131\u0136\u0005;\u0000\u0000\u0132\u0136\u0005\u000f\u0000\u0000\u0133"+
		"\u0136\u0003*\u0015\u0000\u0134\u0136\u0003,\u0016\u0000\u0135\u0130\u0001"+
		"\u0000\u0000\u0000\u0135\u0131\u0001\u0000\u0000\u0000\u0135\u0132\u0001"+
		"\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135\u0134\u0001"+
		"\u0000\u0000\u0000\u0136)\u0001\u0000\u0000\u0000\u0137\u0139\u0005\u001b"+
		"\u0000\u0000\u0138\u013a\u0005%\u0000\u0000\u0139\u0138\u0001\u0000\u0000"+
		"\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000"+
		"\u0000\u013b\u013d\u0005\u001c\u0000\u0000\u013c\u013e\u0003\u0010\b\u0000"+
		"\u013d\u013c\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000"+
		"\u013e\u0143\u0001\u0000\u0000\u0000\u013f\u0140\u00054\u0000\u0000\u0140"+
		"\u0142\u0003\u0010\b\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0142\u0145"+
		"\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144"+
		"\u0001\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u0143"+
		"\u0001\u0000\u0000\u0000\u0146\u0147\u0005:\u0000\u0000\u0147\u0148\u0003"+
		"\u0012\t\u0000\u0148\u0151\u0005\u0019\u0000\u0000\u0149\u014e\u0003&"+
		"\u0013\u0000\u014a\u014b\u00054\u0000\u0000\u014b\u014d\u0003&\u0013\u0000"+
		"\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000"+
		"\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000"+
		"\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000"+
		"\u0151\u0149\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000"+
		"\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0154\u0005\u001a\u0000\u0000"+
		"\u0154+\u0001\u0000\u0000\u0000\u0155\u0156\u0005\f\u0000\u0000\u0156"+
		"\u0163\u0003\u000e\u0007\u0000\u0157\u0159\u0005\u0019\u0000\u0000\u0158"+
		"\u015a\u0003&\u0013\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a"+
		"\u0001\u0000\u0000\u0000\u015a\u015f\u0001\u0000\u0000\u0000\u015b\u015c"+
		"\u00054\u0000\u0000\u015c\u015e\u0003&\u0013\u0000\u015d\u015b\u0001\u0000"+
		"\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000"+
		"\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000"+
		"\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0164\u0005\u001a"+
		"\u0000\u0000\u0163\u0157\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000"+
		"\u0000\u0000\u0164-\u0001\u0000\u0000\u0000&18@BLR[anx\u007f\u0089\u0095"+
		"\u009b\u009f\u00a3\u00ab\u00ae\u00ba\u00c5\u00d2\u00d6\u00db\u00df\u00f1"+
		"\u011c\u0122\u012b\u012d\u0135\u0139\u013d\u0143\u014e\u0151\u0159\u015f"+
		"\u0163";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}