/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

//Imports

import java.io.FileWriter;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author MICHA
 */
public class JSON implements TipoFormato{

    @Override
    public boolean guardarArchivo(String pPiso, ArrayList<String> pP1, ArrayList<String> pP2, String pElevadores, ArrayList<String> pP3,
            ArrayList<String> pP4, ArrayList<String> pUTEntrePisos,ArrayList<String> pUTPuertasAbiertas, ArrayList<String> pMaxPersonas,
            String pNombre, String pUbicacion) {
        //Variable para guardar los distintos elementos de la configuracion
        JSONObject preFile = new JSONObject();
        preFile.put("numPisos", pPiso);
        preFile.put("P1", pP1);
        preFile.put("P2", pP2);
        preFile.put("numElevadores", pElevadores);
        preFile.put("P3", pP3);
        preFile.put("P4", pP4);
        preFile.put("UTPisos", pUTEntrePisos);
        preFile.put("UTPuertas", pUTPuertasAbiertas);
        preFile.put("MaxPersonas", pMaxPersonas);
        try (FileWriter archivo = new FileWriter(pUbicacion+pNombre)) {

            archivo.write(preFile.toJSONString());
            archivo.flush();
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        }

        
    }

    @Override
    public boolean cargarArchivo(String pNombre, String pUbicacion, ArrayList<Object> pData) {
        
         JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(pUbicacion+pNombre));

            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);

            int numPisos = Integer.parseInt((String)jsonObject.get("numPisos"));
            pData.add(numPisos);
            
            // P1 loop array
            ArrayList<Float> tempP1;
            tempP1 = new ArrayList<>();
            JSONArray p1 = (JSONArray) jsonObject.get("P1");
            Iterator<String> iteratorP1 = p1.iterator();
            while (iteratorP1.hasNext()) {
                tempP1.add(Float.parseFloat(iteratorP1.next()));
            }
            pData.add(tempP1);
            
            ArrayList<Float> tempP2;
            tempP2 = new ArrayList<>();
            JSONArray p2 = (JSONArray) jsonObject.get("P2");
            Iterator<String> iteratorP2 = p2.iterator();
            while (iteratorP2.hasNext()) {
                tempP2.add(Float.parseFloat(iteratorP2.next()));
            }
            pData.add(tempP2);
            
            int numElevadores =  Integer.parseInt((String)jsonObject.get("numElevadores"));
            pData.add(numElevadores);
            
            //P3
            
            ArrayList<Float> tempP3;
            tempP3 = new ArrayList<>();
            JSONArray p3 = (JSONArray) jsonObject.get("P3");
            Iterator<String> iteratorP3 = p3.iterator();
            while (iteratorP3.hasNext()) {
                tempP3.add(Float.parseFloat(iteratorP3.next()));
            }
            pData.add(tempP3);
            
            ArrayList<Float> tempP4;
            tempP4 = new ArrayList<>();
            JSONArray p4 = (JSONArray) jsonObject.get("P4");
            Iterator<String> iteratorP4 = p4.iterator();
            while (iteratorP4.hasNext()) {
               tempP4.add(Float.parseFloat(iteratorP4.next()));
            }
            pData.add(tempP4);
            
            //UTS
            
            ArrayList<Integer> tempUTPuertas;
            tempUTPuertas = new ArrayList<>();
            JSONArray UTPuertas = (JSONArray) jsonObject.get("UTPuertas");
            Iterator<String> iteratorUTPuertas = UTPuertas.iterator();
            while (iteratorUTPuertas.hasNext()) {
                tempUTPuertas.add(Integer.parseInt(iteratorUTPuertas.next()));
            }
            pData.add(tempUTPuertas);
            
            
            ArrayList<Integer> tempUTPisos;
            tempUTPisos = new ArrayList<>();
            JSONArray UTPisos = (JSONArray) jsonObject.get("UTPisos");
            Iterator<String> iteratorUTPisos = UTPisos.iterator();
            while (iteratorUTPisos.hasNext()) {
                tempUTPisos.add(Integer.parseInt(iteratorUTPisos.next()));
            }
            pData.add(tempUTPisos);
            
            
                        
            ArrayList<Integer> tempMaxPersonas;
            tempMaxPersonas = new ArrayList<>();
            JSONArray MaxPersonas = (JSONArray) jsonObject.get("MaxPersonas");
            Iterator<String> iteratorMaxPersonas = MaxPersonas.iterator();
            while (iteratorMaxPersonas.hasNext()) {
                tempMaxPersonas.add(Integer.parseInt(iteratorMaxPersonas.next()));
            }
            pData.add(tempMaxPersonas);
            

            return true;

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            return false;
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        } catch (ParseException e) {
            //e.printStackTrace();
            return false;
        }

    }
    
}
    

