/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Cabina;

/**
 *
 * @author Raul
 */
public class Pasajero {
    int pisoActual;
    int pisoDestino;
    Cabina cabinaActual;
    
    public Pasajero(int pPisoActual, int pPisoDestino, Cabina pCabina){
        this.setPisoActual(pPisoActual);
        this.setPisoDestino(pPisoDestino);
        this.setCabinaActual(pCabina);
    }
    
    
    public void seleccionarPiso(){
        
    }
    
    public void presionarBotonDetenerse(){
        
    }
    
    public void usarInterruptorEmergencia(){
        
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    public Cabina getCabinaActual() {
        return cabinaActual;
    }

    public void setCabinaActual(Cabina cabinaActual) {
        this.cabinaActual = cabinaActual;
    }
    
    
}
