package com.UI;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import com.model.SvetskoPrvenstvo;

import pomocnaKlasa.PomocnaKlasa;

public class SvetskoPrvenstvoUI {
	
	private static void ispisiMenu3() {
		System.out.println();
		System.out.println("Meni:");
		System.out.println("\t1 - Unos prvenstva");
		System.out.println("\t2 - Izmena prvenstva");

		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}
	
	public static void ispisPrve() {
		System.out.println();
		System.out.printf("%-5s %-20s %-20s %-20s", "godina", "Naziv", "Domacin", "Osvajac"); 
		System.out.println();
		System.out.println("===== ==================== ==================== ====================");
		for (SvetskoPrvenstvo temp: PopuniListe.prvenstva) {
			System.out.printf("%-5s %-20s %-20s %-20s", temp.getGodina(), temp.getNaziv(), temp.getDomacin(), temp.getOsvajac());
			System.out.println();
		}

	}
	
	public static void unosIzmena2(Connection conn) {
		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu3();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				unosPrvenstva(conn);
				PopuniListe.prikaz2(conn);
				break;
			case "2":
				izmenaPrvenstva(conn);
				PopuniListe.prikaz2(conn);
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
	public static void unosPrvenstva(Connection conn) {


		System.out.print("Uneti godinu:");
		int godina = PomocnaKlasa.ocitajCeoBroj();

		System.out.print("Uneti naziv:");
		String naziv = PomocnaKlasa.ocitajTekst();


		System.out.print("Uneti id domacina: ");
		int dom = PomocnaKlasa.ocitajCeoBroj();

		System.out.print("Uneti id osvajaca: ");
		int osv = PomocnaKlasa.ocitajCeoBroj();

		// kreiramo objekat student u memoriji



		// sadrzaj objekta ubacimo u bazu podataka
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO prvenstva.prvenstvo (godina,naziv,domacin,osvajac) VALUES (?,?,?,?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setInt(index++, godina);
			pstmt.setString(index++, naziv );
			pstmt.setInt(index++, dom);
			pstmt.setInt(index++, osv);

			if (pstmt.executeUpdate() != 1)
				System.out.println("Greska u SQL upitu!");
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		System.out.println("Prvestvo je uspesno dodato");

	}
	public static void izmenaPrvenstva(Connection conn) {

		System.out.print("Uneti godinu:");
		int godina = PomocnaKlasa.ocitajCeoBroj();

		System.out.print("Uneti novi naziv:");
		String naziv = PomocnaKlasa.ocitajTekst();


		System.out.print("Uneti novi id domacina: ");
		int dom = PomocnaKlasa.ocitajCeoBroj();

		System.out.print("Uneti novi id osvajaca: ");
		int osv = PomocnaKlasa.ocitajCeoBroj();


		// sadrzaj objekta ubacimo u bazu podataka
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE prvenstva.prvenstvo SET naziv = ?, domacin =?, osvajac =?  WHERE godina = ? ";

			pstmt = conn.prepareStatement(query);
			int index =1;
			pstmt.setString(index++, naziv);
			pstmt.setInt(index++, dom);
			pstmt.setInt(index++, osv);
			pstmt.setInt(index++, godina);
			if (pstmt.executeUpdate() != 1)
				System.out.println("Greska u SQL upitu!");
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		System.out.println("Drzava je uspesno izmenjena");

	}
	
	
}
