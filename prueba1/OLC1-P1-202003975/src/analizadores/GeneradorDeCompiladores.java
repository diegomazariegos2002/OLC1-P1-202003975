package analizadores;

/**
 *
 * @author esvux
 */

public class GeneradorDeCompiladores {
    
    public static void main(String[] args) {
        generarCompilador();
    }
    
    private static void generarCompilador(){
        try {
            String ruta = "src/analizadores/"; //ruta donde tenemos los archivos con extension .jflex y .cup
            String opcFlex[] = { ruta + "A_Lexico.jflex", "-d", ruta };
            jflex.Main.generate(opcFlex);
            String opcCUP[] = { "-destdir", ruta, "-parser", "parser", ruta + "A_Sintactico.cup" };
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}

