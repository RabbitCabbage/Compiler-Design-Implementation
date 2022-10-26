parser grammar MxParser;
options { tokenVocab = MxLexer; }

program: programSection+ EOF;

programSection:
    functionDefinition
    | classDefinition
    | variableDefinition
    ;

classDefinition:
    Class Identifier LeftBrace (variableDefinition | constructFunctionDef | functionDefinition)* RightBrace Semicolon;

functionDefinition:
    variableType Identifier LeftParen parameter? (Comma parameter)* RightParen suite;

constructFunctionDef:
    Identifier LeftParen parameter? (Comma parameter)* RightParen suite;

basicType:
    Bool
    | Int
    | Void
    | String
    | Identifier;

variableType:
    basicType (LeftBracket RightBracket)*;

newType:
    basicType (LeftBracket expression RightBracket)* (LeftBracket RightBracket)*;

parameter: variableType declaration;

//是指代码块，比如函数体或普通代码块，可以嵌套
suite:
    LeftBrace statement* RightBrace;

statement:
    suite
    | variableDefinition
    | expressionStatement
    | ifStatement
    | jumpStatement
    | circulationStatement
    | emptyStatement;

emptyStatement: Semicolon;

variableDefinition:
    variableType declaration? (Comma declaration?)* Semicolon;

declaration: Identifier (Assign expression)?;

expressionStatement: expression? Semicolon;

jumpStatement:
    Break Semicolon                         # breakStatement
    | Continue Semicolon                    # continueStatement
    | Return (expression) Semicolon         # returnStatement
    ;

ifStatement:
    If LeftParen expression RightParen trueStatement = statement (Else falseStatement = statement)*;

circulationStatement:
    While LeftParen expression RightParen statement             # whileStatement
    | For LeftParen (
        forInitStatement condition = expression? Semicolon next = expression?
    ) RightParen statement                                      # forStatement
    ;

forInitStatement:
    vardef = variableDefinition | init = expression;//expressionStatement可以是空的


expression:
    basicExpression                                                                       # primaryExpression
        | LeftParen expression RightParen                                                 # parenExpression
        | expression LeftBracket expression RightBracket                                  # arrayIndexingExpression
        | expression LeftParen  expression? (Comma expression)* RightParen                # functionCallExpression
        | expression Dot Identifier                                                       # memberCallExpression
        | op = Not expression                                                             # prefixExpression
        | op = Tilde expression                                                           # prefixExpression
        | <assoc=right> expression op  = (PlusPlus | MinusMinus)                          # suffixExpression
        | <assoc=right> op  = (PlusPlus | MinusMinus) expression                          # prefixExpression
        | op = Minus expression                                                           # prefixExression
        | op = Plus expression                                                            # prefixExpression
        | expression op  = (Div | Star | Mod) expression                                 # binaryExpression
        | expression op  = (Plus | Minus) expression                                     # binaryExpression
        | expression op  = (LessLess | GreaterGreater) expression                        # binaryExpression
        | expression op  = (Greater | GreaterEqual | Less | LessEqual) expression        # binaryExpression
        | expression op  = (Equal | NotEqual) expression                                 # binaryExpression
        | expression op = And expression                                                # binaryExpression
        | expression op = Caret expression                                              # binaryExpression
        | expression op = Or expression                                                 # binaryExpression
        | expression op = AndAnd expression                                             # binaryExpression
        | expression op = OrOr expression                                               # binaryExpression
        | <assoc=right> expression Assign expression                                    # assignmentExpression
    ;

basicExpression:
    Literal
    | Identifier//变量
    | This
    | lambdaExpression
    | newExpression;

lambdaExpression:
    LeftBracket (And)? RightBracket (parameter? (Comma parameter)*) RightArrow suite LeftParen (expression (Comma expression)*)? RightParen;

newExpression:
    New newType (LeftParen  expression? (Comma expression)* RightParen)?;

