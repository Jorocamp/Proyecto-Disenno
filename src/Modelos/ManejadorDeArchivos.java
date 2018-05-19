/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**DESCRIPCION:
 * 
 * Clase encargada para cargar y guardar un archivo de configuracion para el simulador
 *
 * @author MICHA
 */
public class ManejadorDeArchivos {
    
    private String nombreArchivo;
    private String ubicacion;
    private String formato;
    
    
    
    
    /**
     * Metodos de la clase
     * *******************************************************************
     */
    
     private void guardarArchivoConfiguracion() {
        // TODO implement here
    }

     private void cargarArchivoConfiguracion() {
        // TODO implement here
    }
    
    /**
     * Getters and Setters para los atributos de la clase
     * 
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    
    
}
