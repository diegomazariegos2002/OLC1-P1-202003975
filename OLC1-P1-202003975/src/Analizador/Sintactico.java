
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizador;

import java_cup.runtime.Symbol;
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
    "\000\041\000\002\002\004\000\002\002\005\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\004\003" +
    "\000\002\004\003\000\002\004\003\000\002\006\010\000" +
    "\002\007\003\000\002\007\003\000\002\010\005\000\002" +
    "\010\005\000\002\010\005\000\002\011\005\000\002\011" +
    "\003\000\002\012\003\000\002\012\003\000\002\012\003" +
    "\000\002\013\006\000\002\014\004\000\002\014\003\000" +
    "\002\015\003\000\002\015\003\000\002\015\003\000\002" +
    "\015\003\000\002\015\003\000\002\015\005\000\002\015" +
    "\003\000\002\015\003\000\002\005\003\000\002\017\004" +
    "\000\002\016\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\004\010\004\001\002\000\010\022\011\024" +
    "\010\027\016\001\002\000\004\002\006\001\002\000\004" +
    "\002\001\001\002\000\012\011\ufffe\022\ufffe\024\ufffe\027" +
    "\ufffe\001\002\000\006\005\053\007\052\001\002\000\004" +
    "\005\024\001\002\000\012\011\ufffb\022\ufffb\024\ufffb\027" +
    "\ufffb\001\002\000\004\006\023\001\002\000\012\011\ufffa" +
    "\022\ufffa\024\ufffa\027\ufffa\001\002\000\012\011\022\022" +
    "\011\024\010\027\016\001\002\000\012\011\uffe3\022\uffe3" +
    "\024\uffe3\027\uffe3\001\002\000\012\011\ufffc\022\ufffc\024" +
    "\ufffc\027\ufffc\001\002\000\012\011\ufffd\022\ufffd\024\ufffd" +
    "\027\ufffd\001\002\000\012\011\uffff\022\uffff\024\uffff\027" +
    "\uffff\001\002\000\004\002\000\001\002\000\012\011\uffe2" +
    "\022\uffe2\024\uffe2\027\uffe2\001\002\000\004\024\025\001" +
    "\002\000\004\007\026\001\002\000\010\020\035\023\027" +
    "\026\033\001\002\000\010\004\ufff0\006\ufff0\012\050\001" +
    "\002\000\004\006\047\001\002\000\006\004\042\006\ufff7" +
    "\001\002\000\006\004\ufff2\006\ufff2\001\002\000\010\004" +
    "\ufff1\006\ufff1\012\040\001\002\000\004\006\ufff8\001\002" +
    "\000\010\004\uffef\006\uffef\012\036\001\002\000\004\020" +
    "\037\001\002\000\004\006\ufff4\001\002\000\004\026\041" +
    "\001\002\000\004\006\ufff6\001\002\000\010\020\046\023" +
    "\043\026\045\001\002\000\006\004\ufff0\006\ufff0\001\002" +
    "\000\006\004\ufff3\006\ufff3\001\002\000\006\004\ufff1\006" +
    "\ufff1\001\002\000\006\004\uffef\006\uffef\001\002\000\012" +
    "\011\ufff9\022\ufff9\024\ufff9\027\ufff9\001\002\000\004\023" +
    "\051\001\002\000\004\006\ufff5\001\002\000\022\010\061" +
    "\013\062\014\063\015\060\016\066\017\064\021\055\025" +
    "\057\001\002\000\004\025\054\001\002\000\004\006\uffe1" +
    "\001\002\000\024\006\uffe4\010\uffe4\013\uffe4\014\uffe4\015" +
    "\uffe4\016\uffe4\017\uffe4\021\uffe4\025\uffe4\001\002\000\024" +
    "\006\uffec\010\uffec\013\uffec\014\uffec\015\uffec\016\uffec\017" +
    "\uffec\021\uffec\025\uffec\001\002\000\024\006\uffe5\010\uffe5" +
    "\013\uffe5\014\uffe5\015\uffe5\016\uffe5\017\uffe5\021\uffe5\025" +
    "\uffe5\001\002\000\024\006\uffe9\010\uffe9\013\uffe9\014\uffe9" +
    "\015\uffe9\016\uffe9\017\uffe9\021\uffe9\025\uffe9\001\002\000" +
    "\004\024\071\001\002\000\024\006\uffeb\010\uffeb\013\uffeb" +
    "\014\uffeb\015\uffeb\016\uffeb\017\uffeb\021\uffeb\025\uffeb\001" +
    "\002\000\024\006\uffea\010\uffea\013\uffea\014\uffea\015\uffea" +
    "\016\uffea\017\uffea\021\uffea\025\uffea\001\002\000\024\006" +
    "\uffe7\010\uffe7\013\uffe7\014\uffe7\015\uffe7\016\uffe7\017\uffe7" +
    "\021\uffe7\025\uffe7\001\002\000\024\006\070\010\061\013" +
    "\062\014\063\015\060\016\066\017\064\021\055\025\057" +
    "\001\002\000\024\006\uffe8\010\uffe8\013\uffe8\014\uffe8\015" +
    "\uffe8\016\uffe8\017\uffe8\021\uffe8\025\uffe8\001\002\000\024" +
    "\006\uffed\010\uffed\013\uffed\014\uffed\015\uffed\016\uffed\017" +
    "\uffed\021\uffed\025\uffed\001\002\000\012\011\uffee\022\uffee" +
    "\024\uffee\027\uffee\001\002\000\004\011\072\001\002\000" +
    "\024\006\uffe6\010\uffe6\013\uffe6\014\uffe6\015\uffe6\016\uffe6" +
    "\017\uffe6\021\uffe6\025\uffe6\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\004\002\004\001\001\000\020\003\014\004" +
    "\006\005\011\006\017\013\016\016\012\017\013\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\016\004\020\005\011\006" +
    "\017\013\016\016\012\017\013\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\007\027\010\033\011\030\012\031\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\012\043\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\014\064\015\055\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\015" +
    "\066\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

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



     public void syntax_error(Symbol s){
        System.out.println("Error (recuperable) de sintaxis: "+s.value+" Linea: "+(s.right)+" columna: "+(s.left));
    }
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{
        System.out.println("Error (no recuperable) de sintaxis: "+s.value+" Linea: "+(s.right)+" columna: "+(s.left));
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
		System.out.println("Fin analisis sintactico");
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= DECLARACIONCONJ 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INSTRUCCION ::= DECLARACIONEXP 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // INSTRUCCION ::= DECLARACIONPORCENTAJES 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // INSTRUCCION ::= DECLARACIONENTRADA 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // DECLARACIONCONJ ::= conj dospuntos id flecha DEFINICIONCONJ ptcoma 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		System.out.println("////////id conjunto: "+i);
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONCONJ",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-5)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DEFINICIONCONJ ::= DEFINICIONVIRGULILLA 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONJ",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // DEFINICIONCONJ ::= DEFINICIONCONCOMAS 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONJ",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // DEFINICIONVIRGULILLA ::= lesinespacio virgulilla_char lesinespacio 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONVIRGULILLA",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // DEFINICIONVIRGULILLA ::= digito virgulilla_char digito 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONVIRGULILLA",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // DEFINICIONVIRGULILLA ::= caracter virgulilla_char caracter 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONVIRGULILLA",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // DEFINICIONCONCOMAS ::= DEFINICIONCONCOMAS coma COMAELEMENTO 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONCOMAS",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // DEFINICIONCONCOMAS ::= COMAELEMENTO 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONCONCOMAS",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // COMAELEMENTO ::= lesinespacio 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("COMAELEMENTO",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // COMAELEMENTO ::= digito 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("COMAELEMENTO",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // COMAELEMENTO ::= caracter 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("COMAELEMENTO",8, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // DECLARACIONEXP ::= id flecha DEFINICIONEXP ptcoma 
            {
              Object RESULT =null;
		int DEFleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int DEFright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object DEF = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONEXP",9, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // DEFINICIONEXP ::= DEFINICIONEXP OPERADOR 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // DEFINICIONEXP ::= OPERADOR 
            {
              Object RESULT =null;
		int OPleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int OPright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object OP = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONEXP",10, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // OPERADOR ::= punto 
            {
              Object RESULT =null;
		int puleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int puright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object pu = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // OPERADOR ::= union 
            {
              Object RESULT =null;
		int uleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int uright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object u = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // OPERADOR ::= kleene 
            {
              Object RESULT =null;
		int kleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int kright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object k = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OPERADOR ::= positivo 
            {
              Object RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object p = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // OPERADOR ::= interrogacion 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // OPERADOR ::= llave_abre id llave_cierra 
            {
              Object RESULT =null;
		int iddleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int iddright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		String idd = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // OPERADOR ::= cadena 
            {
              Object RESULT =null;
		int cadenaleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int cadenaright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		String cadena = (String)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // OPERADOR ::= especiales 
            {
              Object RESULT =null;
		int espleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int espright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object esp = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("OPERADOR",11, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // DECLARACIONPORCENTAJES ::= porcentajes 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONPORCENTAJES",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // DECLARACIONENTRADA ::= DEFINICIONENTRADA ptcoma 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DECLARACIONENTRADA",13, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // DEFINICIONENTRADA ::= id dospuntos cadena 
            {
              Object RESULT =null;

              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("DEFINICIONENTRADA",12, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
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
