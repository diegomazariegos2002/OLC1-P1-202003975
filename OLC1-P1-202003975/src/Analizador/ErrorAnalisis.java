package Analizador;

/**
 * Clase para el manejo de errores en la compilación.
 * @author Melissa
 */
public class ErrorAnalisis {

    /**
     * @return the tipo_Error
     */
    public Tipo_Error getTipo_Error() {
        return tipo_Error;
    }

    /**
     * @param tipo_Error the tipo_Error to set
     */
    public void setTipo_Error(Tipo_Error tipo_Error) {
        this.tipo_Error = tipo_Error;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the linea
     */
    public String getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * @return the columna
     */
    public String getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(String columna) {
        this.columna = columna;
    }

    public static enum Tipo_Error {
        LEXICO,
        SINTACTICO
    }

    private Tipo_Error tipo_Error;
    private String descripcion;
    private String linea;
    private String columna;

    public ErrorAnalisis(Tipo_Error tipo_Error, String descripcion, String linea, String columna) {
        this.tipo_Error = tipo_Error;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "ErrorAnalisis{" + "tipo_Error=" + tipo_Error + ", descripcion=" + descripcion + ", linea=" + linea + ", columna=" + columna + '}';
    }
    
    
}
