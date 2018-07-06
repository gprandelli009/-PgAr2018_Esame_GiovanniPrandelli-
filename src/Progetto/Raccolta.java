package Progetto;

import java.util.ArrayList;

import Libreria.Read;

public class Raccolta {

	static 	public ArrayList<Storia> storie = new ArrayList<Storia>(); 
	
	public Raccolta() {
		
	}
	
	public void raccogli(ArrayList<String> nomeXML) {
		for(int k=0;k<nomeXML.size();k++) {
			Read lettore=new Read();
			lettore.explore(nomeXML.get(k));
		}
	}
}
