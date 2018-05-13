package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Skola;



public class SkolaDAO {

	public static boolean add(Connection conn, Skola skola) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO skola (naziv, adresa, telefon, email,web,pib,maticniBr,ziroRacun) VALUES (?, ?, ?, ?, ?,?,?,?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, skola.getNaziv());
			pstmt.setString(index++, skola.getAdresa());
			pstmt.setString(index++, skola.getTel());
			pstmt.setString(index++, skola.geteMail());
			pstmt.setString(index++, skola.getWeb());
			pstmt.setInt(index++, skola.getPib());
			pstmt.setInt(index++, skola.getMatBroj());
			pstmt.setString(index++, skola.getZiroRacun());

			return pstmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return false;
	}
}
