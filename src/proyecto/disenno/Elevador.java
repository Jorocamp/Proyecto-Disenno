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
public class Elevador {
    private float probabilidadBoton;
    private float probabilidadInterruptor;
    private int utPorMovimiento;
    private int utPorPuertas;
    private ElevadorInterior interior;
    private ElevadorExterior exterior;

    public Elevador(float probabilidadBoton, float probabilidadInterruptor, int utPorMovimiento, int utPorPuertas, ElevadorInterior interior, ElevadorExterior exterior) {
        this.probabilidadBoton = probabilidadBoton;
        this.probabilidadInterruptor = probabilidadInterruptor;
        this.utPorMovimiento = utPorMovimiento;
        this.utPorPuertas = utPorPuertas;
        this.interior = interior;
        this.exterior = exterior;
    }

    public float getProbabilidadBoton() {
        return probabilidadBoton;
    }

    public void setProbabilidadBoton(float probabilidadBoton) {
        this.probabilidadBoton = probabilidadBoton;
    }

    public float getProbabilidadInterruptor() {
        return probabilidadInterruptor;
    }

    public void setProbabilidadInterruptor(float probabilidadInterruptor) {
        this.probabilidadInterruptor = probabilidadInterruptor;
    }

    public int getUtPorMovimiento() {
        return utPorMovimiento;
    }

    public void setUtPorMovimiento(int utPorMovimiento) {
        this.utPorMovimiento = utPorMovimiento;
    }

    public int getUtPorPuertas() {
        return utPorPuertas;
    }

    public void setUtPorPuertas(int utPorPuertas) {
        this.utPorPuertas = utPorPuertas;
    }

    public ElevadorInterior getInterior() {
        return interior;
    }

    public void setInterior(ElevadorInterior interior) {
        this.interior = interior;
    }

    public ElevadorExterior getExterior() {
        return exterior;
    }

    public void setExterior(ElevadorExterior exterior) {
        this.exterior = exterior;
    }

    
}
