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

    private void revisarSiguienteMovimiento() {
        // TODO implement here
        Direccion prevista = calendarizador.getDireccionPrevista();
        this.mover(prevista);
        
        
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
      
    
    
}
