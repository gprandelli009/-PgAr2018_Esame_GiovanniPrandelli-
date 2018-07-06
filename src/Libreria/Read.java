package Libreria;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import Progetto.*;

public class Read {
	Storia storia=new Storia();
	int idDaPassare=0;
	String testo;
	private ArrayList<String> stringheNelTesto = new ArrayList<String>();


	public Read() {

	}

	public void explore(String filename) {
		try {

			XMLInputFactory xmlif=XMLInputFactory.newInstance();
			XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename,
					new FileInputStream(filename));
			while(xmlr.hasNext()) {
				switch(xmlr.getEventType()) {
				case XMLStreamConstants.START_DOCUMENT:
					System.out.println("Start Read Doc "+filename);
					break;
				case XMLStreamConstants.START_ELEMENT:
					//System.out.println(xmlr.getLocalName()+ xmlr.getAttributeValue(0)+xmlr.getAttributeValue(1));
					scritturaStoria(xmlr.getLocalName(),xmlr.getAttributeValue(0),xmlr.getAttributeValue(1));
				case XMLStreamConstants.ATTRIBUTE:
					//System.out.println(xmlr.getAttributeValue(0));
					break;
				case XMLStreamConstants.NOTATION_DECLARATION:
					//System.out.println("Inside "+xmlr.getText());
					break;	            	
				case XMLStreamConstants.CHARACTERS:
					if(xmlr.getText().trim().length()>0) {
						//System.out.println(xmlr.getText());
						testo=xmlr.getText();
						stringheNelTesto.add(testo);
					}
					break;
				case XMLStreamConstants.COMMENT:
					if(xmlr.getText().trim().length()>0)
						//System.out.println("-> "+xmlr.getText());
						break;
				default:
					break;
				}
				xmlr.next();

			}
		}catch(Exception e){
			System.err.println("Error detected");
			System.err.println(e.getMessage());
		}

		Raccolta.storie.add(storia);
        System.out.println(stringheNelTesto.get(0));
	}

	public void scritturaStoria(String tag,String parametro1, String parametro2) {
		if(tag.equals("storygame")) {
			System.out.println("Nuova storia avviata");
			return;	
		}
		if(tag.equals("story")) {
			storia.setTitolo(parametro1);
			storia.setDimensione(Integer.parseInt(parametro2));
		}
		else {
			if(tag.equals("paragraph")) {
				Paragrafo paragrafo = new Paragrafo();
				storia.paragrafi.add(paragrafo);
				paragrafo.setId(Integer.parseInt(parametro1));
				paragrafo.setTipo(parametro2);
				idDaPassare=Integer.parseInt(parametro1);
			}
			if(tag.equals("option")) {
				storia.paragrafi.get(idDaPassare).aggiungiLink(Integer.parseInt(parametro1));
				storia.paragrafi.get(idDaPassare).aggiungiOpzione(testo);
			}
			if(tag.equals("description")) {
				storia.paragrafi.get(idDaPassare).setDescrizione(testo);
			}
		}
	}
}
