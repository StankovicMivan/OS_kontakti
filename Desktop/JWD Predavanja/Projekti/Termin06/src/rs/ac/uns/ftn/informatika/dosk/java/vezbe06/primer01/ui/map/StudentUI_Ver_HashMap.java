package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.ui.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.model.Student;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.utils.PomocnaKlasa;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.utils.StudentNameComparator;

public class StudentUI_Ver_HashMap {

	/** ATRIBUTI KLASE ****/
	public static HashMap<Integer, Student> sviStudenti = new HashMap<Integer, Student>();
	
	/** MENI OPCJA ****/
	public static void meniStudentUI(){	
		int odluka = -1;
		while(odluka!= 0){
			ispisiTekstStudentOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz");	
					break;
				case 1:	
					unosNovogStudenta();	
					break;
				case 2:	
					izmenaPodatakaOStudentu();	
					break;
				case 3:	
					brisanjePodatakaOStudentu();
					break;
				case 4:	
					ispisiSveStudente();
					break;
				case 5:	
					Student st = pronadjiStudentaIndeks();
					if(st!=null){
						System.out.println(st.toStringAllPredmet());
					}	
					break;
				case 6:	
					//TO DO
					break;
				case 7:	
					ArrayList<Student> sortiraniStudenti = sortirajStudentePoImenu();
					ispisiSveStudente(sortiraniStudenti);
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;	
			}
		}
	}
	
	/** METODE ZA ISPIS OPCIJA ****/
	//ispis teksta osnovnih opcija
	
	public static void ispisiTekstStudentOpcije(){	
		System.out.println("Rad sa studentima - opcije:");
		System.out.println("\tOpcija broj 1 - unos podataka o novom studentu");
		System.out.println("\tOpcija broj 2 - izmena podataka o studentu");
		System.out.println("\tOpcija broj 3 - brisanje podataka o studentu");
		System.out.println("\tOpcija broj 4 - ispis podataka svih studenata");
		System.out.println("\tOpcija broj 5 - ispis podataka o odredenom studentu sa njegovim predmetima koje pohađa");
		System.out.println("\tOpcija broj 6 - ispis podataka o odredenom studentu sa njegovim ispitnim prijavama");
		System.out.println("\tOpcija broj 7 - sortiranje i ispis studenata po imenu");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS STUDENATA i ocena ****/
	//ispisi sve studente
	public static void ispisiSveStudente(){
		//I nacin
		for (Integer id : sviStudenti.keySet()) {
			System.out.println(sviStudenti.get(id));
		}
		
		//II nacin
		/*
		for (Student st : sviStudenti.values()) {
			System.out.println(st);
		}*/
		
		//III nacin
		/*
		Set<Integer> setSt = sviStudenti.keySet(); //nije kao ArrayList
		for (Iterator iterator = setSt.iterator(); iterator.hasNext();) {
			Integer id = (Integer) iterator.next();
			System.out.println(sviStudenti.get(id));	
		}*/
	}
	
	public static void ispisiSveStudente(ArrayList<Student> sortiraniStudenti){
		for (int i = 0; i < sortiraniStudenti.size(); i++) {
			System.out.println(sortiraniStudenti.get(i));
		}
	}
	
	/** METODE ZA PRETRAGU STUDENATA****/
	//pronadji studenta
	public static Student pronadjiStudentaIndeks(){
		Student retVal = null;
		System.out.println("Unesi indeks studenta:");
		String stIndex = PomocnaKlasa.ocitajTekst();
		retVal = pronadjiStudentaIndeks(stIndex);
		if(retVal == null)
			System.out.println("Student sa indeksom " +stIndex + " ne postoji u evidenciji");
		return retVal;
	}
	
	//pronadji studenta
	public static Student pronadjiStudentaIndeks(String stIndex){
		//kako su kljucevi mape id studenta a nama treba indeks moramo napraviti mapu Indeksa
		HashMap<String, Student> sviStudentiIndeks = new HashMap<String, Student>();
		for (Student st : sviStudenti.values()) {
			sviStudentiIndeks.put(st.getIndeks(), st);
		}
		return sviStudentiIndeks.get(stIndex);
	}
	
	//pronadji studenta
	public static Student pronadjiStudentaId(Integer id){
		return sviStudenti.get(id);
	}
	
	/** METODA ZA SORTIRANJE STUDENATA****/
	public static ArrayList<Student> sortirajStudentePoImenu(){
		//kako mapa studenata ne može da se sortira tako 
		//sve studente moramo prebaciti u listu čiji elementi mogu da se sortiraju
		ArrayList<Student> sortiraniStudenti = new ArrayList<Student>(sviStudenti.values());
		System.out.println("Studente je moguće sortirati\n\t1 - Ime Rastuće\n\t2- Ime Opadajuće\nIzaberi opciju:");
		int sortOpcija=PomocnaKlasa.ocitajCeoBroj();
		switch (sortOpcija) {
		case 1:
			Collections.sort(sortiraniStudenti, new StudentNameComparator(1));
			break;
		case 2:
			Collections.sort(sortiraniStudenti, new StudentNameComparator(-1));
			break;
		default:
			break;
		}
		return sortiraniStudenti;
	}
	
	/** METODE ZA UNOS, IZMENU i BRISANJE STUDENATA****/
	
	//unos novog studenta
	public static void unosNovogStudenta(){
		System.out.print("Unesi index:");
		String stIndex = PomocnaKlasa.ocitajTekst();
		stIndex = stIndex.toUpperCase();
		while(pronadjiStudentaIndeks(stIndex) != null){
			System.out.println("Student sa indeksom "+stIndex + " vec postoji");
			stIndex = PomocnaKlasa.ocitajTekst();
		}
		System.out.print("Unesi ime:");
		String stIme = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi prezime:");
		String stPrezime = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi grad:");
		String stGrad  = PomocnaKlasa.ocitajTekst();
	
		//ID atribut ce se dodeliti automatski
		Student st = new Student(0,stIme, stPrezime, stGrad, stIndex);
		sviStudenti.put(st.getId(), st);
		
		while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studenta da pohađa određene predmet") == 'Y') {
			PohadjaUI_Ver_HashMap.dodajStudentaNaPredmet(st);
		}
	}
	
	//izmena studenta
	public static void izmenaPodatakaOStudentu(){
		Student st  = pronadjiStudentaIndeks();
		if(st != null){
			System.out.print("Unesi ime:");
			String stIme = PomocnaKlasa.ocitajTekst();
			System.out.print("Unesi prezime:");
			String stPrezime = PomocnaKlasa.ocitajTekst();
			System.out.print("Unesi grad:");
			String stGrad  = PomocnaKlasa.ocitajTekst();
			
			st.setIme(stIme);
			st.setPrezime(stPrezime);
			st.setGrad(stGrad);
			
			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("ukloniti studenta da ne pohađa određene predmet") == 'Y') {
				PohadjaUI_Ver_HashMap.ukloniStudentaSaPredmeta(st);
			}
			
			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studenta da pohađa određene predmet") == 'Y') {
				PohadjaUI_Ver_HashMap.dodajStudentaNaPredmet(st);
			}
		}
	}
	
	//brisanje predmeta
	public static void brisanjePodatakaOStudentu(){
		Student st = pronadjiStudentaIndeks();
		if(st!=null){
			sviStudenti.remove(st.getId());
			System.out.println("Podaci obrisani iz evidencije");
		}
	}	
	
	/** METODA ZA UCITAVANJE PODATAKA****/
	static void citajIzFajlaStudente(File dokument) throws IOException {
		if(dokument.exists()){

			BufferedReader in = new BufferedReader(new FileReader(dokument));
			
			//workaround for UTF-8 files and BOM marker
			//BOM (byte order mark) marker may appear on the beginning of the file
			//BOM can signal which of several Unicode encodings (8-bit, 16-bit, 32-bit) that text is encoded as
			
			in.mark(1); //zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
			if(in.read()!='\ufeff'){
				in.reset();
			}
			
			String s2;
			while((s2 = in.readLine()) != null) {
				Student st = new Student(s2);
				sviStudenti.put(st.getId(),st);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	static void pisiUFajlStudente(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (Student student : sviStudenti.values()) {
			out2.println(student.toFileRepresentation());
		}
		
		out2.flush();
		out2.close();
	}
}
