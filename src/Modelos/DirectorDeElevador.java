/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

/**
 *
 * @author Andres
 * Clase Directora de construir elevadores.
 */
public class DirectorDeElevador {
    private ConstruirElevador constructorElevador;

    public DirectorDeElevador(ConstruirElevador constructorElevador) {
        this.constructorElevador = constructorElevador;
    }
    public DirectorDeElevador(){
        
    }
/*
    Metodo que llama al builder (ConstruirElevador) para construir el elevador    
*/
    public void construirElevador(int cantidadPisos,float probabilidadBoton, float probabilidadInterruptor,int utPorMovimiento, int utPorPuertas){
        constructorElevador.crearElevador();
        constructorElevador.construirExterior(cantidadPisos);
        constructorElevador.construirInterior(cantidadPisos,probabilidadBoton,probabilidadInterruptor);
        constructorElevador.construirMotor(utPorMovimiento);
        constructorElevador.construirPuerta(utPorPuertas);
    }
    
    public ConstruirElevador getConstructorElevador() {
        return constructorElevador;
    }

    public void setConstructorElevador(ConstruirElevador constructorElevador) {
        this.constructorElevador = constructorElevador;
    }
    
    public Elevador getElevador(){
        return this.constructorElevador.getElevador();
    }
    
    public static void main(String[] args) {
        
        DirectorDeElevador director = new DirectorDeElevador();
        director.setConstructorElevador(new ConstruirElevadorNormal());
        director.construirElevador(3, 50, 60, 8, 9);
        Elevador elevador = director.getElevador();
    }
}
