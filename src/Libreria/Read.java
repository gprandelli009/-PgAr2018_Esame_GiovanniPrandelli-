package Libreria;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import Progetto.*;

/*
 * 
 * Classe che permette la lettura delle storie e l'acquisizione dei dati che compongono quest'ultime
 * 
 */

public class Read {
	Storia storia=new Storia();//Ogni volta che il read è chiamato viene creata una nuova storia
	int idDaPassare=0;
	String testo;
	int contatore=0;
	private ArrayList<String> stringheNelTesto = new ArrayList<String>();
	boolean continuaAdAcquisire=true;

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
					break;
				case XMLStreamConstants.START_ELEMENT:
					//System.out.println(xmlr.getLocalName()+ xmlr.getAttributeValue(0)+xmlr.getAttributeValue(1));
					scritturaStoria(xmlr.getLocalName(),xmlr.getAttributeValue(0),xmlr.getAttributeValue(1));
					//					if(xmlr.getLocalName().equals("description")) {
					//						continuaAdAcquisire=true;
					//					}
					break;
				case XMLStreamConstants.END_ELEMENT:

					break;
				case XMLStreamConstants.ATTRIBUTE:
					//System.out.println(xmlr.getAttributeValue(0));
					break;
				case XMLStreamConstants.NOTATION_DECLARATION:
					//System.out.println("Inside "+xmlr.getText());
					break;	            	
				case XMLStreamConstants.CHARACTERS:
					if(xmlr.getText().trim().length()>0) {
						//System.out.println(xmlr.getText());
						testo=xmlr.getText().trim();
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
		}
		catch(Exception e){
			System.err.println("Error detected");
			System.err.println(e.getMessage());
		}

		Raccolta.storie.add(storia); //La storia viene aggiunta a fine lettura alla raccolta
		for(int i=0;i<storia.getDimensione();i++) {
			boolean mettiDescrizione=true;
			for(int j=0;j<storia.paragrafi.get(i).getLinks().size()+1;j++) {
				if(mettiDescrizione) {
					storia.paragrafi.get(i).setDescrizione(stringheNelTesto.get(contatore));
					mettiDescrizione=false;
				}
				else {
					storia.paragrafi.get(i).aggiungiOpzione(stringheNelTesto.get(contatore));
				}
				contatore++;
			}
		}
	}

	public void scritturaStoria(String tag,String parametro1, String parametro2) {
		if(tag.equals("storygame")) { //if messo per escludere la creazione di un parametro indesiderato
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
			}
		}
	}
}