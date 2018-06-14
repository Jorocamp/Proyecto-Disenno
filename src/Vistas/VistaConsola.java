/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelos.Simulador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MICHA
 */
public class VistaConsola implements Vista{
    private ArrayList<Object> parametros = new ArrayList<>();
    private ArrayList<Float> probSolicitudPisos = new ArrayList<>();
    private ArrayList<Float> probDestinoPisos = new ArrayList<>();
    private ArrayList<Float> probDetnerElevadores = new ArrayList<>();
    private ArrayList<Float> probEmergenciaElevadores = new ArrayList<>();   
    private ArrayList<Integer> utEntrePisosElevadores = new ArrayList<>();
    private ArrayList<Integer> utPuertasDetenerseElevadores = new ArrayList<>();
    private ArrayList<Integer> maxCantidadPersonasElevadores = new ArrayList<>();

    public void inicioSimulador() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("------------------------------------------------------------------------------------------------------- \n");
        System.out.println("Bienvenido al simulador de SCE (Sistema de Control de Elevadores) \n ");
        System.out.println("------------------------------------------------------------------------------------------------------- \n \n");
        System.out.println("Menu Principal: \n");
        System.out.println("1. Configurar simulador \n");
        System.out.println("2. Guardar archivo de configuración \n");
        System.out.println("3. Cargar archivo de configuraciónr \n");
        System.out.print("Digite la opción que desea realizar:  ");
        try{
            int input = Integer.parseInt(br.readLine());
            switch(input){
                case 1:{
                    System.out.println("\n==== Configuración del Simulador ====\n");
                    
                    System.out.print("Digite el número de pisos para el edificio: ");
                    int pisos = Integer.parseInt(br.readLine());
                    if(pisos < 2){
                        System.err.println("\nDeben haber por lo menos dos pisos");
                        break;
                    }
                    System.out.println("\n--- Probabilidades de Solicitud ---");
                    float prob = 0;
                    for(int i = 0; i < pisos; i++){// Probabilidades de Solicitud para cada piso
                        System.out.print("\nDigite la probabilidad de solicitud para el piso "+ (i+1)+" : "); 
                        
                        prob = Float.parseFloat(br.readLine());
                        if(prob > 1.0){// Total excedido
                            System.err.println("\nLa probabilidad no debe exceder el 1.0");
                            break;
                        }
                        
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            break;
                        }
                        probSolicitudPisos.add(prob); 
                    }                    
                    parametros.add(probSolicitudPisos);// Ingresa las probabilidades de pisos
                    System.out.println("\nProbabilidades de solicitud ingresadas correctamente.\n"); 
                    
                    System.out.println("\n--- Probabilidades de Destino ---\n");
                    float total = 0;
                    for(int i = 0; i < pisos; i++){
                        System.out.println("\nTotal Acumulado: "+total);
                        System.out.print("\nDigite la probabilidad de destino para el piso "+ (i+1)+" : "); 
                        prob = Float.parseFloat(br.readLine());
                        total += prob;
                        if(total > 1.0){// Total excedido
                            System.err.println("\nEl total no debe exceder el 1.0");
                            break;
                        }
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            break;
                        }
                        probDestinoPisos.add(prob);
                    }
                    parametros.add(probDestinoPisos);
                    System.out.println("\nProbabilidades de destino ingresadas correctamente.\n");
                    
                    System.out.print("\nDigite el numero de elevadores del edificio: ");
                    int elevadores = Integer.parseInt(br.readLine());
                    if(elevadores < 2){
                        System.err.println("\nDeben haber por lo menos dos elevadores");
                        break;
                    }
                    System.out.println("\n--- Probabilidades de Detener Elevadores ---\n");
                    for(int i = 0; i < elevadores; i++){
                        System.out.print("\nDigite la probabilidad de detener el elevador "+ (i+1)+" : "); 
                        prob = Float.parseFloat(br.readLine());
                        if(prob > 1.0){// Total excedido
                            System.err.println("\nLa probabilidad no debe exceder el 1.0");
                            break;
                        }
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            break;
                        }
                        probDetnerElevadores.add(prob);
                    }
                    parametros.add(probDetnerElevadores);
                    System.out.println("\nProbabilidades de detener elevadores ingresadas correctamente.\n");
                    
