parser grammar MxParser;
options { tokenVocab = MxLexer; }

program: programSection+ mainFunctionDefinition EOF;

programSection:
    functionDefinition
    | classDefinition
    | variableDefinition
    ;

mainFunctionDefinition:
    Int Main LeftParen RightParen  suite;

classDefinition:
    Class Identifier LeftBrace (functionDefinition | variableDefinition)* RightBrace Semicolon;

functionDefinition:
    typeName Identifier LeftParen parameter? (Comma parameter)* RightParen suite;

typeName:
    Bool
    | Int
    | Void
    | String
    | Identifier (LeftBracket RightBracket)*;// className

parameter: typeName Identifier;

//是指代码块，比如函数体或普通代码块，可以嵌套
suite:
    LeftBrace statement* RightBrace;

statement:
    suite
    | builtInFunctionReturnVoid
    | variableDefinition
    | expressionStatement
    | ifStatement
    | jumpStatement
    | circulationStatement
    | emptyStatement;

emptyStatement: Semicolon;

builtInFunctionReturnVoid:
    Print LeftParen (complexExpression) RightParen Semicolon
    | Println LeftParen (complexExpression) RightParen Semicolon
    | PrintInt LeftParen (complexExpression) RightParen  Semicolon
    | PrintlnInt LeftParen (complexExpression) RightParen  Semicolon
    ;

variableDefinition:
    typeName Identifier (Assign expression)? (Comma Identifier (Assign expression)?)* Semicolon                             # baseVariableDefinition
    | typeName LeftBracket RightBracket(LeftBracket RightBracket)* Identifier (Assign newExpression)? (Comma Identifier (Assign newExpression)?)* Semicolon  # arrayVariableDefinition
    ;

expressionStatement: expression? Semicolon;

jumpStatement:
    Break Semicolon                         # breakSstatement
    | Continue Semicolon                    # continyeSstatement
    | Return (expression) Semicolon         # returnStatement
    ;

ifStatement:
    If LeftParen expression RightParen trueStatement = statement (Else falseStatement = statement)*;

circulationStatement:
    While LeftParen expression RightParen statement             # whileStatement
    | For LeftParen (
        forInitStatement expression? Semicolon expression?
    ) RightParen statement                                      # forStatement
    ;

forInitStatement:
    variableDefinition | expressionStatement;//expressionStatement可以是空的


expression:
    complexExpression                               # calculationExpression
    | complexExpression Assign complexExpression    # assignmentExpression
    ;

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
    New typeName (LeftParen  expression? (Comma expression)* RightParen)?               # newObjectExpression
    | New typeName LeftBracket expression RightBracket (LeftBracket RightBracket)*      # newArrayExpression
    ;

complexExpression: //包括函数调用和对象成员的访问，存在着递归的定义
    basicExpression                                                                          # primaryExpression
    | LeftParen complexExpression RightParen                                                 # parenExpression
    | complexExpression LeftBracket expression RightBracket                                  # arrayIndexingExpression
    | complexExpression LeftParen  expression? (Comma expression)* RightParen                # functionCallExpression
    | complexExpression Dot builtInFunctionWithReturnValue_Dot                               # builtinfunctionCallExpression
    | complexExpression Dot Identifier                                                       # memberCallExpression
    | Minus complexExpression                                                                # prefixExression
    | (PlusPlus | MinusMinus) complexExpression                                              # prefixIncrementDecrementExpression
    | complexExpression (PlusPlus | MinusMinus)                                              # suffixIncrementDecrementExpression
    | Not complexExpression                                                                  # prefixExpression
    | Tilde complexExpression                                                                # prefixExpression
    | complexExpression (Div | Star | Mod) complexExpression                                 # binaryExpression
    | complexExpression (Plus | Minus) complexExpression                                     # binaryExpression
    | complexExpression (LessLess | GreaterGreater) complexExpression                        # binaryExpression
    | complexExpression (Greater | GreaterEqual | Less | LessEqual) complexExpression        # logicExpression
    | complexExpression (Equal | NotEqual) complexExpression                                 # logicExpression
    | complexExpression And complexExpression                                                # binaryExpression
    | complexExpression Caret complexExpression                                              # binaryExpression
    | complexExpression Or complexExpression                                                 # binaryExpression
    | complexExpression AndAnd complexExpression                                             # logicExpression
    | complexExpression OrOr complexExpression                                               # logicExpression
    ;

builtInFunctionWithReturnValue_Dot:
    Size LeftParen RightParen
    | Length LeftParen RightParen
    | SubString LeftParen complexExpression Comma complexExpression RightParen
    | ParseInt LeftParen RightParen
    | Ord LeftParen (IntegerLiteral | expression) RightParen
    ;

builtInFunctionWithReturnValue:
    GetString LeftParen RightParen
    | GetInt LeftParen RightParen
    | ToString LeftParen (complexExpression) RightParen
    ;


