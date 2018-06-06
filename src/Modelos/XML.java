/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;



/**
 *
 * @author MICHA
 */
public class XML implements TipoFormato{

    @Override
    public boolean guardarArchivo(String pPiso, ArrayList<String> pP1, ArrayList<String> pP2, String pElevadores, ArrayList<String> pP3,
            ArrayList<String> pP4, ArrayList<String> pUTEntrePisos,ArrayList<String> pUTPuertasAbiertas, ArrayList<String> pMaxPersonas,
            String pNombre, String pUbicacion) {
        
         try {
         DocumentBuilderFactory dbFactory =
         DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         Element root = doc.createElement("config");
         doc.appendChild(root);
         
         
         // Numero Pisos
         Element elemPisos = doc.createElement("pisos");
         root.appendChild(elemPisos);
         elemPisos.appendChild(doc.createTextNode(pPiso));
         
         //P1
         Element elemP1 = doc.createElement("p1");
         root.appendChild(elemP1);
         for(int i=0; i < pP1.size(); i++){
            Element temp = doc.createElement("p1-" + String.valueOf(i));
            elemP1.appendChild(temp);
            temp.appendChild(doc.createTextNode(pP1.get(i)));
         }
         //P2
         Element elemP2 = doc.createElement("p2");
         root.appendChild(elemP2);
         for(int i=0; i < pP2.size(); i++){
             Element temp = doc.createElement("p2-" + String.valueOf(i));
             elemP2.appendChild(temp);
             temp.appendChild(doc.createTextNode(pP2.get(i)));
         }
         
          // Numero Elevadores
         Element elemElevadores = doc.createElement("elevadores");
         root.appendChild(elemElevadores);
         elemElevadores.appendChild(doc.createTextNode(pElevadores));
         
          //P3
         Element elemP3 = doc.createElement("p3");
         root.appendChild(elemP3);
         for(int i=0; i < pP3.size(); i++){
             Element temp = doc.createElement("p3-" + String.valueOf(i));
             elemP3.appendChild(temp);
             temp.appendChild(doc.createTextNode(pP3.get(i)));
         }
         
          //P4
         Element elemP4 = doc.createElement("p4");
         root.appendChild(elemP4);
         for(int i=0; i < pP4.size(); i++){
             Element temp = doc.createElement("p4-" + String.valueOf(i));
             elemP4.appendChild(temp);
             temp.appendChild(doc.createTextNode(pP4.get(i)));
         }
         
           //UTPisos
         Element elemUTPisos = doc.createElement("utpisos");
         root.appendChild(elemUTPisos);
         for(int i=0; i < pUTEntrePisos.size(); i++){
             Element temp = doc.createElement("utpisos-" + String.valueOf(i));
             elemUTPisos.appendChild(temp);
             temp.appendChild(doc.createTextNode(pUTEntrePisos.get(i)));
         }
         
            //UTPuertas
         Element elemUTPuertas = doc.createElement("utpuertas");
         root.appendChild(elemUTPuertas);
         for(int i=0; i < pUTPuertasAbiertas.size(); i++){
             Element temp = doc.createElement("utpuertas-" + String.valueOf(i));
             elemUTPuertas.appendChild(temp);
             temp.appendChild(doc.createTextNode(pUTPuertasAbiertas.get(i)));
         }
          //Maximo de personas
         Element elemMaxPersonas = doc.createElement("maxpersonas");
         root.appendChild(elemMaxPersonas);
         for(int i=0; i < pMaxPersonas.size(); i++){
             Element temp = doc.createElement("maxpersonas-" + String.valueOf(i));
             elemMaxPersonas.appendChild(temp);
             temp.appendChild(doc.createTextNode(pMaxPersonas.get(i)));
         }
         
         
         
         
         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File(pUbicacion+pNombre));
         transformer.transform(source, result);
         
         // Output to console for testing
         /*StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);*/
         return true;
      } catch (Exception e) {
         
        e.printStackTrace();
        return false;
      }
    
        
    }

    @Override
    public boolean cargarArchivo(String pNombre, String pUbicacion, ArrayList<Object> pData) {
        try {

	File fXmlFile = new File(pUbicacion+pNombre);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	doc.getDocumentElement().normalize();
        	
	NodeList nPisos = doc.getElementsByTagName("pisos");
	pData.add(Integer.parseInt(nPisos.item(0).getTextContent()));
        
        ArrayList<Float> tempP1;
        tempP1 = new ArrayList<>();
        NodeList nP1 = doc.getElementsByTagName("p1").item(0).getChildNodes();
        for(int temp=0; temp < nP1.getLength(); temp++){
            if (nP1.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempP1.add(Float.parseFloat(nP1.item(temp).getTextContent()));
            }
        }
        pData.add(tempP1);
	
        ArrayList<Float> tempP2;
        tempP2 = new ArrayList<>();
        NodeList nP2 = doc.getElementsByTagName("p2").item(0).getChildNodes();
        for(int temp=0; temp < nP2.getLength(); temp++){
            if (nP2.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempP2.add(Float.parseFloat(nP2.item(temp).getTextContent()));
            }
        }
         pData.add(tempP2);

        NodeList nElevador = doc.getElementsByTagName("elevadores");
	pData.add(Integer.parseInt(nElevador.item(0).getTextContent()));
        
         
         ArrayList<Float> tempP3;
        tempP3 = new ArrayList<>();
        NodeList nP3 = doc.getElementsByTagName("p3").item(0).getChildNodes();
        for(int temp=0; temp < nP3.getLength(); temp++){
            if (nP3.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempP3.add(Float.parseFloat(nP3.item(temp).getTextContent()));
            }
        }
         pData.add(tempP3);
         
         
        ArrayList<Float> tempP4;
        tempP4 = new ArrayList<>();
        NodeList nP4 = doc.getElementsByTagName("p4").item(0).getChildNodes();
        for(int temp=0; temp < nP4.getLength(); temp++){
            if (nP4.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempP4.add(Float.parseFloat(nP4.item(temp).getTextContent()));
            }
        }
         pData.add(tempP4);
         
        ArrayList<Integer> tempUTPuerta;
        tempUTPuerta = new ArrayList<>();
        NodeList nUTPuerta = doc.getElementsByTagName("utpuertas").item(0).getChildNodes();
        for(int temp=0; temp < nUTPuerta.getLength(); temp++){
            if (nUTPuerta.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempUTPuerta.add(Integer.parseInt(nUTPuerta.item(temp).getTextContent()));
            }
        }
         pData.add(tempUTPuerta);
         
         
        ArrayList<Integer> tempUTPiso;
        tempUTPiso = new ArrayList<>();
        NodeList nUTPiso = doc.getElementsByTagName("utpisos").item(0).getChildNodes();
        for(int temp=0; temp < nUTPiso.getLength(); temp++){
            if (nUTPiso.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempUTPiso.add(Integer.parseInt(nUTPiso.item(temp).getTextContent()));
            }
        }
         pData.add(tempUTPiso);
         
        ArrayList<Integer> tempMaxPersonas;
        tempMaxPersonas = new ArrayList<>();
        NodeList nMaxPersonas = doc.getElementsByTagName("maxpersonas").item(0).getChildNodes();
        for(int temp=0; temp < nMaxPersonas.getLength(); temp++){
            if (nMaxPersonas.item(temp).getNodeType() == Node.ELEMENT_NODE) {
                tempMaxPersonas.add(Integer.parseInt(nMaxPersonas.item(temp).getTextContent()));
            }
        }
         pData.add(tempMaxPersonas);
        return true;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
          }

    }
}
    

