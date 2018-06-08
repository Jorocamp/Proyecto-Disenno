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
public class InterrupcionSensor extends Interrupcion {
    
    private int piso;

    public InterrupcionSensor(int piso) {
        this.piso = piso;
    }
    
    

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
    
    
    
}
