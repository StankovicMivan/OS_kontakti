package rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo2_mysql {

	// bez transakcije; nebezbedno!
	public static void test1(Connection conn) {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("Unesi ID uplatioca: ");
		int uplatilacID = scanner.nextInt();
		System.out.print("Unesi ID primaoca: ");
		int primalacID = scanner.nextInt();
		System.out.print("Unesi iznos: ");
		double iznos = scanner.nextDouble();

		scanner.close();		

		// ova funkcionalnost zahteva 2 SQL upita
		PreparedStatement pstmt = null;
		try {
			// 1. SQL upit
			String query = "UPDATE racuni SET stanje = stanje - ? WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setDouble(index++, iznos);
			pstmt.setInt(index++, uplatilacID);

//			if (true) throw new Exception(); // simulacija greske
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}

		try {
			// 2. SQL upit
			String query = "UPDATE racuni SET stanje = stanje + ? WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setDouble(index++, iznos);
			pstmt.setInt(index++, primalacID);

//			if (true) throw new Exception(); // simulacija greske
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
	}

	// sa transakcijom; bezbedno!
	public static void test2(Connection conn) {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("Unesi ID uplatioca: ");
		int uplatilacID = scanner.nextInt();
		System.out.print("Unesi ID primaoca: ");
		int primalacID = scanner.nextInt();
		System.out.print("Unesi iznos: ");
		double iznos = scanner.nextDouble();

		scanner.close();		

		// ova funkcionalnost zahteva 2 SQL upita
		PreparedStatement pstmt = null;
		try {
			String query;
			int index;

			conn.setAutoCommit(false); // iskljucivanje automatske transakcije (pri cemu je svaki upit bio transakcija za sebe)
			conn.commit(); // pocetak transakcije
			
			// 1. SQL upit
			query = "UPDATE racuni SET stanje = stanje - ? WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			index = 1;
			pstmt.setDouble(index++, iznos);
			pstmt.setInt(index++, uplatilacID);

//			if (true) throw new Exception(); // simulacija greske
			
			pstmt.executeUpdate();
			pstmt.close();

			// 2. SQL upit
			query = "UPDATE racuni SET stanje = stanje + ? WHERE id = ?";

			pstmt = conn.prepareStatement(query);
			index = 1;
			pstmt.setDouble(index++, iznos);
			pstmt.setInt(index++, primalacID);

//			if (true) throw new Exception(); // simulacija greske
			
			pstmt.executeUpdate();

			conn.commit(); // kraj transakcije
		} catch (Exception ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
			try {conn.rollback();} catch (SQLException ex1) { ex1.printStackTrace(); } // vratiti bazu u stanje pre pocetka transakcije
		} finally {
			try {pstmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {conn.setAutoCommit(true);} catch (SQLException ex1) {ex1.printStackTrace();} // ukljuciti automatsku tranaskciju
		}
	}

	public static void prikaz(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT id, vlasnik, stanje FROM racuni";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			System.out.println();
			System.out.printf("%-10s %-20s %-10s", "id", "vlasnik", "stanje"); System.out.println();
			System.out.println("========== ==================== ==========");
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String vlasnik = rset.getString(index++);
				double stanje = rset.getDouble(index++);

				System.out.printf("%-10s %-20s %-10s", id, vlasnik, stanje); System.out.println();
			}
		} catch (SQLException ex) {
			System.out.println("Greska u SQL upitu!");
			ex.printStackTrace();
		} finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
	}
	
	public static void main(String args[]) {
		// otvaranje konekcije, jednom na pocetku aplikacije
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/banka?useSSL=false", 
					"root", 
					"root");
		} catch (Exception ex) {
			System.out.println("Neuspela konekcija na bazu!");
			ex.printStackTrace();

			// kraj aplikacije
			return;
		}

		prikaz(conn);
		
		test1(conn);
//		test2(conn);

		prikaz(conn);
		
		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
