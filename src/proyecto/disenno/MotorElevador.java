/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

/**DESCRIPCION:
 * Clase usada para manejar el movimiento de un elevador.
 *
 * @author MICHA
 */
public class MotorElevador {
    
    private Direccion direccionActual;
    private Elevador elevador;

    
    
    
    
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
