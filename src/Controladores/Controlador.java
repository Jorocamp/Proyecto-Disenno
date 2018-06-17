/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import java.util.*;
import Modelos.*;
import java.util.function.Predicate;

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
            case 0: //Prevista
                //System.out.println("Elevador: " + motor.getElevador().getNumElevador());
                //System.out.println(calendarizador.getPisosCalendarizados().size());
                if(calendarizador.comprobarPiso(motor.getElevador().getExterior().getSensorPiso().getPisoActual())){
                    int actual = motor.getElevador().getExterior().getSensorPiso().getPisoActual();
                    Predicate<Integer> predicate = p-> p == actual;
                    calendarizador.getPisosCalendarizados().removeIf(predicate);
                    motor.setDireccionActual(Direccion.ninguna);   
                    motor.permisoAbrirPuertas();
                    calendarizador.setDireccionPrevista(Direccion.ninguna);
                    break;
                }
                calendarizador.siguientePiso(motor.getElevador().getExterior().getSensorPiso().getPisoActual(), motor.getDireccionActual());
                estadoElevador = 2;
                break;
            case 1: //puertas abiertas   
                if(motor.getElevador().getPuerta().getContadorUT() < motor.getElevador().getUtPorPuertas()){
                    motor.getElevador().getPuerta().aumentarUT();
                    calendarizador.setDireccionPrevista(Direccion.ninguna);
                }
                else{
                    motor.getElevador().getPuerta().cerrarPuertas();
                    estadoElevador = 0;
                }
                break;
            case 2: //Hacer movimiento
                Direccion prevista = calendarizador.getDireccionPrevista();
                this.mover(prevista);
                
                estadoElevador = 0;
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
