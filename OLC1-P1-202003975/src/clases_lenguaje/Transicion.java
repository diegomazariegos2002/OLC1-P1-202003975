package clases_lenguaje;

public class Transicion {
    String caracter;
    Estado origen;
    Estado destino;

    /**
     * Constructor de mi clase Transicion
     * @param caracter
     * @param origen 
     */
    public Transicion(String caracter, Estado origen) {
        this.caracter = caracter;
        this.origen = origen;
    }

    /**
     * Constructor de mi clase Transicion
     * @param caracter
     * @param origen
     * @param destino 
     */
    public Transicion(String caracter, Estado origen, Estado destino) {
        this.caracter = caracter;
        this.origen = origen;
        this.destino = destino;
    }
    
}
