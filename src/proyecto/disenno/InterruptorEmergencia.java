/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

/**
 *
 * @author Raul
 */
public class InterruptorEmergencia {
    
    boolean estado;
    
    public InterruptorEmergencia(boolean pEstado){
        this.setEstado(pEstado);
    }
    
    public void activarAlarma(){
        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
