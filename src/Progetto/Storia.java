package Progetto;

import java.util.ArrayList;

import Libreria.CreatoreMenu;
import Libreria.InputDati;

/*
 * Classe composta da un titolo che identifica una singola storia e da un insieme di paragrafi che la compongono
 */

public class Storia {

	private String titolo; 
	private int dimensioneStoria;
	public ArrayList<Paragrafo> paragrafi = new ArrayList<Paragrafo>();

	public Storia() {
	}
	
/*
 * Nel metodo stampaStoria si decide in quale paragrafo l'utente può andare per proseguire nella storia, 
 * Stando attenti a quali paragrafi siano accessibili, e in caso di errore, richiedere un altro percorso
 * 
 */
	
	public void stampaStoria(int paragrafoCorrente) {
		CreatoreMenu menu= new CreatoreMenu(paragrafi.get(paragrafoCorrente).getDescrizione(),paragrafi.get(paragrafoCorrente).getOpzioni(),paragrafi.get(paragrafoCorrente).getLinks());
		menu.stampaMenu();
		int prossimoParagrafo=InputDati.leggiIntero("");
		if(prossimoParagrafo<0) {
			System.out.println("Grazie per aver giocato avventuriero, alla prossima missione!");
			return;
		}
		else {
			boolean nonPossibile=true;
			for(int puntatore:paragrafi.get(paragrafoCorrente).getLinks()) {
				if(puntatore==prossimoParagrafo) {
					nonPossibile=false;
				}
			}
			if(!nonPossibile) {
				stampaStoria(prossimoParagrafo);
			}
			else {
				System.out.println("Cortesemente, inserisci un'opzione valida");
				stampaStoria(paragrafoCorrente);
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
