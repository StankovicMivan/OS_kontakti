package rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.utils.PomocnaKlasa;

public class ApplicationUI {

	private static Connection conn;
	
	static {
		// otvaranje konekcije, jednom na pocetku aplikacije
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
			System.exit(0);
		}
	}
	
	public static void main(String[] args)  {
		int odluka = -1;
		while (odluka != 0) {
			ApplicationUI.ispisiMenu();
			
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:
				StudentUI.menu();
				break;
			case 2:
				PredmetUI.menu();
				break;
			case 3:
				PohadjaUI.menu();
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
	
	// ispis teksta osnovnih opcija
	public static void ispisiMenu() {
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\tOpcija broj 2 - Rad sa predmetima");
		System.out.println("\tOpcija broj 3 - Rad sa pohadjanjem predmeta");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

	public static Connection getConn() {
		return conn;
	}
	
}
