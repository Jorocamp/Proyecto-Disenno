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
public class InterrupcionLlamada extends Interrupcion {
    private int piso;
    

    public InterrupcionLlamada(int piso, int tipo){
        super(tipo);
        this.piso = piso;
    }
}
