/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Simulador;
import Vistas.VistaConsola;

/**
 *
 * @author MICHA
 */
public class ControladorSimulador {
    private Simulador sim;
    private VistaConsola vc;

    public ControladorSimulador(Simulador sim, VistaConsola vc) {
        this.sim = sim;
        this.vc = vc;
    }

    public ControladorSimulador() {
    }

    public Simulador getSim() {
        return sim;
    }

    public void setSim(Simulador sim) {
        this.sim = sim;
    }

    public VistaConsola getVc() {
        return vc;
    }

    public void setVc(VistaConsola vc) {
        this.vc = vc;
    }
    
    
}
