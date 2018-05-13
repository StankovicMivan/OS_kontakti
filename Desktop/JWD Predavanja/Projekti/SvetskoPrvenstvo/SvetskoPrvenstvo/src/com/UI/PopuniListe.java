package com.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Drzava;
import com.model.SvetskoPrvenstvo;


public class PopuniListe {


	public static ArrayList<SvetskoPrvenstvo> prvenstva = new ArrayList<>();
	public static ArrayList<Drzava> drzave = new ArrayList<>();
	

	static void prikaz2(Connection conn) {
		//		List<SvetskoPrvenstvo> prvenstvo = new ArrayList<>(); // imamo vec gore static listu

		prvenstva.clear();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT * FROM prvenstvo";

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
				for (int i = 0; i < drzave.size(); i++) {
					if (domacin==drzave.get(i).getId()) {
						dom = drzave.get(i);
					}
				}
				for (int i = 0; i < drzave.size(); i++) {
					if (osvajac==drzave.get(i).getId()) {
						osv = drzave.get(i);
					}

				}
				
				SvetskoPrvenstvo prvenstvo = new SvetskoPrvenstvo(godina, naziv, dom, osv);
				prvenstva.add(prvenstvo);
			}

		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		}  finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		
	}

	static void prikaz1(Connection conn) {
		//	List<Drzava> drzave = new ArrayList<>(); // lista studenata u memoriji
		drzave.clear();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT * FROM drzava";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			// citanje rezultata upita i punjenje liste
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);

				// kreiramo objekat u memoriji na osnovu preuzetog sloga iz baze
				//				Student student = new Student(id, indeks, ime, prezime);
				Drzava drzava = new Drzava(id,naziv);
				drzave.add(drzava);
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		}  finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

	}
}
