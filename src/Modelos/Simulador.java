
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.ControladorSimulador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MICHA
 */
public class Simulador extends Thread{

    private Edificio edificio;
    private int cantidadPisos;
    private int cantidadElevadores;
    private int velocidadActual;
    private boolean pausa;
    private boolean debug;
    private boolean next;
    private boolean finalizar;
    private ControladorSimulador cs;
    
    /**
     * Metodos de la clase
     * ******************************************************************************
     */
    
     public Simulador(Edificio edificio, int cantidadPisos, int cantidadElevadores, int velocidadActual, boolean pausa, boolean finalizar,boolean next) {
        this.edificio = edificio;
        this.cantidadPisos = cantidadPisos;
        this.cantidadElevadores = cantidadElevadores;
        this.velocidadActual = velocidadActual;
        this.pausa = pausa;
        this.finalizar = finalizar;
        this.next = next;
        // TODO implement here
    }

    public Simulador() {
    }
    private void iniciarSimulacion(){
        
    }
    
    private void iniciarSimulacionConsola() {
        // TODO implement here
    }

    private void finalizarSimulacion() {
        // TODO implement here
    }

    public void pausarSimulacion() {
        this.pausa = true;
        // TODO implement here
    }

    public void reanudarSimulacion() {
        this.pausa = false;
        // TODO implement here
    }

    private void cambiarVelocidad() {
        // TODO implement here
    }

    private void ejecutarPasoConsola(){
        while(!finalizar){

        }
    }

    private void ejecutarPaso(){
        
    }
    
    private void ejecutarUT(int ut){
        this.cs.getVc().printInicioUT(ut);
        for(int i=0; i < cantidadPisos; i++){
            this.edificio.crearPasajero(i);// Crear Pasajeros
            this.cs.getVc().informeCreacionPasajeros(i, this.edificio.getContadorPasajeros()-1);
            Pasajero pasajero = this.edificio.getArrayPisos().get(i).getColaPasajeros().get(0);
            //if(this.edificio.getArrayPisos().get(i).solicitarElevador(pasajero))// Solicitar Elevador
              //  this.cs.getVc().informeSolicitud(pasajero.getId(), pasajero.getDireccion());
        }
        this.cs.getVc().printFinnalUT(ut);
    }
    public void run(){
        int ut = 0;// Contador de UT
        while(!finalizar){
            try {
                Thread.sleep(this.velocidadActual*1000);// Lag
                  
                while(pausa){
                    //En PAUSA
                    Thread.sleep(1000);// Lag
                }
                if(debug){
                    while(this.isNext()){
                        
                        while(pausa){// En PAUSA dentro de debug
                            
                            Thread.sleep(1000);// Lag para sincronizar prints
                        }
                        Thread.sleep(1000);// Lag para sincronizar prints
                    }
                    this.setNext(true);
                }
                ejecutarUT(ut);// Ejecutar Acciones en la UT
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex); 
            }
            ut++;
        }
    }  
    
    private void procesarSimulacion(){
        
    }
    
    
    /**
     * Getters and Setters para los atributos para la clase
     * ********************************************************************************
     */
    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public int getCantidadElevadores() {
        return cantidadElevadores;
    }

    public void setCantidadElevadores(int cantidadElevadores) {
        this.cantidadElevadores = cantidadElevadores;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isFinalizar() {
        return finalizar;
    }

    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

    public ControladorSimulador getCs() {
        return cs;
    }

    public void setCs(ControladorSimulador cs) {
        this.cs = cs;
    }

    public static void main(String[] args) throws InterruptedException {
        Simulador sim = new Simulador();
        Simulador simInput = sim;
        simInput.start();
        sim.setVelocidadActual(1);
        sim.run();// correr simulacion
    }


    public String numElevadores(){
        return String.valueOf(cantidadElevadores);
    }
    public ArrayList<String> getP3(){
        ArrayList<Elevador> elevadores = edificio.getArrayElevadores();
        ArrayList<String> resultado = new ArrayList<>();
        for(int i = 0; i < elevadores.size(); i++){
            resultado.add(String.valueOf(elevadores.get(i).getProbabilidadBoton()));
        }
        return resultado;
    }
    
    public ArrayList<String> getP4(){
        ArrayList<Elevador> elevadores = edificio.getArrayElevadores();
        ArrayList<String> resultado = new ArrayList<>();
        for(int i = 0; i < elevadores.size(); i++){
            resultado.add(String.valueOf(elevadores.get(i).getProbabilidadInterruptor()));
        }
        return resultado;
    }
    
    
    public ArrayList<String> getUTPisos(){
        ArrayList<Elevador> elevadores = edificio.getArrayElevadores();
        ArrayList<String> resultado = new ArrayList<>();
        for(int i = 0; i < elevadores.size(); i++){
            resultado.add(String.valueOf(elevadores.get(i).getUtPorMovimiento()));
        }
        return resultado;
    }
    
    
    public ArrayList<String> getUTPuertas(){
        ArrayList<Elevador> elevadores = edificio.getArrayElevadores();
        ArrayList<String> resultado = new ArrayList<>();
        for(int i = 0; i < elevadores.size(); i++){
            resultado.add(String.valueOf(elevadores.get(i).getUtPorPuertas()));
        }
        return resultado;
    }
    
    
    public ArrayList<String> getMaxPersonas(){
        ArrayList<Elevador> elevadores = edificio.getArrayElevadores();
        ArrayList<String> resultado = new ArrayList<>();
        for(int i = 0; i < elevadores.size(); i++){
            resultado.add(String.valueOf(elevadores.get(i).getInterior().getCabina().getSensorPeso().getMaximaCantidadPersonas()));
        }
        return resultado;
    }

    public ArrayList<String> getProbabilidadLlamadaPisos(){

        ArrayList<String> arrayProbabilidadLlamada = new ArrayList<String>();
        for(int i = 0; i<cantidadPisos; i++){
            arrayProbabilidadLlamada.add(String.valueOf(edificio.getArrayPisos().get(i).getProbabilidadSolicitud()));
        }
        return arrayProbabilidadLlamada;
    }
    
    public ArrayList<String> getProbabilidadDestinoPisos(){

        ArrayList<String> arrayProbabilidadDestino = new ArrayList<String>();
        for(int i = 0; i<cantidadPisos; i++){
            arrayProbabilidadDestino.add(String.valueOf(edificio.getArrayPisos().get(i).getProbabilidadDestino()));
        }
        return arrayProbabilidadDestino;
    }
}
