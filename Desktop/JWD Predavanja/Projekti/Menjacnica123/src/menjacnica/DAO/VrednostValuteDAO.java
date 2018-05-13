package menjacnica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Statement;

import menjacnica.model.VrednostValute;

public class VrednostValuteDAO {

	public static boolean dodaj(Connection conn, VrednostValute it) {
		
		
			PreparedStatement pstmt = null;
			try {
				String query = "INSERT INTO vrednostiValuta (valuta,kursnaLista,kupovniKurs,prodajniKurs) VALUES (?,?,?,?)";
				pstmt = conn.prepareStatement(query);
				int index =1;
				pstmt.setInt(index++, it.getValuta().getId());
				pstmt.setInt(index++, it.getKursnaLista().getId());
				
				
				
				uspelo = pstmt.executeUpdate() ==1;
				
				if(uspelo) {
					for(VrednostValute it : lista.getVrednostiValuta()) {
						VrednostValuteDAO.dodaj(conn, it);
					}
				}
			return false;
		}
		
	}

}
