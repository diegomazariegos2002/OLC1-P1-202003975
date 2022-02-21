
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizador;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import clases_lenguaje.TablaDeSimbolos;
import clases_lenguaje.Operacion;
import clases_lenguaje.Instruccion;
import clases_lenguaje.Asignacion;
import clases_lenguaje.Simbolo.Tipo;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\036\000\002\002\004\000\002\002\005\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\003" +
    "\000\002\004\003\000\002\004\003\000\002\005\010\000" +
    "\002\010\003\000\002\010\003\000\002\011\005\000\002" +
    "\011\005\000\002\011\005\000\002\012\005\000\002\012" +
    "\003\000\002\013\003\000\002\013\003\000\002\013\003" +
    "\000\002\006\006\000\002\014\005\000\002\014\005\000" +
    "\002\014\005\000\002\014\004\000\002\014\004\000\002" +
    "\014\005\000\002\014\003\000\002\007\003\000\002\016" +
    "\004\000\002\015\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\075\000\004\010\004\001\002\000\010\021\011\023" +
    "\010\026\016\001\002\000\004\002\006\001\002\000\004" +
    "\002\001\001\002\000\012\011\ufffe\021\ufffe\023\ufffe\026" +
    "\ufffe\001\002\000\006\005\053\007\052\001\002\000\004" +
    "\005\024\001\002\000\012\011\ufffb\021\ufffb\023\ufffb\026" +
    "\ufffb\001\002\000\004\006\023\001\002\000\012\011\ufffa" +
    "\021\ufffa\023\ufffa\026\ufffa\001\002\000\012\011\022\021" +
    "\011\023\010\026\016\001\002\000\012\011\uffe6\021\uffe6" +
    "\023\uffe6\026\uffe6\001\002\000\012\011\ufffc\021\ufffc\023" +
    "\ufffc\026\ufffc\001\002\000\012\011\ufffd\021\ufffd\023\ufffd" +
    "\026\ufffd\001\002\000\012\011\uffff\021\uffff\023\uffff\026" +
    "\uffff\001\002\000\004\002\000\001\002\000\012\011\uffe5" +
    "\021\uffe5\023\uffe5\026\uffe5\001\002\000\004\023\025\001" +
    "\002\000\004\007\026\001\002\000\010\020\035\022\027" +
    "\025\033\001\002\000\010\004\ufff0\006\ufff0\012\050\001" +
    "\002\000\004\006\047\001\002\000\006\004\042\006\ufff7" +
    "\001\002\000\006\004\ufff2\006\ufff2\001\002\000\010\004" +
    "\ufff1\006\ufff1\012\040\001\002\000\004\006\ufff8\001\002" +
    "\000\010\004\uffef\006\uffef\012\036\001\002\000\004\020" +
    "\037\001\002\000\004\006\ufff4\001\002\000\004\025\041" +
    "\001\002\000\004\006\ufff6\001\002\000\010\020\046\022" +
    "\043\025\045\001\002\000\006\004\ufff0\006\ufff0\001\002" +
    "\000\006\004\ufff3\006\ufff3\001\002\000\006\004\ufff1\006" +
    "\ufff1\001\002\000\006\004\uffef\006\uffef\001\002\000\012" +
    "\011\ufff9\021\ufff9\023\ufff9\026\ufff9\001\002\000\004\022" +
    "\051\001\002\000\004\006\ufff5\001\002\000\020\010\061" +
    "\013\055\014\063\015\064\016\057\017\056\024\060\001" +
    "\002\000\004\024\054\001\002\000\004\006\uffe4\001\002" +
    "\000\020\010\061\013\055\014\063\015\064\016\057\017" +
    "\056\024\060\001\002\000\020\010\061\013\055\014\063" +
    "\015\064\016\057\017\056\024\060\001\002\000\020\010" +
    "\061\013\055\014\063\015\064\016\057\017\056\024\060" +
    "\001\002\000\022\006\uffe7\010\uffe7\013\uffe7\014\uffe7\015" +
    "\uffe7\016\uffe7\017\uffe7\024\uffe7\001\002\000\004\023\072" +
    "\001\002\000\004\006\071\001\002\000\020\010\061\013" +
    "\055\014\063\015\064\016\057\017\056\024\060\001\002" +
    "\000\020\010\061\013\055\014\063\015\064\016\057\017" +
    "\056\024\060\001\002\000\020\010\061\013\055\014\063" +
    "\015\064\016\057\017\056\024\060\001\002\000\022\006" +
    "\uffeb\010\uffeb\013\uffeb\014\uffeb\015\uffeb\016\uffeb\017\uffeb" +
    "\024\uffeb\001\002\000\020\010\061\013\055\014\063\015" +
    "\064\016\057\017\056\024\060\001\002\000\022\006\uffec" +
    "\010\uffec\013\uffec\014\uffec\015\uffec\016\uffec\017\uffec\024" +
    "\uffec\001\002\000\012\011\uffee\021\uffee\023\uffee\026\uffee" +
    "\001\002\000\004\011\073\001\002\000\022\006\uffe8\010" +
    "\uffe8\013\uffe8\014\uffe8\015\uffe8\016\uffe8\017\uffe8\024\uffe8" +
    "\001\002\000\022\006\uffea\010\uffea\013\uffea\014\uffea\015" +
    "\uffea\016\uffea\017\uffea\024\uffea\001\002\000\022\006\uffe9" +
    "\010\uffe9\013\uffe9\014\uffe9\015\uffe9\016\uffe9\017\uffe9\024" +
    "\uffe9\001\002\000\020\010\061\013\055\014\063\015\064" +
    "\016\057\017\056\024\060\001\002\000\022\006\uffed\010" +
    "\uffed\013\uffed\014\uffed\015\uffed\016\uffed\017\uffed\024\uffed" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\075\000\004\002\004\001\001\000\020\003\014\004" +
    "\006\005\017\006\016\007\011\015\012\016\013\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\016\004\020\005\017\006" +
    "\016\007\011\015\012\016\013\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\010\027\011\033\012\030\013\031\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\013\043\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\014\061\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\014\075\001\001\000\004\014\074\001" +
    "\001\000\004\014\073\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\014\066\001\001\000" +
    "\004\014\064\001\001\000\004\014\065\001\001\000\002" +
    "\001\001\000\004\014\067\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\014\076\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    /**
     * Variable en la que se almacena el arbol de sintaxis abstracta que se 
     * genera luego del analisis sintáctico.
     */
    public LinkedList<Instruccion> AST;
    /**
     * Método al que se llama automáticamente ante algún error sintactico.
     */ 
    public void syntax_error(Symbol s){
        System.out.println("Error (recuperable) de sintaxis: "+s.value+" Linea: "+(s.right)+" columna: "+(s.left));
    }
    /**
     * Método al que se llama en el momento en que ya no es posible una recuperación de errores.
     */ 
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        System.out.println("Error (no recuperable) de sintaxis: "+s.value+" Linea: "+(s.right)+" columna: "+(s.left));
    }
    /**
     * Método que devuelve el AST que se generó después de realizar el análisis sintáctico. 
     * @return árbol de sintaxis abstacta que será utilizado posteriormente en la ejecución.
     */
    public LinkedList<Instruccion> getAST() {
        return AST;
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {


    String tmp = "";

  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= llave_abre INSTRUCCIONES llave_cierra 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		
            //se guarda el AST, que es la lista principal de instrucciones en la variable
            //AST que se definió dentro del parser
            parser.AST=a;
            System.out.println("Fin analisis sintactico");
    
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = a; RESULT.add(b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new LinkedList<>(); RESULT.add(a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= DECLARACIONCONJ 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = a;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INSTRUCCION ::= DECLARACIONEXP 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = a;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INSTRUCCION ::= DECLARACIONPORCENTAJES 
            {
              Instruccion RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // INSTRUCCION ::= DECLARACIONENTRADA 
            {
              Instruccion RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // DECLARACIONCONJ ::= conj dospuntos id flecha DEFINICIONCONJ ptcoma 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Operacion b = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = new Asignacion(a, b, Tipo.CONJUNTO);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONCONJ",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DEFINICIONCONJ ::= DEFINICIONVIRGULILLA 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = a;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONJ",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // DEFINICIONCONJ ::= DEFINICIONCONCOMAS 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = a;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONJ",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // DEFINICIONVIRGULILLA ::= lesinespacio virgulilla_char lesinespacio 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.VIRGULILLA, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONVIRGULILLA",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // DEFINICIONVIRGULILLA ::= digito virgulilla_char digito 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.VIRGULILLA, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONVIRGULILLA",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // DEFINICIONVIRGULILLA ::= caracter virgulilla_char caracter 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.VIRGULILLA, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONVIRGULILLA",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // DEFINICIONCONCOMAS ::= DEFINICIONCONCOMAS coma COMAELEMENTO 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion b = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.COMA, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONCOMAS",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // DEFINICIONCONCOMAS ::= COMAELEMENTO 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = a;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONCOMAS",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // COMAELEMENTO ::= lesinespacio 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.CARACTER, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("COMAELEMENTO",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // COMAELEMENTO ::= digito 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.CARACTER, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("COMAELEMENTO",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // COMAELEMENTO ::= caracter 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.CARACTER, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("COMAELEMENTO",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // DECLARACIONEXP ::= id flecha DEFINICIONEXP ptcoma 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Operacion b = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = new Asignacion(a, b, Tipo.EXPRESION);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONEXP",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // DEFINICIONEXP ::= punto DEFINICIONEXP DEFINICIONEXP 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion b = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.CONCATENACION, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // DEFINICIONEXP ::= union DEFINICIONEXP DEFINICIONEXP 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion b = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.OR, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // DEFINICIONEXP ::= kleene DEFINICIONEXP DEFINICIONEXP 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion b = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.KLEENE, a, b);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // DEFINICIONEXP ::= positivo DEFINICIONEXP 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.POSITIVO, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // DEFINICIONEXP ::= interrogacion DEFINICIONEXP 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Operacion a = (Operacion)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.INTERROGACION, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // DEFINICIONEXP ::= llave_abre id llave_cierra 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.IDENTIFICADOR, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // DEFINICIONEXP ::= cadena 
            {
              Operacion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		RESULT = new Operacion(Operacion.tipo_Operacion.CADENA, a);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // DECLARACIONPORCENTAJES ::= porcentajes 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONPORCENTAJES",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // DECLARACIONENTRADA ::= DEFINICIONENTRADA ptcoma 
            {
              Operacion RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONENTRADA",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // DEFINICIONENTRADA ::= id dospuntos cadena 
            {
              Operacion RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)).value;
		int cadenaleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int cadenaright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String cadena = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		//Básicamente aquí también es una asignación
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONENTRADA",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
