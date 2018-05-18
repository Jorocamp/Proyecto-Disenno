/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

/**
 *
 * @author Raul
 */
public class BotonDestino extends Boton {
    
    int pisoDestino;

    public BotonDestino(Bombillo pBombillo, int pPisoDestino) {
        super(pBombillo);
        this.setPisoDestino(pPisoDestino);
    }  

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }
    
    
}
