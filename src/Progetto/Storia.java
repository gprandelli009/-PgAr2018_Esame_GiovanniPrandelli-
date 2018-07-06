package Progetto;

import java.util.ArrayList;

public class Storia {

	private String titolo; 
	private int dimensioneStoria;
	public ArrayList<Paragrafo> paragrafi = new ArrayList<Paragrafo>();

	public Storia() {

	}

	public void stampaStoria() {
		System.out.println(titolo);
		for(int i=0;i<dimensioneStoria;i++) {
			System.out.println(paragrafi.get(0).getId());
		}
	}
	
	public int getDimensione() {
		return dimensioneStoria;
	}
	
	public void setDimensione(int dimensione) {
		dimensioneStoria=dimensione;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String nuovoTitolo) {
		titolo=nuovoTitolo;
	}
}
