package Libreria;

import java.util.ArrayList;
import Libreria.InputDati;

/*
*	Questa classe rappresenta un menu testuale generico a piu' voci
*	Si suppone che la voce per uscire sia sempre associata alla scelta -1 
*	e sia presentata in fondo al menu
*	Bisogna poi ricordare che, per una scelta ottimale del passaggio da effettuare da parte dell'utente
*   Si è fatto in modo di passare i valori dei possibili link avviabili (con l'ArrayList scelte)
*
*/
public class CreatoreMenu {
	  final private static String CORNICE = "--------------------------------";
	  final private static String VOCE_USCITA = "-1\tEsci";
	  final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

	  private String titolo;
	  private ArrayList<String> voci = new ArrayList<String>();
	  ArrayList<Integer> scelte= new ArrayList<Integer>();


		
	  public CreatoreMenu (String titolo, ArrayList<String> voci, ArrayList<Integer> scelte)
	  {
		this.titolo = titolo;
		this.voci = voci;
		this.scelte=scelte;
	  }

	  public int scegli ()
	  {
		stampaMenu();
		return InputDati.leggiIntero(RICHIESTA_INSERIMENTO, -1, voci.size());	 
	  }
			
	  public void stampaMenu ()
	  {
		System.out.println(CORNICE);
		System.out.println(titolo);
		System.out.println(CORNICE);
	    for (int i=0; i<voci.size(); i++)
		 {
	    	if(scelte!=null)
		  System.out.println( (scelte.get(i) + "\t" + voci.get(i)));
	    	else
	    		System.out.println( (i+1) + "\t" + voci.get(i));
		 }
	    System.out.println();
		System.out.println(VOCE_USCITA);
	    System.out.println();
	  }
			
	}


