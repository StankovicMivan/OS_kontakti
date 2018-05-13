package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import PomocnaKlasa.PomocnaKlasa;
import UI.KursUI;
import UI.NastavnikUI;
import UI.SkolaUI;
import UI.UcenikUI;
import UI.UplataUI;

public class ApplicationUI {

	public static void main(String[] args) {


		Connection conn;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/skolaJezika?useSSL=false", "root","root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			return;
		}
		//ocitava bazu i smesta je u liste koje se nalaze u PopuniListe klasi


		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				SkolaUI.kreirajSkolu(conn);
				break;
			case "2":
				NastavnikUI.meni(conn);	
				break;
			case "3":
				UcenikUI.meni(conn);
				break;
			case "4" :
				KursUI.meni(conn);
				break;
			case "5":
				UplataUI.meni(conn);
				break;

			case "x":
				System.out.println("Izlaz");
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}

		// zatvaranje konekcije
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}


	private static void ispisiMenu() {
		System.out.println();
		System.out.println("Meni:");
		System.out.println("\t1 - Kreiraj Skolu");
		System.out.println("\t2 - Rad sa nastavnicima");
		System.out.println("\t3 - Rad sa ucenicima");
		System.out.println("\t4 - Rad sa kursevima");
		System.out.println("\t5 - Rad sa uplatama");


		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}
}
