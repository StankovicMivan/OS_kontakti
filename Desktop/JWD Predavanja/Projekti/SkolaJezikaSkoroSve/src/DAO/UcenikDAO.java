package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import Model.Kurs;

import Model.Ucenik;
import UI.UcenikUI;



public class UcenikDAO {

	public static boolean add(Connection conn, Ucenik ucenik) {
		PreparedStatement pstmt = null;

		try {
			String query = "INSERT INTO ucenik (ime,prezime) VALUES (?, ?)";

			pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			pstmt.setString(index++, ucenik.getIme());
			pstmt.setString(index++, ucenik.getPrezime());

			pstmt.executeUpdate();
			ResultSet resaultSet = pstmt.getGeneratedKeys();
			if (resaultSet.next()) {
				UcenikUI.ucenik_id = resaultSet.getInt(1);   

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

	public static Ucenik getUcenikByID(Connection conn, int id) {

		Ucenik ucenik = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT id, ime, prezime FROM ucenik WHERE id = " + id;

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				int index = 1;
				int id1 = rset.getInt(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);


				ucenik = new Ucenik(id1,ime, prezime);
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		return ucenik;
	}

	public static boolean update(Connection conn, Ucenik st) {
		PreparedStatement pstmt = null;
		try {
			String query = "UPDATE ucenik SET ime = ?, prezime = ? WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, st.getIme());
			pstmt.setString(index++, st.getPrezime());
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
			String update = "DELETE FROM ucenik WHERE id = " + id;

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

	public static HashMap<Ucenik, ArrayList<Kurs>> getAll(Connection conn) {
		HashMap<Ucenik, ArrayList<Kurs>> pohadja = new HashMap<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT u.id, u.ime,u.prezime,k.id, k.naziv,k.tip FROM ucenik u " + 
					"JOIN pohadja p JOIN kurs k " + 
					"ON  u.id = p.ucenik_id AND k.id = p.kurs_id ORDER BY u.ime ASC";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);



			while (rset.next()) {
				ArrayList<Kurs> kursevi = new ArrayList<>();

				int index = 1;

				int id_ucenik = 0;
				String ime = null;
				String prezime = null;
				try {
					id_ucenik = rset.getInt(index++);
					ime = rset.getString(index++);
					prezime = rset.getString(index++);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int id_kurs = 0;
				String naziv = null;
				String tip = null;
				try {
					id_kurs = rset.getInt(index++);
					naziv = rset.getString(index++);
					tip = rset.getString(index++);
				} catch (Exception e) {
					Ucenik ucenik = new Ucenik(id_ucenik, ime, prezime);

					if(pohadja.containsKey(ucenik)){
						break;
					}else {
						Kurs kurs =new Kurs();
						kursevi.add(kurs);
						pohadja.put(ucenik, kursevi);

					}
				}


				Ucenik ucenik = new Ucenik(id_ucenik, ime, prezime);
				Kurs kurs = new Kurs(id_kurs, naziv,tip);

				int counter =0;
				if(pohadja.containsKey(ucenik)){
					for(int i =0;i<pohadja.get(ucenik).size();i++) {
						if(pohadja.get(ucenik).get(i).equals(kurs)) {
							counter++;
							break;
						}
					}
					if(counter ==0) {
						pohadja.get(ucenik).add(kurs);
					}

				}else {
					kursevi.add(kurs);
					pohadja.put(ucenik, kursevi);

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

		return pohadja;
	}
}


