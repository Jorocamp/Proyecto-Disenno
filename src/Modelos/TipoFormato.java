/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author MICHA
 */
public interface TipoFormato {
    
    
    /**
     * Metodos de la intefaz
     */
    
    /**
     * 
     * @param pP1: Probabilidad de solicitud
     * @param pP2: Probabilidad de escogencia 
     * @param pP3: Probabilidad de detenerse
     * @param pP4: Probabilidad de emergencia
     */
    public boolean guardarArchivo(String pPiso, ArrayList<String> pP1, ArrayList<String> pP2, String pElevadores, ArrayList<String> pP3,
            ArrayList<String> pP4, ArrayList<String> pUTEntrePisos,ArrayList<String> pUTPuertasAbiertas, ArrayList<String> pMaxPersonas,
            String pNombre, String pUbicacion);
    public boolean cargarArchivo(String pNombre, String pUbicacion, ArrayList<Object> pData);
}
