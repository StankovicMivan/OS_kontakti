package UI;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DAO.KursDAO;
import DAO.NastavnikDAO;
import Model.Kurs;
import Model.Nastavnik;
import Model.Ucenik;
import PomocnaKlasa.PomocnaKlasa;


public class NastavnikUI {
	public static int nastavnik_id;
	
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

				ispisiSveNastavnike(conn);
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

	private static void brisanje(Connection conn) {
		Nastavnik st = pronadjiNastavnika(conn);
		if (st != null) {
			NastavnikDAO.delete(conn, st.getId());
		}
	}
	private static void izmena(Connection conn) {
		Nastavnik st = pronadjiNastavnika(conn);
		if (st != null) {
			System.out.println("Unesite ime:");
			String ime = PomocnaKlasa.ocitajTekst();
			st.setIme(ime);
			System.out.println("Unesite prezime:");
			String prezime = PomocnaKlasa.ocitajTekst();
			st.setPrezime(prezime);

			if(NastavnikDAO.update(conn, st)) {
				System.out.println("Uspesna izmena");
			}else
				System.out.println("corak");
		}
	}
	public static Nastavnik pronadjiNastavnika(Connection conn) {
		Nastavnik retVal = null;
		System.out.print("Unesi id nastavnika:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		retVal = pronadjiNastavnika(conn, id);
		if (retVal == null)
			System.out.println("Nastavnik sa id " + id
					+ " ne postoji u evidenciji");
		return retVal;
	}

	// pronadji studenta
	public static Nastavnik pronadjiNastavnika(Connection conn, int id) {
		Nastavnik retVal = NastavnikDAO.getNastavnikById(conn, id);
		return retVal;
	}
	private static void unos(Connection conn) {
		System.out.println("Unesite ime Nastavnika:");
		String ime = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite prezime:");
		String prezime = PomocnaKlasa.ocitajTekst();

		Nastavnik nastavnik = new Nastavnik(ime,prezime);
		if(NastavnikDAO.add(conn, nastavnik)) {
			while(PomocnaKlasa.ocitajOdlukuOPotvrdi("Da li zelite da profesoru dodate krus?") != 'N') {
				System.out.println("Unesite id kursa na koji zelite da ga dodate:");
				int id_kursa = PomocnaKlasa.ocitajCeoBroj();
				Kurs kurs = null;
				try {
					kurs = KursDAO.getKursByID(conn, id_kursa);
				}catch (Exception e) {
					System.out.println("Kurs sa tim id-em ne postoji");
				}
				//			
				Nastavnik newNastavnik = new Nastavnik(nastavnik_id,nastavnik.getIme(),nastavnik.getPrezime());

				if(KursDAO.addOnKursNastavnik(conn, newNastavnik, kurs)) {
					System.out.println("nastavnik je uspesto dodat na kurs");

				}
			}
		}else
			System.out.println("Greska pri unosu nastavnika u bazu");
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
	public static void ispisiSveNastavnike(Connection conn) {
		
		HashMap<Nastavnik,ArrayList<Kurs>> predaje1 = NastavnikDAO.getAll(conn);



		ArrayList<Nastavnik> temp = new ArrayList<>();
		for (Nastavnik n : predaje1.keySet()) {
			temp.add(n);
//			System.out.println(n);
		}
		System.out.printf("%-20s %-20s ","Nastavnik","Kurs koji predaje");
		System.out.println();
		System.out.println("----------------------------------------");
		for(int i =0;i<temp.size();i++) {
			System.out.println(temp.get(i));
			for(int j=0; j< predaje1.get(temp.get(i)).size();j++) {

				System.out.printf("%20s %-10s %-10s "," ",(predaje1.get(temp.get(i)).get(j).getNaziv()),(predaje1.get(temp.get(i)).get(j).getTip()));
				System.out.println();
			}
			System.out.println("----------------------------------------");

			System.out.println();
		}
		//		System.out.println();
		//		System.out.printf("%-10s %-20s %-20s  %-20s", 
		//				"id", 
		//				"ime", 
		//				"prezime", 
		//
		//				"predaje"); System.out.println();
		//				System.out.println("========== ==================== ==================== ==================== ====================");
		//				for (Nastavnik it: sviNastavnici) {
		//					System.out.printf("%-10s %-20s %-20s ", 
		//							it.getId(), 
		//							it.getIme(), 
		//							it.getPrezime()); 
		//					System.out.println();
		//					for (Kurs kurs: it.getKursevi()){ 
		//						if(!kurs.equals(null)) {
		//							System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
		//									"", "", "", "", 
		//									kurs.getNaziv()); System.out.println();
		//						}
		//					}
		//					System.out.println("---------- -------------------- -------------------- -------------------- --------------------");
		//				}
	}
}
