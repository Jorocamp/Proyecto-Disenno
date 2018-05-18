/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Cabina {
    private ArrayList<Pasajero> pasajeros;
    private ElevadorInterior elevador;

    public Cabina(ArrayList<Pasajero> pasajeros, ElevadorInterior elevador) {
        this.pasajeros = pasajeros;
        this.elevador = elevador;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public ElevadorInterior getElevador() {
        return elevador;
    }

    public void setElevador(ElevadorInterior elevador) {
        this.elevador = elevador;
    }


    
    
}
