package rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer02.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer02.model.Predmet;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer02.model.Student;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer02.utils.PomocnaKlasa;

public class StudentskaSluzbaUI {

	// ispis teksta osnovnih opcija
	private static void ispisiMenu() {
		System.out.println("Studentska Sluzba - Meni:");
		System.out.println("\t1 - Spisak studenata");
		System.out.println("\t2 - Unos studenta");
		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}

	public static void main(String[] args) {
		// otvaranje konekcije, jednom na pocetku aplikacije
		Connection conn;
		try {
			// ucitavanje MySQL drajvera
			Class.forName("com.mysql.jdbc.Driver");
			// otvaranje konekcije
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentskasluzba?useSSL=false", 
					"root", 
					"root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			// kraj aplikacije
			return;
		}

		// prikaz menija
		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
				case "1":
					prikaziSveStudenteSaPredmetimaBezJoin(conn);
//					prikaziSveStudenteSaPredmetimaSaJoin(conn);
					break;
				case "2":
					unosStudenta(conn);
					break;
				case "x":
					System.out.println("Izlaz");
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static Predmet pronadjiPredmetPoID(Connection conn, int id) {
		Predmet predmet = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT naziv FROM predmeti WHERE predmet_id = " + id;

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) { 
				String naziv = rset.getString(1);
				predmet = new Predmet(id, naziv);
			} else {
				System.out.println("Greska u SQL upitu!");
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return predmet;
	}
	
	private static List<Predmet> pronadjiPredmetePoStudentID(Connection conn, int studentID) {
		 // lista predmeta u memoriji
		List<Predmet> predmetiKojeStudentPohadja = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT predmet_id FROM pohadja WHERE student_id = " + studentID;

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			// za svako pohadjanje predmeta od strane studenta
			while (rset.next()) {
				int predmetID = rset.getInt(1);

				// dobaviti predmet koji student pohadja
				Predmet predmet = pronadjiPredmetPoID(conn, predmetID);
				// dodati predmet u listu predmeta
				predmetiKojeStudentPohadja.add(predmet);
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return predmetiKojeStudentPohadja;
	}

	private static void prikaziSveStudenteSaPredmetimaBezJoin(Connection conn) {
		List<Student> studenti = new ArrayList<>(); // lista studenata u memoriji

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT student_id, indeks, ime, prezime, grad FROM studenti";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			 // za svakog studenta iz baze
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String indeks = rset.getString(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String grad = rset.getString(index++);

				// dobaviti predmete koje student pohadja
				List<Predmet> predmetiKojePohadja = pronadjiPredmetePoStudentID(conn, id);

				// kreirati studenta u memoriji
				Student student = new Student(id, indeks, ime, prezime, grad);
				// povezati predmete sa studentom
				student.getPredmeti().addAll(predmetiKojePohadja);
				// dodati studenta u listu svih studenata
				studenti.add(student); 
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		// sada postoji napunjenu listu studenata u memoriji 
		// proci kroz listu i ispisujemo podatke o svakom studentu
		System.out.println();
		System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
				"indeks", 
				"ime", 
				"prezime", 
				"grad", 
				"predmeti"); System.out.println();
		System.out.println("========== ==================== ==================== ==================== ====================");
		for (Student itStudent: studenti) {
			System.out.printf("%-10s %-20s %-20s %-20s", 
					itStudent.getIndeks(), 
					itStudent.getIme(), 
					itStudent.getPrezime(), 
					itStudent.getGrad()); System.out.println();
			for (Predmet itPredmet: itStudent.getPredmeti()) {
				System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
						"", "", "", "", 
						itPredmet.getNaziv()); System.out.println();
			}
			System.out.println("---------- -------------------- -------------------- -------------------- --------------------");
		}
	}
	
	private static void prikaziSveStudenteSaPredmetimaSaJoin(Connection conn) {
//		Map<Integer, Student> studenti = new HashMap<>(); // mapa studenata
		Map<Integer, Student> studenti = new LinkedHashMap<>(); // mapa studenata

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT s.student_id, s.indeks, s.ime, s.prezime, s.grad, pr.predmet_id, pr.naziv FROM studenti s "
					+ "LEFT JOIN pohadja poh ON s.student_id = poh.student_id "
					+ "LEFT JOIN predmeti pr ON pr.predmet_id = poh.predmet_id " 
					+ "ORDER BY s.student_id";
	
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query); 

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String indeks = rset.getString(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String grad = rset.getString(index++);

				/* join ce za svakog studenta vratiti onoliko redova koliko on pohadja predmeta
				 * (umnozice se kolone koje sadrze podatke o istom studentu)
				 * mozda je ovaj student vec dodat u mapu
				 * dodati studenta u mapu ako nije vec dodat. Ako jeste, samo preuzeti referencu
				 * */
				Student student = studenti.get(id);
				if (student == null) {
					// kreirati novog studenta
					student = new Student(id, indeks, ime, prezime, grad);
					// dodati studenta u mapu svih studenata
					studenti.put(id, student);
				}	
				
				int idPredmeta = rset.getInt(index++);
				// ako student nema predmete koje pohadja, idPredmeta je 0, a nazivPredmeta je null
				if (idPredmeta != 0) { 
					String nazivPredmeta = rset.getString(index++);

					Predmet p = new Predmet(idPredmeta, nazivPredmeta);
					student.getPredmeti().add(p);
				}
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		// sada imamo napunjenu mapu studenata u memoriji
		// prolazimo kroz vrednosti mape i ispisujemo podatke o svakom studentu
		System.out.println();
		System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
				"indeks", 
				"ime", 
				"prezime", 
				"grad", 
				"predmeti"); System.out.println();
		System.out.println("========== ==================== ==================== ==================== ====================");
		for (Student itStudent: studenti.values()) {
			System.out.printf("%-10s %-20s %-20s %-20s", 
					itStudent.getIndeks(), 
					itStudent.getIme(), 
					itStudent.getPrezime(), 
					itStudent.getGrad()); System.out.println();
			for (Predmet itPredmet: itStudent.getPredmeti()) {
				System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
						"", "", "", "", 
						itPredmet.getNaziv()); System.out.println();
			}
			System.out.println("---------- -------------------- -------------------- -------------------- --------------------");
		}
	}

	private static void unosStudenta(Connection conn) {
		System.out.println();
		System.out.print("Unesi indeks:");
		String stIndex = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi ime:");
		String stIme = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi prezime:");
		String stPrezime = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi grad:");
		String stGrad = PomocnaKlasa.ocitajTekst();

		// kreiramo objekat student u memoriji
		Student student = new Student(0, stIndex, stIme, stPrezime, stGrad);

		// sadrzaj objekta ubacimo u bazu podataka
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO studenti (indeks, ime, prezime, grad) VALUES (?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, student.getIndeks());
			pstmt.setString(index++, student.getIme());
			pstmt.setString(index++, student.getPrezime());
			pstmt.setString(index++, student.getGrad());

			if (pstmt.executeUpdate() != 1)
				System.out.println("Greska u SQL upitu!");
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		System.out.println("Student je uspesno dodan.");
	}

}
