package clases_lenguaje;

import java.util.ArrayList;

/**
 * Clase creada con el fin de poder agrupar todos los siguientes
 * que compartan el mismo caracter y agrupar en un solo siguiente
 * sus siguientes, esto realizo para facilitar la construcción de los
 * estados en la tabla de transiciones, esta clase la utilizo en la parte
 * de los for's e if's anidados para entenderle mejor revisar esa parte.
 * @author Melissa
 */
public class Siguientes {
    String caracter;
    ArrayList<Integer> siguientes = new ArrayList<>();

    /**
     * Constructor de mi clase Siguientes.
     * @param caracter 
     */
    public Siguientes(String caracter) {
        this.caracter = caracter;
    }
}
