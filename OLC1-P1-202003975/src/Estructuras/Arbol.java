package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Arbol {

    public NodoArbol raiz;
    String contenido = "";
    int contadorAuxiliar = 0;
    public String nombre;
    public LinkedList<NodoArbol> listaNodosHijos = new LinkedList<>();
    public LinkedList<String> alfabeto = new LinkedList<>();
    
    /**
     * Constructor de clase Arbol
     *
     * @param raiz
     * @param nombre
     */
    public Arbol(NodoArbol raiz, String nombre, LinkedList<NodoArbol> listaNodosHijos) {
        this.raiz = raiz;
        this.nombre = nombre;
        /**
         * Paso 5.2 Hacer listado de nodos hijos.
         */
        this.listaNodosHijos = listaNodosHijos;
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
     * Método para retornar las DECLARACIONES DE NODOS para el .Dot.
     *
     * @param entrada
     * @param actual
     * @return
     */
    public String getNombreNodos_PreOrden(String entrada, NodoArbol actual) {
        String cadena = "";
        if (actual != null) {
            String cuerpoNodo = "";
            cuerpoNodo += actual.valor;
            if (actual.tipo == NodoArbol.TipoNodo.HOJA) {
                cuerpoNodo += "\\n" + actual.numeroHoja;
            }
            if (actual.anulable == true) { // Si el nodo si es anulable pintalo de color rojo
                cadena += "node[shape = box, color = red]; ";
            } else { // Si el nodo no es anulable pintalo de color verde
                cadena += "node[shape = box, color = green]; ";
            }
            /**
             * Encontrar primeros
             */
            String cuerpoFirst = "";
            for (int primero : actual.first) {
                cuerpoFirst += primero + ",";

            }

            /**
             * Encontrar últimos
             */
            String cuerpoLast = "";
            for (int ultimo : actual.last) {
                cuerpoLast += ultimo + ",";

            }

            /**
             * Crea el nodo en graphviz con su respectivo cuerpo
             */
            cadena += "\nNodo" + actual.hashCode() + "[shape=record, label = \"<f0> " + cuerpoFirst + " | <f1>" + cuerpoNodo + " | <f2> " + cuerpoLast + "\"];\n";

            cadena += getNombreNodos_PreOrden(cadena, actual.hijoIzquierdo);
            cadena += getNombreNodos_PreOrden(cadena, actual.hijoDerecho);
        }
        return cadena;
    }

    /**
     * Método para retornar las CONEXIONES ENTRE NODOS para el .Dot.
     *
     * @param entrada
     * @param actual
     * @return
     */
    public String getConexionNodos_PreOrden(String entrada, NodoArbol actual) {
        String cadena = "";
        if (actual != null) {
            /**
             * Estos if de aquí es para realizar las conexiones entre nodos hijo
             * y nodo padre en el Dot.
             */
            if (actual.hijoIzquierdo != null) {
                cadena += String.format("\nNodo%d -> Nodo%d; \n", actual.hashCode(), actual.hijoIzquierdo.hashCode());
            }
            if (actual.hijoDerecho != null) {
                cadena += String.format("\nNodo%d -> Nodo%d; \n", actual.hashCode(), actual.hijoDerecho.hashCode());
            }

            cadena += getConexionNodos_PreOrden(cadena, actual.hijoIzquierdo);
            cadena += getConexionNodos_PreOrden(cadena, actual.hijoDerecho);
        }
        return cadena;
    }

    /**
     * Paso 1,2,3,4.1,4.2 del método del árbol Método diseñado para crear el
     * fichero de extensión .Dot. que después un habrá un método de dibujo que
     * genere ese fichero .Dot en un imagen con extensión .SVG por medio de la
     * librería Graphviz.
     *
     * @param nombreFichero
     */
    public void crearFicheroDot_Arbol(String nombreFichero) {
        //Parte del String o texto que va a llevar el fichero
        // (en este caso un archivo .dot)
        StringBuilder dot = new StringBuilder();

        dot.append("digraph structs { \n");
        dot.append("node[shape = box]; \n");
        NodoArbol actual = this.raiz;

        String nombresNodos = getNombreNodos_PreOrden("", actual);
        dot.append(nombresNodos);

        String conexionesNodos = getConexionNodos_PreOrden("", actual);
        dot.append(conexionesNodos);

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
        dibujar("./" + nombreFichero + ".dot", "./ARBOLES_202003975/" + nombreFichero + ".png");
    }

    /**
     * Método para obtener la cadena de siguientes de todos los nodos y utilizar
     * esta misma cadena en el archivo .dot
     *
     * @param entrada
     * @param actual
     * @return
     */
    public String getSiguientesNodo_PreOrden() {
        String cadena = "";
            for (NodoArbol nodoHijo : listaNodosHijos) {
                String cuerpoSiguientes = "";
                for (int siguiente : nodoHijo.siguientes) {
                    cuerpoSiguientes += siguiente + ",";

                }
                cadena += "\n<TR>";
                cadena += "\n<TD>"+nodoHijo.valor+"</TD><TD>"+nodoHijo.numeroHoja+"</TD>";
                cadena += "<TD>"+cuerpoSiguientes+"</TD>\n";
                cadena += "</TR>";
            }

        return cadena;
    }

    /**
     * Paso 5 del método del árbol diseñado para crear el ficero de extesión
     * Dot.
     *
     * @param nombreFichero
     */
    public void crearFicheroDot_TablaSiguientes(String nombreFichero) {
        //Parte del String o texto que va a llevar el fichero
        // (en este caso un archivo .dot)
        StringBuilder dot = new StringBuilder();
        NodoArbol actual = this.raiz;

        dot.append("digraph html { \n");
        dot.append("abc [shape=none, margin=0, label=< \n");
        dot.append("<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\" CELLPADDING=\"4\">\n");
        dot.append("<TR>");
        dot.append("<TD>Valor</TD><TD>Hoja</TD><TD>Siguientes</TD>");
        dot.append("</TR>");
        /**
         * Parte de agregar cada nodo hoja a su respectiva fila.
         */
        String cuerpoSiguientes = getSiguientesNodo_PreOrden();
        
        dot.append(cuerpoSiguientes);
        dot.append("    </TABLE>>];\n");
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
        dibujar("./" + nombreFichero + ".dot", "./SIGUIENTES_202003975/" + nombreFichero + ".png");
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
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionSvg, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Paso 6.2 del método del árbol es generar la tabla de transiciones.
     */
    public void crearFicheroDot_TablaTransiciones(String nombreFichero){
        //Parte del String o texto que va a llevar el fichero
        // (en este caso un archivo .dot)
        StringBuilder dot = new StringBuilder();
        NodoArbol actual = this.raiz;

        dot.append("digraph html { \n");
        dot.append("abc [shape=none, margin=0, label=< \n");
        dot.append("<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\" CELLPADDING=\"4\">\n");
        dot.append("<TR>");
        dot.append("<TD BORDER=\"0\"></TD>");
        dot.append("<TD COLSPAN = \"1\" ROWSPAN = \"2\" BGCOLOR=\"skyblue\">ESTADOS</TD>");
        dot.append("<TD COLSPAN=\"1000\" BGCOLOR=\"lightgrey\">Σ</TD>");
        dot.append("</TR>");
        dot.append("<TR>");
        /**
         * Primera parte de la tabla (ALFABETO).
         */
        
        dot.append("</TR>");
        dot.append("<TR>");
        /**
         * Segunda parte de la tabla (TRANSICIONES).
         */
        
        dot.append("</TR>");
        dot.append("    </TABLE>>];\n");
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
        dibujar("./" + nombreFichero + ".dot", "./" + nombreFichero + ".png");
    }
}
