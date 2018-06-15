/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import java.util.*;
import Modelos.*;

/**DESCRIPCION:
 * 
 *Clase que controla todos los mecanismos para manejar el elevador.
 * @author MICHA
 */
public class Controlador {
    
    
    private MotorElevador motor;
    private Calendarizador calendarizador;
    private ArrayList<Interrupcion> colaInterrupciones;

    
    /**
     * Metodos de la clase
     * ********************************************************************************
     */
    
    
    
     private void mover(Direccion direccionMover) {
        // TODO implement here4
        switch(direccionMover){
            case abajo:
                motor.bajar();
                break;
            case arriba:
                motor.subir();
                break;
            case ninguna:
                motor.detener();
                break;
            default:
                break;
                
        }
        
    }

    private void procesarInterrupcion() {
        // TODO implement here
    }

    private void revisarSiguienteMovimiento() {
        // TODO implement here
        Direccion prevista = calendarizador.getDireccionPrevista();
        this.mover(prevista);
        
        
    }
    
    private void configurarSimulacion(Simulador simulador,ArrayList<Object> parametrosConfiguracion){
        /* El ArrayList parametrosConfiguracion contiene todos los parametros que se utilizaran para la configuracion
            del sistema de simulacion. Entre estos parametros estan: cantidad pisos, ArrayList con la probabilidad #1,
            ArrayList con la probabilidad #2, ArrayList con la probabilidad #3, ArrayList con la probabilidad #4, la cantidad de
            UT que tarda un elevador de un piso a otro, la canridad de UT que tarda un elevador con las puertas abiertas y 
            la cantidad de personas que entran en un elevador*/
        simulador.setCantidadPisos(Integer.parseInt(parametrosConfiguracion.get(0).toString()));
        Edificio edificio = simulador.getEdificio();
        
        ArrayList<Piso> arrayPisos = new ArrayList<Piso>();
        for(int i=0; i<simulador.getCantidadPisos(); i++){
            
            
            ArrayList<Float> arrayListProbSolicitud = new ArrayList<Float>();
            arrayListProbSolicitud = (ArrayList<Float>) parametrosConfiguracion.get(1);
            
            ArrayList<Float> arrayListProbDestino = new ArrayList<Float>();
            arrayListProbDestino = (ArrayList<Float>) parametrosConfiguracion.get(2);
            
            arrayPisos.add(new Piso(i, arrayListProbSolicitud.get(i), arrayListProbDestino.get(i), new ArrayList<ElevadorExterior>(), new PanelLlamada(), new ArrayList<Pasajero>()));
        }
        
        ArrayList<Elevador> arrayElevadores = new ArrayList<Elevador>();
        for(int i=0; i<simulador.getCantidadElevadores(); i++){
            DirectorDeElevador director = new DirectorDeElevador();
            director.setConstructorElevador(new ConstruirElevadorNormal());
            
            ArrayList<Float> arrayListProbBoton = new ArrayList<Float>();
            arrayListProbBoton = (ArrayList<Float>) parametrosConfiguracion.get(3);
            
            ArrayList<Float> arrayListProbPalanca = new ArrayList<Float>();
            arrayListProbPalanca = (ArrayList<Float>) parametrosConfiguracion.get(4);
            
            ArrayList<Integer> arrayListUTMovimiento = new ArrayList<Integer>();
            arrayListUTMovimiento = (ArrayList<Integer>) parametrosConfiguracion.get(5);
            
            ArrayList<Integer> arrayListUTPuertas = new ArrayList<Integer>();
            arrayListUTPuertas = (ArrayList<Integer>) parametrosConfiguracion.get(6);
            
            ArrayList<Integer> arrayListCantidadPersonas = new ArrayList<Integer>();
            arrayListCantidadPersonas = (ArrayList<Integer>) parametrosConfiguracion.get(7);
            
            
            director.construirElevador(Integer.parseInt(parametrosConfiguracion.get(0).toString()), arrayListProbBoton.get(i), 
                    arrayListProbPalanca.get(i), arrayListUTMovimiento.get(i), arrayListUTPuertas.get(i), arrayListCantidadPersonas.get(i));
            arrayElevadores.add(director.getElevador());
        }
        edificio.setArrayPisos(arrayPisos);
        edificio.setArrayElevadores(arrayElevadores);
        
    }
    
    
     /**
     * Getters and Setters para la clase
     */
    public MotorElevador getMotor() {
        return motor;
    }

    public void setMotor(MotorElevador motor) {
        this.motor = motor;
    }

    public Calendarizador getCalendarizador() {
        return calendarizador;
    }

    public void setCalendarizador(Calendarizador calendarizador) {
        this.calendarizador = calendarizador;
    }

    public ArrayList<Interrupcion> getColaInterrupciones() {
        return colaInterrupciones;
    }

    public void setColaInterrupciones(ArrayList<Interrupcion> colaInterrupciones) {
        this.colaInterrupciones = colaInterrupciones;
    }
      
    
    
}
