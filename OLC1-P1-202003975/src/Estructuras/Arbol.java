package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Arbol {

    public NodoArbol raiz;
    String contenido = "";
    int contadorAuxiliar = 0;
    public String nombre;

    /**
     * Constructor de clase Arbol
     *
     * @param raiz
     * @param nombre
     */
    public Arbol(NodoArbol raiz, String nombre) {
        this.raiz = raiz;
        this.nombre = nombre;
    }

    /**
     * Constructor de mi clase Arbol
     *
     * @param nombre
     */
    public Arbol(String nombre) {
        this.nombre = nombre;
    }

    public void setRaiz(NodoArbol nodoRaiz) {
        this.raiz = nodoRaiz;
    }

    public void recorrerPreOrden(NodoArbol actual) {
        if (actual != null) {
            System.out.println(actual.valor);
            recorrerPreOrden(actual.hijoIzquierdo);
            recorrerPreOrden(actual.hijoDerecho);
        }
    }
    
    /**
     * Método para crear el String del cuerpo del Dot.
     * @param entrada
     * @param actual
     * @return 
     */
    public String recorrerPreOrdenDot(String entrada, NodoArbol actual){
        String cadena = "";
        if(actual !=  null){
        cadena += "\nNodo"+actual.hashCode()+"[label = \""+actual.valor+"\"];\n";
        
        
        /**
         * Estos if de aquí es para realizar las conexiones entre nodos hijo y nodo padre en el Dot.
         */
        if(actual.hijoIzquierdo != null){
            cadena += String.format("\nNodo%d -> Nodo%d; \n", actual.hashCode(), actual.hijoIzquierdo.hashCode());
        }
        if(actual.hijoDerecho != null){
            cadena += String.format("\nNodo%d -> Nodo%d; \n", actual.hashCode(), actual.hijoDerecho.hashCode());
        }
        cadena += recorrerPreOrdenDot(cadena, actual.hijoIzquierdo);
        cadena += recorrerPreOrdenDot(cadena, actual.hijoDerecho);
        }
        return cadena;
    }

    /**
     * Método diseñado para crear el fichero de extensión .Dot. que después un
     * habrá un método de dibujo que genere ese fichero .Dot en un imagen con
     * extensión .SVG por medio de la librería Graphviz.
     *
     * @param nombreFichero
     */
    public void crearFicheroDot_Arbol(String nombreFichero) {
        //Parte del String o texto que va a llevar el fichero
        // (en este caso un archivo .dot)
        StringBuilder dot = new StringBuilder();

        dot.append("digraph G { \n");
        dot.append("node[shape = box]; \n");
        NodoArbol actual = this.raiz;
        
        String cuerpoDot = recorrerPreOrdenDot("", actual);

        dot.append(cuerpoDot);
        dot.append("}");

        FileWriter fichero = null;
        PrintWriter pw = null;
        //Parte de la creación de un fichero
        try {
            fichero = new FileWriter("./" + nombreFichero + ".dot");
            pw = new PrintWriter(fichero);

            pw.println(dot);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        dibujar("./"+nombreFichero+".dot", "./"+nombreFichero+".svg");
    }

    //Método para pasar del archivo .dot a Imagen(png, jpg, etc...)
    public void dibujar(String direccionDot, String direccionSvg) {
        try {
            ProcessBuilder pbuilder;
            /*
             * Realiza la construccion del comando
             * en la linea de comandos esto es:
             * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tsvg", "-o", direccionSvg, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
