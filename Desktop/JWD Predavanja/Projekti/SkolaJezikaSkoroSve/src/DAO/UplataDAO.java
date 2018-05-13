package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;

import Model.Kurs;
import Model.Ucenik;

public class UplataDAO {

	public static boolean addUplata(Connection conn, Ucenik ucenik, Kurs kurs) {
		PreparedStatement pstmt = null;
		try {
			String query = "INSERT INTO uplate (ucenik_id,kurs_id) VALUES (?, ?)";

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
	public static HashMap<Kurs, ArrayList<Ucenik>> get(Connection conn, Kurs kurs) {
		HashMap<Kurs, ArrayList<Ucenik>> uplate = new HashMap<>();
		ArrayList<Ucenik> ucenici = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT u.id FROM kurs k " + 
					"JOIN ucenik u JOIN uplate up " + 
					"ON u.id = up.ucenik_id AND k.id = up.kurs_id WHERE up.kurs_id = ? " + 
					"ORDER BY u.id ASC";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setInt(index++, kurs.getId());
			
			rset = pstmt.executeQuery();
			while (rset.next()) {

				index = 1;

				int id_ucenik = rset.getInt(index++);
				
//				int id_kurs  =  rset.getInt(index++); 	
				
				Ucenik ucenik = UcenikDAO.getUcenikByID(conn, id_ucenik);
//				Kurs kurs1 = KursDAO.getKursByID(conn,id_kurs);
//				System.out.println(kurs);
				int counter =0;
				
				if(uplate.containsKey(kurs)){
					for(int i =0;i<uplate.get(kurs).size();i++) {
						if(uplate.get(kurs).get(i).equals(ucenik)) {
							counter++;
							break;
						}
					}
					if(counter ==0) {
						uplate.get(kurs).add(ucenik);
					}

				}else {
					ucenici.add(ucenik);
					uplate.put(kurs, ucenici);

				}
			
			}
			
			//


		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return uplate;
	}
}
