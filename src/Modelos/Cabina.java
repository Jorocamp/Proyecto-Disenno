/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Cabina {
    private ArrayList<Pasajero> pasajeros;
    private ElevadorInterior elevador;
    private SensorPeso sensorPeso;

    public Cabina(ArrayList<Pasajero> pasajeros, ElevadorInterior elevador, SensorPeso sensorPeso) {
        this.pasajeros = pasajeros;
        this.elevador = elevador;
        this.sensorPeso = sensorPeso;
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

    public SensorPeso getSensorPeso() {
        return sensorPeso;
    }

    public void setSensorPeso(SensorPeso sensorPeso) {
        this.sensorPeso = sensorPeso;
    }

}
