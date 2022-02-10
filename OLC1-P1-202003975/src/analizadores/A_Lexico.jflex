package analizadores;
import java_cup.runtime.*;

%%
%public
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

letra = [a-zA-Z]
id = {letra}+

%%

<YYINITIAL>"," {
                    System.out.println("Reconocio token:<coma> lexema:"+yytext());
                    return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
                }

<YYINITIAL>{id} {
                    System.out.println("
                }