/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private void ejecutarPasoConsola(){
        while(!finalizar){

        }
    }

    private void ejecutarPaso(){
        
    }
    
    private void ejecutarUT(){
        System.out.println("UT ejecutando...");
    }
    private void procesarSimulacionConsola() throws InterruptedException {
        while(!finalizar){
            TimeUnit.SECONDS.sleep(this.velocidadActual);// Lag
            ejecutarUT();// Ejecutar Acciones en la UT
             
            while(pausa){
                //En PAUSA
                TimeUnit.SECONDS.sleep(1);// Lag
            }
            if(debug){
                while(this.isNext()){

                    while(pausa){
                        // En PAUSA 2
                        TimeUnit.SECONDS.sleep(1);// Lag
                    }
                    TimeUnit.SECONDS.sleep(1);// Lag
                }
                this.setNext(true);
            } 
        }
    }  
    
    private void procesarSimulacion(){
        
    }
    
    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String sec = " segundos";
        
        while(true){
            switch(sc.nextInt()){            
                case 0:{// ENTER para pausar
                System.out.println("\nPAUSA\n");
                
                pausarSimulacion();
                
                System.out.println("Valor de pausa cambiado a:\t" + isPausa());
                System.out.println("");
                
                while(isPausa()){// Pausa => Menu de simulador
                    
                    System.out.println("\nMenú de Simulación\n");
                    System.out.println("1. Reanudar");
                    System.out.println("2. Cambiar Raul");
                    System.out.println("3. Cambiar Modalidad");
                    System.out.println("");
                    System.out.print("Elija una opción: ");
                    input = sc.nextInt();
                    
                    switch (input){
                        case 1:{        // REANUDAR
                            reanudarSimulacion();
                            System.out.println("\nValor de pausa cambiado a:\t" + isPausa());
                            break;
                        }
                        case 2:{        // CAMBIAR RETARDO
                            System.out.println("\nRetardo actual: "+ getVelocidadActual());
                            System.out.print("Digite un nuevo retardo(segundos): ");
                            input = sc.nextInt();
                            if(input <= 0){
                                System.out.println("\nERROR: El retardo debe ser positivo.");
                                break;
                            }
                            if(input==1)
                                sec=" segundo";
                            setVelocidadActual(input);
                            System.out.println("\nEl nuevo retardo es "+ input + sec);
                            sec = " segundos";
                            break;
                        }
                        case 3:{        // CAMBIAR MODALIDAD
                            setDebug(!isDebug());
                            if(isDebug())
                                System.out.println("\nSe ha cambiado a Modo Depurador.\n");
                            else
                                System.out.println("\nSe ha cambiado a Modo Normal.\n");
                            break;
                        }
                    }
                }
            }
            case 1:{
                //sc.next();
                if(isDebug()){
                    setNext(false);
                    System.out.println("next is false");
                }
            }
            }
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

    public static void main(String[] args) throws InterruptedException {
        Simulador sim = new Simulador();
        Simulador simInput = sim;
        simInput.start();
        sim.setVelocidadActual(1);
        sim.procesarSimulacionConsola();// correr simulacion
    }

}
