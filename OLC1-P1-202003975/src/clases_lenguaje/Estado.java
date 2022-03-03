package clases_lenguaje;

import java.util.ArrayList;

public class Estado {
    public String nombreEstado;
    public ArrayList<Integer> siguientesEstado;
    public ArrayList<Transicion> transiciones = new ArrayList<>();
    public boolean aceptacion = false;

    /**
     * Constructor de mi clase Estado
     * @param nombreEstado
     * @param siguientesEstado 
     */
    public Estado(String nombreEstado, ArrayList<Integer> siguientesEstado) {
        this.nombreEstado = nombreEstado;
        this.siguientesEstado = (ArrayList)siguientesEstado.clone();
    }

    /**
     * Constructor de mi clase Estado.
     * @param nombreEstado 
     */
    public Estado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
        this.aceptacion = false;
    }
    
    /**
     * Constructor de mi clase Estado.
     * @param aceptacion 
     */
    public Estado(boolean aceptacion) {
        this.aceptacion = aceptacion;
    }
}
