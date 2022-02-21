package clases_lenguaje;


/**
 * Clase que ejecuta las acciones de una instrucción de verificación y que implementa
 * la interfaz de instrucción.
 * 
 * Basicamente las instrucciones verificación tienen como objetivo ejecutar la verificación
 * de las cadenas que traen y relacionando su id con la expresión regular.
 */
public class Verificacion implements Instruccion {

    /**
     * Id de la verificación que se relaciona a una expresión.
     */
    private final String id;
    /**
     * Cadena a verificar.
     */
    private final String cadena;

    /**
     * Constructor de la clase verificación
     * @param id
     * @param cadena 
     */
    public Verificacion(String id, String cadena) {
        this.id = id;
        this.cadena = cadena;
    }
    
    
    /**
     * Método que ejecuta la instrucción Verificación, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna nulo porque no produce ningun valor
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        System.out.println("Ejecución instrucción (verificación) REGEX: "+id+" y la cadena: "+cadena);
        return null;
    }
    
}
