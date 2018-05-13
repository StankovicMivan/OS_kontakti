package projectOne.com;

import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;








public class Oglasnik {

	public static Scanner sc = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	public static ArrayList<Oglas> oglasi = new ArrayList<>();
	public static String []oprema = {"ABS", "ESP", "Alarm","Airbag","Klima","Servo volan", "Putni racunar", "Tempomat" };
	public static ArrayList<String> uOprema = new ArrayList<>();
	public static ArrayList<String> pOprema = new ArrayList<>();
	public int brojac;
	static int index =0;

	public static void main(String[] args) {


		Oglas o = new Oglas();
		load("Oglasi.txt");

		int brojac = oglasi.size();

		String opcija;
		do {
			System.out.println("******************** MENI ********************");
			System.out.println("1. Unos oglas.");
			System.out.println("2. Stampanje svih oglasa.");
			System.out.println("3. Izmena oglasa.");
			System.out.println("4. Pretraga po ceni .");
			System.out.println("5. Pretraga po sifri ."); 					
			System.out.println("6. Pretraga po godini proizvodnje .");		
			System.out.println("7. pretraga po opremi.");					
											

			System.out.println("0.  Izlaz iz programa.");
			System.out.println("Unesite opciju:");

			opcija= sc.nextLine();

			switch(opcija) {

			case "1" :
				unosOglasa();
				save("Oglasi.txt");
				break;
			case "2" :	
				prikaz();
				break;
			case "3" :
				izmenaOglasa();
				break;
			case "4" :
				pretPoCeni();
				break;
			case "5" :
				pretPoSifri();
				break;
			case "6" :
				pretPoGod();
				break;
			case "7" :
				pretraga7();
				break;
			case "8" :
				break;
			case "9" :
				break;


			}
		}while(!opcija.equals("0"));

		save("Oglasi.txt");
		sc.close();



	}

