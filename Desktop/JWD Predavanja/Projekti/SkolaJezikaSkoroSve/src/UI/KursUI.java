package UI;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import DAO.KursDAO;
import DAO.NastavnikDAO;
import DAO.UcenikDAO;
import Model.Kurs;
import Model.Nastavnik;
import Model.Ucenik;
import PomocnaKlasa.PomocnaKlasa;

public class KursUI {

	public static int kurs_id;
	
	public static void meni(Connection conn) {
		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu2();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				unos(conn);
				break;
			case "2":
				izmena(conn);
				break;
			case "3" :
				brisanje(conn);
				break;
			case "4" :

				ispisSveKurseve(conn);
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
		private static void ispisSveKurseve(Connection conn) {
			HashMap<Integer,Kurs> kursevi = KursDAO.getAll(conn);
			
			System.out.printf("%-3s %-20s %-20s %-20s ","Id","Naziv","Tip", "Cena");
			System.out.println();
			System.out.println("------------------------------------------------------------");
			for (Kurs it : kursevi.values()) {
				System.out.printf("%-3s %-20s %-20s %-20s ", it.getId(),it.getNaziv(),it.getTip(),it.getCena());
				System.out.println();
			}
				
			
	}
		private static void brisanje(Connection conn) {
			System.out.println("Unesite ID kursa:");
			int id = PomocnaKlasa.ocitajCeoBroj();
			Kurs st = KursDAO.getKursByID(conn, id);
			if (st != null) {
				KursDAO.delete(conn, st.getId());
			}
		
	}
		private static void izmena(Connection conn) {
			System.out.println("Unesite ID kursa:");
			int id = PomocnaKlasa.ocitajCeoBroj();
			Kurs st = KursDAO.getKursByID(conn, id);
			if (st != null) {
				System.out.println("Unesite naziv:");
				String naziv = PomocnaKlasa.ocitajTekst();
				st.setNaziv(naziv);
				System.out.println("Unesite tip:");
				String tip = PomocnaKlasa.ocitajTekst();
				st.setTip(tip);
				System.out.println("Unesite cenu:");
				double cena = PomocnaKlasa.ocitajRealanBroj();
				st.setCena(cena);
				if(KursDAO.update(conn, st)) {
					System.out.println("Uspesna izmena");
				}else
					System.out.println("corak");
			}
		
	}
		private static void unos(Connection conn) {
			System.out.println("Unesite naziv Kursa:");
			String naziv = PomocnaKlasa.ocitajTekst();
			System.out.println("Unesite tip kursa [osnovni,srednji,visi...]:");
			String tip = PomocnaKlasa.ocitajTekst();
			System.out.println("Unesite cenu kursa:");
			double cena = PomocnaKlasa.ocitajRealanBroj();
			
			Kurs kurs = new Kurs(naziv,tip,cena);
			if(KursDAO.add(conn, kurs)) {
				kurs = new Kurs(kurs_id,naziv,tip,cena);
				if(PomocnaKlasa.ocitajOdlukuOPotvrdi("Da li zelite da dodate profesora koji predaje kurs?") != 'N') {
					System.out.println("Unesite id profesora:");
					int id_profesora = PomocnaKlasa.ocitajCeoBroj();
					Nastavnik nastavnik =null;
					try {
						nastavnik = NastavnikDAO.getNastavnikById(conn, id_profesora);
					}catch (Exception e) {
						System.out.println("Nastavnik sa tim ID-em ne postoji");
					}
			
					if(KursDAO.addOnKursNastavnik(conn, nastavnik, kurs)) {
						System.out.println("Nastavnik je uspesto dodat na kurs");

					}
				}
				while(PomocnaKlasa.ocitajOdlukuOPotvrdi("Da li zelite da dodate polaznike kursa?") != 'N') {
					System.out.println("Unesite id ucenika kojeg zelite da dodate na kurs:");
					int id_ucenika = PomocnaKlasa.ocitajCeoBroj();
					Ucenik ucenik = null;
					try {
						ucenik = UcenikDAO.getUcenikByID(conn, id_ucenika);
					}catch (Exception e) {
						System.out.println("Ucenik sa tim id-em ne postoji");
					}
					
					if(KursDAO.addOnKursUcenik(conn, ucenik, kurs)) {
						System.out.println("Ucenik je uspesto dodat na kurs");

					}
					
				}
			}else
				System.out.println("Greska pri unosu u bazu");
		
	}
		public static void ispisiMenu2() {
			System.out.println();
			System.out.println("Meni:");
			System.out.println("\t1 - Unos");
			System.out.println("\t2 - Izmena");
			System.out.println("\t3 - Brisanje");
			System.out.println("\t4 - Prikaz svih");

			System.out.println("\tx - Vrati se nazad");
		}
}
