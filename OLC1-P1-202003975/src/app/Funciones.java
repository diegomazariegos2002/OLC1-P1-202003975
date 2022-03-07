package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que me sirve para manejar las funciones de los archivos tales como
 * nuevo, guardar como, abrir, etc...
 *
 * @author Melissa
 */
public class Funciones {

    private JFileChooser accion = null;
    private File archivo = null;
    private Menu menu;
    public static String ruta = "";

    public void LeerFichero(Menu menu) {
        this.menu = menu;

        accion = new JFileChooser("./");
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("EXP", "exp");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Abrir archivo");
        if (accion.showOpenDialog(menu) == JFileChooser.APPROVE_OPTION) {
            archivo = accion.getSelectedFile();
            menu.jLabelNombreArchivoEntrada.setText(archivo.getName());
            ruta = accion.getSelectedFile().toString();
            System.out.println(ruta);
            try {
                /*Si existe el fichero*/
                if (archivo.exists()) {
                    /*Abre un flujo de lectura a el fichero*/
                    BufferedReader leeArchivo = new BufferedReader(new FileReader(archivo));
                    String Slinea, datos = "";
                    /*Lee el fichero linea a linea hasta llegar a la ultima*/
                    while ((Slinea = leeArchivo.readLine()) != null) {
                        /*Imprime la linea leida*/
                        datos = datos + Slinea + "\n";
                    }
                    menu.jTextAreaEntrada.setText(datos);
                    menu.jTextAreaEntrada.setEditable(true);
                    menu.jTextAreaEntrada.requestFocus();
                    /*Cierra el flujo*/
                    leeArchivo.close();
                    this.menu.abrioArchivo = true;
                    this.menu.creoNuevo = false;
                } else {
                    System.out.println("Fichero No Existe");
                }
            } catch (Exception ex) {
                /*Captura un posible error y le imprime en pantalla*/
                System.out.println(ex.getMessage());
            }
        }
    }

    public void CrearFicheroNuevo(Menu menu, String SCadena, String nombre) {
        this.menu = menu;

        accion = new JFileChooser("./");
        accion.setFileSelectionMode(0);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("EXP", "exp");
        accion.setFileFilter(filtroImagen);
        accion.setDialogTitle("Guardar archivo " + nombre);
        accion.setSelectedFile(new File(nombre));
        if (accion.showSaveDialog(menu) == JFileChooser.APPROVE_OPTION) {
            ruta = accion.getSelectedFile().toString();
            System.out.println(ruta);
            archivo = new File(ruta);
            menu.jLabelNombreArchivoEntrada.setText(archivo.getName());
            try {
                //Si Existe el fichero lo borra
                if (archivo.exists()) {
                    archivo.delete();
                }
                BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
                FileWriter escribirArchivo = new FileWriter(archivo, true);
                BufferedWriter buffer = new BufferedWriter(escribirArchivo);
                buffer.write(SCadena);
                buffer.newLine();
                buffer.close();
                wr.close();
                escribirArchivo.close();

                this.menu.abrioArchivo = true;
                this.menu.creoNuevo = false;
            } catch (Exception ex) {
            }
        }
    }

    public void GuardarFichero(String SCadena, String nombre) {

        System.out.println(ruta);
        archivo = new File(ruta);
        try {
            //Si Existe el fichero lo borra
            if (archivo.exists()) {
                archivo.delete();
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
            FileWriter escribirArchivo = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(SCadena);
            buffer.newLine();
            buffer.close();
            wr.close();
            escribirArchivo.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }
    }

    public void BorrarFichero(Menu menu) {
        this.menu = menu;
        archivo = new File(ruta);
        try {
            /*Si existe el fichero*/
            if (archivo.exists()) {
                /*Borra el fichero*/
                archivo.delete();
                JOptionPane.showMessageDialog(menu, "Archivo eliminado.");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Crear fichero especifamente para JSON
     */
    public void CrearFicheroNuevoJSON(String SCadena, String nombre, String ruta, String extension) {
        ruta += "/"+nombre+"."+extension;
        System.out.println(ruta);
        archivo = new File(ruta);
        try {
            //Si Existe el fichero lo borra
            if (archivo.exists()) {
                archivo.delete();
            }
            BufferedWriter wr = new BufferedWriter(new FileWriter(archivo));
            FileWriter escribirArchivo = new FileWriter(archivo, true);
            BufferedWriter buffer = new BufferedWriter(escribirArchivo);
            buffer.write(SCadena);
            buffer.newLine();
            buffer.close();
            wr.close();
            escribirArchivo.close();
        } catch (Exception ex) {
        }
    }
    
}
