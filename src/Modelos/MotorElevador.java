/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**DESCRIPCION:
 * Clase usada para manejar el movimiento de un elevador.
 *
 * @author MICHA
 */
public class MotorElevador {
    
    private Direccion direccionActual;

    public MotorElevador(Direccion direccionActual, Elevador elevador) {
        this.direccionActual = direccionActual;
        this.elevador = elevador;
    }
    private Elevador elevador;

    
    /**
     * Metodos de la clase
     */
    

    private void subir() {
        // TODO implement here
    }

    private void bajar() {
        // TODO implement here
    }

    private void detener() {
        // TODO implement here
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
    
    
    
    
}
