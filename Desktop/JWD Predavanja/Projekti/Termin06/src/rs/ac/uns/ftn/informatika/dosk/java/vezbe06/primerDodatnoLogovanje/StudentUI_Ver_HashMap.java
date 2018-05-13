package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentUI_Ver_HashMap {

	public static Logger logger = LogManager.getLogger(StudentUI_Ver_HashMap.class.toString());
	
	/** ATRIBUTI KLASE ****/
	//posto radimo sa HashMap, ne moramo inicijalno reci velicinu
	public static HashMap<String, Student> sviStudenti = new HashMap<String,Student>();
	
	/** MENI OPCJA ****/
	public static void meniStudentUI(){	
		int odlukaS = -1;
		while(odlukaS!= 0){
			ispisiTekstStudentOpcije();
			System.out.print("opcija:");
			odlukaS = Utility.ocitajCeoBroj();
			switch (odlukaS) {
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
					ispisiSveStudente();
					break;
				case 4:	
					Student st = pronadjiStudenta();
					if(st!=null){
						System.out.println(st);
						ispisiOcene(st);
					}	
					break;
				case 5:	
					Student ocStudent = pronadjiStudenta();
					if(ocStudent!=null){
						ocStudent.getOcene().clear();
						unosOcena(ocStudent);
					}	
					break;
				case 6:
					ispisiSveStudente(sortirajStudentePoImenu());
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;	
			}
		}
		
	}
	
	/** METODE ZA ISPIS OPCIJA ****/
	//ispis teksta osnovnih opcija
	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void ispisiTekstStudentOpcije(){	
		System.out.println("Rad sa studentima - opcije:");
		System.out.println("\tOpcija broj 1 - unos podataka o novom studentu");
		System.out.println("\tOpcija broj 2 - izmena podataka o studentu");
		System.out.println("\tOpcija broj 3 - ispis podataka svih studenata");
		System.out.println("\tOpcija broj 4 - ispis podataka o odredenom studentu sa njegovim ocenama");
		System.out.println("\tOpcija broj 5 - unos ocena i racunanje proseka studenta");
		System.out.println("\tOpcija broj 6 - sortiranje i ispis studenata po imenu");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA PRETRAGU STUDENATA****/
	//pronadji studenta
	public static Student pronadjiStudenta(){
		Student retVal = null;
		System.out.println("Unesi indeks studenta:");
		String stIndex = Utility.ocitajTekst();
		retVal = pronadjiStudenta(stIndex);
		if(retVal == null)
			System.out.println("Student sa indeksom " +stIndex + " ne postoji u evidenciji");
		return retVal;
	}
	
	//pronadji studenta
	public static Student pronadjiStudenta(String stIndex){
		return sviStudenti.get(stIndex.toUpperCase());
	}
	
	/** METODE ZA UNOS i IZMENU STUDENATA****/
	
	//unos novog studenta
	public static void unosNovogStudenta(){
		System.out.print("Unesi index:");
		String stIndex = Utility.ocitajTekst();
		while(pronadjiStudenta(stIndex) != null){
			System.out.println("Student sa indeksom "+stIndex + " vec postoji");
			stIndex = Utility.ocitajTekst();
		}
		System.out.print("Unesi JMBG:");
		String stJMBG = Utility.ocitajTekst();
		System.out.print("Unesi ime i prezime:");
		String stImeIPrezime = Utility.ocitajTekst();
		System.out.print("Unesi grad:");
		String stGrad  = Utility.ocitajTekst();
		
		Student st = new Student(stJMBG, stImeIPrezime, stGrad, stIndex.toUpperCase());
		sviStudenti.put(stIndex.toUpperCase(), st);
		
		if (Utility.ocitajOdlukuOPotvrdi("uneti ocene") == 'Y') {
			unosOcena(st);
		}
	}
	
	//izmena studenta
	public static void izmenaPodatakaOStudentu(){
		Student st  = pronadjiStudenta();
		if(st != null){
			System.out.print("Unesi JMBG:");
			String stJMBG = Utility.ocitajTekst();
			System.out.print("Unesi ime i prezime:");
			String stImeIPrezime = Utility.ocitajTekst();
			System.out.print("Unesi grad:");
			String stGrad  = Utility.ocitajTekst();
			
			st.setJMBG(stJMBG);
			st.setImeIPrezime(stImeIPrezime);
			st.setGrad(stGrad);
			
			if (Utility.ocitajOdlukuOPotvrdi("izmeniti ocene") == 'Y') {
				st.getOcene().clear();
				unosOcena(st);
			}
		}
	}
	
	/** METODA ZA UNOS i IZMENU OCENA STUDENTA****/
	//unos ocene studenta
	public static void unosOcena(Student st){

		char odluka;
		do {
			System.out.println("Unesi vrednost od 5 do 10:");
			int ocOcena  = -1;
			do {
				ocOcena = Utility.ocitajCeoBroj();
				if(ocOcena<5 || ocOcena > 10)
					System.out.println("Greska - Ocena se unosi u rasponu od 5 do 10");
			}while (ocOcena < 5 || ocOcena > 10);
			
			System.out.println("Unesi naziv predmeta:");
			String predmet;
			do {
				predmet = Utility.ocitajTekst();
				if(predmet==null || predmet.trim().equals(""))
					System.out.println("Greska - naziv predmeta mora biti tekst");
			}while (predmet==null || predmet.trim().equals(""));
			
			st.getOcene().add(new Ocena(predmet, ocOcena));
			
			odluka = Utility.ocitajOdlukuOPotvrdi("uneti jos ocena");
		} while (odluka == 'Y');
	}
	
	/** METODE ZA ISPIS STUDENATA i ocena ****/
	//ispisi sve studente
	public static void ispisiSveStudente(){
		//I nacin
		for (String indeks : sviStudenti.keySet()) {
			System.out.println(sviStudenti.get(indeks));
		}
		
		//II nacin
		/*
		for (Student st : sviStudenti.values()) {
			System.out.println(st);
		}*/
		
		//III nacin
		/*
		Set<String> setSt = sviStudenti.keySet(); //nije kao ArrayList
		for (Iterator iterator = setSt.iterator(); iterator.hasNext();) {
			String indeks = (String) iterator.next();
			System.out.println(sviStudenti.get(indeks));	
		}*/
	}
	
	//ispisi sve studente
	public static void ispisiSveStudente(ArrayList<Student> lista){
		for (Student st : lista) {
			System.out.println(st);
		}
	}
		
	//ispisi ocene studenta
	public static void ispisiOcene(Student st){
		st.ispisiOcene();
	}
	
	/** METODA ZA SORTIRANJE STUDENATA****/
	public static ArrayList<Student> sortirajStudentePoImenu(){
		ArrayList<Student> retVal = new ArrayList<Student>(sviStudenti.values());
		Collections.sort(retVal, new OsobaNameComparator(1));
		return retVal;
	}
}
