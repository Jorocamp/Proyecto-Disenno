/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import java.util.*;
import Modelos.*;

/**DESCRIPCION:
 * 
 *Clase que controla todos los mecanismos para manejar el elevador.
 * @author MICHA
 */
public class Controlador {
    
    
    private MotorElevador motor;
    private Calendarizador calendarizador;
    private ArrayList<Interrupcion> colaInterrupciones;
    private int estadoElevador = 0;

    public Controlador(MotorElevador motor, Calendarizador calendarizador, ArrayList<Interrupcion> colaInterrupciones) {
        this.motor = motor;
        this.calendarizador = calendarizador;
        this.colaInterrupciones = colaInterrupciones;
    }

    
    /**
     * Metodos de la clase
     * ********************************************************************************
     */
    
    
    
     private void mover(Direccion direccionMover) {
        // TODO implement here4
        switch(direccionMover){
            case abajo:
                motor.bajar();
                break;
            case arriba:
                motor.subir();
                break;
            case ninguna:
                motor.detener();
                break;
            default:
                break;
                
        }
        
    }

    private void procesarInterrupcion() {
        // TODO implement here
    }

    public void revisarSiguienteMovimiento() {
        // TODO implement here
        switch(estadoElevador){
            case 0: //Moviendose
                if(calendarizador.comprobarPiso(motor.getElevador().getExterior().getSensorPiso().getPisoActual())){
                    motor.permisoAbrirPuertas();
                    return;
                }
                calendarizador.siguientePiso(motor.getElevador().getExterior().getSensorPiso().getPisoActual(), motor.getDireccionActual());
                Direccion prevista = calendarizador.getDireccionPrevista();
                this.mover(prevista);
                break;
            case 1: //puertas abiertas   
                if(motor.getElevador().getPuerta().getContadorUT() < motor.getElevador().getUtPorPuertas()){
                    motor.getElevador().getPuerta().aumentarUT();
                }
                else{
                    motor.getElevador().getPuerta().cerrarPuertas();
                    estadoElevador = 0;
                }
                break;

                
        }
        
        
        
    }
    
     /**
     * Getters and Setters para la clase
     */
    public MotorElevador getMotor() {
        return motor;
    }

    public void setMotor(MotorElevador motor) {
        this.motor = motor;
    }

    public Calendarizador getCalendarizador() {
        return calendarizador;
    }

    public void setCalendarizador(Calendarizador calendarizador) {
        this.calendarizador = calendarizador;
    }

    public ArrayList<Interrupcion> getColaInterrupciones() {
        return colaInterrupciones;
    }

    public void setColaInterrupciones(ArrayList<Interrupcion> colaInterrupciones) {
        this.colaInterrupciones = colaInterrupciones;
    }

    public int getEstadoElevador() {
        return estadoElevador;
    }

    public void setEstadoElevador(int estadoElevador) {
        this.estadoElevador = estadoElevador;
    }
      
    
    
}
