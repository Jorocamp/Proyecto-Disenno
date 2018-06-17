/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import java.util.ArrayList;
import Modelos.Piso;
import java.util.Random;

/**
 *
 * @author Andres
 */
public class Edificio {
    private ArrayList<Piso> arrayPisos;
    private ArrayList<Elevador> arrayElevadores;
    private int contadorPasajeros = 0;
    private ArrayList<Pasajero> personas = new ArrayList<>();
    private Simulador simulador;
    
    public Edificio(ArrayList<Piso> arrayPisos,ArrayList<Elevador> arrayElevadores) {
        this.arrayPisos = arrayPisos;
        this.arrayElevadores = arrayElevadores;
    }

    public ArrayList<Piso> getArrayPisos() {
        return arrayPisos;
    }

    public void setArrayPisos(ArrayList<Piso> arrayPisos) {
        this.arrayPisos = arrayPisos;
    }

    public ArrayList<Elevador> getArrayElevadores() {
        return arrayElevadores;
    }

    public void setArrayElevadores(ArrayList<Elevador> arrayElevadores) {
        this.arrayElevadores = arrayElevadores;
    }

    public int getContadorPasajeros() {
        return contadorPasajeros;
    }

    public void setContadorPasajeros(int contadorPasajeros) {
        this.contadorPasajeros = contadorPasajeros;
    }
    public void pulsarBotonLlamada(int pisoActual,int pisoDestino){
        if(pisoDestino > pisoActual)
            this.arrayPisos.get(pisoActual).getPanelLlamada().botonArriba.crearInterrupcion(pisoActual);// si es mayor, pide subir
        else
            this.arrayPisos.get(pisoActual).getPanelLlamada().botonAbajo.crearInterrupcion(pisoActual);// si es menor, pide bajar
    }
    
/*
  Funcion para asignar un piso destino a un pasajero  
\*/   
    public int asignarDestino(int pisoActual,int pisoMaximo){
        Random rand = new Random();
        int pisoDestino = pisoActual;
        int i = 0;
        
        do{
            if(this.arrayPisos.get(i).probabilidad(this.arrayPisos.get(i).getProbabilidadDestino()))
                pisoDestino = i;
            
            i++;
            
            if(i>pisoMaximo)
                i=0;
        }
        while(pisoDestino == pisoActual);// Por si da el mismo piso que el actual, repetir el comando
        return pisoDestino;
    } 
/*
 * Funcion para crear un pasajero en algun piso
 * piso es el piso del edificio en donde se crea el pasajero
 * Se usan funciones de la clase Piso
 * La cabina se deja en null dado que no ha ingresado a ninguna   
 */     
    public Pasajero crearPasajero(int piso){
        if(this.arrayPisos.get(piso).probabilidad(this.arrayPisos.get(piso).getProbabilidadSolicitud())){// Si se da la probabilidad, se solicita el elevador
            Pasajero pasajero = new Pasajero(piso,asignarDestino(piso,this.arrayPisos.size()-1),null,this.contadorPasajeros);// Creacion
            pulsarBotonLlamada(pasajero.pisoActual,pasajero.pisoDestino);// manda la interrupcion a la computadora
            this.arrayPisos.get(piso).getColaPasajeros().add(pasajero);// Agrega el pasajero a la cola de espera del piso respectivo
            this.contadorPasajeros++;
            return pasajero;
        }
        return null;
    }
    
    
    public void ingresarPasajeros(){
        for(int i = 0; i < arrayPisos.size(); i++){
            arrayPisos.get(i).ingresoElevador();
        }
    }
    
    public void generarPasajeros(){
        if(personas.size() > 1000){
                    personas.subList(499,personas.size()).clear();
        }
        
        if(simulador.getBitacora().size() > 1000){
                    simulador.getBitacora().subList(499, simulador.getBitacora().size()).clear();
        }
        for(int i = 0; i < arrayPisos.size(); i++){
            if(arrayPisos.get(i).probabilidad(arrayPisos.get(i).getProbabilidadSolicitud())){
                Pasajero temp = new Pasajero(i,asignarDestino(i,this.arrayPisos.size()-1),null,this.contadorPasajeros);
                
                personas.add(0, temp);
                this.arrayPisos.get(i).getColaPasajeros().add(temp);// Agrega el pasajero a la cola de espera del piso respectivo
                this.contadorPasajeros++;
                
                String sTemp = "CB01 (UT "+ String.valueOf(simulador.getUt()) +"): El pasajero " + String.valueOf(temp.getId()) + " solicitó un elevador en el piso " + String.valueOf(temp.getPisoActual()+1) + " hacia " + temp.getDireccion();
                
                String sTemp1 = "CB05 (UT "+ String.valueOf(simulador.getUt()) +"): La computadora recibió una interrupción, luz del boton de llamada  " + temp.getDireccion() + " del piso " + String.valueOf(temp.getPisoActual()+1) + " encendida" ;
                
                
                simulador.getBitacora().add(0, sTemp);
                arrayPisos.get(i).pulsarBotonLlamada(temp.pisoActual, temp.pisoDestino);
                
                simulador.getBitacora().add(0, sTemp1);
                
            }
        }
    }
    
    public void accionarElevadores(){
        for(int i = 0; i < arrayElevadores.size(); i++){
            arrayElevadores.get(i).getMotorElevador().getControlador().revisarSiguienteMovimiento();
        }
    }
    
  
    public ArrayList<Pasajero> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Pasajero> personas) {
        this.personas = personas;
    }

    public Simulador getSimulador() {
        return simulador;
    }

    public void setSimulador(Simulador simulador) {
        this.simulador = simulador;
    }
    
    public ArrayList<String> estadoElevadores(){
        ArrayList<String> msjs = new ArrayList<String>();
        String msj = "";
        for(int i=0; i<this.arrayElevadores.size(); i++){
            Elevador elevador = this.arrayElevadores.get(i);
            msj = "Elevador "+(i+1)+": [ Piso Actual: "+(elevador.getExterior().getSensorPiso().getPisoActual()+1) +" | Direccion Actual: "+elevador.getMotorElevador().getDireccionActual()+" | Prevista: "+ elevador.getMotorElevador().getControlador().getCalendarizador().getDireccionPrevista() +" ]";
            msjs.add(msj);
        }
        return msjs;
    }
}
