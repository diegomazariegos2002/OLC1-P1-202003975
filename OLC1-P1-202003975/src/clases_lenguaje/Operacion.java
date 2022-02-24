package clases_lenguaje;

import java.util.LinkedList;
import Estructuras.NodoArbol;
import Estructuras.Arbol;
import java.util.ArrayList;

//NOTA aquí lo mejor hubiera sido dividir conjuntos de expresiones para ahorrarme algunas verificaciones.
/**
 * Clase que se encarga de realizar todas las operaciones ya sean aritméticas o
 * relacionales esta implementa la interfaz Instrucción.
 */
public class Operacion implements Instruccion {

    /**
     * Enumeración del tipo de operación que puede ser ejecutada por esta clase.
     */
    public static enum tipo_Operacion {
        CONCATENACION,
        OR,
        KLEENE,
        INTERROGACION,
        POSITIVO,
        CADENA,
        CARACTER,
        IDENTIFICADOR,
        COMA,
        VIRGULILLA,
        DOLAR
    }
    /**
     * Tipo de operación a ejecutar.
     */
    private final tipo_Operacion tipo;
    /**
     * Operador A de la operación.
     */
    private Operacion operadorA;
    /**
     * Operador B de la operación.
     */
    private Operacion operadorB;
    /**
     * Valor específico si se tratara de una literal, es decir un número o una
     * cadena.
     */
    private Object valor1;
    private Object valor2;

    /**
     * Constructor de la clase para operaciones binarias (con dos operadores),
     * estas operaciones son: CONCATENACION, OR, COMA.
     *
     * @param tipo Tipo de operación que realiza el símbolo.
     * @param operadorA Operador A de la operación.
     * @param operadorB Operador B de la operación.
     */
    public Operacion(tipo_Operacion tipo, Operacion operadorA, Operacion operadorB) {
        this.tipo = tipo;
        this.operadorA = operadorA;
        this.operadorB = operadorB;
    }

    /**
     * Constructor de la clase para operaciones unarias (un operador), estas
     * operaciones son: INTERROGACION, POSITIVO, KLEENE.
     *
     * @param tipo Tipo de operación que realiza el símbolo.
     * @param operadorA Operador A de la operación.
     */
    public Operacion(tipo_Operacion tipo, Operacion operadorA) {
        this.tipo = tipo;
        this.operadorA = operadorA;
    }

    /**
     * Constructor de la clase para operaciones binarias (con dos operadores),
     * específicamente con dos cadenas y estas operaciones son: VIRGULILLA.
     *
     * @param tipo Tipo de operación que realiza el símbolo.
     * @param operadorA Operador A de la operación.
     * @param operadorB Operador B de la operación.
     */
    public Operacion(tipo_Operacion tipo, String operadorA, String operadorB) {
        this.tipo = tipo;
        this.valor1 = operadorA;
        this.valor2 = operadorB;
    }

    /**
     * Constructor de la clase para operaciones unarias (un operador), cuyo
     * operador es específicamente una cadena y dichas operaciones son:
     * IDENTIFICADOR, CADENA, CARACTER.
     *
     * @param tipo Tipo de operación que realiza el símbolo.
     * @param operadorA Objecto de entrada normalmente van a ser de tipo String
     * pero también puedo recibir listas de Strings digamos en el caso de
     * CARACTER.
     */
    public Operacion(tipo_Operacion tipo, Object operadorA) {
        this.tipo = tipo;
        this.valor1 = operadorA;
    }

    /**
     * Método que ejecuta la instrucción operación, es una sobreescritura del
     * método ejecutar que se debe programar por la implementación de la
     * interfaz instrucción.
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Esta instrucción retorna el valor producido por la operación que
     * se ejecutó.
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {

        if (null == tipo) {

            return null;
        } else /* ======== OPERACIONES BINARIAS ======== */ {
            NodoArbol nodoNuevo;
            switch (tipo) {
                case CONCATENACION:
                    if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.
                        nodoNuevo = new NodoArbol(false, (NodoArbol) ((Operacion) operadorA).ejecutar(ts), (NodoArbol) ((Operacion) operadorB).ejecutar(ts), ".");

                        return nodoNuevo;
                    } else {//Se desarrolla proceso del método Thompson.

                        return null;
                    }

                case OR:
                    if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.
                        nodoNuevo = new NodoArbol(false, (NodoArbol) ((Operacion) operadorA).ejecutar(ts), (NodoArbol) ((Operacion) operadorB).ejecutar(ts), "|");

                        return nodoNuevo;
                    } else {//Se desarrolla proceso del método Thompson.

                        return null;
                    }

