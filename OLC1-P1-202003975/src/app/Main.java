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

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Analizar();
    }
        static LinkedList<Instruccion> arbol_Abstacto = null;
        static LinkedList<Instruccion> lista_Expresiones = null;
        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        static TablaDeSimbolos ts = null;
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
            System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para ejecutar todos los pasos del método del árbol.
     */
    public static void ejecutarAST() {
        if(arbol_Abstacto==null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el archivo de entrada no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        //Se le asigna un espacio en memoria al objeto TablaDeSimbolos ts.
        ts = new TablaDeSimbolos();
        //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.
        for(Instruccion ins:arbol_Abstacto){
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if(ins!=null)
                ins.ejecutar(ts);
        }
        System.out.println("");
    }

    /**
     * Método para ejecutar el primer paso del método del árbol. El cual es la
     * concatenación del simbolo dolar.
     */
    public static void primeraPaso() {
        /**
         * Preparando recorrido pre orden.
         */
        for (Instruccion instruccion : lista_Expresiones) {

            System.out.println("Recorrido Pre-orden de la expresión: " + ((Asignacion) instruccion).id);
             
            /**
             * Para el método de árbol tengo añadir la concatenación con el $ al
             * nodo raíz.
             */
            Operacion nodoRaiz = ((Asignacion) instruccion).valor;
            Operacion dolar = new Operacion(Operacion.tipo_Operacion.CARACTER, "$");
            Operacion concatenar = new Operacion(Operacion.tipo_Operacion.CONCATENACION, nodoRaiz, dolar);
            ((Asignacion) instruccion).valor = concatenar;
            System.out.println("Se añadió el signo $ a la expresión: "+((Asignacion) instruccion).id);
        }
    }

    
    public static void recorrido_PreOrden(){
        
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
