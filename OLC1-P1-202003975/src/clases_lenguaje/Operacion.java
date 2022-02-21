package clases_lenguaje;

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
        VIRGULILLA
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
     * estas operaciones son: CONCATENACION, OR, KLEENE, COMA.
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
     * Constructor de la clase para operaciones unarias (un operador),
     * estas operaciones son: INTERROGACION, POSITIVO.
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
     * específicamente con dos cadenas y estas operaciones son: 
     * VIRGULILLA.
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
     * @param operadorA Operador A de la operación.
     */
    public Operacion(tipo_Operacion tipo, String operadorA) {
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
        } else /* ======== OPERACIONES BINARIAS ======== */ 
            switch (tipo) {
            case CONCATENACION:
                return operadorA.ejecutar(ts).toString() + operadorB.ejecutar(ts).toString();
            case OR:
                return operadorA.ejecutar(ts).toString() + operadorB.ejecutar(ts).toString();
            case KLEENE:
                return operadorA.ejecutar(ts).toString() + operadorB.ejecutar(ts).toString();
            case COMA:
                return operadorA.ejecutar(ts).toString() + operadorB.ejecutar(ts).toString();
        /* ======== OPERACIONES UNARIAS ======== */
        //REVISAR BIEN ESTA PARTE PORQUE PUEDE QUE SE TENGAN QUE CLASIFICAR LOS ID.
            case VIRGULILLA:
                //Recordar que la virgulilla no me debería de retornar una concatenación
                //sino que debería de retornar un grupo de caracteres.
                return operadorA.ejecutar(ts).toString() + operadorB.ejecutar(ts).toString();
            case IDENTIFICADOR:
                return ts.getValor(valor1.toString());
            case CADENA:
                return valor1.toString();
            case CARACTER:
                return generarChar();
            default:
                return null;
        }
    }
    
    /**
     * Metodo que obtiene un valor char del Token CARACTER
     * @return un valor de tipo char obtenido de una cadena
     */
    private char generarChar()
    {
        String cad = this.valor1.toString(); 
        return switch (cad) {
            case "\" \"" -> '\n';
            default -> cad.isEmpty() ? '\0' : cad.charAt(0);
        };
    }

}
