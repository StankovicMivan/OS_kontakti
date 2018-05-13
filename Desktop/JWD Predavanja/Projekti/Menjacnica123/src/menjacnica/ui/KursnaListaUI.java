package menjacnica.ui;

import java.sql.Connection;
import java.sql.Date;

import menjacnica.DAO.KursnaListaDAO;
import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.utils.PomocnaKlasa;

public class KursnaListaUI {

	public static void prikaz(Connection conn) {
		System.out.println("Unesite datum kursne liste[dd.MM.yyyy.]");
		Date datum = PomocnaKlasa.ocitajDatum();
		KursnaLista krLista = KursnaListaDAO.pronadji(conn, datum);
		System.out.println(krLista);
		
	}

	public static void unos(Connection conn) {
		System.out.println("Unesite datum kursne liste[dd.MM.yyyy.]");
		Date datum = PomocnaKlasa.ocitajDatum();
		System.out.println();
		
		KursnaLista kursnalista = new KursnaLista(0, datum);
		while(PomocnaKlasa.ocitajOdlukuOPotvrdi("Da li zelite da dodate vrednost valute?") != 'N') {
			Valuta valuta = ValutaUI.pronadji(conn);
			VrednostValuteUI.unos(conn, kursnalista, valuta);
		}	
	
	}
	
}