                    System.out.println("\n--- Probabilidades de Emergencia de Elevadores ---\n");
                    for(int i = 0; i < elevadores; i++){
                        System.out.print("\nDigite la probabilidad de emergencia en el elevador "+ (i+1)+" : "); 
                        prob = Float.parseFloat(br.readLine());
                        if(prob > 1.0){// Total excedido
                            System.err.println("\nLa probabilidad no debe exceder el 1.0");
                            break;
                        }
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            break;
                        }
                        probEmergenciaElevadores.add(prob);
                    }
                    parametros.add(probEmergenciaElevadores);
                    System.out.println("\nProbabilidades de emergencia en elevadores ingresadas correctamente.\n");
                    System.out.println("\n--- UT Entre Pisos ---\n");
                    int ut = 1;
                    for(int i = 0; i < elevadores; i++){
                        System.out.print("\nDigite las UT entre pisos para el elevador "+ (i+1)+" : "); 
                        ut = Integer.parseInt(br.readLine());
                        if(ut < 1){// Dato menor
                            System.err.println("\nIngrese enteros mayores que 1");
                            break;
                        }
                        utEntrePisosElevadores.add(ut);
                    }
                    parametros.add(utEntrePisosElevadores);
                    System.out.println("\nUT entre pisos ingresadas correctamente.\n");
                    
                    System.out.println("\n--- UT de Puertas Abiertas y al Detenerse ---\n");
                    ut = 1;
                    for(int i = 0; i < elevadores; i++){
                        System.out.print("\nDigite las UT de puertas abiertas y al detenerse para el elevador "+ (i+1)+" : "); 
                        ut = Integer.parseInt(br.readLine());
                        if(ut < 1){// Dato menor
                            System.err.println("\nIngrese enteros mayores que 1");
                            break;
                        }
                        utPuertasDetenerseElevadores.add(ut);
                    }
                    parametros.add(utPuertasDetenerseElevadores);
                    System.out.println("\nUT de puertas abiertas y al detenerse ingresadas correctamente.\n"); 
                    
                    System.out.println("\n--- Máxima Cantidad de Personas ---\n");
                    int max = 1;
                    for(int i = 0; i < elevadores; i++){
                        System.out.print("\nDigite la maxima cantidad de personas para el elevador "+ (i+1)+" : "); 
                        max = Integer.parseInt(br.readLine());
                        if(max < 1){// Dato menor
                            System.err.println("\nIngrese enteros mayores que 1");
                            break;
                        }
                        maxCantidadPersonasElevadores.add(max);
                    }
                    parametros.add(maxCantidadPersonasElevadores);
                    System.out.println("\nMaxima cantidad de personas ingresadas correctamente.\n");
                    
                    break; // Break final Caso 1
                }
                case 2:{
                    break;
                }
                case 3:{
                    break;
                }
            }
        }catch(NumberFormatException nfe){
            System.err.println("Debe ser un número 1 al 3");
        } catch (IOException ex) {
            System.err.println("Error de entrada");
        }
        if(parametros.size() == 7){
            System.out.println("\nConfiguración Exitosa!");
        }
        inicioSimulador();

    }
    
    
    

    @Override
    public void getConfiguracion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearProbabilidad1(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearProbabilidad2(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearProbabilidad3(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearProbabilidad4(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearUTPisos(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearUTPuertas(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearMaxPersonas(int pNumPisos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) throws InterruptedException {
        VistaConsola vc = new VistaConsola();
        vc.inicioSimulador();
    }
    
}
