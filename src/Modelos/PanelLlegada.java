/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class PanelLlegada {
    private ArrayList<Bombillo> bombillos;

    public PanelLlegada(ArrayList<Bombillo> bombillos) {
        this.bombillos = bombillos;
    }

    public ArrayList<Bombillo> getBombillos() {
        return bombillos;
    }

    public void setBombillos(ArrayList<Bombillo> bombillos) {
        this.bombillos = bombillos;
    }


    
    
}
