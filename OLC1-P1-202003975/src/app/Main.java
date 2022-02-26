package app;

import java.io.BufferedReader;
import java.io.StringReader;
import Analizador.Sintactico;
import Analizador.Lexico;
import Analizador.sym;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
import clases_lenguaje.Instruccion;
import java.util.LinkedList;
import clases_lenguaje.Asignacion;
import clases_lenguaje.Operacion;
import clases_lenguaje.TablaDeSimbolos;
import Estructuras.Arbol;
import Estructuras.NodoArbol;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Analizar();
        //Recorrido pre-orden de los arboles en la lista de arboles.
        for (int i = 0; i < arboles.size(); i++) {
            System.out.println("Recorrido pre orden de la expresión: " + arboles.get(i).nombre);
            arboles.get(i).recorrerPreOrden(arboles.get(i).raiz);
            arboles.get(i).crearFicheroDot_Arbol(arboles.get(i).nombre+"_Arbol");
            arboles.get(i).crearFicheroDot_TablaSiguientes(arboles.get(i).nombre+"_TablaSiguientes");
        }
    }
    /**
     * Variable booleana metodoElegido la utilizo para saber con que método voy
     * a trabajar el analisis del AST. FALSE = ÁRBOL, TRUE = THOMPSON
     */
    public static boolean metodoElegido = false;
    public static boolean definiendoArbol = false;
    /**
     * La delcaración de esta lista de hijosTemporales es para poder asignarle
     * los nodos hijos a cada nodo arbol ya que los necesito para simplificar
     * el trabajo de la asignación de siguientes a cada nodo hijo.
     */
    public static LinkedList<NodoArbol> hijosTemporales = new LinkedList<>();
    static LinkedList<Instruccion> arbol_Abstacto = null;
    static LinkedList<Instruccion> lista_Expresiones = null;
    static LinkedList<Arbol> arboles = null;
    //Se crea una tabla de símbolos global para ejecutar las instrucciones.
    static TablaDeSimbolos ts = null;
    /**
     * Variable global números de hojas que utilizo para llevar el conteo de mis
     * hojas en cada árbol.
     */
    public static int numeroHojas = 0;

    public static void Analizar() {

        try {
            System.out.println("Inicia el analisis...\n");

            /**
             * Realizo los análisis tanto léxicos como sintácticos.
             */
            Lexico scanner = new Lexico(new BufferedReader(leerFichero()));
            Sintactico sintactico = new Sintactico(scanner);
            sintactico.parse();

            arbol_Abstacto = sintactico.getAST();
            lista_Expresiones = sintactico.getLista_Expresiones();

            System.out.println("Finaliza el analisis...\n");

            ejecutarAST();
            ejecutarMetodoArbol();

            System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para ejecutar todos los pasos del método del árbol.
     */
    public static void ejecutarAST() {
        try {
            if (arbol_Abstacto == null) {
                System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                        + "el archivo de entrada no fue cargado de forma adecuada por la existencia\r\n"
                        + "de errores léxicos o sintácticos.");
                return;
            }
            //Se le asigna un espacio en memoria al objeto TablaDeSimbolos ts.
            ts = new TablaDeSimbolos();
            //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
            //la lista principal de instrucciones.
            for (Instruccion ins : arbol_Abstacto) {
                //Si existe un error léxico o sintáctico en cierta instrucción esta
                //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
                //es por esto que se hace esta validación.
                if (ins != null) {
                    ins.ejecutar(ts);
                }
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error en ejecutarAST: " + e);
        }
    }

    /**
     * Método para ejecutar el método del árbol y generar mis árboles de cada
     * regex en mi lista de expresiones. funciona de forma que ejecuta la
     * primera instrucción de cada regex y como estan conectadas en forma de
     * cadena estan se van a ir entrelazando.
     */
    public static void ejecutarMetodoArbol() {
        try {
            definiendoArbol = true;
            arboles = new LinkedList<>();
            for (Instruccion ins : lista_Expresiones) { //recorro mi lista de expresiones
                numeroHojas = 1; //reinicio mi contador de hojas en cada árbol.
                hijosTemporales = new LinkedList<>(); //reinicion la lista de hojas temporales global
                //genero mi nodo raíz que tiene que ir concatenado de un nodo $
                ArrayList<Integer> first = new ArrayList<>();
                ArrayList<Integer> last = new ArrayList<>();
                first.add(-1);
                last.add(-1);

                NodoArbol nodoDolar = new NodoArbol(false, first, last, "#", -1, NodoArbol.TipoNodo.HOJA);
                NodoArbol hijoIzquieroRaiz = (NodoArbol) ((Asignacion) ins).valor.ejecutar(ts);
                NodoArbol nodoRaiz = new NodoArbol(false, hijoIzquieroRaiz, nodoDolar, ".", NodoArbol.TipoNodo.NO_HOJA);
                /**
                 * PASO 4.1) MÉTODO DEL ÁRBOL -> If de verificación de primeros
                 */
                if (hijoIzquieroRaiz.anulable == true) {
                    nodoRaiz.first.addAll(hijoIzquieroRaiz.first);
                    nodoRaiz.first.addAll(nodoDolar.first); //Recordar que el nodo dolar es su hijo derecho.

                } else {
                    nodoRaiz.first.addAll(hijoIzquieroRaiz.first);
                }
                /**
                 * PASO 4.2) MÉTODO DEL ÁRBOL -> If de verificación de últimos
                 */
                nodoRaiz.last.addAll(nodoDolar.last);
                
                /**
                 * PASO 5) Asignar siguientes
                 */
                ((Asignacion) ins).valor.asignarSiguientes(nodoRaiz);
                
                //Le añado el último nodo hijo a mi lista temporal de nodos hijos.
                hijosTemporales.add(nodoDolar);
                
                //genero mi árbol
                Arbol arbolNuevo = new Arbol(nodoRaiz, ((Asignacion) ins).id, hijosTemporales);
                
                //guardo mi árbol en la lista de árboles
                arboles.add(arbolNuevo);
            }
            System.out.println("Finaliza método del árbol.");
        } catch (Exception e) {
            System.out.println("Error en ejecutarMetodoArbol: " + e);
        } finally {
            definiendoArbol = false;
        }
    }

    //Método para leer un fichero y pasar el fichero a un String.
    public static FileReader leerFichero() throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser("./src/app"); // Crear un objeto para seleccionar un archivo
        String txt = "";
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile(); // Crea un objeto de archivo, que es el archivo seleccionado
            InputStream ins = new FileInputStream(file);//Crea un objeto de contenido de archivo leído
            FileReader file2 = new FileReader(file);
            return file2;
        } else {
            System.out.println("¡Ningún archivo seleccionado!");
            return null;
        }
    }
}
