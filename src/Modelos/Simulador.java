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
    /**
     * Metodos de la clase
     * ******************************************************************************
     */
    
     public Simulador(Edificio edificio, int cantidadPisos, int cantidadElevadores, int velocidadActual, boolean pausa) {
        this.edificio = edificio;
        this.cantidadPisos = cantidadPisos;
        this.cantidadElevadores = cantidadElevadores;
        this.velocidadActual = velocidadActual;
        this.pausa = pausa;
        // TODO implement here
    }

    public Simulador() {
    }

    private void iniciarSimulacion() {
        // TODO implement here
    }

    private void finalizarSimulacion() {
        // TODO implement here
    }

    private void pausarSimulacion() {
        // TODO implement here
    }

    private void reanudarSimulacion() {
        // TODO implement here
    }

    private void cambiarVelocidad() {
        // TODO implement here
    }

    private void ejecutarPaso(int retraso) throws InterruptedException {
        while(!pausa){
            ejecutarUT();// Ejecutar Acciones en la UT
            TimeUnit.SECONDS.sleep(retraso);// Lag
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }

    private void ejecutarUT(){
        System.out.println("UT ejecutando...");
    }
    public void procesarSimulacion(int retraso) throws InterruptedException {
        while(!pausa){
            ejecutarUT();// Ejecutar Acciones en la UT
            TimeUnit.SECONDS.sleep(retraso);// Lag 
        }
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
    
    public static void main(String[] args) throws InterruptedException {
        
        Simulador sim = new Simulador();
        int retraso = 1;
        sim.ejecutarPaso(retraso);
    }
    
  
}
