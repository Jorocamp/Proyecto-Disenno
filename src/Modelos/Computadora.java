/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;


//Imports************************************************************
import Controladores.Controlador;
import Controladores.ControladorSimulador;
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
    private ControladorSimulador controladorSim;


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
        ArrayList<Interrupcion> interrupciones = null;
        interrupciones = colaInterrupciones;
        for(int i = 0; i<interrupciones.size(); i++){
            Interrupcion inter2 = interrupciones.get(i);
            if(inter2.getTipo() == 1){
                InterrupcionDestino inter = (InterrupcionDestino) interrupciones.get(i);
            
                for(int j = 0; j<controladores.size(); j++){
                    Controlador contr = controladores.get(j);
                    if(contr.getMotor().getElevador().getNumElevador() == inter.getNumElev()){
                        contr.getColaInterrupciones().add(inter);
                        contr.getCalendarizador().calendarizarPiso(inter.getPiso());
                        colaInterrupciones.remove(i);
                    }
                }
            }
            
        }
    }

    public void asignarInterrupcionLlamada() {
        // TODO implement here
        ArrayList<Interrupcion> interrupciones = null;
        interrupciones = colaInterrupciones;
        for(int i = 0; i<interrupciones.size(); i++){
  
            Interrupcion inter2 = interrupciones.get(i);
            
            if(inter2.getTipo() == 0){
                InterrupcionLlamada inter = (InterrupcionLlamada) interrupciones.get(i);
                int calificacion = 0;
                int calificacionMax = 0;
                int mejorElevador = 0;
                for(int j = 0; j<controladores.size(); j++){
                    Controlador contr = controladores.get(j);
                    int pisoElevador = contr.getMotor().getElevador().getExterior().getSensorPiso().getPisoActual();
                    if(contr.getMotor().getDireccionActual() == inter.getDireccion()){
                        calificacion += 40;
                    }
                    else if(contr.getMotor().getDireccionActual() == Direccion.ninguna){
                        calificacion += 30;
                    }
                    int difPisos = (pisoElevador - inter.getPiso());
                    if(difPisos < 0)
                        difPisos = difPisos * -1;
                    calificacion += 30 - (difPisos * 3);
                    difPisos = 0;
                    for(int n = 0; n<contr.getCalendarizador().getPisosCalendarizados().size(); n++){
                        int pisoCalendarizado = contr.getCalendarizador().getPisosCalendarizados().get(n);
                        if(contr.getMotor().getDireccionActual() == Direccion.abajo){
                            if(pisoCalendarizado < pisoElevador && pisoCalendarizado > inter.getPiso()){
                                difPisos++;
                            }
                        }else if(contr.getMotor().getDireccionActual() == Direccion.arriba){
                            if(pisoCalendarizado > pisoElevador && pisoCalendarizado < inter.getPiso()){
                                difPisos++;
                                
                            }
                        }
                    }
                    calificacion += 30 - (difPisos * 3);
                    
                    if(calificacion > calificacionMax){
                        calificacionMax = calificacion;
                        mejorElevador = j;
                        calificacion = 0;
                    }
                    difPisos = 0;
                }
                Controlador contr = controladores.get(mejorElevador);
                contr.getColaInterrupciones().add(inter);
                controladorSim.recibirMejorElevador(contr.getMotor().getElevador().getNumElevador(), inter.getPiso());
                contr.getCalendarizador().calendarizarPiso(inter.getPiso());
                colaInterrupciones.remove(i);
            }
            
        }
        
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

    public ControladorSimulador getControladorSim() {
        return controladorSim;
    }

    public void setControladorSim(ControladorSimulador controladorSim) {
        this.controladorSim = controladorSim;
    }
    
    
    
    
}
