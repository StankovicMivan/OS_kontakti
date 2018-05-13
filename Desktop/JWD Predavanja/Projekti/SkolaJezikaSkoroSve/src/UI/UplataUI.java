package UI;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import DAO.KursDAO;
import DAO.UcenikDAO;
import DAO.UplataDAO;
import Model.Kurs;
import Model.Ucenik;
import PomocnaKlasa.PomocnaKlasa;

public class UplataUI {

	public static void meni(Connection conn) {

		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu2();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				uplata(conn);
				break;
			case "2":
				ispis2(conn);
				break;
			case "3" :
				ispis3(conn);
				break;
			case "4" :

				ispisiSve(conn);
				break;	
			case "x":
				System.out.println("Izlaz");
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;

			}
		}

	}
	private static void ispisiSve(Connection conn) {

		
	}
	private static void ispis3(Connection conn) {

		System.out.println("Unesite id kursa:");
		int id_kurs = PomocnaKlasa.ocitajCeoBroj();
		Kurs kurs = null;
		try {
			kurs = KursDAO.getKursByID(conn, id_kurs);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HashMap<Kurs,ArrayList<Ucenik>> uplate = UplataDAO.get(conn, kurs);



		ArrayList<Kurs> temp = new ArrayList<>();
		for (Kurs n : uplate.keySet()) {
			temp.add(n);

		}
		System.out.printf("%-15s %-10s %-20s ","Naziv kursa", "Tip kursa","Ukupna zarada");
		System.out.println();
		System.out.println("----------------------------------------");
		
		double zarada =0;
		for(int i =0;i<temp.size();i++) {
			for(int j=0; j< uplate.get(temp.get(i)).size();j++) {
				
//				System.out.printf("%20s %-10s ",(uplate.get(temp.get(i)).get(j).getIme()),(uplate.get(temp.get(i)).get(j).getPrezime()));
				zarada += temp.get(i).getCena();
		
			
			}
			System.out.printf("%-15s %-10s %-20s ",temp.get(i).getNaziv(), temp.get(i).getTip(),zarada);
//			System.out.println("Ukupna zarada kursa iznos: " + zarada);
			
			System.out.println();
			System.out.println("----------------------------------------");

		}
	}

	private static void ispis2(Connection conn) {

		System.out.println("Unesite id kursa:");
		int id_kurs = PomocnaKlasa.ocitajCeoBroj();
		Kurs kurs = null;
		try {
			kurs = KursDAO.getKursByID(conn, id_kurs);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HashMap<Kurs,ArrayList<Ucenik>> uplate = UplataDAO.get(conn, kurs);



		ArrayList<Kurs> temp = new ArrayList<>();
		for (Kurs n : uplate.keySet()) {
			temp.add(n);

		}
		System.out.printf("%-20s %-20s ","Kurs","Ucenici koji pohadjaju kurs");
		System.out.println();
		System.out.println("----------------------------------------");
		
		for(int i =0;i<temp.size();i++) {
			System.out.println(temp.get(i).getNaziv()+" " + temp.get(i).getTip());
			for(int j=0; j< uplate.get(temp.get(i)).size();j++) {
				
				System.out.printf("%20s %-10s ",(uplate.get(temp.get(i)).get(j).getIme()),(uplate.get(temp.get(i)).get(j).getPrezime()));
		
				System.out.println();
			}
			
			System.out.println("----------------------------------------");

			System.out.println();
		}

	}
	private static void uplata(Connection conn) {
		System.out.println("Unesite id ucenika:");
		int id_ucenika = PomocnaKlasa.ocitajCeoBroj();
		
		System.out.println("Unesite id kursa:");
		int id_kurs = PomocnaKlasa.ocitajCeoBroj();

		Ucenik ucenik = null;
		try {
			ucenik = UcenikDAO.getUcenikByID(conn, id_ucenika);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Kurs kurs = null;
		try {
			kurs = KursDAO.getKursByID(conn, id_kurs);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(UplataDAO.addUplata(conn, ucenik, kurs)) {
			while(PomocnaKlasa.ocitajOdlukuOPotvrdi("Da li zelite da platite jos neki kurs?") != 'N') {
				System.out.println("Unesite id kursa na koji zelite platite:");
				int id_kursa = PomocnaKlasa.ocitajCeoBroj();
				kurs = null;
				try {
					kurs = KursDAO.getKursByID(conn, id_kursa);
				}catch (Exception e) {
					System.out.println("Kurs sa tim id-em ne postoji");
				}
				//			
				

				if(UplataDAO.addUplata(conn, ucenik, kurs)) {
					System.out.println("Uplata je uspesno dodata");

				}
			}	
		}		
	}

	private static void ispisiMenu2() {
		System.out.println();
		System.out.println("Meni:");
		System.out.println("\t1 - Uplata ucenika");
		System.out.println("\t2 - Ispis svih uplata za odredjeni kurs");
		System.out.println("\t3 - Zarada od odredjenog kursa");
		System.out.println("\t4 - Prikaz svih ucenika koji nisu platili slusanje kursa");

		System.out.println("\tx - Vrati se nazad.");

	}
}