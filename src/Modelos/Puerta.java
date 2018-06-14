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
public class Puerta {
    private boolean estado;
    private int contadorUT;

    public Puerta(boolean estado, int contadorUT) {
        this.estado = estado;
        this.contadorUT = contadorUT;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getContadorUT() {
        return contadorUT;
    }

    public void setContadorUT(int contadorUT) {
        this.contadorUT = contadorUT;
    }
    
    public void aumentarUT(int uT){
        
    }
    public void disminuirUT(){
        
    }
}
