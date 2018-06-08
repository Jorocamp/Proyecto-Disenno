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
        return (rand.nextInt(100) + 0) <= probSobreCien;
    }
    
/*
 * Funcion para crear pasajeros en el piso actual
 * cantidadPasajeros es el numero de nuevos pasajeros que se crean 
 * Los pasajeros se crean con el piso distino igual al actual y sin cabinaActual (o sea null)
 */     
    public void crearPasajeros(int cantidadPasajeros){

    }
 /*
 * Funcion para tocar algun boton de llamada
 * 
 */ 
    public void pulsarBotonLlamada(int numPiso){
        if(numPiso == 1)
            panelLlamada.botonArriba.crearInterrupcion();// si es el primer piso solo se puede arriba
        else
        if(numPiso == 6)
            panelLlamada.botonAbajo.crearInterrupcion();// sexto solo abajo
        else
            if(probabilidad(50))// casos del 2 al 5 hay 1/2 probabilidad de escoger algun boton
                panelLlamada.botonAbajo.crearInterrupcion();
            else
                panelLlamada.botonArriba.crearInterrupcion();
    }
/*
 * Funcion para solicitar elevador en un piso
 * 
 */ 
    public void solicitarElevador(int numeroElevador){
        if(probabilidad(probabilidadSolicitud)){
            Pasajero nuevo = new Pasajero(numeroPiso, numeroPiso, null);// Creacion del pasajero
            pulsarBotonLlamada(numeroPiso);// manda la interrupcion a la computadora
            colaPasajeros.add(nuevo);// Añadir a la lista de espera
        }
    }
}
