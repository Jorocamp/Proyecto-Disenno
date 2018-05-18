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
public class Piso {

    private int numeroPiso;
    private float probabilidadSolicitud;
    private float probabilidadDestino;
    private ArrayList<ElevadorExterior> elevadores;
    private PanelLlamada panelLlamada;
    private ArrayList<Pasajero> colaPasajeros;

    public Piso(int numeroPiso, float probabilidadSolicitud, float probabilidadDestino, ArrayList<ElevadorExterior> elevadores, PanelLlamada panelLlamada, ArrayList<Pasajero> colaPasajeros) {
        this.numeroPiso = numeroPiso;
        this.probabilidadSolicitud = probabilidadSolicitud;
        this.probabilidadDestino = probabilidadDestino;
        this.elevadores = elevadores;
        this.panelLlamada = panelLlamada;
        this.colaPasajeros = colaPasajeros;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public float getProbabilidadSolicitud() {
        return probabilidadSolicitud;
    }

    public void setProbabilidadSolicitud(float probabilidadSolicitud) {
        this.probabilidadSolicitud = probabilidadSolicitud;
    }

    public float getProbabilidadDestino() {
        return probabilidadDestino;
    }

    public void setProbabilidadDestino(float probabilidadDestino) {
        this.probabilidadDestino = probabilidadDestino;
    }

    public ArrayList<ElevadorExterior> getElevadores() {
        return elevadores;
    }

    public void setElevadores(ArrayList<ElevadorExterior> elevadores) {
        this.elevadores = elevadores;
    }

    public PanelLlamada getPanelLlamada() {
        return panelLlamada;
    }

    public void setPanelLlamada(PanelLlamada panelLlamada) {
        this.panelLlamada = panelLlamada;
    }

    public ArrayList<Pasajero> getColaPasajeros() {
        return colaPasajeros;
    }

    public void setColaPasajeros(ArrayList<Pasajero> colaPasajeros) {
        this.colaPasajeros = colaPasajeros;
    }




}
