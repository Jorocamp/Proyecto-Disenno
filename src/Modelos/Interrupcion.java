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
public class Interrupcion {
    private int tipo;
    //0 para InterrupcionLlamada, 1 para InterrupcionDestino y 2 para InterrupcionSensor
    
    public Interrupcion(int tipo){
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
