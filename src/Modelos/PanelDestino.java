/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class PanelDestino {
    
    ArrayList<BotonDestino> botones = new ArrayList<BotonDestino>();
    BotonDetenerse botonDetenerse;
    
    public PanelDestino(ArrayList<BotonDestino> pBotones, BotonDetenerse pBoton){
        this.setBotones(pBotones);
        this.setBotonDetenerse(pBoton);
    }

    public ArrayList<BotonDestino> getBotones() {
        return botones;
    }

    public void setBotones(ArrayList<BotonDestino> botones) {
        this.botones = botones;
    }

    public BotonDetenerse getBotonDetenerse() {
        return botonDetenerse;
    }

    public void setBotonDetenerse(BotonDetenerse botonDetenerse) {
        this.botonDetenerse = botonDetenerse;
    }
    
    
}
