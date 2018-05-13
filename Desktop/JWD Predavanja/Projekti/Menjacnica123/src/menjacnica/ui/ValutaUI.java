package menjacnica.ui;

import java.sql.Connection;
import java.util.List;

import menjacnica.DAO.ValutaDAO;
import menjacnica.model.Valuta;
import menjacnica.utils.PomocnaKlasa;

public class ValutaUI {

	public static void prikazSvih(Connection conn) {
		List<Valuta> valute = ValutaDAO.getAll(conn);
		
		for (int i = 0; i < valute.size(); i++) {
			System.out.println(valute.get(i));
		}
	}
	public static Valuta pronadji(Connection conn) {
		System.out.println("Uneste oznaku valute:");
		String oznaka = PomocnaKlasa.ocitajTekst();
		Valuta valuta = ValutaDAO.get(conn,oznaka);
		return valuta;
	}
	public static void statistika(Connection conn) {
		
	}
	
}
