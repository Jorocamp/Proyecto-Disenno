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
public class InterrupcionDestino extends Interrupcion {
    
    private int piso;
    private int numElev;
    
    public InterrupcionDestino(int piso, int tipo, int numElev){
        super(tipo);
        this.piso = piso;
        this.numElev = numElev;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumElev() {
        return numElev;
    }

    public void setNumElev(int numElev) {
        this.numElev = numElev;
    }
    
    
}
