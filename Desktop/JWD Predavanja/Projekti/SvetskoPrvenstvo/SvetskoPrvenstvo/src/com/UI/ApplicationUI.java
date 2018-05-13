package com.UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pomocnaKlasa.PomocnaKlasa;



public class ApplicationUI {



	public static void main(String[] args) {

		Connection conn;
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prvenstva?useSSL=false", "root","root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			return;
		}
		//ocitava bazu i smesta je u liste koje se nalaze u PopuniListe klasi
		PopuniListe.prikaz1(conn);
		PopuniListe.prikaz2(conn);
	
		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				DrzavaUI.ispisDrzava();
				break;
			case "2":
				SvetskoPrvenstvoUI.ispisPrve();
				break;
			case "3":
				DrzavaUI.unosIzmena(conn);
				break;
			case "4" :
				SvetskoPrvenstvoUI.unosIzmena2(conn);
				break;
			case "5":
				Pretrage5UI.prikaz5(conn);
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
		System.out.println("\t1 - Prikazi sve drzave");
		System.out.println("\t2 - Prikazi sva svetska prvenstva");
		System.out.println("\t3 - Unos i izmenu drzava");
		System.out.println("\t4 - Unos i izmenu svetskih prvenstava");
		System.out.println("\t5 - Pretraga i prikaz svetskih prvenstava po godini odrzavanja");


		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}



}
