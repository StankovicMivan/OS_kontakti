package menjacnica.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menjacnica.utils.PomocnaKlasa;

public class ApplicationUI {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menjacnica?useSSL=false", 
					"root", 
					"root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			System.exit(0);
		}

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
					ValutaUI.prikazSvih(conn);
					break;
				case 2:
					KursnaListaUI.prikaz(conn);
					break;
				case 3:
					KursnaListaUI.unos(conn);
					break;
				case 4:
					ValutaUI.statistika(conn);
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}
		
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void ispisiMenu() {
		System.out.println("Menjacnica - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Prikaz svih valuta");
		System.out.println("\tOpcija broj 2 - Prikaz određene kursne liste sa spiskom svih valuta");
		System.out.println("\tOpcija broj 3 - Kreiranje nove kursne liste");
		System.out.println("\tOpcija broj 4 - Statistika");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

}
