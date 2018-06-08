/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Andres
 * Clase abstracta Builder
 */
public abstract class ConstruirElevador {
    protected Elevador elevador;
    
    public abstract void construirExterior(int cantidadPisos);
    public abstract void construirInterior(int cantidadPisos,float probabilidadBoton,float probabilidadInterruptor);
    public abstract void construirMotor(int utPorMovimiento);
    public abstract void construirPuerta(int utPorPuertas);
    
    public Elevador getElevador(){
        return elevador;
    }
    public void crearElevador(){
        elevador = new Elevador();
    }
}
