package Progetto;

import java.util.ArrayList;

import Libreria.CreatoreMenu;

public class Storia {

	private String titolo; 
	private int dimensioneStoria;
	public ArrayList<Paragrafo> paragrafi = new ArrayList<Paragrafo>();

	public Storia() {

	}

	public void stampaStoria(int prossimoParagrafo) {
		CreatoreMenu menu= new CreatoreMenu(titolo,paragrafi.get(prossimoParagrafo).getOpzioni(),paragrafi.get(prossimoParagrafo).getLinks());
		menu.stampaMenu();
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
