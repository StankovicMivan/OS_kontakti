//package DAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import Model.Kurs;
//import Model.Nastavnik;
//
//public class NastavnikDAO {
//
//	public static boolean add(Connection conn, Nastavnik nastavnik) {
//		PreparedStatement pstmt = null;
//		try {
//			String query = "INSERT INTO nastavnik (ime,prezime) VALUES (?, ?)";
//
//			pstmt = conn.prepareStatement(query);
//			int index = 1;
//			pstmt.setString(index++, nastavnik.getIme());
//			pstmt.setString(index++, nastavnik.getPrezime());
//
//
//			return pstmt.executeUpdate() == 1;
//		} catch (SQLException ex) {
//			System.out.println("Greska u SQL upitu!");
//			ex.printStackTrace();
//		} finally {
//			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//		}
//
//		return false;
//	}
//
//	public static Nastavnik getNastavnikById(Connection conn, int id) {
//
//		Nastavnik nastavnik = null;
//
//		Statement stmt = null;
//		ResultSet rset = null;
//		try {
//			String query = "SELECT id, ime, prezime FROM nastavnik WHERE id = " + id;
//
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//
//			if (rset.next()) {
//				int index = 1;
//				int id1 = rset.getInt(index++);
//				String ime = rset.getString(index++);
//				String prezime = rset.getString(index++);
//
//
//				nastavnik = new Nastavnik(id1,ime, prezime);
//			}
//		} catch (SQLException ex) {
//			System.out.println("Greska u SQL upitu!");
//			ex.printStackTrace();
//		} finally {
//			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//		}
//
//		return nastavnik;
//	}
//
//	public static boolean update(Connection conn, Nastavnik st) {
//		PreparedStatement pstmt = null;
//		try {
//			String query = "UPDATE nastavnik SET ime = ?, prezime = ? WHERE id = ?";
//
//			pstmt = conn.prepareStatement(query);
//			int index = 1;
//			pstmt.setString(index++, st.getIme());
//			pstmt.setString(index++, st.getPrezime());
//			pstmt.setInt(index++,st.getId());
//
//			return pstmt.executeUpdate() == 1;
//		} catch (SQLException ex) {
//			System.out.println("Greska u SQL upitu!");
//			ex.printStackTrace();
//		} finally {
//			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//		}
//
//		return false;
//
//	}
//
//	public static boolean delete(Connection conn, int id) {
//
//		Statement stmt = null;
//		try {
//			String update = "DELETE FROM nastavnik WHERE id = " + id;
//
//			stmt = conn.createStatement();
//			return stmt.executeUpdate(update) == 1;
//		} catch (SQLException ex) {
//			System.out.println("Greska u SQL upitu!");
//			ex.printStackTrace();
//		} finally {
//			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//		}
//
//		return false;
//	}
//
//	public static HashMap<Integer,Nastavnik> getAll(Connection conn) {
//
//		Statement stmt = null;
//		ResultSet rset = null;
//		try {
//			String query = "SELECT n.id, n.ime,n.prezime,k.id, k.naziv,k.tip FROM nastavnik n "
//					+ "JOIN predaje p JOIN kurs k "
//					+ "ON  n.id = p.nastavnik_id AND k.id = p.kurs_id ORDER BY n.ime ASC";
//
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//
//			//			int index1= 1;
//			//			int index2= 1;
//			HashMap<Integer,Nastavnik> nastavnici = new HashMap<>();
//			HashMap<Integer,Kurs> predaje = new HashMap<>();
//			HashMap<Nastavnik,ArrayList<Kurs>> predaje1 = new HashMap<>();
//			while (rset.next()) {
//				ArrayList<Kurs> kursevi = new ArrayList<>();
//				nastavnici = new HashMap<>();
//				predaje = new HashMap<>();
//				int index = 1;
//
//				int id_nastavnik = rset.getInt(index++);
//				String ime = rset.getString(index++);
//				String prezime = rset.getString(index++);
//				int id_kurs = rset.getInt(index++);
//				String naziv = rset.getString(index++);
//				String tip = rset.getString(index++);
//
//				//	predaje = PredajeDAO.getKursByNastavnikID(conn, id);
//				Nastavnik nastavnik = new Nastavnik(id_nastavnik, ime, prezime);
//				Kurs kurs = new Kurs(id_kurs, naziv,tip);
//
//				int counter =0;
//				if(predaje1.containsKey(nastavnik)){
//					for(int i =0;i<predaje1.get(nastavnik).size();i++) {
//						if(predaje1.get(nastavnik).get(i).equals(kurs)) {
//							counter++;
//							break;
//						}
//					}
//					if(counter ==0) {
//						predaje1.get(nastavnik).add(kurs);
//					}
//					
//				}else {
//					kursevi.add(kurs);
//					predaje1.put(nastavnik, kursevi);
//
//				}
////
////				if(nastavnici.containsKey(nastavnik.getId())) {
////					if(predaje.containsKey(kurs.getId())) {
////
////					}else {
////						predaje.put(kurs.getId(), kurs);
////
////					}
////				}else {
////					nastavnici.put(nastavnik.getId(), nastavnik);
////
////					if(predaje.containsKey(kurs.getId())) {
////
////					}else {
////						predaje.put(kurs.getId(), kurs);
////
////					}
////				}
////				for (Integer i : nastavnici.keySet()) {
////					System.out.println(nastavnici.get(i) ); 
////				}
////				for (Integer j : predaje.keySet()) {
////					System.out.println( "\t\t\t\t " + predaje.get(j));
////					
////				}
////				System.out.println();
//
//
//			}
//		} catch (SQLException ex) {
//			System.out.println("Greska u SQL upitu!");
//			ex.printStackTrace();
//		} finally {
//			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
//		}
//
//		 return null;
//	}
//}