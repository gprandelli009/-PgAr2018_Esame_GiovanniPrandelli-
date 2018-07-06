package Progetto;

import java.util.ArrayList;

import Libreria.CreatoreMenu;
import Libreria.InputDati;

public class MainMenu {


	public static void main(String[] args) {
		ArrayList<String> nomiXML = new ArrayList<String>();
		Raccolta raccolta= new Raccolta(); //viene creata una nuova raccolta
		storieAvviabili(nomiXML); 
		raccolta.raccogli(nomiXML);//Legge tutte le storie e salva i dati di ogni storia
		CreatoreMenu scegliStoria = new CreatoreMenu("Che storia vuoi fare?",nomiXML,null);
		scegliStoria.stampaMenu();//Permette la selezione tra le varie storie
		int storiaSelezionata=InputDati.leggiIntero("");
		Raccolta.storie.get(storiaSelezionata-1).stampaStoria(0);//permette di giocare con la storia selezionata
	}
	
	/*
	 * il seguente metodo aggiunge tutte le storie in formato xml
	 * all'Array che passerò alla raccolta
	 * 
	 */
	
	public static void storieAvviabili(ArrayList<String> aggiungiNomeXML){
		aggiungiNomeXML.add("PgAr2018_Story_2.1.xml");
		aggiungiNomeXML.add("PgAr2018_Story_2.2.xml");
		aggiungiNomeXML.add("PgAr2018_Story_2.3.xml");
//		aggiungiNomeXML.add("PgAr2018_Story_5.1.xml");
//		aggiungiNomeXML.add("PgAr2018_Story_5.2.xml");
//		aggiungiNomeXML.add("PgAr2018_Story_6.1.xml");
//		aggiungiNomeXML.add("PgAr2018_Story_6.2.xml");
	}

}
