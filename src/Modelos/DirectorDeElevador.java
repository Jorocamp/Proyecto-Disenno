/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

/**
 *
 * @author Andres
 * 
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
    public void construirElevador(){
        constructorElevador.crearElevador();
        constructorElevador.construirExterior();
        constructorElevador.construirInterior();
        constructorElevador.construirMotor();
        constructorElevador.construirPuerta();
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
}
