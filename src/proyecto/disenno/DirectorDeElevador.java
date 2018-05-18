/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

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

    public ConstruirElevador getConstructorElevador() {
        return constructorElevador;
    }

    public void setConstructorElevador(ConstruirElevador constructorElevador) {
        this.constructorElevador = constructorElevador;
    }
    
    
}
