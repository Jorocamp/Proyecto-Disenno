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
    
    public String seleccionarPiso(){
        BotonDestino boton = cabinaActual.getElevador().getPanelDestino().getBotones().get(pisoDestino);
        boton.crearInterrupcion(pisoDestino, cabinaActual.getElevador().getElevador().getNumElevador());
        Computadora compu = Computadora.getInstance();
        compu.getControladorSim().enviarDestino(id, (pisoDestino+1));
        return new String("Solicitud Destino: [ Pasajero: "+ (id+1) +" | Piso: "+ (pisoDestino+1)+" ]");
    }
    
    public String presionarBotonDetenerse(Elevador elevadorActual){
        String msj = "";
        Random rand = new Random();
        int porcentajeProbabilidad = rand.nextInt(100 + 1);
        if(porcentajeProbabilidad <= (elevadorActual.getProbabilidadBoton()*100)){
            elevadorActual.getPuerta().setContadorUT(0);
            msj = "Detención: [ Pasajero: "+(this.getId()+1)+" | Elevador: "+ (elevadorActual.getNumElevador()+1) +" ]";
            Computadora compu = Computadora.getInstance();
            compu.getControladorSim().enviarDetener(this.getId(),elevadorActual.getNumElevador());
            
        }
        return msj;
    }
    
    public String usarInterruptorEmergencia(Elevador elevadorActual){
        //ArrayList<String>msjs = new ArrayList<String>();
        String msj = "";
        Random rand = new Random();
        int porcentajeProbabilidad = rand.nextInt(100 + 1);
        if(porcentajeProbabilidad <= (elevadorActual.getProbabilidadInterruptor()*100)){
            elevadorActual.getInterior().getInterruptor().activarAlarma();
            
            msj = "Emergencia: [ Pasajero: "+(this.getId()+1) +" ha usado el Interruptor de Emergencia ]";
            Computadora compu = Computadora.getInstance();
            compu.getControladorSim().enviarEmergencia(this.getId(),elevadorActual.getNumElevador());
            
        }
        return msj;
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
