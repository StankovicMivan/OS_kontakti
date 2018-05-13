package rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.ui;

import java.util.List;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.utils.PomocnaKlasa;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.dao.PohadjaDAO;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.model.Predmet;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.model.Student;

public class PohadjaUI {
	private static void ispisiMenu() {
		System.out.println("Rad sa predmetima studenta - opcije:");
		System.out.println("\tOpcija broj 1 - predmeti koje student pohadja");
		System.out.println("\tOpcija broj 2 - studenti koji pohadjaju predmet");
		System.out.println("\tOpcija broj 3 - dodavanje studenta na predmet");
		System.out.println("\tOpcija broj 4 - uklanjanje studenta sa predmeta");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");
	}

	public static void menu() {
		int odluka = -1;
		while (odluka != 0) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				ispisiPredmeteZaStudenta();
				break;
			case 2:
				ispisiStudenteZaPredmet();
				break;
			case 3:
				dodajStudentaNaPredmet();
				break;
			case 4:
				ukloniStudentaSaPredmeta();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}

	private static void ispisiPredmeteZaStudenta() {
		// najpre pronadjemo studenta za kojeg zelimo ispis predmeta
		Student student = StudentUI.pronadjiStudenta();
		if (student != null) {
			List<Predmet> predmeti = PohadjaDAO.getPredmetiByStudentID(
					ApplicationUI.getConn(), student.getId());

			System.out.println();
			System.out.printf("%-10s %-20s",
					"id",
					"naziv"); System.out.println();
			System.out.println("========== ====================");
			for (Predmet itPredmet: predmeti) {
				System.out.printf("%-10s %-20s", 
						itPredmet.getId(),
						itPredmet.getNaziv()); System.out.println();
			}
		}
	}
	
	private static void ispisiStudenteZaPredmet() {
		// najpre pronadjemo predmet za koji zelimo ispis studenata
		Predmet predmet = PredmetUI.pronadjiPredmet();
		if (predmet != null) {
			List<Student> studenti = PohadjaDAO.getStudentiByPredmetID(
					ApplicationUI.getConn(), predmet.getId());
	
			System.out.println();
			System.out.printf("%-10s %-20s %-20s %-20s", 
					"indeks", 
					"ime", 
					"prezime", 
					"grad"); System.out.println();
			System.out.println("========== ==================== ==================== ====================");
			for (Student itStudent: studenti) {
				System.out.printf("%-10s %-20s %-20s %-20s", 
						itStudent.getIndeks(), 
						itStudent.getIme(), 
						itStudent.getPrezime(), 
						itStudent.getGrad()); System.out.println();
			}
		}
	}

	private static void dodajStudentaNaPredmet() {
		// najpre pronadjemo studenta kojeg zelimo da dodamo na predmet
		Student student = StudentUI.pronadjiStudenta();
		//pronadjemo predmet na koji zelimo da dodamo studenta
		Predmet predmet = PredmetUI.pronadjiPredmet();
		
		if (student != null && predmet != null) {
			//uspostavimo vezu izmedju studenta i predmeta
			PohadjaDAO.add(ApplicationUI.getConn(), student.getId(), predmet.getId());
		}
	}
	
	private static void ukloniStudentaSaPredmeta() {
		// najpre pronadjemo studenta kojeg zelimo da uklonimo sa predmeta
		Student student = StudentUI.pronadjiStudenta();
		//pronadjemo predmet sa kojeg zelimo da ukloniko studenta
		Predmet predmet = PredmetUI.pronadjiPredmet();
		
		if (student != null && predmet != null) {
			//uspostavimo vezu izmedju studenta i predmeta
			PohadjaDAO.delete(ApplicationUI.getConn(), student.getId(), predmet.getId());
		}
	}
}
