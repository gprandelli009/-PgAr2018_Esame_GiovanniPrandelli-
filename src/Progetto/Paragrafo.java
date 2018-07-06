package Progetto;

import java.util.ArrayList;

/*
 *Classe paragrafo, composta dal tipo di paragrafo, l'id che lo identifica, e tutti i link
 *alle varie opzioni del gioco
 */

public class Paragrafo {

	private ArrayList<Integer> link = new ArrayList<Integer>();
	private ArrayList<String> opzioni = new ArrayList<String>();
	private String tipo;		
	private String descrizione;
	private  int id;

	public Paragrafo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int nuovoId) {
		id=nuovoId;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String nuovaDescrizione) {
		descrizione=nuovaDescrizione;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String nuovoTipo) {
		tipo = nuovoTipo;
	}

	public void aggiungiLink(int linkAggiunto) {
		link.add(linkAggiunto);
	}

	public ArrayList<Integer> getLinks(){
		return link;
	}
	
	public int getLink(int puntatore){
		return link.get(puntatore);
	}
	
	public void aggiungiOpzione(String opzioneAggiunta) {
		opzioni.add(opzioneAggiunta);
	}

	public String getOpzione(int puntatore){
		return opzioni.get(puntatore);
	}
	
	public ArrayList<String> getOpzioni(){
		return opzioni;
	}

}
