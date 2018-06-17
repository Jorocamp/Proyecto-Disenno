/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author MICHA
 */
//-----------------------------------------------------------------------------
/*
CODIGOS DE BITACORA

CB01 - Solicitud de elevador
CB02 - Salir elevador
CB03 - Entro a elevador
CB04 - Se presiono boton destino piso
CB05 - Se encendio luz de boton
CB06 - Sensor de piso
CB07 - Calendarizador
CB08 - Puertas
CB09 - Energencia
CB10 - Detener
CB11 - Maxima capacidad
*/
public class BitacoraRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
           
         Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
           
        try{
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB01")) {
                c.setBackground( Color.BLUE );
                c.setForeground(Color.WHITE);
            }
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB02")) {
                c.setBackground( Color.CYAN );
            }
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB03")) {
                c.setBackground( Color.DARK_GRAY );
                c.setForeground(Color.WHITE);
            }if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB04")) {
                c.setBackground( Color.GRAY );
                c.setForeground(Color.WHITE);
            }
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB05")) {
                c.setBackground( Color.YELLOW );
            }
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB06")) {
                c.setBackground( Color.LIGHT_GRAY );
            }if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB07")) {
                c.setBackground( Color.MAGENTA );
            }
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB08")) {
                c.setBackground( Color.ORANGE );
            }
            if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB09")) {
                c.setBackground( Color.RED );
                c.setForeground(Color.WHITE);
            }if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB10")) {
                c.setBackground( Color.PINK );
            }if (list.getModel().getElementAt(index).toString().substring(0,4).equals("CB11")) {
                c.setBackground( Color.BLACK );
                c.setForeground(Color.WHITE);
            }
            }
            catch(Exception e){
                
            }

            return c;
        }
}
