/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
import Modelos.ConstruirElevador;
import java.util.ArrayList;
/**
 *
 * @author Andres
 * Clase BuilderConcreto que hereda del Builder
 */
public class ConstruirElevadorNormal extends ConstruirElevador{
    
    public void construirExterior(){
        Bombillo bombillo0,bombillo1,bombillo2,bombillo3,bombillo4,bombillo5; // Bombillos del panel de llegada 
        bombillo0 = new Bombillo();
        bombillo1 = new Bombillo();
        bombillo2 = new Bombillo();
        bombillo3 = new Bombillo();
        bombillo4 = new Bombillo();
        bombillo5 = new Bombillo();
        
        
        ArrayList<Bombillo> bombillos = new ArrayList<Bombillo>();// para el Panel de llegada
        bombillos.add(bombillo0);
        bombillos.add(bombillo1);// Se agregan los bombillos previamente iniciados
        bombillos.add(bombillo2);
        bombillos.add(bombillo3);
        bombillos.add(bombillo4);
        bombillos.add(bombillo5);

        PanelLlegada panelLlegada = new PanelLlegada(bombillos); // Panel de Llegada
        
        SensorPiso sensorPiso = new SensorPiso(0);// Sensor de Piso
        
        ElevadorExterior elevadorExterior = new ElevadorExterior(this.elevador,panelLlegada,sensorPiso);
        
        this.elevador.setExterior(elevadorExterior);// Agrega elevadorExterior al elevador en construccion
    }
    public void construirInterior(){
        ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
        ElevadorInterior elevadorInterior = new ElevadorInterior();
        Cabina cabina = new Cabina(pasajeros,elevadorInterior);
        elevadorInterior.setCabina(cabina);
        
        Bombillo bombillo0,bombillo1,bombillo2,bombillo3,bombillo4,bombillo5; // Bombillos de botones del panel de destino 
        bombillo0 = new Bombillo();
        bombillo1 = new Bombillo();
        bombillo2 = new Bombillo();
        bombillo3 = new Bombillo();
        bombillo4 = new Bombillo();
        bombillo5 = new Bombillo();
        
        BotonDestino botonDestino1 = new BotonDestino(bombillo0, 0);// Botones del panel de destino
        BotonDestino botonDestino2 = new BotonDestino(bombillo1, 1);
        BotonDestino botonDestino3 = new BotonDestino(bombillo2, 2);
        BotonDestino botonDestino4 = new BotonDestino(bombillo3, 3);
        BotonDestino botonDestino5 = new BotonDestino(bombillo4, 4);
        BotonDestino botonDestino6 = new BotonDestino(bombillo5, 5);
        
        ArrayList<BotonDestino> botonesDestino = new ArrayList<BotonDestino>();// ArrayList de botones de destino
        BotonDetenerse botonDetenerse = new BotonDetenerse();   
        PanelDestino panelDestino = new PanelDestino(botonesDestino, botonDetenerse);
        
        elevadorInterior.setPanelDestino(panelDestino);
        
        elevadorInterior.setElevador(this.elevador);
        
    }
    public void construirMotor(){
        
        MotorElevador motorElevador = new MotorElevador(Direccion.ninguna, this.elevador); 
        
    }
    public void construirPuerta(){
        Puerta puerta = new Puerta(true, 0);// Empieza en 0. Se debe cambiar en algun momento
    }
}
