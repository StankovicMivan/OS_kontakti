package com.elektro.distribucija;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {

	//provera id-a isDigit
	//mesec za racun u opsegu od 1 do 12
	//datum placanja ne moze biti veci od dana[njeg
	//vrednost racuna mora biti veca od 0

	public static boolean isDigit (String string) {

		try {
			int broj = Integer.parseInt(string);
			if (broj > 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			System.out.println("Niste uneli ceo broj ili je broj manji od nule, pokusajte ponovo.");
		}return false;
	}
	
	public static boolean isDouble (String string) {
		
		try {
			double broj = Double.parseDouble(string);
			if (broj > 0) {
				return true;
			}
		} catch (NumberFormatException e) {
			System.out.println("Broj koji ste uneli je manji od nule, pokusajte ponovo.");
		}return false;
	}
	
	public static boolean jeMesec (String string) {

		try {
			int broj = Integer.parseInt(string);
			if (broj >= 1 && broj <= 12 ) {
				return true;
			}
		} catch (NumberFormatException e) {
			System.out.println("Niste uneli ceo broj ili je broj manji od nule, pokusajte ponovo.");
		}return false;
	}
	
	public static boolean ispravanDatum (String datum) {
		
		try {
			LocalDate datum1 = LocalDate.parse(datum, dtf);
			LocalDate datumNow = LocalDate.now();
			if (datum1.isBefore(datumNow)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Datum koji ste uneli je veci od danasnjeg, pokusajte ponovo.");
		}return false;
		
	}

	public static Scanner sc = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");



	public static void main(String[] args) {
		
		Elektrodistribucija elektrodistribucija = new Elektrodistribucija();
		String answer = null;
																				// Ovde je pisalo answer = sc.nextLine();, a to treba da pise dole unutar do petlje>
		elektrodistribucija.load("racuni.txt");

		do {
			System.out.println("*************** M E N I ***************");
			System.out.println("1. Unos podataka o novoj elektrodistribuciji");
			System.out.println("2. Unos novog računa");
			System.out.println("3. Ispis podataka o svim računima");
			System.out.println("4. Izmenu podataka o računu (navodi se identifikator računa koji se menja)");
			System.out.println("5. Brisanje podataka o računu (navodi se identifikator računa koji se briše)");
			System.out.println("6. Pretragu i ispis svih računa čija je potrošnja niže i više tarife u zadatom opsegu min i max tarifa, gde se poseban opseg zadaje za svaku od tarifa");
			System.out.println("7. Izračunavanje i ispis prosečne potrošnje kW (ukupno i niže i više tarife) za zadati mesec");
			System.out.println("8. Pretragu i ispis svih računa za zadati mesec čija je potrošnja veća od prosečne potrošnje za isti taj mesec.");
			System.out.println("9. Pronalaženje i ispis najskupljeg računa koji je plaćen u zadatom periodu (zadaje se datum početka i karaja perioda)");
			System.out.println("10. Ispis podataka o elektrodistribuciji (naziv, adresa, telefon, ukupan broj računa i ukupna zarada)/n");
			System.out.println("x Za cuvanje podataka i izlaz iz programa.");
			System.out.println("Unesite zeljenu opciju: ");
			answer = sc.nextLine();												//Ovde sam ga prebacio i sada radi.
			switch (answer) {
			case "1":
				unosElektro(elektrodistribucija);
				elektrodistribucija.save("racuni.txt");

				break;
			case "2":
				unosRacuna(elektrodistribucija);
				elektrodistribucija.save("racuni.txt");

				break;
			case "3":
				ispisRacuna(elektrodistribucija);


				break;
			case "4":


				break;
			case "5":


				break;
			case "6":


				break;
			case "7":


				break;
			case "8":


				break;
			case "9":


				break;
			case "10":


				break;
			case "x":
				elektrodistribucija.save("racuni.txt");

				break;

			default:
				System.out.println("Izabrana opcija nije ponudjena, molim vas pokusajte ponovo.");
				break;
			}



		}while(!answer.equals("x"));
		sc.close();
	}

	public static void unosElektro(Elektrodistribucija elektrodistribucija) {
		
		System.out.println("Unesite naziv Elektrodistribucije:");
		String naziv = sc.nextLine().trim();

		System.out.println("Unesite adresu Elektrodistribucije:");
		String adresa = sc.nextLine().trim();

		System.out.println("Unesite telefon Elektrodistribucije:");
		String telefon = sc.nextLine().trim();


		elektrodistribucija.setNaziv(naziv);
		elektrodistribucija.setAdresa(adresa);
		elektrodistribucija.setTelefon(telefon);
	}

	public static void ispisRacuna(Elektrodistribucija elektrodistribucija) {
		
		elektrodistribucija.ispisRacuna();
	}

	public static void unosRacuna(Elektrodistribucija elektrodistribucija) {
		
		int id;
		String vlasnik;
		int nizaPotrosnja;
		int visaPotrosnja;
		//double ukupanRacun;
		int mesecRacuna;
		LocalDate datumPlacanja;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		String broj;
		do {
			System.out.println("Unesite identifikacioni broj: ");
			broj = sc.nextLine();
			} while (!isDigit(broj));
		id = Integer.parseInt(broj);
		
		System.out.println("Unesite vlasnika brojila: ");
		vlasnik = sc.nextLine();
		
		String niza;
		do {
			System.out.println("Unesite stanje brojila nize tarife: ");
			niza = sc.nextLine();
			} while (!isDigit(niza));
		nizaPotrosnja = Integer.parseInt(niza);
		
		String visa;
		do {
			System.out.println("Unesite stanje brojila vise tarife: ");
			visa = sc.nextLine();
			} while (!isDigit(visa));
		visaPotrosnja = Integer.parseInt(visa);
		
		String mesec;
		do {
			System.out.println("Unesite redni broj meseca za koji se radi obracun: ");
			mesec = sc.nextLine();
			} while (!jeMesec(mesec));
		mesecRacuna = Integer.parseInt(mesec);
		
		String datum;
		do {
			System.out.println("Unesite datum placanja u formatu dd.MM.yyyy. : ");
			datum = sc.nextLine();
		} while (!ispravanDatum(datum));
		datumPlacanja = LocalDate.parse(datum, dtf);
		
		elektrodistribucija.unosNovogRacuna(id, vlasnik, nizaPotrosnja, visaPotrosnja, mesecRacuna, datumPlacanja);
	}

}
