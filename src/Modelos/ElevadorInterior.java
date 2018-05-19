/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Andres
 */
public class ElevadorInterior {
    private Cabina cabina;
    private PanelDestino panelDestino;
    private Elevador elevador;

    public ElevadorInterior(Cabina cabina, PanelDestino panelDestino, Elevador elevador) {
        this.cabina = cabina;
        this.panelDestino = panelDestino;
        this.elevador = elevador;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public void setCabina(Cabina cabina) {
        this.cabina = cabina;
    }

    public PanelDestino getPanelDestino() {
        return panelDestino;
    }

    public void setPanelDestino(PanelDestino panelDestino) {
        this.panelDestino = panelDestino;
    }

    public Elevador getElevador() {
        return elevador;
    }

    public void setElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    
}
