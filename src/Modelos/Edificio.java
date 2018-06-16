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
    public void crearPasajero(int piso){
        Pasajero pasajero = new Pasajero(piso,asignarDestino(piso,this.arrayPisos.size()-1),null,this.contadorPasajeros);// Creacion
        this.arrayPisos.get(piso).getColaPasajeros().add(pasajero);// Agrega el pasajero a la cola de espera del piso respectivo
        this.contadorPasajeros++;
        System.out.println("Pasajero: "+pasajero.getId()+ " Actual: "+pasajero.getPisoActual() + " Destino: " +pasajero.getPisoDestino());
    }

}
