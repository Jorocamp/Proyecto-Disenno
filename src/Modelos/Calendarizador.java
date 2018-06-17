/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Direccion;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Andres
 */
public class Calendarizador {
    private Direccion direccionPrevista;
    private ArrayList<Integer> pisosCalendarizados;

    public Calendarizador(Direccion direccionPrevista, ArrayList<Integer> pisosCalendarizados) {
        this.direccionPrevista = direccionPrevista;
        this.pisosCalendarizados = pisosCalendarizados;
    }

    public Direccion getDireccionPrevista() {
        return direccionPrevista;
    }

    public void setDireccionPrevista(Direccion direccionPrevista) {
        this.direccionPrevista = direccionPrevista;
    }

    public ArrayList<Integer> getPisosCalendarizados() {
        return pisosCalendarizados;
    }

    public void setPisosCalendarizados(ArrayList<Integer> pisosCalendarizados) {
        this.pisosCalendarizados = pisosCalendarizados;
    }


    public void calendarizarPiso(int piso){
        int banderaRep = 0;
        for(int i = 0; i<pisosCalendarizados.size(); i++){
            if(pisosCalendarizados.get(i) == piso){
                banderaRep = 1;
                break;
            }
        }
        if(banderaRep == 0){
            pisosCalendarizados.add(piso);
        }
        
    }
    
}
