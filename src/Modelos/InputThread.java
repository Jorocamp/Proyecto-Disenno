/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.IOException;
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
        Scanner sc = new Scanner(System.in);
        int input = 0;
        String sec = " segundos";
        
        while(true){
            
            //System.out.println("Listo para captar input de usuario.");
            
            if(sc.nextInt() == 0){// 0 + ENTER para pausar
                System.out.println("\nPAUSA\n");
                
                this.simulador.pausarSimulacion();
                
                System.out.println("Valor de pausa cambiado a:\t" + this.simulador.isPausa());
                System.out.println("");
                
                while(this.simulador.isPausa()){// Pausa => Menu de simulador
                    System.out.println("\nMenú de Simulación\n");
                    System.out.println("1. Reanudar");
                    System.out.println("2. Cambiar Retardo");
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
                            input = 0;
                            break;
                        }
                    }
                }
                
            }

        }
    }
}
