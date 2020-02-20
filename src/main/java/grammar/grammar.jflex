package grammar;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

import static grammar.Token.*;

import java.io.Reader;

%%

%public
%class TinyJavaLexer
%cup
//todo: implements????
%char
%line
%column

%unicode

%{
    private StringBuffer stringBuffer = new StringBuffer();
    private ComplexSymbolFactory symbolFactory;

    public TinyJavaLexer(Reader input, ComplexSymbolFactory symbolFactory) {
        this(input);
        this.symbolFactory = symbolFactory;
    }

    private Symbol symbol(String name, int token) {
        return symbol(name, token, null);
    }

    private Symbol symbol(String name, int token, Object value) {
        int line = yyline + 1;
        Location left = new Location(line, yycolumn + 1, yychar);
        Location right = new Location(line, yycolumn + yylength(), yychar + yylength());
        return symbolFactory.newSymbol(name, token, left, right, value);
    }

    private void error(String error) {
        System.out.println("Error on line " + (yyline + 1) + ", at col " + (yycolumn + 1) + " : " + error);
    }
%}

%eofval{
    return symbolFactory.newSymbol("EOF", EOF, new Location(yyline + 1, yycolumn + 1, yychar), new Location(yyline + 1, yycolumn + 1, yychar + 1));
%eofval}

Character = [^\r\n]
LineEnd = \r|\n|\r\n

Identifier = [a-zA-Z_][\w]*

NonZeroDigit = [1-9]
DecimalInteger = 0|\d{NonZeroDigit}*

Exponent = [e|E][[\+|-]\d+]|\d+
SimpleFloat = {DecimalInteger}+.\d+
FormalFloat = {DecimalInteger}+.\d+[f|F]
FloatingPoint = {SimpleFloat} | {FormalFloat} | {SimpleFloat}{Exponent} | {FormalFloat}{Exponent}

StringLiteral = \".*\"
WhiteSpace = \s

MultiLineComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
SingleLineComment = "//" {Character}* {LineEnd}?
Comment = {SingleLineComment} | {MultiLineComment}

%state STRING

%%

<YYINITIAL> {
  "if"                         { return symbol("if", IF); }
  "else"                       { return symbol("else", ELSE); }
  "while"                      { return symbol("while", WHILE); }
  "return"                     { return symbol("return", RETURN); }
  "public"                     { return symbol("public", PUBLIC); }
  "static"                     { return symbol("static", STATIC); }
  "void"                       { return symbol("void", VOID); }
  "class"                      { return symbol("class", CLASS); }

  "double"                     { return symbol("double", DOUBLE); }
  "int"                        { return symbol("int", INT); }

  {Identifier}                 { return symbol("Identifier", IDENTIFIER, yytext()); }
  {DecimalInteger}             { return symbol("DecimalInteger", DECIMAL_INTEGER, Integer.parseInt(yytext())); }
  {FloatingPoint}              { return symbol("FloatingPoint", FLOATING_POINT, Float.parseFloat(yytext())); }
  {StringLiteral}              { return symbol("StringLiteral", STRING_LITERAL, yytext()); }
  {WhiteSpace}                 { /* IGNORE WhiteSpace */ }
  {Comment}                    { /* IGNORE Comment */ }

  "="                          { return symbol("=", EQUALS); }
  "+"                          { return symbol("+", PLUS); }
  "-"                          { return symbol("-", MINUS); }
  "*"                          { return symbol("*", TIMES); }
  "/"                          { return symbol("/", DIVIDE); }
  ";"                          { return symbol(";", SEMICOLON); }
  ","                          { return symbol(",", COMMA); }
  "."                          { return symbol(".", PERIOD); }

  "=="                         { return symbol("==", DOUBLE_EQUALS); }
  "!="                         { return symbol("!=", NOT_EQUALS); }
  "<="                         { return symbol("<=", LESS_THAN_EQUALS); }
  ">="                         { return symbol(">=", GREATER_THAN_EQUALS); }
  ">"                          { return symbol(">", GREATER_THAN); }
  "<"                          { return symbol("<", LESS_THAN); }

  "]"                          { return symbol("]", RIGHT_BRACKET); }
  "["                          { return symbol("[", LEFT_BRACKET); }
  ")"                          { return symbol(")", RIGHT_PAREN); }
  "("                          { return symbol("(", LEFT_PAREN); }
  "{"                          { return symbol("{", LEFT_CURLY_BRACE); }
  "}"                          { return symbol("}", RIGHT_CURLY_BRACE); }
}

[^]                            { error("Unrecognized character " + yytext()); }