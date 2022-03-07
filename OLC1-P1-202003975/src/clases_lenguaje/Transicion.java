package clases_lenguaje;

import Estructuras.NodoArbol.TipoHoja;

public class Transicion {
    String caracter;
    Estado origen;
    Estado destino;
    TipoHoja tipo; //Variable que define si es un conjunto o una cadena como tal.
    

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

    /**
     * Constructor de mi clase Transicion.
     * @param caracter
     * @param origen
     * @param destino
     * @param tipo 
     */
    public Transicion(String caracter, Estado origen, Estado destino, TipoHoja tipo) {
        this.caracter = caracter;
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
    }
}
