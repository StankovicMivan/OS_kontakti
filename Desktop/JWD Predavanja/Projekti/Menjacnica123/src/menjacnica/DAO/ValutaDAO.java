package menjacnica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import menjacnica.model.Valuta;

public class ValutaDAO {

	public static Valuta get(Connection conn, String oznaka){
		Valuta valuta = null;
			
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT id,naziv FROM valute WHERE oznaka = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, oznaka);
			rset= stmt.executeQuery();
			while(rset.next()) {
				int index =1;
				int id = rset.getInt(index++);
				
				String naziv = rset.getString(index++);
				
				valuta = new Valuta(id,oznaka,naziv);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {stmt.close();}catch(SQLException e){}
			try {rset.close();}catch(SQLException s){}
		}
		
		
		return valuta;
}
	
	public static List<Valuta> getAll(Connection conn){
			List<Valuta> valute = new ArrayList<>();
				
			Statement stmt = null;
			ResultSet rset = null;
			
			try {
				String query = "SELECT id,oznaka,naziv FROM valute";
				stmt = conn.createStatement();
				rset= stmt.executeQuery(query);
				while(rset.next()) {
					int index =1;
					int id = rset.getInt(index++);
					String oznaka = rset.getString(index++);
					String naziv = rset.getString(index++);
					
					Valuta val = new Valuta(id,oznaka,naziv);
					valute.add(val);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {stmt.close();}catch(SQLException e){}
				try {rset.close();}catch(SQLException s){}
			}
			
			
			return valute;
	}
}
