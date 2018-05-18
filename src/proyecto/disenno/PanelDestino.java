/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class PanelDestino {
    
    ArrayList<Boton> botones = new ArrayList<Boton>();
    BotonDetenerse botonDetenerse;
    
    public PanelDestino(ArrayList<Boton> pBotones, BotonDetenerse pBoton){
        this.setBotones(pBotones);
        this.setBotonDetenerse(pBoton);
    }

    public ArrayList<Boton> getBotones() {
        return botones;
    }

    public void setBotones(ArrayList<Boton> botones) {
        this.botones = botones;
    }

    public BotonDetenerse getBotonDetenerse() {
        return botonDetenerse;
    }

    public void setBotonDetenerse(BotonDetenerse botonDetenerse) {
        this.botonDetenerse = botonDetenerse;
    }
    
    
}
