/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;


//Imports************************************************************
import Controladores.Controlador;
import java.util.*;

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
    private static final Computadora INSTANCE = new Computadora();



    /**
     * Default constructor
     */
    private Computadora() {}
    
    
    //Singleton
    
    public static Computadora getInstance() {
        return INSTANCE;
    }

    /**
     * Metodos de la clase
     * ********************************************************************************
     */
    
    public void asignarInterrupcionDestino() {
        // TODO implement here
    }

    public void asignarInterrupcionLlamada() {
        // TODO implement here
    }
    
    
    public void nuevaInterrupcion(Interrupcion nueva){
  
        //LUEGO LLENO ESTO

        colaInterrupciones.add(nueva);
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
