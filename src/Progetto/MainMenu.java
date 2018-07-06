package Progetto;

import java.util.ArrayList;

import Libreria.CreatoreMenu;
import Libreria.InputDati;
import Libreria.Read;

public class MainMenu {


	public static void main(String[] args) {
		ArrayList<String> nomiXML = new ArrayList<String>();
		Raccolta raccolta= new Raccolta();
		storieAvviabili(nomiXML);
		raccolta.raccogli(nomiXML);
		CreatoreMenu scegliStoria = new CreatoreMenu("Che storia vuoi fare?",nomiXML,null);
		scegliStoria.stampaMenu();
		int storiaSelezionata=InputDati.leggiIntero("");
		Raccolta.storie.get(storiaSelezionata-1).stampaStoria(0);
//		Read lettore=new Read();
//		lettore.explore("PgAr2018_Story_5.1.xml");

//		Raccolta.storie.get(0).stampaStoria(0);
//		Read lettore1=new Read();
//		lettore1.explore("PgAr2018_Story_2.2.xml");
//		Read lettore2=new Read();
//		lettore2.explore("PgAr2018_Story_2.3.xml");
//		Raccolta.storie.get(0).stampaStoria(0);
	}
	
	public static void storieAvviabili(ArrayList<String> aggiungiNomeXML){
		aggiungiNomeXML.add("PgAr2018_Story_2.1.xml");
		aggiungiNomeXML.add("PgAr2018_Story_2.2.xml");
		aggiungiNomeXML.add("PgAr2018_Story_2.3.xml");
		aggiungiNomeXML.add("PgAr2018_Story_5.1.xml");
		aggiungiNomeXML.add("PgAr2018_Story_5.2.xml");
//		aggiungiNomeXML.add("PgAr2018_Story_6.1.xml");
//		aggiungiNomeXML.add("PgAr2018_Story_6.2.xml");
	}

}
