/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MICHA
 */
public class Simulador {

    private Edificio edificio;
    private int cantidadPisos;
    private int cantidadElevadores;
    private int velocidadActual;
    private boolean pausa;
    private boolean debug;
    private boolean finalizar;
    /**
     * Metodos de la clase
     * ******************************************************************************
     */
    
     public Simulador(Edificio edificio, int cantidadPisos, int cantidadElevadores, int velocidadActual, boolean pausa, boolean finalizar) {
        this.edificio = edificio;
        this.cantidadPisos = cantidadPisos;
        this.cantidadElevadores = cantidadElevadores;
        this.velocidadActual = velocidadActual;
        this.pausa = pausa;
        this.finalizar = finalizar;
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

    protected void pausarSimulacion() {
        this.pausa = true;
        // TODO implement here
    }

    protected void reanudarSimulacion() {
        this.pausa = false;
        // TODO implement here
    }

    private void cambiarVelocidad() {
        // TODO implement here
    }

    private void ejecutarPasoConsola(int retraso) throws InterruptedException {
        while(!finalizar){
            ejecutarUT();// Ejecutar Acciones en la UT
            TimeUnit.SECONDS.sleep(retraso);// Lag
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }

    private void ejecutarPaso(){
        
    }
    
    private void ejecutarUT(){
        System.out.println("UT ejecutando...");
    }
    private void procesarSimulacionConsola() throws InterruptedException {
        while(!finalizar){
            
            ejecutarUT();// Ejecutar Acciones en la UT
            TimeUnit.SECONDS.sleep(this.velocidadActual);// Lag 
            
            while(pausa){
                //System.out.println("En PAUSA");
                TimeUnit.SECONDS.sleep(this.velocidadActual);// Lag

            }
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

    
    
    public static void main(String[] args) throws InterruptedException {
        Simulador sim = new Simulador();
        InputThread background = new InputThread(sim);// hilo para inputs
        background.start();
        sim.setVelocidadActual(1);
        sim.procesarSimulacionConsola();// iniciar simulacion
    }
    
  
}
