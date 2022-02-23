package Estructuras;

import java.util.LinkedList;

/**
 *
 * El objetivo de crear esta clase es que tengo que pasar las expresiones
 * regulares de entrada a un árbol binario y de esa forma poder realizar el
 * método del árbol en cada expresión. Notar que voy a insertar mis objetos
 * ArbolBinario en una LinkedList después.
 *
 * Aquí se declaran todas las clases necesarias para trabajar con el árbol de
 * mis expresiones.
 */
public class ArbolBB {

    /**
     * En esta parte de aquí enumero en una lista todos los tipos de nodos que
     * existen en mi árbol.
     */
    public static enum TipoNodo {
        BINARIO,
        NOBINARIO,
        HOJA
    }

    public class NodoArbolBB {

        /**
         * Declaro los atributos de mi nodo
         */
        public Object valor;
        /**
         * Variable para NODO HOJA
         */
        public int identificador;
        public String anulable;
        public LinkedList<Integer> primeros;
        public LinkedList<Integer> ultimos;
        public Object izquierdo;
        public Object derecho;
        public TipoNodo tipo;

        /**
         * Constructor de mi clase Nodo de tipo binario
         *
         * @param valor
         */
        public NodoArbolBB(Object valor, TipoNodo tipo) {
            this.valor = valor;
            this.tipo = tipo;
        }

    }

    public class Arbol {

        /**
         * Nodo raíz al cual voy a hacer referencia y por el cual voy a poder
         * acceder al resto de nodos del árbol.
         */
        NodoArbolBB nodoRaiz;

        /**
         * Constructor de mi clase Árbol.
         *
         * @param nodoRaiz
         */
        public Arbol(NodoArbolBB nodoRaiz) {
            this.nodoRaiz = nodoRaiz;
        }

        /**
         * Método para ingresar un n
         *
         * @param nuevo
         */
        public void insertar_Nodo(NodoArbolBB nuevo) {
            
        }
    }
}
