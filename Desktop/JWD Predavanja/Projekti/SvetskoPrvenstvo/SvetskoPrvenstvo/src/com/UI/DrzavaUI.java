package com.UI;

import com.model.Drzava;

import pomocnaKlasa.PomocnaKlasa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DrzavaUI {

	public static void ispisiMenu2() {
		System.out.println();
		System.out.println("Meni:");
		System.out.println("\t1 - Unos Drzave");
		System.out.println("\t2 - Izmena Drzave");

		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}
	public static void ispisDrzava() {

		System.out.println();
		System.out.printf("%-5s %-20s ", "id", "naziv"); 
		System.out.println();
		System.out.println("===== ====================");
		for (Drzava temp: PopuniListe.drzave) {
			System.out.printf("%-5s %-20s", temp.getId(), temp.getNaziv());
			System.out.println();
		}
	}
	public static void unosIzmena(Connection conn) {
		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu2();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				unos(conn);
				PopuniListe.prikaz1(conn);
				break;
			case "2":
				izmena(conn);
				PopuniListe.prikaz1(conn);
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
	private static void unos(Connection conn) {
		System.out.print("Uneti naziv:");
		String naziv = PomocnaKlasa.ocitajTekst();


		// kreiramo objekat student u memoriji
		Drzava dr = new Drzava(0,naziv);

		// sadrzaj objekta ubacimo u bazu podataka
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO drzava (naziv) VALUES (?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, dr.getNaziv());

			if (pstmt.executeUpdate() != 1)
				System.out.println("Greska u SQL upitu!");
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		System.out.println("Drzava je uspesno dodata");
	}
	private static void izmena(Connection conn) {


		System.out.print("Uneti ID drzave:");
		int id = PomocnaKlasa.ocitajCeoBroj();


		System.out.print("Uneti naziv:");
		String naziv = PomocnaKlasa.ocitajTekst();


		// sadrzaj objekta ubacimo u bazu podataka
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE prvenstva.drzava SET naziv = ? WHERE id = ? ";

			pstmt = conn.prepareStatement(query);
			int index =1;
			pstmt.setString(index++, naziv);
			pstmt.setInt(index++, id);

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
