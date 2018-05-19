/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;


//Imports************************************************************
import Controladores.Controlador;
import java.util.*;
import proyecto.disenno.Interrupcion;

/**DESCRIPCION:
 * 
 * Clase computadora, se encarga de mantener en el sistema todas las interrupciones y controladores
 * necesarios.
 * 
 * @author MICHA
 */
public class Computadora {
    
 
    /**
     * 
     */
    private ArrayList<Controlador> controladores;
    private ArrayList<Interrupcion> colaInterrupciones;


    /**
     * Default constructor
     */
    public Computadora() {
    }
    
    
    /**
     * Metodos de la clase
     * ********************************************************************************
     */
    
    private void asignarInterrupcionDestino() {
        // TODO implement here
    }

    private void asignarInterrupcionLlamada() {
        // TODO implement here
    }
    
    
    
    
    /**
     * Getters and setters para los atributos de la clase
     * ********************************************************************************** 
     */
    
    public ArrayList<Controlador> getControladores() {
        return controladores;
    }

    public void setControladores(ArrayList<Controlador> controladores) {
        this.controladores = controladores;
    }

    public ArrayList<Interrupcion> getColaInterrupciones() {
        return colaInterrupciones;
    }

    public void setColaInterrupciones(ArrayList<Interrupcion> colaInterrupciones) {
        this.colaInterrupciones = colaInterrupciones;
    }
    
    
}
