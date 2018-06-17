/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.Controlador;

/**DESCRIPCION:
 * Clase usada para manejar el movimiento de un elevador.
 *
 * @author MICHA
 */
public class MotorElevador {
    
    private Direccion direccionActual;
    private Elevador elevador;
    private Controlador controlador;
    private InterruptorEmergencia interruptorEmergencia;
    

    public MotorElevador(Direccion direccionActual, Elevador elevador, Controlador controlador,InterruptorEmergencia interruptorEmergencia, int utEmergencia) {
        this.direccionActual = direccionActual;
        this.elevador = elevador;
        this.controlador = controlador;
        this.interruptorEmergencia = interruptorEmergencia;
    }

    public MotorElevador() {
    }
   
    
    /**
     * Metodos de la clase
     */
    

    public void subir() {
        // TODO implement here
        direccionActual = Direccion.arriba;
        int pisoActual = elevador.getExterior().getSensorPiso().getPisoActual();
        elevador.getExterior().getSensorPiso().setPisoActual(pisoActual + 1);
        elevador.getExterior().getSensorPiso().crearInterrupcion();
        
    }

    public void bajar() {
        // TODO implement here
        direccionActual = Direccion.abajo;
        int pisoActual = elevador.getExterior().getSensorPiso().getPisoActual();
        elevador.getExterior().getSensorPiso().setPisoActual(pisoActual - 1);
        elevador.getExterior().getSensorPiso().crearInterrupcion();
    }

    public void detener() {
        // TODO implement here
        direccionActual = Direccion.ninguna;
        
    }
    public void detenerEmergencia() {
        // TODO implement here
        direccionActual = Direccion.ninguna;
        
    }
    
    /**
     * 
     * Getters and setters para la clase
     * ************************************************************************
     */
    
    public Direccion getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(Direccion direccionActual) {
        this.direccionActual = direccionActual;
    }

    public Elevador getElevador() {
        return elevador;
    }

    public void setElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public InterruptorEmergencia getInterruptorEmergencia() {
        return interruptorEmergencia;
    }

    public void setInterruptorEmergencia(InterruptorEmergencia interruptorEmergencia) {
        this.interruptorEmergencia = interruptorEmergencia;
    }
    
    
    public void permisoAbrirPuertas(){
        elevador.getPuerta().abrirPuertas();
        elevador.getPuerta().setContadorUT(0);
        controlador.setEstadoElevador(1);
    }
    
    
    
}
