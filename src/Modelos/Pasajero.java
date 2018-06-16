/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Cabina;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Raul
 */
public class Pasajero {
    int pisoActual;
    int pisoDestino;
    Cabina cabinaActual;
    int elevadorActual = -1;
    int id;
    
    public Pasajero(int pPisoActual, int pPisoDestino, Cabina pCabina, int id){
        this.setPisoActual(pPisoActual);
        this.setPisoDestino(pPisoDestino);
        this.setCabinaActual(pCabina);
        this.setId(id);
    }
    public Pasajero(){
        
    }
    
    public void seleccionarPiso(ArrayList<Piso> arrayPisos){
        for(int i = 0; i<arrayPisos.size(); i++){
            if(arrayPisos.get(i).probabilidad(arrayPisos.get(i).getProbabilidadDestino())){
                this.setPisoDestino(arrayPisos.get(i).getNumeroPiso());
                break;
            }
        }
    }
    
    public void presionarBotonDetenerse(Elevador elevadorActual){
        elevadorActual.getPuerta().aumentarUT(elevadorActual.getUtPorPuertas());
    }
    
    public void usarInterruptorEmergencia(Elevador elevadorActual){
        Random rand = new Random();
        int porcentajeProbabilidad = rand.nextInt(100 + 1);
        if(porcentajeProbabilidad <= (elevadorActual.getProbabilidadInterruptor()*100)){
            elevadorActual.getInterior().getInterruptor().activarAlarma();
        }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDireccion(){
        if(this.pisoDestino>this.pisoActual)
            return "arriba";
        return "abajo";
    }
    
}
