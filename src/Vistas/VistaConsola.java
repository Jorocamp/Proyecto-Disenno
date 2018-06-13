/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MICHA
 */
public class VistaConsola implements Vista{


    public void inicioSimulador() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("------------------------------------------------------------------------------------------------------- \n");
        System.out.println("Bienvenido al simulador de SCE (Sistema de Control de Elevadores) \n ");
        System.out.println("------------------------------------------------------------------------------------------------------- \n \n");
        System.out.println("Menu Principal: \n");
        System.out.println("1. Configurar simulador \n");
        System.out.println("2. Guardar archivo de configuración \n");
        System.out.println("3. Cargar archivo de configuraciónr \n");
        System.out.println("Digite la opción que desea realizar:  ");
        try{
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Debe ser un número 1 al 3");
        } catch (IOException ex) {
            System.err.println("Error de entrada");
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
    
    
    
}
