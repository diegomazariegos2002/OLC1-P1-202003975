package clases_lenguaje;

/**
* La clase símbolo vendría siendo un nodo en la tabla de símbolos (ver concepto tabla de símbolos en el libro)
* los símbolos se caracterizar por tener su Tipo, su identificador y su valor.
*/

public class Simbolo {

    private final Tipo tipo;
    private final String id;
    private Object valor;
    //Único constructor
    public Simbolo(Tipo tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }
    
    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the valor
     */
    public Object getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    /**
    * En esta parte de aquí enumero en una lista todos los tipos
    * de variable que son reconocidos en mi lenguaje.    
    */
    public static enum Tipo {
        CONJUNTO,
        EXPRESION
    }
}
