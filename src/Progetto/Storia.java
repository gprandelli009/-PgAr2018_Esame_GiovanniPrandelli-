package Progetto;

import java.util.ArrayList;

import Libreria.CreatoreMenu;
import Libreria.InputDati;

public class Storia {

	private String titolo; 
	private int dimensioneStoria;
	public ArrayList<Paragrafo> paragrafi = new ArrayList<Paragrafo>();

	public Storia() {

	}

	public void stampaStoria(int paragrafoCorrente) {
		CreatoreMenu menu= new CreatoreMenu(paragrafi.get(paragrafoCorrente).getDescrizione(),paragrafi.get(paragrafoCorrente).getOpzioni(),paragrafi.get(paragrafoCorrente).getLinks());
		menu.stampaMenu();
		int prossimoParagrafo=InputDati.leggiIntero("");
		if(prossimoParagrafo<0) {
			System.out.println("Grazie per aver giocato avventuriero, alla prossima missione!");
			return;
		}
		else {
			for(int puntatore:paragrafi.get(paragrafoCorrente).getLinks()) {
				if(puntatore==prossimoParagrafo) {
					stampaStoria(prossimoParagrafo);
				}
				else {
					System.out.println("Cortesemente, inserisci un'opzione valida");
					stampaStoria(paragrafoCorrente);
				}
			}
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
