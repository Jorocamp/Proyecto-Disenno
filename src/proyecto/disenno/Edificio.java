/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.disenno;
import java.util.ArrayList;
import proyecto.disenno.Piso;

/**
 *
 * @author Andres
 */
public class Edificio {
    private ArrayList<Piso> arrayPisos;
    private ArrayList<Elevador> arrayElevadores;
    
    public Edificio(ArrayList<Piso> arrayPisos,ArrayList<Elevador> arrayElevadores) {
        this.arrayPisos = arrayPisos;
        this.arrayElevadores = arrayElevadores;
    }

    public ArrayList<Piso> getArrayPisos() {
        return arrayPisos;
    }

    public void setArrayPisos(ArrayList<Piso> arrayPisos) {
        this.arrayPisos = arrayPisos;
    }

    public ArrayList<Elevador> getArrayElevadores() {
        return arrayElevadores;
    }

    public void setArrayElevadores(ArrayList<Elevador> arrayElevadores) {
        this.arrayElevadores = arrayElevadores;
    }


}
