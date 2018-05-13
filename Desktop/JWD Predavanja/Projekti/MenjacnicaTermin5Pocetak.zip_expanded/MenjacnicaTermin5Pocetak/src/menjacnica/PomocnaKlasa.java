package menjacnica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PomocnaKlasa {

	public static Scanner sc = new Scanner(System.in);

	public static String ocitajTekst() {
		String tekst = "";
		while (tekst == null || tekst.equals(""))
			tekst = sc.nextLine();

		return tekst;
	}

	public static int ocitajCeoBroj() {
		while (sc.hasNextInt() == false) {
			System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		int ceoBroj = sc.nextInt();
		sc.nextLine();
		return ceoBroj;
	}
	
	public static long ocitajCeoBrojLong() {
		while (sc.hasNextLong() == false) {
			System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		long ceoBroj = sc.nextLong();
		sc.nextLine();
		return ceoBroj;
	}

	public static double ocitajDouble() {
		while (sc.hasNextInt() == false) {
			System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		double ceoBroj = sc.nextInt();
		sc.nextLine();
		return ceoBroj;
	}

	// citanje promenljive char
	public static char ocitajKarakter() {
		char karakter = ' ';
		boolean notRead = true;
		do {
			String text = sc.next();
			if (text.length() == 1) {
				karakter = text.charAt(0);
				notRead = false;
			} else {
				System.out.println("GRESKA - Pogresno unsesena vrednost za karakter, pokusajte ponovo: ");
			}
			sc.nextLine();// cisti sve sa ulaza sto nije broj ili ostatak testa
							// posle karaktera
		} while (notRead);
		return karakter;
	}

	// citanje promenljive char
	public static char ocitajOdlukuOPotvrdi(String tekst) {
		System.out.println("Da li zelite " + tekst + " [Y/N]:");
		char odluka = ' ';
		while (!(odluka == 'Y' || odluka == 'N')) {
			odluka = ocitajKarakter();
			if (!(odluka == 'Y' || odluka == 'N')) {
				System.out.println("Opcije su Y ili N");
			}
		}
		return odluka;
	}

	public static Date proveriDatum() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		String datumUnos = null;
		Date datum = null;
		do {
			System.out.println("Unesi datum u formatu dd.MM.yyyy.");
			datumUnos = sc.nextLine();
		} while (!proveriDatum(datumUnos));
		try {
			datum = sdf.parse(datumUnos);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datum;
	}

	public static boolean proveriDatum(String datum) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

		try {
			sdf.parse(datum);
			return true;
		} catch (Exception e) {
			System.out.println("Unesite datum u formatu dd.MM.yyyy.");
			return false;
		}

	}

}
