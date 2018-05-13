package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer02.model.*;

public class Test {

	public static void test1() {
		boolean greska = false;
		int broj = 0;

		try {
			//verzija 1 - Greska pri konverziji teksta u broj
//			broj = Integer.parseInt("NIJE BROJ NEGO TEKST");
			
			//verzija 2 - Greska metoda je pozvana u nedozvoljenom trunutku 
//			Utility.sc.close();
//			System.out.println("Unesite broj");
//			broj = Utility.ocitajCeoBroj();
			
			//verzija 3 - Greska pri konverziji objekata 
//			Object obj = new Student("3,E1 03/2013,Trajković,Nebojša,Inđija");
//			Predmet b = (Predmet) obj;
			
		}
		catch (NumberFormatException ex) {
			System.out.println("greska pri parsiranju teksta u broj");
			greska = true;
		}
		catch (IllegalStateException ex) {
			System.out.println("greska pri radu sa skenerom");
			greska = true;
//			return;
		}
		catch (ClassCastException ex) {
			System.out.println("Zabranjena konverzija");
			greska = true;
		}
		catch (Exception ex){
			System.out.println("greska");
			ex.printStackTrace();
			greska = true;
		} 
		finally {
			System.out.println("Obavezan deo try/catch");
			if (greska == true){
				if (Utility.ocitajOdlukuOPotvrdi("nastaviti aplikaciju") == 'N')
					return;
			}
		}

		System.out.println("Nastavak aplikacije");
	}

//	public static void ucitavanjePodatakaCVS() {
	public static void ucitavanjePodatakaCVS() throws FileNotFoundException, IOException {
		String sP = System.getProperty("file.separator");

		File studenti = new File("."+sP+"materijali"+sP+"studenti.csv");
//		File studenti = new File("."+sP+"materijali"+sP+"studentiFajlNePostoji.csv"); 

		BufferedReader in = new BufferedReader(
				new FileReader(studenti));
		
		//workaround for UTF-8 files and BOM marker
		//BOM (byte order mark) marker may appear on the beginning of the file
		//BOM can signal which of several Unicode encodings (8-bit, 16-bit, 32-bit) that text is encoded as
		
		in.mark(1); //zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
		if(in.read()!='\ufeff'){
			in.reset();
		}
		
		String s2;
		while((s2 = in.readLine()) != null) {
			System.out.println(s2);
		}
		in.close();
	}
	
	//propagacija izuzetaka, hijerarhija izuzetaka
	public static void test2() {
		try {
			ucitavanjePodatakaCVS();
		}
//		catch (IOException ex) {
//			System.out.println("greska pri radu sa fajlovima - ne postoji fajl ili ne moze da se cita/pise fajl");
//		}
		catch (FileNotFoundException ex) {
			System.out.println("Fajl ne postoji");
		}
		catch (IOException ex) {
			System.out.println("greska pri citanju/pisanju iz fajla");
		}
	}

	/** METODA ZA UCITAVANJE PODATAKA **/
	static ArrayList<Student> citajIzFajlaStudente(File dokument) throws FileNotFoundException, IOException, IzuzetakNeispravanSlog {
		ArrayList<Student> sviStudenti = new ArrayList<>();

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
			sviStudenti.add(new Student(s2));
		}
		in.close();

		return sviStudenti;
	}

	public static void test3() {
		String sP = System.getProperty("file.separator");
		
		File studentiFajl = new File("."+sP+"data"+sP+"studenti.csv");
//		File studentiFajl = new File("."+sP+"data"+sP+"neispravniStudenti1.csv");
//		File studentiFajl = new File("."+sP+"data"+sP+"neispravniStudenti2.csv");
		try {
			List<Student> sviStudenti = citajIzFajlaStudente(studentiFajl);
			for (Student itStudent: sviStudenti)
				System.out.println(itStudent);
		} catch (FileNotFoundException ex) {
			System.out.println("Ne postoji datoteka!");
		} catch (IzuzetakNeispravanSlog ex) {
			ex.ispisIzuzetak();
		} catch (IOException ex) {
			System.out.println("Nepoznata greska!");
		}
	}

	public static void main(String[] args) throws Exception{
		test1();
//		test2();	
//		test3();
		 
		System.out.println("Kraj aplikacije");
	}

}