                case KLEENE:
                    if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.
                        nodoNuevo = new NodoArbol(false, (NodoArbol) ((Operacion) operadorA).ejecutar(ts), null, "*");

                        return nodoNuevo;
                    } else {//Se desarrolla proceso del método Thompson.

                        return null;
                    }
                case POSITIVO:
                    if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.
                        nodoNuevo = new NodoArbol(false, (NodoArbol) ((Operacion) operadorA).ejecutar(ts), null, "+");

                        return nodoNuevo;
                    } else {//Se desarrolla proceso del método Thompson.

                        return null;
                    }
                case INTERROGACION:
                    if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.
                        nodoNuevo = new NodoArbol(false, (NodoArbol) ((Operacion) operadorA).ejecutar(ts), null, "?");

                        return nodoNuevo;
                    } else {//Se desarrolla proceso del método Thompson.

                        return null;
                    }

                case COMA:
                    return valor1;
                /* ======== OPERACIONES UNARIAS ======== */
                case VIRGULILLA:
                    /*
                     * Se crea una LinkedList que almacenara todos los valores de mi conjuntos.
                     */
                    LinkedList<Character> valoresConjunto = new LinkedList<>();
                    /*
                     * Se asignan los valores inferiores y superiores del rango de caracteres.
                     */
                    char inferior = valor1.toString().charAt(0);
                    char superior = valor2.toString().charAt(0);

                    /**
                     * Por medio de un for voy a rellenar mi lista de caracteres
                     * permitidos siempre respetandos las condiciones del
                     * proyecto. en las cuales dice que si me viene un rango de
                     * caracteres tipo &,%,}... no se incluyen las letras a-zA-Z
                     * y tampoco los dígitos 0-9.
                     */
                    for (int i = (int) inferior; i <= (int) superior; i++) {
                        /**
                         * Si el limite inferior esta en el siguiente rango
                         * quiere decir que se trata de operación de virgulilla
                         * con caracteres tipo &,%,}... por lo que no deben
                         * incluir a a-zA-Z y 0-9
                         */
                        if ((inferior >= 33 && inferior <= 47) || (inferior >= 58 && inferior <= 64) || (inferior >= 91 && inferior <= 96) || (inferior >= 123 && inferior <= 126)) {
                            if ((i >= 48 && i <= 57) || (i >= 65 && i <= 90) || (i >= 97 && i <= 122)) {
                                continue;
                            }
                        }
                        valoresConjunto.add((char) i);
                    }

                    return valoresConjunto;
                case IDENTIFICADOR:
                    if (app.Main.definiendoArbol == true) {//En caso si se este definiendo un árbol.
                        if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.

                            ArrayList<Integer> first = new ArrayList<>();
                            ArrayList<Integer> last = new ArrayList<>();
                            first.add(app.Main.numeroHojas);
                            last.add(app.Main.numeroHojas);

                            //Al ser un Nodo identificador es un nodo HOJA y todo lo que eso conlleva.
                            nodoNuevo = new NodoArbol(false, first, last, "ID CONJ", app.Main.numeroHojas);

                            app.Main.numeroHojas++;
                            return nodoNuevo;
                        } else {//Se desarrolla proceso del método Thompson.

                            return null;
                        }
                    } else {
                        /**
                         * En caso de que se ejecute la acción de esta operación
                         * porque no es una ejecución dentro de una expresión
                         * regular. Entonces solo debe guardar el identificador
                         * en la TABLA DE SÍMBOLOS.
                         */
                        return ts.getValor(valor1.toString());
                    }
                case CADENA:
                    if (app.Main.metodoElegido == false) { //Se desarrolla proceso del método del árbol.

                        ArrayList<Integer> first = new ArrayList<>();
                        ArrayList<Integer> last = new ArrayList<>();
                        first.add(app.Main.numeroHojas);
                        last.add(app.Main.numeroHojas);

                        //Al ser un Nodo identificador es un nodo HOJA y todo lo que eso conlleva.
                        nodoNuevo = new NodoArbol(false, first, last, valor1.toString(), app.Main.numeroHojas);

                        app.Main.numeroHojas++;
                        return nodoNuevo;
                    } else {//Se desarrolla proceso del método Thompson.

                        return null;
                    }
                case CARACTER: //Caracter ni lo uso pero no lo quito porque así funciona todo jsjsjs
                    return generarChar();
                default:
                    return null;
            }
        }
    }

    /**
     * Metodo que obtiene un valor char del Token CARACTER
     *
     * @return un valor de tipo char obtenido de una cadena
     */
    private char generarChar() {
        String cad = this.valor1.toString();
        return switch (cad) {
            case "\" \"" ->
                '\n';
            default ->
                cad.isEmpty() ? '\0' : cad.charAt(0);
        };
    }

}
