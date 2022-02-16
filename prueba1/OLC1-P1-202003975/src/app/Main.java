package app;

import java.io.BufferedReader;
import java.io.StringReader;
import analizadores.Analizador_Lexico;
import analizadores.parser;

public class Main {

    public static void main(String[] args) {
        try {
            String texto=" {\n" +
"CONJ:letra->a~z;\n" +
"CONJ:digito->0~9;\n" +
"CONJ:especial->!~&;\n" +
"CONJ: vocales->a,e,i,o,u;\n" +
"\n" +
"decimal->..+{digito}\".\"+{digito};\n" +
"Raro->+..{vocales}?{especial}\"\\n\";\n" +
"\n" +
"%%\n" +
"decimal:\"34.51\";\n" +
"Raro:\"a$\\n\";\n" +
"\n" +
"}";
            System.out.println("Inicia el analisis...\n");
            Analizador_Lexico scanner = new Analizador_Lexico(new BufferedReader( new StringReader(texto)));
            
            System.out.println("Finaliza el analisis...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
