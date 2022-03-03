package clases_lenguaje;

import java.util.ArrayList;
import Estructuras.NodoArbol;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class TablaTransiciones {

    String nombreTabla;
    ArrayList<String> terminales = new ArrayList<>();
    LinkedList<NodoArbol> tablaSiguientes = new LinkedList<>();
    ArrayList<Estado> listaEstados = new ArrayList<>();
    int contEstados;
    ArrayList<Transicion> listaTransiciones = new ArrayList<>();

    /**
     * Constructos de mi clase TablaTransiciones
     *
     * @param nombreTabla
     * @param contEstados
     */
    public TablaTransiciones(String nombreTabla, Estado estado0, ArrayList<String> terminales, LinkedList<NodoArbol> tablaSiguientes) {
        this.nombreTabla = nombreTabla;
        this.tablaSiguientes = tablaSiguientes;
        this.terminales = terminales;
        //Recordar que el estado ya trae sus siguientes que son los first del nodo raíz.
        this.listaEstados.add(estado0);
        this.contEstados = 1;
    }

    /**
     * Método que crea el resto de la tabla de transiciones.
     */
    public void crearTablaTransiciones() {
        listaTransiciones = new ArrayList<>();
        for (int i = 0; i < listaEstados.size(); i++) { //recorrer listaEstados
            Estado estadoActual = listaEstados.get(i);
            ArrayList<Integer> siguientes = estadoActual.siguientesEstado;
            //Agrupar siguientes
            ArrayList<Siguientes> siguientes_Agrupados = agrupar_Siguientes(siguientes);

            for (int j = 0; j < siguientes_Agrupados.size(); j++) { //Recordar que los siguientes_Agrupados vienen siendo siguientes sin caracteres repetidos.
                String caracter = siguientes_Agrupados.get(j).caracter;
                /*
                Verificar la existencia de una transicion con los mismos siguientes.
                 */
                Estado estadoAux = verificarExistenciaTrans(siguientes_Agrupados.get(j).siguientes);
                /*
                Si existe una transicion con los mismos siguientes quiere decir que su Estado destino 
                debería ser el mismo de esa transicion.
                 */
                if (estadoAux != null) {
                    Transicion nuevaTrans = new Transicion(caracter, estadoActual, estadoAux);
                    listaTransiciones.add(nuevaTrans);
                    estadoActual.transiciones.add(nuevaTrans);
                } /*
                Si no se cumplen mutuamente ninguna de las anteriores situaciones quiere decir
                que amerita la construcción de un nuevo estado.
                 */ else {
                    //En caso de un nuevo estado entonces:
                    //Se debe crear ese nuevo Estado.
                    Estado nuevoEstado = new Estado("S" + contEstados, siguientes_Agrupados.get(j).siguientes);
                    contEstados++;
                    if (nuevoEstado.siguientesEstado.contains(tablaSiguientes.size())) { //si dentro de sus siguientes esta el estado #
                        nuevoEstado.aceptacion = true;
                    }
                    //Crear la transición, añadir a listaTransiciones y a la lista del estado.
                    Transicion nuevaTrans = new Transicion(caracter, estadoActual, nuevoEstado);
                    listaTransiciones.add(nuevaTrans);
                    estadoActual.transiciones.add(nuevaTrans);
                    //Por último solo para cierre añadir el nuevoEstado a la listaEstados.
                    listaEstados.add(nuevoEstado);
                }
            }
        }
        //Verificando que todos los nodos aceptación esten bien.
        for (Estado estado : listaEstados) {
            if (estado.transiciones.isEmpty()) {
                estado.aceptacion = true;
            }
        }
    }

    /**
     * Método para encontrar una hoja de la Tabla de siguientes según su número
     * de hoja.
     *
     * @param numHoja
     * @return
     */
    public NodoArbol getHoja(int numHoja) {
        for (NodoArbol hoja : tablaSiguientes) {
            if (hoja.numeroHoja == numHoja) {
                return hoja;
            }
        }
        return null;
    }

    /**
     * Método que me devuelve una transicion tras verificar la existencia de una
     * misma lista de siguientes en la lista de transiciones. Este método lo
     * utilizo principalmente porque me ayuda a ver si no existe ya una
     * transicion con la misma lista de siguientes. Esto es necesario porque si
     * no existe quiere decir que necesito crear un estado nuevo.
     *
     * @param caracter
     * @return
     */
    public Estado verificarExistenciaTrans(ArrayList<Integer> siguientes) {
        for (Estado estado : listaEstados) {
            if (estado.siguientesEstado.equals(siguientes)) {
                return estado;
            }
        }
        return null;
    }

    /**
     * Método para imprimir datos de estados únicamente sirve de desarrollo.
     */
    public void imprimirEstados() {
        System.out.println("///////////////////Tabla de transiciones de: " + nombreTabla + "///////////////////");
        for (Estado estado : listaEstados) {
            System.out.println("[");
            System.out.println("Estado: " + estado.nombreEstado);
            System.out.println("Siguientes: " + estado.siguientesEstado.toString());
            System.out.println("Aceptación: " + estado.aceptacion);
            System.out.println("=========Lista de transiciones==========");
            int i = 0;
            for (Transicion transicion : estado.transiciones) {
                System.out.println(i + ". Caracter: " + transicion.caracter);

                System.out.println("   Origen: " + transicion.origen.nombreEstado);
                System.out.println("   Destino: " + transicion.destino.nombreEstado);
                i++;
            }
            System.out.println("]");
        }
    }

    /**
     * Método para agrupar una lista de siguientes y devolver una lista agrupada
     * de siguientes esto lo realizo para ahorrarme verificaciones mas adelante
     * y facilitarme las verificaciones de siguientes con mismas letras.
     *
     * @param siguientes
     * @return
     */
    public ArrayList<Siguientes> agrupar_Siguientes(ArrayList<Integer> siguientes) {
        ArrayList<Siguientes> siguientes_Agrupados = new ArrayList<>();
        for (Integer siguiente : siguientes) {
            NodoArbol hoja = getHoja(siguiente);
            String caracter = hoja.valor;
            if (!siguientes_Agrupados.isEmpty()) { // Si la lista NO esta vacía.
                boolean existe = false; //booleano que utilizo para verificar si existe o no un siguiente_Agrupado con el mismo caracter.
                for (Siguientes siguiente_Agrupado : siguientes_Agrupados) {
                    if (siguiente_Agrupado.caracter.equals(caracter)) { // de lo contrario se añaden los siguientes no repetidos al grupo ya existente.
                        siguiente_Agrupado.siguientes.addAll(hoja.siguientes);
                        Set<Integer> hashSet = new HashSet<>(siguiente_Agrupado.siguientes);
                        siguiente_Agrupado.siguientes.clear();
                        siguiente_Agrupado.siguientes.addAll(hashSet);
                        Collections.sort(siguiente_Agrupado.siguientes);
                        existe = true;
                    }
                }
                /*
                si no contiene un grupo de siguientes con ese caracter entonces se crea el grupo y se añade a los siguientes_agrupados.
                 */
                if (existe == false) {
                    Siguientes nuevoGrupo_Siguientes = new Siguientes(caracter);
                    nuevoGrupo_Siguientes.siguientes.addAll(hoja.siguientes);
                    siguientes_Agrupados.add(nuevoGrupo_Siguientes);
                }
            } else {
                Siguientes nuevoGrupo_Siguientes = new Siguientes(caracter);
                nuevoGrupo_Siguientes.siguientes.addAll(hoja.siguientes);
                siguientes_Agrupados.add(nuevoGrupo_Siguientes);
            }
        }
        return siguientes_Agrupados;
    }

        /**
     * Paso 6.2 del método del árbol es generar la tabla de transiciones.
     */
    public void crearFicheroDot_TablaTransiciones(String nombreFichero){
        //Parte del String o texto que va a llevar el fichero
        // (en este caso un archivo .dot)
        StringBuilder dot = new StringBuilder();

        dot.append("digraph html { \n");
        dot.append("abc [shape=none, margin=0, label=< \n");
        dot.append("<TABLE BORDER=\"0\" CELLBORDER=\"1\" CELLSPACING=\"0\" CELLPADDING=\"4\">\n");
        dot.append("<TR>\n");
        dot.append("<TD BORDER=\"0\"></TD>\n");
        dot.append("<TD COLSPAN = \"1\" ROWSPAN = \"2\" BGCOLOR=\"skyblue\">ESTADOS</TD>\n");
        dot.append("<TD COLSPAN=\"1000\" BGCOLOR=\"lightgrey\">Σ</TD>\n");
        dot.append("</TR>\n");
        dot.append("<TR>\n");
        dot.append("<TD BORDER=\"0\"></TD>\n");
        /**
         * Primera parte de la tabla (ALFABETO).
         */
        String terminales = generarTerminalesString();
        
        dot.append(terminales);
        dot.append("</TR>\n");
        /**
         * Segunda parte de la tabla (TRANSICIONES).
         */
        String transiciones = generarTransicionesString();
        
        dot.append(transiciones);
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
        dibujar("./" + nombreFichero + ".dot", "./" + nombreFichero + ".svg");
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
    
    /**
     * Método para generar terminales/alfabetos de mi tabla de transiciones.
     * @return 
     */
    private String generarTerminalesString() {
        String cadena = "";
        for (String terminal : terminales) {
            cadena += "<TD>";
            cadena += terminal;
            cadena += "</TD>\n";
        }
        return cadena;
    }

    private String generarTransicionesString() {
        String cadena = "";
        for (Estado estado : listaEstados) {
            cadena += "<TR>\n";
            if (estado.aceptacion) {
                cadena +=  "<TD>ACEPTACION</TD>\n";
            } else {
                cadena +=  "<TD BORDER = \"0\"></TD>\n";
            }
            
            cadena += "<TD>"+estado.nombreEstado+"</TD>\n";
            for (Transicion transicion : estado.transiciones) {
                cadena += "<TD>"+transicion.destino.nombreEstado+"</TD>\n";
            }
            cadena += "</TR>\n";
        }
        return cadena;
    }
}
