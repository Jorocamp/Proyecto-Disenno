/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author MICHA
 */
public class Texto implements TipoFormato {

    @Override
    public boolean guardarArchivo(String pPiso, ArrayList<String> pP1, ArrayList<String> pP2, String pElevadores, ArrayList<String> pP3,
            ArrayList<String> pP4, ArrayList<String> pUTEntrePisos,ArrayList<String> pUTPuertasAbiertas, ArrayList<String> pMaxPersonas,
            String pNombre, String pUbicacion) {
        
        String filename = pUbicacion + pNombre;
        
        BufferedWriter bw = null;
	FileWriter fw = null;
        
        //***********************
        
        try {
            //Escritura del archivo
            String content = pPiso + "\r\n" + "@\r\n";
            for(int i=0; i < pP1.size(); i++){
                content = content + pP1.get(i) + "\r\n";
            }
            content = content + "@\r\n";
            for(int i=0; i < pP2.size(); i++){
                content = content + pP2.get(i) + "\r\n";
            }
            content = content + "@\r\n";
            content = content + pElevadores + "\r\n@\r\n";
            for(int i=0; i < pP3.size(); i++){
                content = content + pP3.get(i) + "\r\n";
            }
            
            content = content + "@\r\n";
            for(int i=0; i < pP4.size(); i++){
                content = content + pP4.get(i) + "\r\n";
            }
            content = content + "@\r\n";
            for(int i=0; i < pUTPuertasAbiertas.size(); i++){
                content = content + pUTPuertasAbiertas.get(i) + "\r\n";
            }
            content = content + "@\r\n";
            for(int i=0; i < pUTEntrePisos.size(); i++){
                content = content + pUTEntrePisos.get(i) + "\r\n";
            }
            content = content + "@\r\n";
            for(int i=0; i < pMaxPersonas.size(); i++){
                content = content + pMaxPersonas.get(i) + "\r\n";
            }
            
            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);
            bw.write(content);

            
	} catch (IOException e) {
            e.printStackTrace();
	} finally {
            try {
                if (bw != null)
                bw.close();
		if (fw != null)
                    fw.close();
                return true;

            } catch (IOException ex) {
                return false;
            }   
        }
   }
    
    @Override
    public boolean cargarArchivo(String pNombre, String pUbicacion, ArrayList<Object> pData) {

		BufferedReader br = null;
		FileReader fr = null;
                String FILENAME = pUbicacion + pNombre;
		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
                        int contador = 0;
			String sCurrentLine;                        
                        
                        ArrayList<Float> tempP1 = new ArrayList<>();
                        while((sCurrentLine = br.readLine()) != null){
                            if(sCurrentLine.equals("@")){
                                contador++;
                                continue;
                            }
                            if(contador == 0 || contador == 3){
                                pData.add(Integer.parseInt(sCurrentLine));
                                continue;
                            }
                            if(contador == 1 || contador == 2 || contador == 4 || contador == 5){
                                ArrayList<Float> temp = new ArrayList<>();
                                temp.add(Float.parseFloat(sCurrentLine));
                                while(!(sCurrentLine = br.readLine()).equals("@")){
                                    temp.add(Float.parseFloat(sCurrentLine));
                                }
                                contador++;
                                pData.add(temp);
                                continue;                   
                            }
                            if(contador == 6 || contador == 7){
                                ArrayList<Integer> tempI = new ArrayList<>();
                                tempI.add(Integer.parseInt(sCurrentLine));
                                while(!(sCurrentLine = br.readLine()).equals("@") ){
                                    tempI.add(Integer.parseInt(sCurrentLine));
                                }
                                contador++;
                                pData.add(tempI);                 
                                continue;
                            }
                            if(contador == 8){
                                ArrayList<Integer> tempI = new ArrayList<>();
                                tempI.add(Integer.parseInt(sCurrentLine));
                                while((sCurrentLine = br.readLine()) != null ){
                                    tempI.add(Integer.parseInt(sCurrentLine));
                                }
                                contador++;
                                pData.add(tempI);
                            }
                        }
                        

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
                                
                                return true;

			} catch (IOException ex) {

				//ex.printStackTrace();
                                return false;

			}

		}

	}
    
    
}
