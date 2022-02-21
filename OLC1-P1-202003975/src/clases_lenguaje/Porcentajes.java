package clases_lenguaje;

import java.util.LinkedList;

/**
 * * Clase que ejecuta las acciones de una instrucción Porcentajes y que implementa
 * la interfaz de instrucción.
 * En esta instrucción es donde se almacenan las instrucciones de verificación de cadenas
 */
public class Porcentajes implements Instruccion{
    
    /**
     * Variable que almacena la lista de instrucciones de verificación
     */
    private final LinkedList<Instruccion> listaInstruccionesVerificacion;
    
    /**
     * Constructor de la clase Porcentajes.
     * @param listaInstruccionesVerificacion 
     */
    public Porcentajes(LinkedList<Instruccion> listaInstruccionesVerificacion) {
        this.listaInstruccionesVerificacion = listaInstruccionesVerificacion;
    }
    
    /**
     * Método que ejecuta la instrucción Porcentajes, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna nulo porque no produce ningun valor
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        return null;
    }
    
}
