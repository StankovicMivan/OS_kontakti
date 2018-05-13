package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.ui.list;

import java.io.File;
import java.io.IOException;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.utils.PomocnaKlasa;


public class ApplicationUI_Ver_ArrayList {
	
	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\tOpcija broj 2 - Rad sa predmetima");
		System.out.println("\tOpcija broj 3 - Rad sa nastavnicima");
		System.out.println("\tOpcija broj 4 - Rad sa ispitnim rokovima");
		System.out.println("\tOpcija broj 5 - Rad sa pohađa");
		System.out.println("\tOpcija broj 6 - Rad sa predaje");
		System.out.println("\tOpcija broj 7 - Rad sa ispitnim prijavama");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void main(String[] args) throws IOException {
		String sP = System.getProperty("file.separator");
		
		File studentiFajl = new File("."+sP+"data"+sP+"studenti.csv");
		StudentUI_Ver_ArrayList.citajIzFajlaStudente(studentiFajl);
		
		File predmetiFajl = new File("."+sP+"data"+sP+"predmeti.csv");
		PredmetUI_Ver_ArrayList.citajIzFajlaPredmete(predmetiFajl);
		
		File pohadjaFajl = new File("."+sP+"data"+sP+"pohadja.csv");
		PohadjaUI_Ver_ArrayList.citajIzFajlaPohadja(pohadjaFajl);
		
		int odluka = -1;
		while(odluka!= 0){
			ApplicationUI_Ver_ArrayList.ispisiTekstOsnovneOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					StudentUI_Ver_ArrayList.meniStudentUI();
					break;
				case 2:
					PredmetUI_Ver_ArrayList.meniPredmetUI();
					break;
				case 5:
					PohadjaUI_Ver_ArrayList.menuPohadjaUI();
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}
		
		StudentUI_Ver_ArrayList.pisiUFajlStudente(studentiFajl);
		PredmetUI_Ver_ArrayList.pisiUFajlPredmete(predmetiFajl);
		PohadjaUI_Ver_ArrayList.pisiUFajlPohadja(pohadjaFajl);
		System.out.print("Program izvrsen");
	}
}