	private static void pretraga7() {
		System.out.println("Oznacite dodatnu koju opremu koju zelite: ");
		String temp;
		pOprema.clear();
		
		do {
			System.out.println("Da li poseduje: " + oprema[0] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[1] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[2] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[3] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[4] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());
		do {
			System.out.println("Da li poseduje: " + oprema[5] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[6] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[7] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		pOprema.add(temp.toUpperCase());
		ArrayList<Oglas> listaSPOpreme = new ArrayList<>();
		for(int i =0; i<oglasi.size();i++) {						//Ovde sam zakucao, moj neki pokusaj da filtriram oglase po opremi, debug-er mi je zakucao menja mi varijable ali ne prikazuje gde se trenutno nalazi
			for(int j =0; j<pOprema.size();j++) {
				if(pOprema.get(j).equalsIgnoreCase("DA")) {
					temp = oglasi.get(i).getOprema().get(j);
					if(temp.equalsIgnoreCase(pOprema.get(j))){
						
					}else 
						continue;
				
					
				}else
					continue;
				listaSPOpreme.add(oglasi.get(i));
			
			}
			
		}
		for(int i=0;i<listaSPOpreme.size();i++) {
			System.out.println("Redni broj oglasa je: " + listaSPOpreme.get(i).getSifraOglasa());
			System.out.println(listaSPOpreme.get(i));
		}
	}

	private static void pretPoGod() {
		String temp;
		do {
			System.out.println("Unesite datum proizvodnje auta kojeg zelite da nadjete u oglasima:");
			temp = sc.nextLine().trim();
		}while(!isInt(temp));
		int godinaProizvodnje= Integer.parseInt(temp);
		boolean stanje = false;
		for(int i =0;i<oglasi.size();i++) {

			if(godinaProizvodnje == oglasi.get(i).getGodinaProizvodnje()) {
				int k = i+1;
				System.out.println("Redni broj oglasa: " + k);

				System.out.println(oglasi.get(i));
				stanje = true;
			}
		}
		if(!stanje) {
			System.out.println("Ne postoji vozile sa tom godinom proizvodnje");
		}
	}

	private static void pretPoSifri() {
		String temp;
		uOprema.clear();
		do {
			System.out.println("Unesite sifru pod kojom je zaveden vas oglas: ");
			temp = sc.nextLine().trim();
		}while(!isSifra(temp));
		int sifra = Integer.parseInt(temp);

		for(int i =0;i<oglasi.size();i++) {
			if(oglasi.get(i).getSifraOglasa() == sifra) {
				System.out.println(oglasi.get(i));
			}
		}
	}

	private static void pretPoCeni() {
		String opcija;
		do {
			System.out.println("**********************************");
			System.out.println("1. Pretraga OD-DO (npr. 2000-3000)");
			System.out.println("2. Pretraga OD (skuplji od...)");
			System.out.println("3. Pretraga DO (jeftiniji od...)");
			System.out.println("0. Vratite se nazad.");
			System.out.println("Unesite opciju:");

			opcija= sc.nextLine();

			switch(opcija) {

			case "1" :
				ispis1();
				break;
			case "2" :
				ispis2();
				break;
			case "3" :	
				ispis3();
				break;

			}
		}while(!opcija.equals("0"));

	}

	private static void ispis3() {
		String temp;
		System.out.println("-------------------------------------------------");

		do {
			System.out.println("Unesite gornju granicu.");
			temp = sc.nextLine().trim();
		}while(!isDecimal(temp));
		double max = Double.parseDouble(temp);

		stampa3(max);
	}

	private static void ispis2() {
		String temp;
		System.out.println("-------------------------------------------------");

		do {
			System.out.println("Unesite donju granicu.");
			temp = sc.nextLine().trim();
		}while(!isDecimal(temp));
		double min = Double.parseDouble(temp);

		stampa2(min);
	}

	private static void ispis1() {
		String temp;
		System.out.println("-------------------------------------------------");

		do {
			System.out.println("Unesite donju granicu.");
			temp = sc.nextLine().trim();
		}while(!isDecimal(temp));
		double min = Double.parseDouble(temp);

		do {
			System.out.println("Unesite gornju granicu.");
			temp = sc.nextLine().trim();
		}while(!isDecimal(temp));
		double max = Double.parseDouble(temp);

		stampa1(min,max);


	}

	private static void stampa1(double min, double max) {
		for(int i=0; i<oglasi.size();i++) {
			if(oglasi.get(i).getCena() >= min && oglasi.get(i).getCena() <= max) {
				int k = i+1;
				System.out.println("Redni broj oglasa: " + k);

				System.out.println(oglasi.get(i));
				System.out.println("-------------------------------------------------");
			}
		}

	}

	private static void stampa2(double min) {
		for(int i=0; i<oglasi.size();i++) {
			if(oglasi.get(i).getCena() >= min) {
				int k = i+1;
				System.out.println("Redni broj oglasa: " + k);

				System.out.println(oglasi.get(i));
				System.out.println("-------------------------------------------------");
			}
		}

	}
	private static void stampa3(double max) {
		for(int i=0; i<oglasi.size();i++) {
			if(oglasi.get(i).getCena() <= max) {
				int k = i+1;
				System.out.println("Redni broj oglasa: " + k);

				System.out.println(oglasi.get(i));
				System.out.println("-------------------------------------------------");
			}
		}

	}
	private static void izmenaOglasa() {
		String opcija;
		do {
			System.out.println("**********************************");
			System.out.println("1. Izmena osnovnih detalja.");
			System.out.println("2. Izmena informacija o opremi.");
			System.out.println("0. Vratite se nazad.");
			System.out.println("Unesite opciju:");

			opcija= sc.nextLine();

			switch(opcija) {

			case "1" :
				izmena1();
				save("Oglasi.txt");	
				break;
			case "2" :
				izmena2();
				save("Oglasi.txt");	
				break;

			}
		}while(!opcija.equals("0"));

		save("Oglasi.txt");		
	}

	private static void izmena2() {
		String temp;
		uOprema.clear();
		do {
			System.out.println("Unesite sifru pod kojom je zaveden vas oglas: ");
			temp = sc.nextLine().trim();
		}while(!isSifra(temp));
	//	int sifra = Integer.parseInt(temp);

		do {
			System.out.println("Da li poseduje: " + oprema[0] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[1] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[2] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[3] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[4] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[5] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[6] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[7] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		Oglas izmenjen = oglasi.get(index);
		oglasi.remove(index);
		izmenjen.setOprema(uOprema);

		oglasi.add(index, izmenjen);
	}

	private static void izmena1() {
		String temp;

		do {
			System.out.println("Unesite sifru pod kojom je zaveden vas oglas: ");
			temp = sc.nextLine().trim();
		}while(!isSifra(temp));
		//	int sifra = Integer.parseInt(temp);

		uOprema.clear();
		System.out.println("Unesite naslov oglasa: ");
		String naslov= sc.nextLine().trim();

		do {
			System.out.println("Unesite cenu automobila:");
			temp = sc.nextLine().trim();
		}while(!isDecimal(temp));
		Double cena = Double.parseDouble(temp);

		do {
			System.out.println("Unesite datum proizvodnje:");
			temp = sc.nextLine().trim();
		}while(!isInt(temp));
		int godinaProizvodnje= Integer.parseInt(temp);

		Oglas izmenjen = oglasi.get(index);
		oglasi.remove(index);
		izmenjen.setCena(cena);
		izmenjen.setGodinaProizvodnje(godinaProizvodnje);
		izmenjen.setNaslovOglasa(naslov);
		oglasi.add(index, izmenjen);
	}

	private static boolean isSifra(String temp) {
		try {
			int sifra = Integer.parseInt(temp);
			for(int i=0; i<oglasi.size(); i++) {
				if(sifra == oglasi.get(i).getSifraOglasa()) {
					index = i;
					return true;
				}
			}

		}catch (Exception e) {
			return false;
		}
		return false;
	}

	private static boolean isInt(String temp) {
		try {
			Integer.parseInt(temp);
			return true;	

		}catch (Exception e) {
			return false;
		}


	}

	private static void unosOglasa() {
		String temp;

		System.out.println("Sifra oglasa se dodenjuje sama i prikazuje nakon uspesnog kreiranja oglasa!\n");
		uOprema.clear();
		System.out.println("Unesite naslov oglasa: ");
		String naslov= sc.nextLine().trim();

		do {
			System.out.println("Unesite cenu automobila:");
			temp = sc.nextLine().trim();
		}while(!isDecimal(temp));
		Double cena = Double.parseDouble(temp);

		do {
			System.out.println("Unesite godinu proizvodnje:");
			temp = sc.nextLine().trim();
		}while(!isInt(temp));
		int godinaProizvodnje= Integer.parseInt(temp);

		do {
			System.out.println("Da li poseduje: " + oprema[0] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[1] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[2] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[3] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[4] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());
		do {
			System.out.println("Da li poseduje: " + oprema[5] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());


		do {
			System.out.println("Da li poseduje: " + oprema[6] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		do {
			System.out.println("Da li poseduje: " + oprema[7] + "(DA ili NE)");
			temp = sc.nextLine().trim();
		}while(!isOprema(temp));
		uOprema.add(temp.toUpperCase());

		int sifra = oglasi.size() +1;

		System.out.println("Oglas je uspesno za veden pod sifrom: " + sifra);
		Oglas noviOglas = new Oglas(sifra,naslov,cena,godinaProizvodnje,uOprema);
		oglasi.add(noviOglas);		

	}
	private static boolean isOprema(String temp) {
		if(temp.equalsIgnoreCase("DA")) {
			return true;
		}else if (temp.equalsIgnoreCase("NE")) {
			return true;
		}else
			return false;
	}

	/*	public static boolean datumValid(String datum) {
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
	 */
	private static boolean isDecimal(String temp) {
		try {
			Double.parseDouble(temp);
			return true;


		}catch (Exception e) {
			return false;
		}
	}

	private static void prikaz() {
		for(int i =0;i<oglasi.size();i++) {
			int k = i+1;
			System.out.println("Redni broj oglasa: " + k);
			System.out.println(oglasi.get(i));
			System.out.println();
		}
	}

	public static void save(String path) {	


		ArrayList<String> lines = new ArrayList<String>();
		String line= "";

		for (int i = 0; i < oglasi.size(); i++) {
			Oglas temp;
			temp = oglasi.get(i);
			line = temp.getSifraOglasa() + ";"+ temp.getNaslovOglasa() + ";" + temp.getCena() + ";" + temp.getGodinaProizvodnje() + ";";
			for(int j=0 ; j< oprema.length; j++) {
				line += temp.getOprema().get(j) +";"; 
			}
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
		oglasi.clear();

		try {
			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());



			for(int i=0;i<lines.size();i++) {
				String line= lines.get(i);
				String[] part = line.split(";");

				int sifra =Integer.parseInt(part[0]);
				String naslov = part[1];
				Double cena = Double.parseDouble(part[2]);
				int godProiz =Integer.parseInt(part[3]);

				ArrayList<String> oprema = new ArrayList<>();
				oprema.add(part[4]);
				oprema.add(part[5]);
				oprema.add(part[6]);
				oprema.add(part[7]);
				oprema.add(part[8]);
				oprema.add(part[9]);
				oprema.add(part[10]);
				oprema.add(part[11]);



				Oglas noviOglas = new Oglas(sifra, naslov, cena, godProiz,oprema);

				oglasi.add(noviOglas);


			}
		} catch (java.io.IOException e) {
			System.out.println("Datoteka " + path + " nije pronadjena.");
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
