package Progetto;

import Libreria.CreatoreMenu;
import Libreria.Read;

public class MainMenu {


	public static void main(String[] args) {
		Read lettore=new Read();
		lettore.explore("PgAr2018_Story_2.1.xml");
//		System.out.println(Raccolta.storie.get(0).getTitolo());
//		System.out.println(Raccolta.storie.get(0).paragrafi.get(0).getId());
//		System.out.println(Raccolta.storie.get(0).paragrafi.get(0).getTipo());
//		System.out.println(Raccolta.storie.get(0).paragrafi.get(1).getLink(0));
//		System.out.println(Raccolta.storie.get(0).paragrafi.get(1).getDescrizione());
//		System.out.println(Raccolta.storie.get(0).paragrafi.get(1).getOpzione(0));
		Raccolta.storie.get(0).stampaStoria(2);
//		Read lettore1=new Read();
//		lettore1.explore("PgAr2018_Story_2.2.xml");
//		System.out.println(Raccolta.storie.get(1).getTitolo());
//		System.out.println(Raccolta.storie.get(1).paragrafi.get(0).getId());
//		System.out.println(Raccolta.storie.get(1).paragrafi.get(0).getTipo());
//		System.out.println(Raccolta.storie.get(1).paragrafi.get(0).getLink());
//		System.out.println(Raccolta.storie.get(1).paragrafi.get(0).getDescrizione());
//		System.out.println(Raccolta.storie.get(1).paragrafi.get(0).getOpzioni());
	}

}
