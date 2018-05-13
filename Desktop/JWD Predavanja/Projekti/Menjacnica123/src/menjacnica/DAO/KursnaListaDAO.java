package menjacnica.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;

public class KursnaListaDAO {

	public static KursnaLista pronadji(Connection conn, Date datum) {
		KursnaLista kursnaLista = null;
		
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		try {
			String query = "SELECT k.id,v.id,v.oznaka,v.naziv,vr.kupovniKurs,vr.prodajniKurs FROM kursneListe k  LEFT JOIN vrednostiValuta vr " + 
					"ON k.id = vr.kursnaLista " + 
					"LEFT JOIN valute v ON vr.valuta = v.id " + 
					"WHERE k.datum = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, datum);
			System.out.println(pstmt);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(kursnaLista ==null) {
					int index =1;
					int id = rset.getInt(index++);
					
					kursnaLista = new KursnaLista(id,datum);
						
				}
				int index =2;
				int id = rset.getInt(index++);
				String oznaka = rset.getString(index++);
				String naziv = rset.getString(index++);
				
				Valuta valuta = new Valuta(id,oznaka,naziv);
				
				double kupovniKurs = rset.getDouble(index++);
				double prodajniKurs = rset.getDouble(index++);
				
				VrednostValute vrValute = new VrednostValute(valuta,kursnaLista, kupovniKurs,prodajniKurs);
				kursnaLista.getVrednostiValuta().add(vrValute);
			}
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {pstmt.close();}catch(SQLException e){}
			try {rset.close();}catch(SQLException s){}
		}
		
	
		return kursnaLista;
	}
	
	public static boolean dodaj(Connection conn, KursnaLista lista) {
		
		boolean uspelo = false;
		PreparedStatement pstmt = null;
		
		try {
			String query = "INSERT INTO kursneListe (datum) VALUES (?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, lista.getDatum());
			
			
			uspelo = pstmt.executeUpdate() ==1;
			ResultSet ids = pstmt.getGeneratedKeys();
			if(ids.next()) {
				lista.setId(ids.getInt(1));
			}
			if(uspelo) {
				for(VrednostValute it : lista.getVrednostiValuta()) {
					VrednostValuteDAO.dodaj(conn, it);
				}
			}
		}catch(Exception e) {
			e.getMessage();
		
		}finally {
			try {pstmt.close();}catch(SQLException e){}
		
		}
		
	
		
		return uspelo;
	}


}
