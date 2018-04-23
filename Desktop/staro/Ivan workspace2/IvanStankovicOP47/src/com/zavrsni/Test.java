package com.zavrsni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {

	public static Scanner sc = new Scanner(System.in);
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public static void main(String[] args) {
		Ordinacija ordinacija = new Ordinacija();
		ordinacija.load("Ordinacija.txt");
		//MENI
		String opcija;
		do {
			System.out.println("******************** MENI ********************");
			System.out.println("1.  Unos podataka o ordinaciji.");
			System.out.println("2.  Unos podataka o intervenciji.");
			System.out.println("3.  Ispis podataka o svim intervencijama.");
			System.out.println("4.  Izmena podataka o intervenciji.");
			System.out.println("5.  Brisanje podataka o intervenciji.");
			System.out.println("6.  Ispis svih intervencija za zadatog pacijenta.");
			System.out.println("7.  Ispis svih intervencija zadatog tipa u zadatom vremenskom periodu.");
			System.out.println("8.  Izracunavanje i prikaz procenta pacijenata koje je primio zadati lekar.");
			System.out.println("9.  Pronalazenje najskuplje intervencije zadatog tipa u vremenskom periodu.");
			System.out.println("10. Ispis podataka o ordinaciji.");
			System.out.println("0.  Izlaz iz programa.");
			System.out.println();
			System.out.println("Unesite opciju:");
			opcija= sc.nextLine();

			switch(opcija) {

			case "1" :
				unos1(ordinacija);						//Funkcija za unos 1 iz menija
				ordinacija.save("Ordinacija.txt");
				break;
			case "2" :
				unos2(ordinacija);						//Funkcija za unos 2 iz menija
				ordinacija.save("Ordinacija.txt");
				break;
			case "3" :
				zaglavlje();
				ispis3(ordinacija);						//Ispisuje podataka os svim intervencija
				break;
			case "4" :
				izmena4(ordinacija);
				ordinacija.save("Ordinacija.txt");
				break;
			case "5" :
				brisanje5(ordinacija);
				ordinacija.save("Ordinacija.txt");
				break;
			case "6" :
				ispis6(ordinacija);
				break;
			case "7" :
				ispis7(ordinacija);
				break;
			case "8" :
				pretraga8(ordinacija);
				break;
			case "9" :
				pretraga9(ordinacija);
				break;
			case "10" :
				System.out.println(ordinacija);
				break;

			}
		}while(!opcija.equals("0"));

		ordinacija.save("Ordinacija.txt");
		sc.close();




	}

	public static void pretraga9(Ordinacija ordinacija) {
		String temp;

		do {
			System.out.println("Unesite tip intervencije [plomba,vadjenje,operacija,estetika]:");
			temp = sc.nextLine().trim().toLowerCase();
		}while(!tipValid(temp));
		String tipIntervencije = temp;

		do {
			System.out.println("Unesite donju granicu pretrage po datumu");
			temp = sc.nextLine();
		}while(!datumValid(temp));
		LocalDate donjaGranica = LocalDate.parse(temp, dtf);
		do {
			System.out.println("Unesite gornju granicu pretrage po datumu");
			temp = sc.nextLine();
		}while(!datumValid(temp));
		LocalDate gornjaGranica = LocalDate.parse(temp, dtf);

		ordinacija.pretraga9(tipIntervencije, donjaGranica,gornjaGranica);
	}

	public static void pretraga8(Ordinacija ordinacija) {
		String temp;
		do {
			System.out.println("Unesite ime lekara:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String imeLekara = temp;

		do {
			System.out.println("Unesite prezime lekara:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String prezimeLekara = temp;

		ordinacija.pretraga8(imeLekara, prezimeLekara);
	}

	public static void ispis7(Ordinacija ordinacija) {
		String temp;

		do {
			System.out.println("Unesite tip intervencije [plomba,vadjenje,operacija,estetika]:");
			temp = sc.nextLine().trim().toLowerCase();
		}while(!tipValid(temp));
		String tipIntervencije = temp;

		do {
			System.out.println("Unesite donju granicu pretrage po datumu");
			temp = sc.nextLine();
		}while(!datumValid(temp));
		LocalDate donjaGranica = LocalDate.parse(temp, dtf);
		do {
			System.out.println("Unesite gornju granicu pretrage po datumu");
			temp = sc.nextLine();
		}while(!datumValid(temp));
		LocalDate gornjaGranica = LocalDate.parse(temp, dtf);

		ordinacija.ispis7(tipIntervencije, donjaGranica, gornjaGranica);
	}

	public static void ispis6(Ordinacija ordinacija) {
		String temp;
		do {
			System.out.println("Unesite ime pacijenta:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String imePacijenta = temp;


		do {
			System.out.println("Unesite prezime pacijenta:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String prezimePacijenta = temp;

		ordinacija.ispis6(imePacijenta, prezimePacijenta);
	}

	public static void brisanje5(Ordinacija ordinacija) {
		String temp;
		do {
			System.out.println("Unesite identifikacioni broj intervencije:");
			temp= sc.nextLine();
		}while(!isIdValid(ordinacija , temp));
		int id = Integer.parseInt(temp);

		ordinacija.brisanje(id);
	}

	public static void izmena4(Ordinacija ordinacija) {
		String temp;
		do {
			System.out.println("Unesite identifikacioni broj intervencije:");
			temp= sc.nextLine();
		}while(!isIdValid(ordinacija , temp));
		int id = Integer.parseInt(temp);

		do {
			System.out.println("Unesite ime pacijenta:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String imePacijenta = temp;


		do {
			System.out.println("Unesite prezime pacijenta:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String prezimePacijenta = temp;

		do {
			System.out.println("Unesite ime lekara:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String imeLekara = temp;

		do {
			System.out.println("Unesite prezime lekara:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String prezimeLekara = temp;

		do {
			System.out.println("Unesite tip intervencije [plomba,vadjenje,operacija,estetika]:");
			temp = sc.nextLine().trim().toLowerCase();
		}while(!tipValid(temp));
		String tipIntervencije = temp;


		do {
			System.out.println("Unesite opis intervencije:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String opisIntevencije = temp;

		LocalDate datum;

		do {
			System.out.println("Unesite datum:");
			temp = sc.nextLine();
		}while(!datumValid(temp));
		datum = LocalDate.parse(temp, dtf);



		do {
			System.out.println("Unesite cenu intervencije:");
			temp = sc.nextLine();
		}while(!isDouble(temp));
		double cena = Double.parseDouble(temp);


		Intervencija novaIntervencija = new Intervencija(id,imePacijenta,prezimePacijenta,imeLekara,prezimeLekara,tipIntervencije,opisIntevencije,datum,cena);
		ordinacija.izmenaIntervencije(novaIntervencija);

	}

	public static void ispis3(Ordinacija ordinacija) {

		for(int i = 0; i < ordinacija.getListaInterverncija().size();i++) {
			System.out.println(ordinacija.getListaInterverncija().get(i));
		}
	}

	public static void unos2(Ordinacija ordinacija) {


		String temp;
		do {
			System.out.println("Unesite identifikacioni broj intervencije:");
			temp= sc.nextLine();
		}while(!isIdValid(temp , ordinacija));
		int id = Integer.parseInt(temp);

		do {
			System.out.println("Unesite ime pacijenta:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String imePacijenta = temp;


		do {
			System.out.println("Unesite prezime pacijenta:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String prezimePacijenta = temp;

		do {
			System.out.println("Unesite ime lekara:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String imeLekara = temp;

		do {
			System.out.println("Unesite prezime lekara:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String prezimeLekara = temp;

		do {
			System.out.println("Unesite tip intervencije [plomba,vadjenje,operacija,estetika]:");
			temp = sc.nextLine().trim().toLowerCase();
		}while(!tipValid(temp));
		String tipIntervencije = temp;


		do {
			System.out.println("Unesite opis intervencije:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		String opisIntevencije = temp;

		LocalDate datum;

		do {
			System.out.println("Unesite datum:");
			temp = sc.nextLine();
		}while(!datumValid(temp));
		datum = LocalDate.parse(temp, dtf);



		do {
			System.out.println("Unesite cenu intervencije:");
			temp = sc.nextLine();
		}while(!isDouble(temp));
		double cena = Double.parseDouble(temp);


		Intervencija novaIntervencija = new Intervencija(id,imePacijenta,prezimePacijenta,imeLekara,prezimeLekara,tipIntervencije,opisIntevencije,datum,cena);
		ordinacija.unosNoveIntervencije(novaIntervencija);

	}

	public static boolean isDouble(String temp) {
		try {
			double cena = Double.parseDouble(temp);
			if(cena > 1) {
				return true;
			}else
				return false;
		}catch (Exception e) {
			return false;
		}
	}

	public static boolean tipValid(String temp) {

		if(temp.equals("plomba") || temp.equals("vadjenje") ||temp.equals("operacija") ||temp.equals("estetika") ) {
			return true;
		}else
			return false;

	}

	public static void unos1(Ordinacija ordinacija) {
		String temp;
		do {
			System.out.println("Unesite naziv ordinacije:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		ordinacija.setNaziv(temp);
		do {
			System.out.println("Unesite adresu ordinacije:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		ordinacija.setAdresa(temp);
		do {
			System.out.println("Unesite PIB ordinacije:");
			temp = sc.nextLine().trim();
		}while(temp.equals(""));
		ordinacija.setPib(temp);

		System.out.println("Podatci su uspesno zapisani.");
	}

	public static boolean isIdValid(String id1, Ordinacija ordinacija) {			//Ova validacija gleda da li id postoji, ako postoji u listi trazi da se unose drugi id
		try {																		// Metode se isto zovu ali su parametri u grugacijem redosledu.			
			int id = Integer.parseInt(id1);
			if(id > 0) {

				for(int i=0;i<ordinacija.getListaInterverncija().size();i++) {
					if(ordinacija.getListaInterverncija().get(i).getIdentifikator() == id) {
						System.out.println("Uneli ste identifikacioni broj koji vec postoji!");
						return false;
					}

				}
				return true;
			}else{
				System.out.println("ID mora biti veci od 0");
				return false;
			}

		}catch (Exception x) {
			return false;
		}
	}
	public static boolean isIdValid( Ordinacija ordinacija,String id1) {			//Ova validacija gleda da li id postoji, ako postoji dozvoljava dalji upis radi izmene podataka
		try {
			int id = Integer.parseInt(id1);
			if(id < 0) {
				System.out.println("ID mora biti veci od 0");

				return false;
			}
			for(int i=0;i<ordinacija.getListaInterverncija().size();i++) {
				if(ordinacija.getListaInterverncija().get(i).getIdentifikator() == id) {
					return true;
				}

			}
			System.out.println("Uneli ste identifikacioni broj koji ne postoji!");
			return false;
		}catch (Exception x) {
			return false;
		}
	}
	public static void zaglavlje() {
		System.out.println("_________________________________________________________________________________________________________________________________________________________________");

		System.out.println(String.format( "|%14s | %19s | %14s | %14s | %11s | %17s| %16s | %15s | %15s |","Identifikator", "I pacijenta", "P pacijenta","I lekara" , "P Lekara" , "Tip " ,"Opis ","Datum", "Cena"));
		System.out.println("_________________________________________________________________________________________________________________________________________________________________");

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
}
