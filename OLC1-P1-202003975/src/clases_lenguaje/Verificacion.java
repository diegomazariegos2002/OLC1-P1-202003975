package clases_lenguaje;

import Estructuras.NodoArbol;
import app.Menu;
import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción de verificación y que
 * implementa la interfaz de instrucción.
 *
 * Basicamente las instrucciones verificación tienen como objetivo ejecutar la
 * verificación de las cadenas que traen y relacionando su id con la expresión
 * regular.
 */
public class Verificacion implements Instruccion {

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the cadena
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * @param cadena the cadena to set
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    /**
     * @return the cadenaValida
     */
    public boolean isCadenaValida() {
        return cadenaValida;
    }

    /**
     * @param cadenaValida the cadenaValida to set
     */
    public void setCadenaValida(boolean cadenaValida) {
        this.cadenaValida = cadenaValida;
    }

    /**
     * Id de la verificación que se relaciona a una expresión.
     */
    private String id;
    /**
     * Cadena a verificar.
     */
    private String cadena;
    /**
     * Variable booleana para mostrar el resultado de la verificación.
     */
    private boolean cadenaValida = true;

    /**
     * Constructor de la clase verificación
     *
     * @param id
     * @param cadena
     */
    public Verificacion(String id, String cadena) {
        this.id = id;
        cadena = (String) cadena.subSequence(1, cadena.length() - 1);
        this.cadena = cadena;
    }

    /**
     * Método que ejecuta la instrucción Verificación, es una sobreescritura del
     * método ejecutar que se debe programar por la implementación de la
     * interfaz instrucción
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna nulo porque no produce ningun valor
     */
    @Override
    public Object ejecutar(TablaDeSimbolos ts) {
        LinkedList<TablaTransiciones> tTs = Menu.tablasTrans;
        TablaTransiciones tT = null;
        for (TablaTransiciones tablaTransicion : tTs) {
            if (tablaTransicion.nombreTabla.equals(getId())) {
                tT = tablaTransicion;
            }
        }
        if (tT == null) {
            System.out.println("No se encontro la expresión.");
        }

        int i = 0;
        int posicionEnCadena = 0;
        boolean meMovi = false; //variable bandera para verificar si nos desplazamos en transiciones.
        Estado estadoActual = tT.listaEstados.get(0);
        try {
            while (posicionEnCadena < getCadena().length()) {
                for (Transicion transicionActual : estadoActual.transiciones) {
                    if (transicionActual.tipo == NodoArbol.TipoHoja.IDENTIFICADOR) {
                        char caracterAComprobar = getCadena().charAt(posicionEnCadena);

                        boolean existe = verificarConjunto(transicionActual.caracter, caracterAComprobar, ts);
                        if (!existe) {
                            continue;
                        } else {
                            posicionEnCadena++;
                            meMovi = true;
                            estadoActual = transicionActual.destino;
                            break;
                        }
                    } else if (transicionActual.tipo == NodoArbol.TipoHoja.CADENA) {
                        String cadenaAComprobar = getCadena().substring(posicionEnCadena, posicionEnCadena + transicionActual.caracter.length());
                        if (cadenaAComprobar.equals(transicionActual.caracter)) {
                            posicionEnCadena = posicionEnCadena + transicionActual.caracter.length();
                            meMovi = true;
                            estadoActual = transicionActual.destino;
                            break;
                        }
                    }
                }
                if (!meMovi) {
                    //Marcar error
                    setCadenaValida(false);
                    break;
                } else {
                    meMovi = false;
                }
            }
            if (!estadoActual.aceptacion) {
                //Marcar error
                setCadenaValida(false);
            }
            System.out.println("Ejecución instrucción (verificación) REGEX: " + getId() + ", cadena: " + getCadena() + " y validación = " + isCadenaValida());
            return this;
        } catch (Exception error) {
            setCadenaValida(false);
            System.out.println("*Ejecución instrucción (verificación) REGEX: " + getId() + ", cadena: " + getCadena() + " y validación = " + isCadenaValida());            
            return this;
        }
    }

    /**
     * Método para verificar si el caracter es contenido por mi conjunto.
     * Básicamente lo que tendría que hacer es verificar si existe un conjunto
     * con ese nombre en mi tabla de simbolos y verificar si la cadena de
     * entrada concuerda con su rango de datos.
     *
     * @param conjunto
     * @param caracterAComprobar
     * @return
     */
    private boolean verificarConjunto(String conjunto, char caracterAComprobar, TablaDeSimbolos ts) {
        for (Simbolo t : ts) {
            if (t.getTipo() == Simbolo.Tipo.CONJUNTO) {
                if (t.getId().equals(conjunto)) {
                    if (((LinkedList<Character>) t.getValor()).contains(caracterAComprobar)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
