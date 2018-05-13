package UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import DAO.KursDAO;
import DAO.NastavnikDAO;
import DAO.UcenikDAO;
import Model.Kurs;
import Model.Nastavnik;
import Model.Ucenik;
import PomocnaKlasa.PomocnaKlasa;


public class UcenikUI {

	public static int ucenik_id ;
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

				ispisiSve(conn);
				break;	
			case "5":
				dodajStudentaNaKurs(conn);
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

	private static void dodajStudentaNaKurs(Connection conn) {
		System.out.println("Unesite ID ucenika:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		Ucenik st = null;
		try {
			st = UcenikDAO.getUcenikByID(conn, id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Unesite id kursa na koji zelite da ga dodate:");
		int id_kursa = PomocnaKlasa.ocitajCeoBroj();
		Kurs kurs = null;
		try {
			kurs = KursDAO.getKursByID(conn, id_kursa);
		}catch (Exception e) {
			System.out.println("Kurs sa tim id-em ne postoji");
		}
		if(st != null && kurs != null) {
			if(KursDAO.addOnKursUcenik(conn, st, kurs)) {
				System.out.println("Ucenik je uspesto dodat na kurs");

			}
		}
	}

	private static void ispisiSve(Connection conn) {
		HashMap<Ucenik,ArrayList<Kurs>> pohadja = UcenikDAO.getAll(conn);



		ArrayList<Ucenik> temp = new ArrayList<>();
		for (Ucenik n : pohadja.keySet()) {
			temp.add(n);

		}
		System.out.printf("%-20s %-20s ","Ucenik","Predmeti koje pohadja");
		System.out.println();
		System.out.println("----------------------------------------");
		for(int i =0;i<temp.size();i++) {
			System.out.println(temp.get(i));
			for(int j=0; j< pohadja.get(temp.get(i)).size();j++) {

				System.out.printf("%20s %-10s %-10s "," ",(pohadja.get(temp.get(i)).get(j).getNaziv()),(pohadja.get(temp.get(i)).get(j).getTip()));
				System.out.println();
			}
			System.out.println("----------------------------------------");

			System.out.println();
		}
	}

	private static void brisanje(Connection conn) {
		System.out.println("Unesite ID ucenika:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		Ucenik st = UcenikDAO.getUcenikByID(conn, id);
		if (st != null) {
			UcenikDAO.delete(conn, st.getId());
		}
	}

	private static void izmena(Connection conn) {
		System.out.println("Unesite ID ucenika:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		Ucenik st = UcenikDAO.getUcenikByID(conn, id);
		if (st != null) {
			System.out.println("Unesite ime:");
			String ime = PomocnaKlasa.ocitajTekst();
			st.setIme(ime);
			System.out.println("Unesite prezime:");
			String prezime = PomocnaKlasa.ocitajTekst();
			st.setPrezime(prezime);

			if(UcenikDAO.update(conn, st)) {
				System.out.println("Uspesna izmena");
			}else
				System.out.println("corak");
		}

	}



	private static void unos(Connection conn) {
		System.out.println("Unesite ime:");
		String ime = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite prezime:");
		String prezime = PomocnaKlasa.ocitajTekst();

		Ucenik ucenik = new Ucenik(ime,prezime);
		if(UcenikDAO.add(conn, ucenik)) {
			while(PomocnaKlasa.ocitajOdlukuOPotvrdi("Da li zelite da dodate ucenika da pohadja kurs?") != 'N') {
				System.out.println("Unesite id kursa na koji zelite da ga dodate:");
				int id_kursa = PomocnaKlasa.ocitajCeoBroj();
				Kurs kurs = null;
				try {
					kurs = KursDAO.getKursByID(conn, id_kursa);
				}catch (Exception e) {
					System.out.println("Kurs sa tim id-em ne postoji");
				}
				//			
				Ucenik newUcenik = new Ucenik(ucenik_id,ucenik.getIme(),ucenik.getPrezime());

				if(KursDAO.addOnKursUcenik(conn, newUcenik, kurs)) {
					System.out.println("Ucenik je uspesto dodat na kurs");

				}
			}	
		}

	}

	private static void ispisiMenu2() {
		System.out.println();
		System.out.println("Meni:");
		System.out.println("\t1 - Unos");
		System.out.println("\t2 - Izmena");
		System.out.println("\t3 - Brisanje ");
		System.out.println("\t4 - Prikaz svih");
		System.out.println("\t5 - Dodajte ucenika na kurs");
		System.out.println("\tx - Vrati se nazad.");

	}

}
