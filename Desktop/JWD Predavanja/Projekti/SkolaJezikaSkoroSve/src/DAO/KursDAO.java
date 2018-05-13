package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Model.Kurs;
import Model.Nastavnik;
import Model.Ucenik;
import UI.KursUI;



public class KursDAO {
	
	public static Kurs getKursByID(Connection conn, int id) {
		Kurs kurs = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT naziv,tip,cena FROM kurs WHERE id = " + id;

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				int index =1;
				String naziv = rset.getString(index++);
				String tip = rset.getString(index++);
				double cena = rset.getDouble(index++);
				kurs = new Kurs(id, naziv,tip,cena);
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return kurs;
	}
	public static boolean addOnKursUcenik(Connection conn, Ucenik ucenik, Kurs kurs) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO pohadja (ucenik_id,kurs_id) VALUES (?, ?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setInt(index++, ucenik.getId());
			pstmt.setInt(index++, kurs.getId());

//			System.out.println(pstmt);
			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!!!!!!!!!!!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;

	}
	public static boolean addOnKursNastavnik(Connection conn, Nastavnik newNastavnik, Kurs kurs) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO predaje (nastavnik_id,kurs_id) VALUES (?, ?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setInt(index++, newNastavnik.getId());
			pstmt.setInt(index++, kurs.getId());

//			System.out.println(pstmt);
			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!!!!!!!!!!!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	public static boolean add(Connection conn, Kurs kurs) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO kurs (naziv,tip,cena) VALUES (?, ?,?)";

			pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			pstmt.setString(index++, kurs.getNaziv());
			pstmt.setString(index++, kurs.getTip());
			pstmt.setDouble(index++, kurs.getCena());
			

			pstmt.executeUpdate();
			ResultSet resaultSet = pstmt.getGeneratedKeys();
			if (resaultSet.next()) {
				KursUI.kurs_id = resaultSet.getInt(1);   

			}
			return true;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	public static boolean update(Connection conn, Kurs st) {
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE kurs SET naziv = ?, tip = ?,cena =? WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, st.getNaziv());
			pstmt.setString(index++, st.getTip());
			pstmt.setDouble(index++, st.getCena());
			pstmt.setInt(index++,st.getId());

			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	public static boolean delete(Connection conn, int id) {
		Statement stmt = null;
		try {
			String update = "DELETE FROM kurs WHERE id = " + id;

			stmt = conn.createStatement();
			return stmt.executeUpdate(update) == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	public static HashMap<Integer, Kurs> getAll(Connection conn) {

		HashMap<Integer,Kurs> kursevi = new HashMap<>();
		int keyit = 1;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT k.id, k.naziv, k.tip ,k.cena FROM kurs k " + 
					" ORDER BY k.naziv ASC";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);



			while (rset.next()) {
				Kurs kurs =null;

				int index = 1;

				int id = 0;
				String naziv = null;
				String tip = null;
				double cena= 0;
				try {
					id = rset.getInt(index++);
					naziv = rset.getString(index++);
					tip = rset.getString(index++);
					cena = rset.getDouble(index++);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
				kurs = new Kurs(id, naziv, tip,cena);
				try {
				
					kursevi.put(keyit, kurs);
					keyit++;
				}catch(Exception e) {
					e.getMessage();
				}
				
			}
			//


		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return kursevi;
	}

}
