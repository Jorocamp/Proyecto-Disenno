/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andres
 */
public class Piso {

    private int numeroPiso;
    private float probabilidadSolicitud;
    private float probabilidadDestino;
    private ArrayList<ElevadorExterior> elevadores;
    private PanelLlamada panelLlamada;
    private ArrayList<Pasajero> colaPasajeros;

    public Piso(int numeroPiso, float probabilidadSolicitud, float probabilidadDestino, ArrayList<ElevadorExterior> elevadores, PanelLlamada panelLlamada, ArrayList<Pasajero> colaPasajeros) {
        this.numeroPiso = numeroPiso;
        this.probabilidadSolicitud = probabilidadSolicitud;
        this.probabilidadDestino = probabilidadDestino;
        this.elevadores = elevadores;
        this.panelLlamada = panelLlamada;
        this.colaPasajeros = colaPasajeros;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public float getProbabilidadSolicitud() {
        return probabilidadSolicitud;
    }

    public void setProbabilidadSolicitud(float probabilidadSolicitud) {
        this.probabilidadSolicitud = probabilidadSolicitud;
    }

    public float getProbabilidadDestino() {
        return probabilidadDestino;
    }

    public void setProbabilidadDestino(float probabilidadDestino) {
        this.probabilidadDestino = probabilidadDestino;
    }

    public ArrayList<ElevadorExterior> getElevadores() {
        return elevadores;
    }

    public void setElevadores(ArrayList<ElevadorExterior> elevadores) {
        this.elevadores = elevadores;
    }

    public PanelLlamada getPanelLlamada() {
        return panelLlamada;
    }

    public void setPanelLlamada(PanelLlamada panelLlamada) {
        this.panelLlamada = panelLlamada;
    }

    public ArrayList<Pasajero> getColaPasajeros() {
        return colaPasajeros;
    }

    public void setColaPasajeros(ArrayList<Pasajero> colaPasajeros) {
        this.colaPasajeros = colaPasajeros;
    }
/*
 * Funcion de Probabilidad para ejecutar o no una accion. Retorna boolean
 * probSobreCien es la probabilidad sobre 100 que se busca   
 */    
    public boolean probabilidad(float probSobreCien){
        Random rand = new Random();
        return (rand.nextInt(100) + 0) <= probSobreCien*100;
    }
    
 /*
 * Funcion para tocar algun boton de llamada
 * 
 */ 
    public void pulsarBotonLlamada(int pisoActual,int pisoDestino){
        if(pisoDestino > pisoActual)
            panelLlamada.botonArriba.crearInterrupcion(pisoActual);// si es mayor, pide subir
        else
            panelLlamada.botonAbajo.crearInterrupcion(pisoActual);// si es menor, pide bajar
    }
    

/*
 * Funcion para crear pasajero y solicitar elevador en un piso
 * 
 */ 
    public boolean solicitarElevador(Pasajero pasajero){
        if(probabilidad(probabilidadSolicitud)){// Si se da la probabilidad, se solicita el elevador
            pulsarBotonLlamada(pasajero.pisoActual,pasajero.pisoDestino);// manda la interrupcion a la computadora
            System.out.println("Si hay solicitud del pasajero "+pasajero.getId());
            return true;
        }
        return false;
    }
    
    public void ingresoElevador(){
        for(int i = 0;i < this.elevadores.size() ;i ++){// Para cada elevador del piso:
            // Revisa todos los que estan con puerta abierta y con espacio para mas personas
            if(this.elevadores.get(i).getElevador().getPuerta().isEstado() || this.elevadores.get(i).getElevador().getInterior().getCabina().getPasajeros().size() < this.elevadores.get(i).getElevador().getInterior().getCabina().getSensorPeso().getMaximaCantidadPersonas()){
                // Mientras la capacidad maxima no sea alcanzada:
                while(this.elevadores.get(i).getElevador().getInterior().getCabina().getPasajeros().size() < this.elevadores.get(i).getElevador().getInterior().getCabina().getSensorPeso().getMaximaCantidadPersonas()){
                    // Agrega el pasajero a la cabina
                    this.elevadores.get(i).getElevador().getInterior().getCabina().getPasajeros().add(this.colaPasajeros.get(0));
                    // Remueve el pasajero de la cola de espera
                    this.colaPasajeros.remove(0);
                }
            }
        }
    }

}
