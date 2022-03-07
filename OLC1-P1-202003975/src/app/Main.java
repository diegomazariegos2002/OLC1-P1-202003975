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
import clases_lenguaje.Estado;
import clases_lenguaje.Transicion;
import clases_lenguaje.TablaTransiciones;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
        /*
        Analizar();
        //Recorrido pre-orden de los arboles en la lista de arboles.
        for (int i = 0; i < arboles.size(); i++) {
            
            //System.out.println("Recorrido pre orden de la expresión: " + arboles.get(i).nombre);
            //arboles.get(i).recorrerPreOrden(arboles.get(i).raiz);
            
            arboles.get(i).crearFicheroDot_Arbol(arboles.get(i).nombre + "_Arbol");
            arboles.get(i).crearFicheroDot_TablaSiguientes(arboles.get(i).nombre + "_TablaSiguientes");

        }
         */
    }
}
