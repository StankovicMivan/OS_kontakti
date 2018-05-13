package com.ftninformatika.vezbe04.primer05.ui.teze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ftninformatika.vezbe04.primer05.model.PomocnaKlasa;
import com.ftninformatika.vezbe04.primer05.model.Predmet;
import com.ftninformatika.vezbe04.primer05.model.Student;

public class PredmetUI {

	/** ATRIBUTI KLASE ****/
	public ArrayList<Predmet> sviPredmeti = new ArrayList<Predmet>();
	
	public void meniPredmetUI(StudentUI stUI, PohadjaUI pohUI){
		int odluka = -1;
		while (odluka != 0) {
			ispisiTekstStudentOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				unosNovogPredmeta(stUI, pohUI);
				break;
			case 2:
				izmenaPodatakaOPredmetu(stUI, pohUI);
				break;
			case 3:
				brisanjePodatakaOPredmetu();
				break;
			case 4:
				ispisiSvePredmete();
				break;
			case 5:
				Predmet pr = pronadjiPredmet();
				if(pr!=null){
					System.out.println(pr.toStringAllStudent());
				}	
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}
	
	public void ispisiTekstStudentOpcije() {
		System.out.println("Rad sa predmetima - opcije:");
		System.out.println("\tOpcija broj 1 - unos podataka o novom Predmetu");
		System.out.println("\tOpcija broj 2 - izmena podataka o Predmetu");
		System.out.println("\tOpcija broj 3 - brisanje podataka o Predmetu");
		System.out.println("\tOpcija broj 4 - ispis podataka svih predmeta");
		System.out.println("\tOpcija broj 5 - ispis podataka o odredenom Predmetu i svih studenta koji pohašaju predmet");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS PREDMETA ****/
	// ispisi sve predmete
	public void ispisiSvePredmete() {
		for (int i = 0; i < sviPredmeti.size(); i++) {
			System.out.println(sviPredmeti.get(i));
		}
	}
	
	/** METODE ZA PRETRAGU PREDMETA ****/
	// pronadji predmet
	public Predmet pronadjiPredmet() {
		Predmet retVal = null;
		System.out.print("Unesi id predmeta:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		retVal = pronadjiPredmetId(id);
		if (retVal == null)
			System.out.println("Predmet sa id-om " + id
					+ " ne postoji u evidenciji");
		return retVal;
	}

	// pronadji predmet
	public Predmet pronadjiPredmetId(int id) {
		Predmet retVal = null;
		for (int i = 0; i < sviPredmeti.size(); i++) {
			Predmet pr = sviPredmeti.get(i);
			if (pr.getId() ==id) {
				retVal = pr;
				break;
			}
		}
		return retVal;
	}
	
	public int pronadjiPozicijuPredmeta(){
		int retVal = -1;
		System.out.println("Unesi id predmeta:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		for (int i = 0; i < sviPredmeti.size(); i++) {
			Predmet pr = sviPredmeti.get(i);
			if (pr.getId() ==id) {
				retVal = i;
				break;
			}
		}
		if(retVal == -1)
			System.out.println("Predmet sa id-om " + id
					+ " ne postoji u evidenciji");
		return retVal;
	}
	
	/** METODE ZA UNOS, IZMENU I BRISANJE PREDMETA ****/
	// unos novog predmeta
	public void unosNovogPredmeta(StudentUI stUI, PohadjaUI pohUI) {
		System.out.print("Naziv:");
		String prNaziv= PomocnaKlasa.ocitajTekst();
		
		Predmet pred = new Predmet(0, prNaziv);
		sviPredmeti.add(pred);
		
		while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studente da pohađaju predmet") == 'Y') {
			pohUI.dodajStudentaNaPredmet(pred, stUI);
		}
	}
	
	// izmena predmeta
	public void izmenaPodatakaOPredmetu(StudentUI stUI, PohadjaUI pohUI) {
		Predmet pred = pronadjiPredmet();
		if(pred != null){
			System.out.print("Unesi novi naziv :");
			String prNaziv = PomocnaKlasa.ocitajTekst();
			pred.setNaziv(prNaziv);
			
			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("ukloniti studente da ne pohađaju predmet") == 'Y') {
				pohUI.dodajStudentaNaPredmet(pred, stUI);
			}
			
			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studente da pohađaju predmet") == 'Y') {
				pohUI.dodajStudentaNaPredmet(pred, stUI);
			}
		}
	}

	//brisanje predmeta
	public void brisanjePodatakaOPredmetu(){
		int pozicija = pronadjiPozicijuPredmeta();
		if(pozicija!=-1){
			Predmet pr = sviPredmeti.remove(pozicija);
			System.out.println("Podaci obrisani iz evidencije");
			//to do treba obisati predmet i iz slušanih predmeta
			for (Student st : pr.getStudenti()) {
				st.getPredmeti().remove(pr);
			}
		}
	}	
	
	/** METODA ZA UCITAVANJE PODATAKA****/
	public void citajIzFajlaPredmete(File dokument) throws IOException {
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
				sviPredmeti.add(new Predmet(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	public void pisiUFajlPredmete(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (Predmet predmet : sviPredmeti) {
			out2.println(predmet.toFileRepresentation());
		}
		
		out2.flush();
		out2.close();
	}
}
