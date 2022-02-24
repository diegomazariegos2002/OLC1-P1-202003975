package Estructuras;

import java.util.ArrayList;

public class Arbol {
    
    public NodoArbol raiz;
    String contenido = "";
    int contadorAuxiliar = 0;
    public String nombre;
    

    /**
     * Constructor de clase Arbol
     * @param raiz
     * @param nombre 
     */
    public Arbol(NodoArbol raiz, String nombre) {
        this.raiz = raiz;
        this.nombre = nombre;
    }
    /**
     * Constructor de mi clase Arbol
     * @param nombre 
     */
    public Arbol(String nombre) {
        this.nombre = nombre;
    }
    
    public void setRaiz(NodoArbol nodoRaiz){
        this.raiz = nodoRaiz;
    }
    
    public void recorrerPreOrden(NodoArbol actual){
        if (actual != null) {
            recorrerPreOrden(actual.hijoIzquierdo);
            recorrerPreOrden(actual.hijoDerecho);
        }
    }
    
}
