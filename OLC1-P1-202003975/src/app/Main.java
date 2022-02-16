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



public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            String direccion="./PruebaExp.txt";
            System.out.println("Inicia el analisis...\n");
            
            Lexico scanner = new Lexico(new BufferedReader(leerFichero()));
            Sintactico sintactico = new Sintactico(scanner);
            sintactico.parse();
            System.out.println("Finaliza el analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
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
