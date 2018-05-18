/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;

/**
 *
 * @author Andres
 */
public class ElevadorExterior {
    private Elevador elevador;
    private PanelLlegada panelLlegada;
    private SensorPiso sensorPiso;

    public ElevadorExterior(Elevador elevador, PanelLlegada panelLlegada, SensorPiso sensorPiso) {
        this.elevador = elevador;
        this.panelLlegada = panelLlegada;
        this.sensorPiso = sensorPiso;
    }

    public Elevador getElevador() {
        return elevador;
    }

    public void setElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    public PanelLlegada getPanelLlegada() {
        return panelLlegada;
    }

    public void setPanelLlegada(PanelLlegada panelLlegada) {
        this.panelLlegada = panelLlegada;
    }

    public SensorPiso getSensorPiso() {
        return sensorPiso;
    }

    public void setSensorPiso(SensorPiso sensorPiso) {
        this.sensorPiso = sensorPiso;
    }
    
    
}
