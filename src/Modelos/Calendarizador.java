/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Direccion;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Andres
 */
public class Calendarizador {
    private Direccion direccionPrevista;
    private ArrayList<Integer> pisosCalendarizados;

    public Calendarizador(Direccion direccionPrevista, ArrayList<Integer> pisosCalendarizados) {
        this.direccionPrevista = direccionPrevista;
        this.pisosCalendarizados = pisosCalendarizados;
    }

    public Direccion getDireccionPrevista() {
        return direccionPrevista;
    }

    public void setDireccionPrevista(Direccion direccionPrevista) {
        this.direccionPrevista = direccionPrevista;
    }

    public ArrayList<Integer> getPisosCalendarizados() {
        return pisosCalendarizados;
    }

    public void setPisosCalendarizados(ArrayList<Integer> pisosCalendarizados) {
        this.pisosCalendarizados = pisosCalendarizados;
    }


    public void calendarizarPiso(int piso){
        int banderaRep = 0;
        for(int i = 0; i<pisosCalendarizados.size(); i++){
            if(pisosCalendarizados.get(i) == piso){
                banderaRep = 1;
                break;
            }
        }
        if(banderaRep == 0){
            pisosCalendarizados.add(piso);
        }
        
    }
    
    
    public void revisarPisosAbajo(int piActual){
        
        for(int i = 0; i < pisosCalendarizados.size(); i++){
          if(pisosCalendarizados.get(i) < piActual){
                    direccionPrevista = Direccion.abajo;
            }
      
        }
       direccionPrevista = Direccion.arriba;
    }
    
        public void revisarPisosArriba(int piActual){
        
        for(int i = 0; i < pisosCalendarizados.size(); i++){
          if(pisosCalendarizados.get(i) > piActual){
                    direccionPrevista = Direccion.arriba;
            }
      
        }
       direccionPrevista = Direccion.abajo;
    }
        
     public void revisarPisosNinguna(int piActual){
       if(piActual > cercano(piActual))
           direccionPrevista = Direccion.abajo;
       else
           direccionPrevista = Direccion.arriba;
    }
    
    public int cercano(int piActual){
        
        int distance = Math.abs(pisosCalendarizados.get(0) - piActual);
        int idx = 0;
        for(int c = 1; c < pisosCalendarizados.size(); c++){
            int cdistance = Math.abs(pisosCalendarizados.get(c) - piActual);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return pisosCalendarizados.get(idx);
    }
    
    public void siguientePiso(int piActual, Direccion dirActual){
            
        if(pisosCalendarizados.size() != 0){
                if(dirActual.equals(Direccion.abajo)){
                    revisarPisosAbajo(piActual);
                }
                if(dirActual.equals(Direccion.arriba)){
                    revisarPisosArriba(piActual);
                }
                else{
                    revisarPisosNinguna(piActual);
                }
            }
            else{
                direccionPrevista = Direccion.ninguna;
            }
        
            
        
    }
    
    public boolean comprobarPiso(int pisoActual){
        for(int i = 0; i < pisosCalendarizados.size(); i++){
            if(pisoActual == pisosCalendarizados.get(i)){
                return true;
            }
        }
        return false;
    }
    
}
