/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.ControladorSimulador;
import Modelos.Simulador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MICHA
 */
public class VistaConsola extends Thread implements Vista{
    private ControladorSimulador cs;
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
        System.out.println("Bienvenido al simulador de SCE (Sistema de Control de Elevadores) \n");
        System.out.println("------------------------------------------------------------------------------------------------------- \n \n");
        System.out.println("Menu Principal: \n");
        System.out.println("1. Configurar simulador \n");
        System.out.println("2. Guardar archivo de configuración \n");
        System.out.println("3. Cargar archivo de configuraciónr \n");
        System.out.println("4. Simular");
        System.out.print("Digite la opción que desea realizar:  ");
        try{
            
            int input = Integer.parseInt(br.readLine());
            switch(input){
                case 1:{
                    parametros.removeAll(parametros);
                    System.out.println("\n{==== Configuración del Simulador ====}\n");
                    
                    System.out.print("Digite el número de pisos para el edificio: ");
                    int pisos = Integer.parseInt(br.readLine());
                    if(pisos < 2){
                        System.err.println("\nDeben haber por lo menos dos pisos");
                        break;
                    }
                    parametros.add(pisos);
                    System.out.println("\n--- Probabilidades de Solicitud ---");
                    float prob = 0;
                    for(int i = 0; i < pisos; i++){// Probabilidades de Solicitud para cada piso
                        System.out.print("\nDigite la probabilidad de solicitud para el piso "+ (i+1)+" : "); 
                        
                        prob = Float.parseFloat(br.readLine());
                        if(prob > 1.0){// Total excedido
                            System.err.println("\nLa probabilidad no debe exceder el 1.0");
                            inicioSimulador();
                        }
                        
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            inicioSimulador();
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
                            inicioSimulador();
                        }
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            inicioSimulador();
                        }
                        probDestinoPisos.add(prob);
                    }
                    parametros.add(probDestinoPisos);
                    System.out.println("\nProbabilidades de destino ingresadas correctamente.\n");
                    
                    System.out.print("\nDigite el numero de elevadores del edificio: ");
                    int elevadores = Integer.parseInt(br.readLine());
                    if(elevadores < 1){
                        System.err.println("\nDebe haber por lo menos un elevador");
                        break;
                    }
                    System.out.println("\n--- Probabilidades de Detener Elevadores ---\n");
                    for(int i = 0; i < elevadores; i++){
                        System.out.print("\nDigite la probabilidad de detener el elevador "+ (i+1)+" : "); 
                        prob = Float.parseFloat(br.readLine());
                        if(prob > 1.0){// Total excedido
                            System.err.println("\nLa probabilidad no debe exceder el 1.0");
                            inicioSimulador();
                        }
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            inicioSimulador();
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
                            inicioSimulador();
                        }
                        if(prob < 0){// Dato negativo
                            System.err.println("\nIngrese decimales positivos del 0 al 1");
                            inicioSimulador();
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
                            inicioSimulador();
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
                            inicioSimulador();
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
                            inicioSimulador();
                        }
                        maxCantidadPersonasElevadores.add(max);
                    }
                    parametros.add(maxCantidadPersonasElevadores);
                    System.out.println("\nMaxima cantidad de personas ingresadas correctamente.\n");
                    System.out.println(parametros);
                    cs.configurarSimulacion(parametros);
                    System.out.println("\nConfiguración Exitosa!\n");
                    break; // Break final Caso 1
                }
                case 2:{
                    if(parametros.size() < 8){
                        System.err.println("\nDebe crear o cargar una configuración para guardarla.\n");
                        break;
                    }
                    else{
                        System.out.println("\nLa configuración a guardar tiene los siguientes parametros:");
                        int pisos = (Integer)parametros.get(0);
                        System.out.print("\nPisos: ");
                        System.out.println(parametros.get(0));
                        System.out.println("\nProbabilidades de Solicitud: ");
                        ArrayList<Float> probs = (ArrayList<Float>)parametros.get(1);
                        for(int i=0; i< pisos; i++){
                            System.out.print("\tPiso "+ (i+1) +" : ");
                            System.out.println(probs.get(i));
                        }
                        System.out.println("\nProbabilidades de Destino: ");
                        probs = (ArrayList<Float>)parametros.get(2);
                        for(int i=0; i< pisos; i++){
                            System.out.print("\tPiso "+ (i+1) +" : ");
                            System.out.println(probs.get(i));
                        }
                        
                        System.out.println("\nProbabilidades de Detenerse: ");
                        probs = (ArrayList<Float>)parametros.get(3);
                        int elevadores = probs.size();
                        for(int i=0; i< elevadores; i++){
                            System.out.print("\tElevador "+ (i+1) +" : ");
                            System.out.println(probs.get(i));
                        }
                        System.out.println("\nProbabilidades de Emergencia: ");
                        probs = (ArrayList<Float>)parametros.get(4);
                        for(int i=0; i< elevadores; i++){
                            System.out.print("\tElevador "+ (i+1) +" : ");
                            System.out.println(probs.get(i));
                        }
                        System.out.println("\nUTs Entre Pisos: ");
                        ArrayList<Integer> uts = (ArrayList<Integer>)parametros.get(5);
                        for(int i=0; i< elevadores; i++){
                            System.out.print("\tElevador "+ (i+1) +" : ");
                            System.out.println(probs.get(i));
                        }
                        System.out.println("\nUTs Puertas Abiertas: ");
                        uts = (ArrayList<Integer>)parametros.get(6);
                        for(int i=0; i< elevadores; i++){
                            System.out.print("\tElevador "+ (i+1) +" : ");
                            System.out.println(uts.get(i));
                        }
                        System.out.println("\nMaxima Cantidad de Personas: ");
                        uts = (ArrayList<Integer>)parametros.get(7);
                        for(int i=0; i< elevadores; i++){
                            System.out.print("\tElevador "+ (i+1) +" : ");
                            System.out.println(uts.get(i));
                        }
                        System.out.println("\nSi la información es correcta presione 1 para guardar.");
                        System.out.println("Si no lo es, digite otro numero para volver al menú.\n");
                        
                        input = Integer.parseInt(br.readLine());
                        if(input == 1){
                            
                            System.out.println("Datos configurados en la simulacion correctamente. Listo para Simular!");
                        }
                        else{
                            inicioSimulador();
                        }
                    }
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    if(parametros.size()<8){
                        this.cs.getSimulador().start();
                        this.cs.getVc().start();
                        return;
                    }
                    else{
                        System.err.println("\nDebe crear o cargar una configuración para simular.\n");
                        inicioSimulador();
                    }
                    break;
                }
            }
        }catch(NumberFormatException nfe){
            System.err.println("Debe ser un número 1 al 3");
        } catch (IOException ex) {
            System.err.println("Error de entrada");
        }

        
        inicioSimulador();

    }
    
    
    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String sec = " segundos";
        System.out.println("Input Time!");
        while(true){
            switch(sc.nextInt()){            
                case 0:{// ENTER para pausar
                System.out.println("\nPAUSA\n");
                
                cs.getSimulador().pausarSimulacion();
                
                System.out.println("Valor de pausa cambiado a:\t" + cs.getSimulador().isPausa());
                System.out.println("");
                
                while(cs.getSimulador().isPausa()){// Pausa => Menu de simulador
                    
                    System.out.println("\nMenú de Simulación\n");
                    System.out.println("1. Reanudar");
                    System.out.println("2. Cambiar Raul");
                    System.out.println("3. Cambiar Modalidad");
                    System.out.println("");
                    System.out.print("Elija una opción: ");
                    input = sc.nextInt();
                    
                    switch (input){
                        case 1:{        // REANUDAR
                            cs.getSimulador().reanudarSimulacion();
                            System.out.println("\nValor de pausa cambiado a:\t" + cs.getSimulador().isPausa());
                            break;
                        }
                        case 2:{        // CAMBIAR RETARDO
                            System.out.println("\nRetardo actual: "+ cs.getSimulador().getVelocidadActual());
                            System.out.print("Digite un nuevo retardo(segundos): ");
                            input = sc.nextInt();
                            if(input <= 0){
                                System.out.println("\nERROR: El retardo debe ser positivo.");
                                break;
                            }
                            if(input==1)
                                sec=" segundo";
                            cs.getSimulador().setVelocidadActual(input);
                            System.out.println("\nEl nuevo retardo es "+ input + sec);
                            sec = " segundos";
                            break;
                        }
                        case 3:{        // CAMBIAR MODALIDAD
                            cs.getSimulador().setDebug(!cs.getSimulador().isDebug());
                            if(cs.getSimulador().isDebug())
                                System.out.println("\nSe ha cambiado a Modo Depurador.\n");
                            else
                                System.out.println("\nSe ha cambiado a Modo Normal.\n");
                            break;
                        }
                    }
                }
            }
            case 1:{
                //sc.next();
                if(cs.getSimulador().isDebug()){
                    cs.getSimulador().setNext(false);
                }
            }
            }
        }
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

    public ControladorSimulador getCs() {
        return cs;
    }

    public void setCs(ControladorSimulador cs) {
        this.cs = cs;
    }

    public ArrayList<Object> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Object> parametros) {
        this.parametros = parametros;
    }

    public ArrayList<Float> getProbSolicitudPisos() {
        return probSolicitudPisos;
    }

    public void setProbSolicitudPisos(ArrayList<Float> probSolicitudPisos) {
        this.probSolicitudPisos = probSolicitudPisos;
    }

    public ArrayList<Float> getProbDestinoPisos() {
        return probDestinoPisos;
    }

    public void setProbDestinoPisos(ArrayList<Float> probDestinoPisos) {
        this.probDestinoPisos = probDestinoPisos;
    }

    public ArrayList<Float> getProbDetnerElevadores() {
        return probDetnerElevadores;
    }

    public void setProbDetnerElevadores(ArrayList<Float> probDetnerElevadores) {
        this.probDetnerElevadores = probDetnerElevadores;
    }

    public ArrayList<Float> getProbEmergenciaElevadores() {
        return probEmergenciaElevadores;
    }

    public void setProbEmergenciaElevadores(ArrayList<Float> probEmergenciaElevadores) {
        this.probEmergenciaElevadores = probEmergenciaElevadores;
    }

    public ArrayList<Integer> getUtEntrePisosElevadores() {
        return utEntrePisosElevadores;
    }

    public void setUtEntrePisosElevadores(ArrayList<Integer> utEntrePisosElevadores) {
        this.utEntrePisosElevadores = utEntrePisosElevadores;
    }

    public ArrayList<Integer> getUtPuertasDetenerseElevadores() {
        return utPuertasDetenerseElevadores;
    }

    public void setUtPuertasDetenerseElevadores(ArrayList<Integer> utPuertasDetenerseElevadores) {
        this.utPuertasDetenerseElevadores = utPuertasDetenerseElevadores;
    }

    public ArrayList<Integer> getMaxCantidadPersonasElevadores() {
        return maxCantidadPersonasElevadores;
    }

    public void setMaxCantidadPersonasElevadores(ArrayList<Integer> maxCantidadPersonasElevadores) {
        this.maxCantidadPersonasElevadores = maxCantidadPersonasElevadores;
    }

    public VistaConsola(ControladorSimulador cs) {
        this.cs = cs;
    }

    public VistaConsola() {
    }
    
    public static void main(String[] args) throws InterruptedException {
        VistaConsola vc = new VistaConsola();
        Simulador sim = new Simulador();
        sim.setVelocidadActual(1);
        ControladorSimulador cs = new ControladorSimulador(sim, vc);
        vc.setCs(cs);
        sim.setCs(cs);
        vc.inicioSimulador();
        //sim.start();
        //vc.start();
    }
}
