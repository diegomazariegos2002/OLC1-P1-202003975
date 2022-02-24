package Estructuras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class NodoArbol {
    /**
     * En esta parte de aquí enumero en una lista todos los tipos de nodos que
     * existen en mi árbol.
     */
    public static enum TipoNodo {
        NO_HOJA,
        HOJA
    }
    
    public boolean anulable;
    public ArrayList<Integer> first = new ArrayList<>();
    public ArrayList<Integer> last = new ArrayList<>();
    public NodoArbol hijoIzquierdo;
    public NodoArbol hijoDerecho;
    public String valor; // CONCATENACION, OR, INTERROGACION, KLEENE, POSITIVO... 
    public int numeroHoja; //Esto para el caso de los nodos hoja
    public TipoNodo tipo; //Variable que define el tipo de HOJA en el árbol.
    /**
     * Constructor para nodos de tipo HOJA
     * @param anulable
     * @param first
     * @param last
     * @param hijoIzquierdo
     * @param hijoDerecho
     * @param valor 
     * @param numeroHoja 
     */
    public NodoArbol(boolean anulable, ArrayList<Integer> first, ArrayList<Integer> last, String valor, int numeroHoja, TipoNodo tipo) {
        this.anulable = anulable;
        this.first = first;
        this.last = last;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.valor = valor;
        this.numeroHoja = numeroHoja;
        this.tipo = tipo;
    }
    
    /**
     * Constructor para nodos de tipo NO_HOJA
     * @param anulable
     * @param hijoIzquierdo
     * @param hijoDerecho
     * @param valor 
     */
    public NodoArbol(boolean anulable, NodoArbol hijoIzquierdo, NodoArbol hijoDerecho, String valor, TipoNodo tipo) {
        this.anulable = anulable;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
        this.valor = valor;
        this.tipo = tipo;
    }
    
    /**
     * Este método se utiliza para pasarle los primeros y siguientes que vienen como parametro
     * al nodo actual.
     * Este método ya es parte del proceso del método del árbol.
     * @param first
     * @param last 
     */
    public void insertarPrimerosSiguientes(ArrayList<Integer> first, ArrayList<Integer> last){
        this.first.addAll(first); //inserto todos los primeros en los siguientes
        this.last.addAll(last); //inserto todos los últimos en los siguien
        Collections.sort(this.first); //ordeno los números de la lista firts
        Collections.sort(this.last); //ordeno los números de la lista last
    }
    
    public void insertarPrimeros(ArrayList<Integer> first){
        this.first.addAll(first);
        Collections.sort(this.first);
    }
    
    public void insertarSiguientes(ArrayList<Integer> last){
        this.last.addAll(last);
        Collections.sort(this.last);
    }
}
