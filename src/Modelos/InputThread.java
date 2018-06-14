/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class InputThread extends Thread{
    private final Simulador simulador;

    public InputThread(Simulador simulador) {
        this.simulador = simulador;
    }
    
    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String sec = " segundos";
        
        while(true){
            switch(sc.nextInt()){            
                case 0:{// ENTER para pausar
                System.out.println("\nPAUSA\n");
                
                this.simulador.pausarSimulacion();
                
                System.out.println("Valor de pausa cambiado a:\t" + this.simulador.isPausa());
                System.out.println("");
                
                while(this.simulador.isPausa()){// Pausa => Menu de simulador
                    
                    System.out.println("\nMenú de Simulación\n");
                    System.out.println("1. Reanudar");
                    System.out.println("2. Cambiar Retardo");
                    System.out.println("3. Cambiar Modalidad");
                    System.out.println("");
                    System.out.print("Elija una opción: ");
                    input = sc.nextInt();
                    
                    switch (input){
                        case 1:{        // REANUDAR
                            this.simulador.reanudarSimulacion();
                            System.out.println("\nValor de pausa cambiado a:\t" + this.simulador.isPausa());
                            break;
                        }
                        case 2:{        // CAMBIAR RETARDO
                            System.out.println("\nRetardo actual: "+ this.simulador.getVelocidadActual());
                            System.out.print("Digite un nuevo retardo(segundos): ");
                            input = sc.nextInt();
                            if(input <= 0){
                                System.out.println("\nERROR: El retardo debe ser positivo.");
                                break;
                            }
                            if(input==1)
                                sec=" segundo";
                            this.simulador.setVelocidadActual(input);
                            System.out.println("\nEl nuevo retardo es "+ input + sec);
                            sec = " segundos";
                            break;
                        }
                        case 3:{        // CAMBIAR MODALIDAD
                            this.simulador.setDebug(!this.simulador.isDebug());
                            if(this.simulador.isDebug())
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
                if(this.simulador.isDebug()){
                    this.simulador.setNext(false);
                    System.out.println("next is false");
                }
            }
            }
        }
    }
}
