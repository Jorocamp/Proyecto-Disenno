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
    
    public void construirExterior(){
        
    }
    public void construirInterior(){
        
    }
    public void construirMotor(){
        
    }
    public void construirPuerta(){
        
    }
    public Elevador getElevador(){
        return elevador;
    }
    public void crearElevador(){
        elevador = new Elevador();
    }
}
