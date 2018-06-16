/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.ConstruirElevadorNormal;
import Modelos.DirectorDeElevador;
import Modelos.Edificio;
import Modelos.Elevador;
import Modelos.ElevadorExterior;
import Modelos.PanelLlamada;
import Modelos.Pasajero;
import Modelos.Piso;
import Modelos.Simulador;
import Vistas.VistaConsola;
import Modelos.*;
import Vistas.VistaGUI;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author MICHA
 */
public class ControladorSimulador {

    private VistaConsola vc;
    private Simulador simulador;
    private VistaGUI vg;

    public VistaGUI getVg() {
        return vg;
    }

    public void setVg(VistaGUI vg) {
        this.vg = vg;
    }

    public ControladorSimulador(Simulador simulador, VistaConsola vc) {
        this.simulador = simulador;

        this.vc = vc;
    }
    public ControladorSimulador() {
    }

    public VistaConsola getVc() {
        return vc;
    }
    public void setVc(VistaConsola vc) {
        this.vc = vc;
    }

    public Simulador getSimulador() {
        return simulador;
    }
    public void setSimulador(Simulador simulador) {
        this.simulador = simulador;
    }
    
    
     public void configurarSimulacion(ArrayList<Object> parametrosConfiguracion){
        /* El ArrayList parametrosConfiguracion contiene todos los parametros que se utilizaran para la configuracion
            del sistema de simulacion. Entre estos parametros estan: cantidad pisos, ArrayList con la probabilidad #1,
            ArrayList con la probabilidad #2, ArrayList con la probabilidad #3, ArrayList con la probabilidad #4, la cantidad de
            UT que tarda un elevador de un piso a otro, la canridad de UT que tarda un elevador con las puertas abiertas y 
            la cantidad de personas que entran en un elevador*/
        simulador.setCantidadPisos((Integer)parametrosConfiguracion.get(0));
        simulador.setCantidadElevadores((Integer) parametrosConfiguracion.get(3));
        Edificio edificio = simulador.getEdificio();
        
        ArrayList<Float> arrayListProbSolicitud = new ArrayList<Float>();
        arrayListProbSolicitud = (ArrayList<Float>) parametrosConfiguracion.get(1);

        ArrayList<Float> arrayListProbDestino = new ArrayList<Float>();
        arrayListProbDestino = (ArrayList<Float>) parametrosConfiguracion.get(2);
        
        ArrayList<Piso> arrayPisos = new ArrayList<Piso>();
            

        for(int i=0; i<simulador.getCantidadPisos(); i++){         
            arrayPisos.add(new Piso(i, arrayListProbSolicitud.get(i), arrayListProbDestino.get(i), new ArrayList<ElevadorExterior>(), new PanelLlamada(new BotonLlamadaArriba(new Bombillo(false)),new BotonLlamadaAbajo(new Bombillo(false))), new ArrayList<Pasajero>()));

        }
        
        
        ArrayList<Elevador> arrayElevadores = new ArrayList<Elevador>();


        DirectorDeElevador director = new DirectorDeElevador();
        director.setConstructorElevador(new ConstruirElevadorNormal());

        ArrayList<Float> arrayListProbBoton = new ArrayList<Float>();
        arrayListProbBoton = (ArrayList<Float>) parametrosConfiguracion.get(4);

        ArrayList<Float> arrayListProbPalanca = new ArrayList<Float>();
        arrayListProbPalanca = (ArrayList<Float>) parametrosConfiguracion.get(5);

        ArrayList<Integer> arrayListUTMovimiento = new ArrayList<Integer>();
        arrayListUTMovimiento = (ArrayList<Integer>) parametrosConfiguracion.get(7);

        ArrayList<Integer> arrayListUTPuertas = new ArrayList<Integer>();
        arrayListUTPuertas = (ArrayList<Integer>) parametrosConfiguracion.get(6);

        ArrayList<Integer> arrayListCantidadPersonas = new ArrayList<Integer>();
        arrayListCantidadPersonas = (ArrayList<Integer>) parametrosConfiguracion.get(8);        
        
        for(int i=0; i<simulador.getCantidadElevadores(); i++){
            
            System.out.println(arrayListUTMovimiento.get(0));

            director.construirElevador(Integer.parseInt(parametrosConfiguracion.get(0).toString()), arrayListProbBoton.get(i), 
                    arrayListProbPalanca.get(i), arrayListUTMovimiento.get(i), arrayListUTPuertas.get(i), arrayListCantidadPersonas.get(i));
            director.getElevador().setNumElevador(i);
            arrayElevadores.add(director.getElevador());
        }
        edificio.setArrayPisos(arrayPisos);
        edificio.setArrayElevadores(arrayElevadores);
        
    }
     
     
     
     
     //Ejecucion de la simulacion
     public void enviarUT(){
        vg.getTxt_utContador().setText(String.valueOf(simulador.getUt()));
     }
     
    public void generarPasajeros(){
        simulador.getEdificio().generarPasajeros();
    }
     
    public void enviarPasajeros(){
        ArrayList<String> pasajeros = simulador.getEdificio().enviarPasajeros();
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < pasajeros.size(); i++)
        {
            listModel.addElement(pasajeros.get(i));
        }
        vg.getLst_Pasajeros().setModel(listModel);
        
    }
     public void ejecutarSimulacionUT(){
         enviarUT();
         generarPasajeros();
         enviarPasajeros();
     }
     
}
