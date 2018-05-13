package rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.model.Predmet;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer03.model.Student;

// CRUD operacije nad predmetom
public class PredmetDAO {
	
	public static Predmet getPredmetByID(Connection conn, int id) {
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

	public static Predmet getPredmetByNaziv(Connection conn, String naziv) {
		Predmet predmet = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT predmet_id FROM predmeti WHERE naziv = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, naziv);
					
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				index = 1;
				int id = rset.getInt(index++);
				predmet = new Predmet(id, naziv);
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return predmet;
	}
	
	public static List<Predmet> getAll(Connection conn) {
		List<Predmet> predmeti = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT predmet_id, naziv FROM predmeti";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);
	
				List<Student> studentiKojiPohadjajuPredmet = PohadjaDAO.getStudentiByPredmetID(conn, id);
				
				Predmet predmet = new Predmet(id, naziv);
				predmet.getStudenti().addAll(studentiKojiPohadjajuPredmet);
				predmeti.add(predmet);
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return predmeti;
	}

	public static boolean add(Connection conn, Predmet predmet){
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO predmeti (naziv) values (?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, predmet.getNaziv());

			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
	
	public static boolean update(Connection conn, Predmet predmet) {
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE predmeti SET naziv = ? WHERE predmet_id = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, predmet.getNaziv());
			pstmt.setInt(index++, predmet.getId());

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
			String update = "DELETE FROM predmeti WHERE predmet_id = " + id;

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

}
