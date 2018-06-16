/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.nio.file.Files;
import java.util.ArrayList;

/**DESCRIPCION:
 * 
 * Clase encargada para cargar y guardar un archivo de configuracion para el simulador
 *
 * @author MICHA
 */
public class ManejadorDeArchivos {
    
    //Atributos de archivos
    private String nombreArchivo;
    private String ubicacion;
    private String formato;
    //Formatos: json, xml y txt
    
    
    //Datos: nPiso, P1, P2, nElevador, P3, P4, ut puertas, utpiso, maxpersonas
    private ArrayList<Object> datos = new ArrayList<>();
    
    
    
    
    /**
     * Metodos de la clase
     * *******************************************************************
     */
    
    /**
     * Guarda un archivo de acuerdo al formato especificado.
     * @return 
     */
     public boolean guardarArchivoConfiguracion(String pPiso, ArrayList<String> pP1, ArrayList<String> pP2, String pElevadores, ArrayList<String> pP3,
            ArrayList<String> pP4, ArrayList<String> pUTEntrePisos,ArrayList<String> pUTPuertasAbiertas, ArrayList<String> pMaxPersonas) {
        if(this.formato.equals("json")){
            JSON jsonFormat = new JSON();
            jsonFormat.guardarArchivo(pPiso, pP1, pP2, pElevadores, pP3, pP4, pUTEntrePisos, pUTPuertasAbiertas, pMaxPersonas, nombreArchivo, ubicacion);
            return true;
        }
        else{
            if(this.formato.equals("xml")){
               XML xmlFormat = new XML();
               xmlFormat.guardarArchivo(pPiso, pP1, pP2, pElevadores, pP3, pP4, pUTEntrePisos, pUTPuertasAbiertas, pMaxPersonas, nombreArchivo, ubicacion);
               return true;
            }
            else{
                if(this.formato.equals("txt")){
                    
                    Texto txtFormat = new Texto();
                    txtFormat.guardarArchivo(pPiso, pP1, pP2, pElevadores, pP3, pP4, pUTEntrePisos, pUTPuertasAbiertas, pMaxPersonas, nombreArchivo, ubicacion);
                    
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

     public boolean cargarArchivoConfiguracion() {
        JSON jsonFormat = new JSON();
        XML xmlFormat = new XML();
        Texto txtFormat = new Texto();
        String extension = "";

        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0) 
            extension = nombreArchivo.substring(i+1);
            
        if(extension.equals("json") && jsonFormat.cargarArchivo(nombreArchivo, ubicacion, datos)){
            return true;
        }
        else{
            if(extension.equals("xml") && xmlFormat.cargarArchivo(nombreArchivo, ubicacion, datos)){
                return true;
            }
            else{
                if(extension.equals("txt") && txtFormat.cargarArchivo(nombreArchivo, ubicacion, datos)){
                }
                else{
                    return false;
                }
            }
        }
        return false;
        
    }

    public ArrayList<Object> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Object> datos) {
        this.datos = datos;
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


   /* public static void main(String argv[]) {
        ManejadorDeArchivos testing = new ManejadorDeArchivos();
        testing.formato = "txt";
        testing.nombreArchivo = "test1.json";
        testing.ubicacion = "C:\\Users\\MICHA\\Documents\\TEC\\ISem2018\\";
       /* ArrayList<String> p1s = new ArrayList<>();
        p1s.add("0.6");p1s.add("0.2");p1s.add("0.1");
        ArrayList<String> pP2 = new ArrayList<>();
        pP2.add("0.3");pP2.add("0.3");pP2.add("0.4");
        ArrayList<String> pP3 = new ArrayList<>();
        pP3.add("0.1");pP3.add("0.05");
        ArrayList<String> pP4 = new ArrayList<>();
        pP4.add("0.05");pP4.add("0.02");   
        ArrayList<String> pUTEntrePisos = new ArrayList<>();
        pUTEntrePisos.add("1");pUTEntrePisos.add("1");
        ArrayList<String> pUTPuertasAbiertas = new ArrayList<>();
        pUTPuertasAbiertas.add("3");pUTPuertasAbiertas.add("2");
        ArrayList<String> pMaxPersonas = new ArrayList<>();
        pMaxPersonas.add("8");pMaxPersonas.add("7");
        testing.guardarArchivoConfiguracion("3", p1s, pP2, "2", pP3, pP4, pUTEntrePisos, pUTPuertasAbiertas, pMaxPersonas);
       
        testing.cargarArchivoConfiguracion();
        
       for(int i = 0; i < testing.datos.size(); i++){
            System.out.println(testing.datos.get(i));
        }
    }*/
    
}
