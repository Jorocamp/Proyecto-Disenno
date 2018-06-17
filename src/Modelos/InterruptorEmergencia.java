/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Raul
 */
public class InterruptorEmergencia {
    private MotorElevador motor;
    private boolean estado;
    
    public InterruptorEmergencia(boolean pEstado){
        this.setEstado(pEstado);
    }
    
    public void activarAlarma(){
        this.estado = true;
        this.motor.detenerEmergencia();
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public MotorElevador getMotor() {
        return motor;
    }

    public void setMotor(MotorElevador motor) {
        this.motor = motor;
    }
    
    
}
