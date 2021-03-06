package analizadores;
import java_cup.runtime.*;

%%

%{
    String cadena = "";
    String leorid = "";
%}

%public
%class Analizador_Lexico
%cupsym sym
%cup
%char
%column
%full
%ignorecase
%line
%unicode
%state CADENA, LEORID

//Aquí LEORID viene representando a las transicion de aceptación de LeSinEspacio o ID

//Simbolos 

COMA = ","
DOSPUNTOS = ":"
PTCOMA = ";"
FLECHA = "->"
LLAVE_ABRE = "{"
LLAVE_CIERRA = "}"
VIRGULILLA = "~"
PUNTO = "."
UNION = "|"
KLEENE = "*"
POSITIVO = "+"
INTERROGACION = "?"
 

//Palabra reservada

CONJ = "CONJ"

//Expresiones
Le = [a-zA-Z_]
Especiales = [\\n,\\',\"]
Dig = [0-9]
ID = {Le}+
PorcentajesDobles = %%
Chars = [ -@\131-\140\173-\176] 
OnlyChar = (","|"~")

LineTerminator = \r|\n|\r\n
InputCaracter = [^\r\n]
CommentLine = "//" {InputCaracter}* {LineTerminator}?

CommentMultiLine = "<!"[^\"]~"!>" 

Spaces = [\ \r\t\f]
Enter = [ \n]
%%

<YYINITIAL>[\"] {yybegin(CADENA); cadena += "\"";}

<YYINITIAL>{CommentLine}   {/* ignore */}
<YYINITIAL>{CommentMultiLine}   {/* ignore */}
<YYINITIAL>{Spaces}   {/* ignore */}
<YYINITIAL>{Enter}   {/* ignore */} 

<YYINITIAL>{COMA}   {
                    System.out.println("Reconocio token:<coma> lexema:"+yytext());
                    return new Symbol(sym.coma, yycolumn, yyline, yytext());
                } 

<YYINITIAL>{PorcentajesDobles} {
                            System.out.println("Reconocio token:<porcentajes> lexema:"+yytext());
                            return new Symbol(sym.porcentajes, yycolumn, yyline, yytext());
                        } 

<YYINITIAL>{DOSPUNTOS} {
                    System.out.println("Reconocio token:<dospuntos> lexema:"+yytext());
                    return new Symbol(sym.dospuntos, yycolumn, yyline, yytext());
                }

<YYINITIAL>{PTCOMA} {
                    System.out.println("Reconocio token:<ptcoma> lexema:"+yytext());
                    return new Symbol(sym.ptcoma, yycolumn, yyline, yytext());
                }

<YYINITIAL>{FLECHA} {
                    System.out.println("Reconocio token:<flecha> lexema:"+yytext());
                    return new Symbol(sym.flecha, yycolumn, yyline, yytext());
                }

<YYINITIAL>{LLAVE_ABRE} {
                    System.out.println("Reconocio token:<llave_abre> lexema:"+yytext());
                    return new Symbol(sym.llave_abre, yycolumn, yyline, yytext());
                }

<YYINITIAL>{LLAVE_CIERRA} {
                    System.out.println("Reconocio token:<llave_cierra> lexema:"+yytext());
                    return new Symbol(sym.llave_cierra, yycolumn, yyline, yytext());
                }

<YYINITIAL>{VIRGULILLA} {
                    System.out.println("Reconocio token:<virgulilla_char> lexema:"+yytext());
                    return new Symbol(sym.virgulilla_char, yycolumn, yyline, yytext());
                }

<YYINITIAL>{PUNTO} {
                    System.out.println("Reconocio token:<punto> lexema:"+yytext());
                    return new Symbol(sym.punto, yycolumn, yyline, yytext());
                }

<YYINITIAL>{UNION} {
                    System.out.println("Reconocio token:<union> lexema:"+yytext());
                    return new Symbol(sym.union, yycolumn, yyline, yytext());
                }

<YYINITIAL>{KLEENE} {
                    System.out.println("Reconocio token:<kleene> lexema:"+yytext());
                    return new Symbol(sym.kleene, yycolumn, yyline, yytext());
                }

<YYINITIAL>{POSITIVO} {
                    System.out.println("Reconocio token:<positivo> lexema:"+yytext());
                    return new Symbol(sym.positivo, yycolumn, yyline, yytext());
                }

<YYINITIAL>{INTERROGACION} {
                    System.out.println("Reconocio token:<interrogacion> lexema:"+yytext());
                    return new Symbol(sym.interrogacion, yycolumn, yyline, yytext());
                }

<YYINITIAL>{Especiales} {
                    System.out.println("Reconocio token:<especiales> lexema:"+yytext());
                    return new Symbol(sym.especiales, yycolumn, yyline, yytext());
                }

<YYINITIAL>{CONJ} {
                    System.out.println("Reconocio token:<conj> lexema:"+yytext());
                    return new Symbol(sym.conj, yycolumn, yyline, yytext());
                }

<YYINITIAL>{Dig} {
                    System.out.println("Reconocio token:<digito> lexema:"+yytext());
                    return new Symbol(sym.digito, yycolumn, yyline, yytext());
                }

<YYINITIAL>[a-zA-Z] {yybegin(LEORID); leorid += yytext();}

<YYINITIAL>{Chars} {
                    System.out.println("Reconocio token:<caracter> lexema:"+yytext());
                    return new Symbol(sym.caracter, yycolumn, yyline, yytext());
                }

<YYINITIAL> . {
                String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
                System.out.println(errLex);
              }

<CADENA>{
        [\"] { String tmp =cadena+"\""; cadena=""; yybegin(YYINITIAL); return new Symbol(sym.cadena, yychar, yyline, tmp); }
        [\n] { String tmp =cadena; cadena=""; System.out.println("Error léxico: Se esperaba cierre de cadena (\").");
               yybegin(YYINITIAL);
             }
        {Especiales} { cadena +=yytext();} 
        [^\"] { cadena +=yytext(); }

}

<LEORID>{
        {ID} { leorid +=yytext(); }
        [\ ] { String tmp =leorid+yytext(); leorid=""; yybegin(YYINITIAL); return new Symbol(sym.id, yychar, yyline, tmp); }
        {OnlyChar} {String tmp =leorid; leorid=""; yybegin(YYINITIAL); return new Symbol(sym.lesinespacio, yychar, yyline, tmp);}
         . {  String tmp =leorid; leorid=""; System.out.println("Error Léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1));
               yybegin(YYINITIAL);
           }
}