package clases_lenguaje;

import java.util.LinkedList;

/**
 * Clase Tabla de símbolos, es en la que se almacenan todos los identicadores
 * esta hereda de la clase LinkedList ya que de por si es una lista.
 */
public class TablaDeSimbolos extends LinkedList<Simbolo>{
    
    /**
    * Constructor que lo único que hace es llamar al constructor de la linkelist.
    * Para eso se utiliza el super();
    */
    public TablaDeSimbolos() {
        super();
    }
    
    /**
     * Metodo que busca un identificador en la tabla de símbolos por medio de su id
     * y devuelve su valor.
     * @param id Identificador de la variable que quiere buscarse
     * @return Valor de la variable que se buscaba, si no existe se devuelve nulo
     */
    Object getValor(String id) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                return s.getValor();
            }
        }
        System.out.println("La variable "+id+" no existe.");
        return "Desconocido";
    }
    /**
     * Método que asigna un valor a una variable específica, si no la encuentra 
     * no realiza la asignación y despliega un mensaje de error.
     * @param id Identificador de la variable que quiere buscarse
     * @param valor Valor que quiere asignársele a la variable buscada
     */
    void setValor(String id, Object valor) {
        for(Simbolo s:this){
            if(s.getId().equals(id)){
                s.setValor(valor);
                return;
            }
        }
        System.out.println("La variable "+id+" no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
}
