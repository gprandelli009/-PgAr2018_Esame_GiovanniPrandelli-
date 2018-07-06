package Progetto;

import java.util.ArrayList;

import Libreria.Read;
/*
 * la seguente classe crea un archivio dove è possibile inserire tutte le storie giocabili
 */

public class Raccolta {

	static 	public ArrayList<Storia> storie = new ArrayList<Storia>(); //Array che contiene le storie

	public Raccolta() {

	}
/*
 * metodo che inizializza tutte le storie, pronte per essere lette
 */
	public void raccogli(ArrayList<String> nomeXML) {
		for(int k=0;k<nomeXML.size();k++) {
			Read lettore=new Read();
			lettore.explore(nomeXML.get(k));
		}
	}
	
}
