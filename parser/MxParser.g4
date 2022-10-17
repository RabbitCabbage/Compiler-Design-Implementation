parser grammar MxParser;
options { tokenVocab = MxLexer; }

program: programSections+ EOF;

programSections:
    (
        functionDefinition
        | classDefinition
        | globalVariableDefinition
    )+;

classDefinition:
    Class Identifier LeftBrace (functionDefinition | variableDefinition)* RightBrace Semicolon;

functionDefinition:
    typeName Identifier LeftParen parameter? (Comma parameter)* RightParen suite;

globalVariableDefinition:
    typeName (LeftBracket RightBracket)* Identifier (Assign expression)? (Comma Identifier (Assign expression)?)* Semicolon;

typeName: Bool | Int | Void | String | Identifier (LeftBracket RightBracket)*;// className

parameter: typeName Identifier;

//是指代码块，比如函数体或普通代码块，可以嵌套
suite:
    LeftBrace statement* RightBrace;

statement:
    suite
    | builtInFunctionReturnVoid Semicolon
    | variableDefinition
    | expressionStatement
    | ifStatement
    | jumpStatement
    | circulationStatement;

builtInFunctionReturnVoid:
    Print LeftParen (complexExpression) RightParen
    | Println LeftParen (complexExpression) RightParen
    | PrintInt LeftParen (complexExpression) RightParen
    | PrintlnInt LeftParen (complexExpression) RightParen;

variableDefinition: typeName Identifier (Assign expression)? (Comma Identifier (Assign expression)?)* Semicolon;

expressionStatement: expression? Semicolon;

jumpStatement:
    (
        Break
        | Continue
        | Return (expression)
    )Semicolon;

ifStatement:
    If LeftParen expression RightParen statement (Else statement)*;

circulationStatement:
    While LeftParen expression RightParen statement
    | For LeftParen (
        forInitStatement expression? Semicolon expression?
    ) RightParen statement;

forInitStatement:
    variableDefinition | expressionStatement;//expressionStatement可以是空的


expression:
    complexExpression
    | complexExpression Assign complexExpression;//todo?

basicExpression:
    Literal
    | Identifier//变量
    | This
    | lambdaExpression
    | newExpression
    | builtInFunctionWithReturnValue;

lambdaExpression:
    LeftBracket (And)? RightBracket (parameter? (Comma parameter)*) RightArrow suite;

newExpression:
    New typeName (LeftParen  expression? (Comma expression)* RightParen)?
    | New typeName LeftBracket expression RightBracket (LeftBracket RightBracket)*;

complexExpression: //包括函数调用和对象成员的访问，存在着递归的定义
    basicExpression
    | LeftParen complexExpression RightParen
    | complexExpression LeftBracket expression RightBracket //数组下标的取法
    | complexExpression LeftParen  expression? (Comma expression)* RightParen //函数调用，可能存在递归的嵌套
    | complexExpression Dot builtInFunctionWithReturnValue_Dot
    | complexExpression Dot Identifier
    | Minus complexExpression
    | (PlusPlus | MinusMinus) complexExpression
    | complexExpression (PlusPlus | MinusMinus)
    | Not complexExpression
    | Tilde complexExpression
    | complexExpression (Div | Star | Mod) complexExpression
    | complexExpression (Plus | Minus) complexExpression
    | (LessLess | GreaterGreater) complexExpression
    | complexExpression (Greater | GreaterEqual | Less | LessEqual) complexExpression
    | complexExpression (Equal | NotEqual) complexExpression
    | complexExpression And complexExpression
    | complexExpression Caret complexExpression
    | complexExpression Or complexExpression
    | complexExpression AndAnd complexExpression
    | complexExpression OrOr complexExpression;

builtInFunctionWithReturnValue_Dot:
    Size LeftParen RightParen
    | Length LeftParen RightParen
    | SubString LeftParen complexExpression Comma complexExpression RightParen
    | ParseInt LeftParen RightParen
    | Ord LeftParen (IntegerLiteral | expression) RightParen;

builtInFunctionWithReturnValue:
    GetString LeftParen RightParen
    | GetInt LeftParen RightParen
    | ToString LeftParen (complexExpression) RightParen;


