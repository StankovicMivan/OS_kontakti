package com.TelefonskiImenik;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static Scanner sc = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	public static ArrayList<Kontakt> kontakti = new ArrayList<>();


	public static void main(String[] args) {


		Kontakt k = new Kontakt();
		load("Kontakti.txt");

		//MENI
		String opcija;
		do {
			System.out.println("******************** MENI ********************");
			System.out.println("1.  Unos kontakta");
			System.out.println("2.  Ispis svih kontakata");
			System.out.println("3.  Izmenu kontakta.");
			System.out.println("4.  Brisanje kontakta.");
			System.out.println("5.  Pretragu i ispis svih kontakta koji imaju isti lokal");
			System.out.println("6.  Pretragu i ispis svih kontakta koji pripadaju istom radnom mestu.");
			System.out.println("7.  Pretragu i ispis svih kontakta cije ime odgovara navedenom.");
			System.out.println("8.  Pretragu i ispis svih kontakata cije ime i prezime odgovar navedenom i da naziv radnog mesta pocinje sa zadatim.");
			System.out.println("9.  Pretragu i ispis svih kontakata koji su uneti u zadatom intervalu datuma.");
			
			System.out.println("0.  Izlaz iz programa.");
			System.out.println("Unesite opciju:");

			opcija= sc.nextLine();

			switch(opcija) {

			case "1" :
				unosKontakta();
				save("Kontakti.txt");
				break;
			case "2" :
				ispisSvih2();
				break;
			case "3" :
				izmenuKontakta();
				save("Kontakti.txt");
				break;
			case "4" :
				brisanjeKontakta();
				save("Kontakti.txt");
				break;
			case "5" :
				pretraga5();
				break;
			case "6" :
				pretraga6();
				break;
			case "7" :
				pretraga7();
				break;
			case "8" :
				pretraga8();
				break;
			case "9" :
				pretraga9();
				break;
		

			}
		}while(!opcija.equals("0"));

		save("Kontakti.txt");
		sc.close();


	}	public static void pretraga9() {
		LocalDate datum1= null;
		LocalDate datum2= null;
		String datum;
		do {
			System.out.println("Unesite donju granicu pretrage po datumu");
			datum = sc.nextLine();
		}while(!datumValid(datum));
		datum1 = LocalDate.parse(datum, dtf);
		do {
			System.out.println("Unesite gornju granicu pretrage po datumu");
			datum = sc.nextLine();
		}while(!datumValid(datum));
		datum2 = LocalDate.parse(datum, dtf);
		
		zaglavlje();
		for(int i = 0; i < kontakti.size(); i++) {
			if(kontakti.get(i).getDatumUnosaKontakta().compareTo(datum1) >= 0 &&	
					kontakti.get(i).getDatumUnosaKontakta().compareTo(datum2) <= 0) {
				System.out.println(kontakti.get(i));
			}
		}
		System.out.println();
	}
	public static void pretraga8() {

		System.out.println("Unesite ime kontakta: ");
		String ime= sc.nextLine().trim();

		System.out.println("Unesite prezime kontakta: ");
		String prezime= sc.nextLine().trim();

		System.out.println("Unesite pocetna slova radnog mesta:");
		String radMestoPretraga = sc.nextLine().trim();
		
		zaglavlje();
		for(int i=0;i<kontakti.size();i++) {
			if(ime.equalsIgnoreCase(kontakti.get(i).getIme()) && prezime.equalsIgnoreCase(kontakti.get(i).getPrezime()) && kontakti.get(i).getNazRadMesta().startsWith(radMestoPretraga) ) {
				System.out.println(kontakti.get(i));
			}
		}
		System.out.println();
	}
	public static void pretraga7() {
		System.out.println("Unesite ime kontakta: ");
		String ime= sc.nextLine().trim();
		zaglavlje();
		for(int i=0;i<kontakti.size();i++) {
			if(ime.equalsIgnoreCase(kontakti.get(i).getIme())) {
				System.out.println(kontakti.get(i));
			}
		}
		System.out.println();
	}
	public static void pretraga6() {
		System.out.println("Unesite naziv radnog mesta:");
		String nazRadnogMesta = sc.nextLine().trim();
		zaglavlje();
		for(int i=0;i<kontakti.size();i++) {
			if(nazRadnogMesta.equals(kontakti.get(i).getNazRadMesta())) {
				System.out.println(kontakti.get(i));
			}
		}
		System.out.println();
	}
	public static void pretraga5() {
		String temp;
		do {
			System.out.println("Unesite broj lokala kontakta:");
			temp = sc.nextLine().trim();
		}while(!isIdValid(temp));
		int brojLokala = Integer.parseInt(temp);
		zaglavlje();
		
		for(int i=0;i<kontakti.size();i++) {
			if(brojLokala == kontakti.get(i).getBrojLokala()) {
				System.out.println(kontakti.get(i));
			}
		}
		System.out.println();
	}
	public static void brisanjeKontakta() {
		String temp;
		do {
			System.out.println("Unesite identifikator kontakta:");
			temp = sc.nextLine().trim();
		}while(!isIdValid2(temp));
		int id = Integer.parseInt(temp);

		int index = isIdValid2(id);
		if(index != -1) {
			kontakti.remove(index);
		}

	}



	public static void izmenuKontakta() {
		String temp;
		do {
			System.out.println("Unesite identifikator kontakta:");
			temp = sc.nextLine().trim();
		}while(!isIdValid2(temp));
		int id = Integer.parseInt(temp);


		System.out.println("Unesite ime novog kontakta: ");
		String ime= sc.nextLine().trim();

		System.out.println("Unesite prezime novog kontakta: ");
		String prezime= sc.nextLine().trim();

		System.out.println("Unesite naziv radnog mesta:");
		String nazRadnogMesta = sc.nextLine().trim();

		System.out.println("Unesite broj prostorije:");
		String brojProstorije = sc.nextLine().trim();

		do {
			System.out.println("Unesite broj lokala kontakta:");
			temp = sc.nextLine().trim();
		}while(!isIdValid(temp));
		int brojLokala = Integer.parseInt(temp);

		String datum;
		do {
			System.out.println("Unesite datum rada:");
			datum = sc.nextLine().trim();
		}while(!datumValid(datum));
		LocalDate datumRada= LocalDate.parse(datum, dtf);


		Kontakt noviKontak = new Kontakt(id,ime,prezime,nazRadnogMesta,brojProstorije,brojLokala,datumRada);
		int index = isIdValid2(id);
		if(index != -1) {
			kontakti.set(index,noviKontak);
		}

	}
	public static boolean isIdValid2(String temp) {
		try {
			int id = Integer.parseInt(temp);
			if(id >0) {
				for(int i=0; i< kontakti.size();i++) {
					if(id == kontakti.get(i).getIdentifikator()) {
						return true;
					}
				}
				return false;
			}
			return false;
		}catch (Exception e) {
			return false;
		}
	}
	public static int isIdValid2(int temp) {
		int i = -1;
		for(i=0; i< kontakti.size();i++) {
			if(temp == kontakti.get(i).getIdentifikator()) {
				return i;
			}
		}
		return i;
	}
	public static void zaglavlje() {
		System.out.println("___________________________________________________________________________________________________________________________");
		System.out.println(String.format("|%14s | %10s | %10s | %16s | %25s | %11s | %16s |","Identifikator", "Ime","Prezime","Radno mesto" ,"Broj prostorije","Broj lokala" ,  "datum unosa" ));
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
	}
	public static void ispisSvih2() {

		String temp = "";

		zaglavlje();

		for(int i = 0; i < kontakti.size(); i++) {
			temp += kontakti.get(i) + "\n";
		}
		temp += ("___________________________________________________________________________________________________________________________");

		System.out.println(temp);
		System.out.println();
	}

	public static void unosKontakta() {
		String temp;
		do {
			System.out.println("Unesite identifikator kontakta:");
			temp = sc.nextLine().trim();
		}while(!isIdValid(temp));
		int id = Integer.parseInt(temp);

		System.out.println("Unesite ime novog kontakta: ");
		String ime= sc.nextLine().trim();

		System.out.println("Unesite prezime novog kontakta: ");
		String prezime= sc.nextLine().trim();

		System.out.println("Unesite naziv radnog mesta:");
		String nazRadnogMesta = sc.nextLine().trim();

		System.out.println("Unesite broj prostorije:");
		String brojProstorije = sc.nextLine().trim();

		do {
			System.out.println("Unesite broj lokala kontakta:");
			temp = sc.nextLine().trim();
		}while(!isIdValid(temp));
		int brojLokala = Integer.parseInt(temp);

		String datum;
		do {
			System.out.println("Unesite datum rada:");
			datum = sc.nextLine().trim();
		}while(!datumValid(datum));
		LocalDate datumRada= LocalDate.parse(datum, dtf);


		Kontakt noviKontak = new Kontakt(id,ime,prezime,nazRadnogMesta,brojProstorije,brojLokala,datumRada);
		kontakti.add(noviKontak);		

	}
	public static boolean datumValid(String datum) {
		try {
			LocalDate datum1 = LocalDate.parse(datum, dtf);
			LocalDate datumNow = LocalDate.now();
			if(datum1.compareTo(datumNow)<=0) {
				return true;
			}else 
				return false;

		}catch (Exception e) {
			return false;
		}

	}
	public static boolean isIdValid(String id1) {
		try {
			int id = Integer.parseInt(id1);
			if(id >0) {
				for(int i=0; i< kontakti.size();i++) {
					if(id == kontakti.get(i).getIdentifikator()) {
						return false;
					}
				}
				return true;
			}
			return false;
		}catch (Exception e) {
			return false;
		}

	}

	public static void save(String path) {						

		ArrayList<String> lines = new ArrayList<String>();
		String line= "";

		for (int i = 0; i < kontakti.size(); i++) {
			Kontakt temp;
			temp = kontakti.get(i);
			line = temp.getIdentifikator() + ";"+ temp.getIme() + ";" + temp.getPrezime() + ";" + temp.getNazRadMesta() + ";"+ temp.getBrojProstorije()+";" + temp.getBrojLokala() + ";" + dtf.format(temp.getDatumUnosaKontakta());
			lines.add(line);
		}
		try {
			Files.write(Paths.get(path), lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (IOException e) {
			System.out.println("File " + path + " not found.");
		}

	}

	public static void load(String path) {						

		List<String> lines = new ArrayList<>();
		kontakti.clear();

		try {
			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());



			for(int i=0;i<lines.size();i++) {
				String line= lines.get(i);
				String[] part = line.split(";");

				int id =Integer.parseInt(part[0]);
				String ime = part[1];
				String prezime = part[2];
				String nazivRad = part[3];
				String brojProstorije = part[4];
				int brojLokala = Integer.parseInt(part[5]);
				LocalDate datum= null;
				try {
					datum = LocalDate.parse(part[6],dtf);
				} catch (Exception e) {
					e.printStackTrace();
				}

				Kontakt noviKontakt = new Kontakt(id, ime, prezime, nazivRad,brojProstorije,brojLokala,datum);

				kontakti.add(noviKontakt);
			}
		} catch (java.io.IOException e) {
			System.out.println("Datoteka " + path + " nije pronadjena.");
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
