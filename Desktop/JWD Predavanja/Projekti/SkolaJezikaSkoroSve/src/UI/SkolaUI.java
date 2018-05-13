package UI;

import java.sql.Connection;

import DAO.SkolaDAO;
import Model.Skola;
import PomocnaKlasa.PomocnaKlasa;

public class SkolaUI {

	public static void kreirajSkolu(Connection conn) {

		System.out.println("Unesite naziv skole:");
		String naziv = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite adresu skole:");
		String adresa = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite telefon skole:");
		String tel = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite EMail skole:");
		String eMail = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite WEB adresu skole:");
		String web = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesite PIB");
		int pib = PomocnaKlasa.ocitajCeoBroj();
		System.out.println("Unesite Maticni broj:");
		int matBroj = PomocnaKlasa.ocitajCeoBroj();
		System.out.println("Unesite broj ziro racuna");
		String ziroRacun = PomocnaKlasa.ocitajTekst();
		
		
		Skola skola = new Skola(naziv,adresa,tel,eMail,web,pib,matBroj,ziroRacun);
		if(SkolaDAO.add(conn, skola)) {
			System.out.println("Skola je uspesno uneta u bazu!");
		}else
			System.out.println("Greska pri unosu skole u bazu");
	}

}
