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
public class BotonLlamadaAbajo  extends Boton {

    public BotonLlamadaAbajo(Bombillo pBombillo) {
        super(pBombillo);
    }
    
    public void crearInterrupcion(int piso) {
        InterrupcionLlamada inter = new InterrupcionLlamada(piso);
        Computadora compu = Computadora.getInstance();
        compu.nuevaInterrupcion(inter);
    }
    
    
}
