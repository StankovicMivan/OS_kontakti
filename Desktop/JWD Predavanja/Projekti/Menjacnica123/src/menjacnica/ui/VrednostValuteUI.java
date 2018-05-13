package menjacnica.ui;

import java.sql.Connection;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;
import menjacnica.utils.PomocnaKlasa;

public class VrednostValuteUI {

	public static VrednostValute unos(Connection conn,KursnaLista kursnaLista, Valuta valuta) {
		System.out.println("Unestite kupovni kurs");
		double kupovniKurs = PomocnaKlasa.ocitajRealanBroj();
		
		System.out.println("Unestite pordajni kurs");
		double prodajniKurs = PomocnaKlasa.ocitajRealanBroj();
		
		VrednostValute vrValute = new VrednostValute(valuta, kursnaLista, kupovniKurs, prodajniKurs);
		kursnaLista.getVrednostiValuta().add(vrValute);
		return vrValute;
	}


}
