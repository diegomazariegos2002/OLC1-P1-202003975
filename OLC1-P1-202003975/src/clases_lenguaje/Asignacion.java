package clases_lenguaje;

import clases_lenguaje.Simbolo.Tipo;

/**
 * Clase que ejecuta las acciones de una instrucción de asignación y que implementa
 * la interfaz de instrucción
 */
public class Asignacion implements Instruccion{
    
    /**
     * Identificador de la variable a la que se le asigna el valor.
     */
    public final String id;
    
    /**
     * Valor que se le asigna a la variable.
     */
    public Operacion valor;
    /**
     * Tipo de la variable que será declarada.
     */
    Simbolo.Tipo tipo;
    
    
    /**
     * Constructor de la clase asignación
     * @param a identificador de la variable
     * @param b valor que se le va a asignar
     * @param tipo Tipo de la clase que será declarada.
     */
    public Asignacion(String id, Operacion valor, Simbolo.Tipo tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    
    
    /**
    * Método que ejecuta la accion de asignar un valor, es una sobreescritura del 
    * método ejecutar que se debe programar por la implementación de la interfaz
    * instrucción.
    * @param ts tabla de símbolos del ámbito padre de la sentencia asignación
    * @return En este caso retorna nulo porque no es una sentencia que genere un valor.
    */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        if(tipo == Tipo.CONJUNTO){
        ts.add(new Simbolo(tipo, id));
        ts.setValor(id,valor.ejecutar(ts));
        return null;
        }else{ //osea que si es de tipo EXPRESION
                ts.add(new Simbolo(tipo, id));
                //Enviar tabla de transiciones a la tabla de simbolos como valor de la regex.
                ts.setValor(id,null);
                return null;
        }
    }
}
