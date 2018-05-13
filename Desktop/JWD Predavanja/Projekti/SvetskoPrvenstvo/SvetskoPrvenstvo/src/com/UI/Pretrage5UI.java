package com.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Drzava;
import com.model.SvetskoPrvenstvo;

import pomocnaKlasa.PomocnaKlasa;

public class Pretrage5UI {


	static void prikazSvihDESC(Connection conn) {
		//		List<SvetskoPrvenstvo> prvenstvo = new ArrayList<>(); // imamo vec gore static listu

		PopuniListe.prvenstva.clear();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT godina,naziv,domacin,osvajac FROM prvenstva.prvenstvo " +"ORDER  BY godina DESC ";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			// citanje rezultata upita i punjenje liste
			while (rset.next()) {
				int index = 1;
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacin = rset.getInt(index++);
				int osvajac = rset.getInt(index++);

				Drzava dom = null;
				Drzava osv = null;
				for (int i = 0; i < PopuniListe.drzave.size(); i++) {
					if (domacin==PopuniListe.drzave.get(i).getId()) {
						dom = PopuniListe.drzave.get(i);
					}
				}
				for (int i = 0; i < PopuniListe.drzave.size(); i++) {
					if (osvajac==PopuniListe.drzave.get(i).getId()) {
						osv = PopuniListe.drzave.get(i);
					}

				}

				SvetskoPrvenstvo prvenstvo = new SvetskoPrvenstvo(godina, naziv, dom, osv);
				PopuniListe.prvenstva.add(prvenstvo);
			}
			System.out.printf("%-5s %-20s %-8s %-8s", "godina", "naziv", "domacin", "osvajac"); System.out.println();
			System.out.println("===== ==================== ======== ========");
			for (SvetskoPrvenstvo temp: PopuniListe.prvenstva) {
				System.out.printf("%-5s %-20s %-20s %-20s", temp.getGodina(), temp.getNaziv(), temp.getDomacin(), temp.getOsvajac());
				System.out.println();
			}

		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		}  finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}


	}


	public static void prikaz5(Connection conn) {
		String odluka = "";
		while (!odluka.equals("x")) {

			ispisiMenu4();

			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
			case "1":
				pretragaPoGodini(conn);
				break;
			case "2":
				prikazSvihDESC(conn);
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
	private static void pretragaPoGodini(Connection conn) {

		System.out.print("Uneti godinu:");
		int godina = PomocnaKlasa.ocitajCeoBroj();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT * FROM prvenstvo ";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			System.out.printf("%-5s %-20s %-8s %-8s", "godina", "naziv", "domacin", "osvajac"); System.out.println();
			System.out.println("===== ==================== ======== ========");
			// citanje rezultata upita
			while (rset.next()) {
				int index =1;
				int godina2 = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int dom = rset.getInt(index++);
				int osv = rset.getInt(index++);
				if(godina == godina2) {
					System.out.printf("%-5s %-20s %-8s %-8s", godina, naziv,dom,osv); 
					System.out.println();
				}
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
	}

	private static void ispisiMenu4() {
		System.out.println();
		System.out.println("Meni:");
		System.out.println("\t1 - Pretraga po godini");
		System.out.println("\t2 - Ispish svi po godini u opadajucem");

		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}


}
