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
            System.out.println("Pasajero: "+pasajero.getId()+ " Actual: "+pasajero.getPisoActual() + " Destino: " +pasajero.getPisoDestino());
            return pasajero;
        }
        return null;
    }
    
    
    public void generarPasajeros(){
        for(int i = 0; i < arrayPisos.size(); i++){
            if(arrayPisos.get(i).probabilidad(arrayPisos.get(i).getProbabilidadSolicitud())){
                Pasajero temp = new Pasajero(i,asignarDestino(i,this.arrayPisos.size()-1),null,this.contadorPasajeros);
                if(personas.size() > 500){
                    personas.remove(0);
                }
                personas.add(temp);
                this.arrayPisos.get(i).getColaPasajeros().add(temp);// Agrega el pasajero a la cola de espera del piso respectivo
                this.contadorPasajeros++;
        
            }
        }
    }
    
    public ArrayList<String> enviarPasajeros(){
        ArrayList<String> resultado = new ArrayList<>();
        
        for(int i = 0; i < personas.size(); i++){
            String temp = "Pasajero: ";
            temp = temp + String.valueOf(personas.get(i).id);
            temp = temp + " | Piso Actual: ";
            temp = temp + String.valueOf(personas.get(i).pisoActual);
            temp = temp + " | Piso Destino: ";
            temp = temp + String.valueOf(personas.get(i).pisoDestino);
            temp = temp + " | Elevador Actual: ";
            if(personas.get(i).elevadorActual == -1){
                temp = temp + "Esperando elevador ";
            }
            else{
                temp = temp + String.valueOf(personas.get(i).elevadorActual);
            }
            
            resultado.add(0, temp);
            
        }
        return resultado; 
    }
    

}
