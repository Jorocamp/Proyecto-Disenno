/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Raul
 */
public class Boton {
 
    Bombillo bombillo;

    public Boton(Bombillo pBombillo) {
        this.setBombillo(pBombillo);
    }

    public void crearInterrupcion(){
        
    }
    
    public Bombillo getBombillo() {
        return bombillo;
    }

    public void setBombillo(Bombillo bombillo) {
        this.bombillo = bombillo;
    }
    
    
}
