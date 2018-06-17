/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Controladores.Controlador;
import Modelos.ConstruirElevador;
import java.util.ArrayList;
/**
 *
 * @author Andres
 * Clase BuilderConcreto que hereda del Builder
 */
public class ConstruirElevadorNormal extends ConstruirElevador{
    
    public void construirExterior(int cantidadPiso){
        ArrayList<Bombillo> bombillos = new ArrayList<Bombillo>();// para el Panel de llegada
        while(cantidadPiso != 0){// Se mete la cantidad de bombillos para los pisos que se desean
            Bombillo bombillo = new Bombillo(false);
            bombillos.add(bombillo);
            cantidadPiso--;
        }
        PanelLlegada panelLlegada = new PanelLlegada(bombillos); // Panel de Llegada 
        SensorPiso sensorPiso = new SensorPiso(0);// Sensor de Piso 
        ElevadorExterior elevadorExterior = new ElevadorExterior(this.elevador,panelLlegada,sensorPiso); 
        this.elevador.setExterior(elevadorExterior);// Agrega elevadorExterior al elevador en construccion
    }

    public void construirInterior(int cantidadPiso,float probabilidadBoton,float probabilidadInterruptor,int maximaCantidadPersonas){

        ArrayList<BotonDestino> botonesDestino = new ArrayList<BotonDestino>();// ArrayList de botones de destino
        
        while(cantidadPiso != 0){
            Bombillo bombillo = new Bombillo(false);// cada boton ocupa un bombillo
            BotonDestino botonDestino = new BotonDestino(bombillo, cantidadPiso-1);// Botones del panel de destino
            botonesDestino.add(botonDestino);
            cantidadPiso--;
        }
        BotonDetenerse botonDetenerse = new BotonDetenerse();   
        PanelDestino panelDestino = new PanelDestino(botonesDestino, botonDetenerse);//se crea panel destino con botones  
        ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();// Lista de pasajeros en la cabina
        
        ElevadorInterior elevadorInterior = new ElevadorInterior();  // se crea nuevo elevador interior  
        
        SensorPeso sensorPeso = new SensorPeso(maximaCantidadPersonas);
        
        Cabina cabina = new Cabina(pasajeros,elevadorInterior,sensorPeso);// Cabina tiene el elevador interior y los pasajeros
        
        elevadorInterior.setPanelDestino(panelDestino);
        elevadorInterior.setElevador(this.elevador);
        elevadorInterior.setCabina(cabina);// elevador interior tiene a la cabina
        
        this.elevador.setInterior(elevadorInterior);
        this.elevador.setProbabilidadBoton(probabilidadBoton);
        this.elevador.setProbabilidadInterruptor(probabilidadInterruptor);
    }
    public void construirMotor(int utPorMovimiento){
        ArrayList<Integer>a = new ArrayList<Integer>();
        Calendarizador calendarizador = new Calendarizador(Direccion.ninguna, a);
        MotorElevador motorElevador = new MotorElevador();
        ArrayList<Interrupcion> colaInterrupciones = new ArrayList<Interrupcion>();
        Controlador controlador = new Controlador(motorElevador, calendarizador, colaInterrupciones);
        motorElevador.setDireccionActual(Direccion.ninguna);
        motorElevador.setElevador(elevador); 
        motorElevador.setControlador(controlador);
        elevador.setMotorElevador(motorElevador);
        Computadora computadora = Computadora.getInstance();
        computadora.getControladores().add(controlador);
        this.elevador.setUtPorMovimiento(utPorMovimiento);
        
    }
    public void construirPuerta(int utPorPuertas){
        Puerta puerta = new Puerta(true, 0);// Empieza en 0. Se debe cambiar en algun momento
        this.elevador.setPuerta(puerta);
        this.elevador.setUtPorPuertas(utPorPuertas);
    }
}
