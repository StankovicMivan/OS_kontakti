package com.drugi.pokusaj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class IspitnaPrijavaUI {

	/** ATRIBUTI KLASE ****/
	//	
	public static ArrayList<IspitnaPrijava> svePrijave = new ArrayList<>();

	//	private static Student st;
	//	private static Predmet predmet;
	public static IspitniRokUI rok;
	public static IspitniRok rokz;

	public static void meniIspitnaPrijavaUI(){
		int odluka = -1;
		while (odluka != 0) {
			ispisiTekstIspisnePrijave();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				prijavaStudentaZaOdredjeniPredmet();
				break;
			case 2:
				prikazSvihPrijavaZaStudentaURoku();
				break;
			case 3:
				//				brisanjePodatakaOPredmetu();
				break;
			case 4:
				//				ispisiSvePredmete();
				break;
			case 5:
				//				Predmet pr = pronadjiPredmet();
				//				if(pr!=null){
				//					System.out.println(pr.toStringAllStudent());
				//				}	
				//				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}

	private static void prikazSvihPrijavaZaStudentaURoku() {
		System.out.print("Unesi index studenta za koga zelite da proverite prijave:");
		String index = PomocnaKlasa.ocitajTekst();
		index = index.toUpperCase();

		while(StudentUI.pronadjiStudentaIndeks(index) == null){
			System.out.println("Student sa indeksom "+index + " NE POSTOJI!");
			index = PomocnaKlasa.ocitajTekst();
		}

		System.out.print("Unesi ID za rok za koji zelite proveru:");
		int rokID = PomocnaKlasa.ocitajCeoBroj();


		while(IspitniRokUI.pronadjiIspitniRokID(rokID) == null){
			System.out.println("Rok sa ID-em : "+rokID + " NE POSTOJI!");
			rokID = PomocnaKlasa.ocitajCeoBroj();
		}
		Student s = StudentUI.pronadjiStudentaIndeks(index);
		System.out.println("Student je prijavio sledece predmete:");
		for (int i = 0; i <s.ispitnePrijave.size() ; i++) {

			if(rokID == s.ispitnePrijave.get(i).getIr().getId()) {

				System.out.println(s.ispitnePrijave.get(i).getPr());
			}

		}
	}

	private static void prijavaStudentaZaOdredjeniPredmet() {
		System.out.print("Unesi ID za rok u kome prijavljute ispit:");
		int rokID = PomocnaKlasa.ocitajCeoBroj();


		while(IspitniRokUI.pronadjiIspitniRokID(rokID) == null){
			System.out.println("Rok sa ID-em : "+rokID + " NE POSTOJI!");
			rokID = PomocnaKlasa.ocitajCeoBroj();
		}
		System.out.print("Unesi index studenta koji bi zeleo da prijavi ispit:");
		String index = PomocnaKlasa.ocitajTekst();
		index = index.toUpperCase();

		while(StudentUI.pronadjiStudentaIndeks(index) == null){
			System.out.println("Student sa indeksom "+index + " NE POSTOJI!");
			index = PomocnaKlasa.ocitajTekst();
		}

		System.out.print("Unesi ID predmeta koji zelite da prijavite:");
		int predmetID = PomocnaKlasa.ocitajCeoBroj();


		while(PredmetUI.pronadjiPredmetId(predmetID) == null){
			System.out.println("Predmet sa ID-em: "+predmetID + " NE POSTOJI!");
			predmetID = PomocnaKlasa.ocitajCeoBroj();
		}


		if(!daLiPrijavaZaOdredjeniPredmetPostoji(index, predmetID, rokID)) {
			return;
		}

		Student s = StudentUI.pronadjiStudentaIndeks(index);
		Predmet p = PredmetUI.pronadjiPredmetId(predmetID);
		IspitniRok r = IspitniRokUI.pronadjiIspitniRokID(rokID);

		//Nisam siguran kako odakle se iscitavaju poeni za teoriju i zadatke;
		//Pa sam stavio da korisnik unosi broj poena za teoriju i zadatke

		System.out.print("Unesi broj ostvarenih poena na teoriji:");
		int teo = PomocnaKlasa.ocitajCeoBroj();

		System.out.print("Unesi broj ostvarenih poena na zadacima:");
		int zad = PomocnaKlasa.ocitajCeoBroj();



		IspitnaPrijava ip = new IspitnaPrijava(s, p, r, teo, zad);
		rokz.ispitnePrijave.add(ip);

		//ID atribut ce se dodeliti automatski


		//		Student st = new Student(0,stIme, stPrezime, stGrad, stIndex);
		//		sviStudenti.add(st);
		//		
		
	}

	public static boolean daLiPrijavaZaOdredjeniPredmetPostoji(String index, int predmetID, int rokID) {
		// TODO Auto-generated method stub
		Student s = StudentUI.pronadjiStudentaIndeks(index);
		//		Predmet p = PredmetUI.pronadjiPredmetId(predmetID);
		//		IspitniRok r = IspitniRokUI.pronadjiIspitniRokID(rokID);

		for (int i = 0; i < s.ispitnePrijave.size(); i++) {
			if((predmetID == s.ispitnePrijave.get(i).getPr().id) && (rokID == s.ispitnePrijave.get(i).getIr().id)) {
				System.out.println("Nije moguce prijaviti predmet, posto je predmet vec prijavljen!");

				return false;
			}
		}

		//		for (int i = 0; i < IspitnaPrijavaUI.svePrijave.size(); i++) {
		//			for (int j = 0; j <IspitnaPrijavaUI.svePrijave.size(); j++) {
		//
		//				if((index.equals(IspitniRokUI.sviRokovi.get(i).ispitnePrijave.get(j).st.indeks ))&&( predmetID == IspitniRokUI.sviRokovi.get(i).ispitnePrijave.get(j).pr.id) ) {
		//					System.out.println("Nije moguce prijaviti predmet, posto je predmet vec prijavljen!");
		//					return false;
		//				}
		//			}
		//		}

		return true;

	}

	//	
	static void pisiUFajlIspitnePrijave(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (IspitnaPrijava pr : rokz.ispitnePrijave) {
			out2.println(pr.toFileRepresentation());
		}

		out2.flush();
		out2.close();
	}

	static void citajIzFajlaIspitnePrijave(File dokument) throws IOException {
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
				if(s2.equals("")) {
					continue;
				}
				rokz.ispitnePrijave.add(new IspitnaPrijava(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	public static void ispisiTekstIspisnePrijave() {
		System.out.println("Rad sa predmetima - opcije:");
		System.out.println("\tOpcija broj 1 - Prijava studenta za odredjeni predmet");
		System.out.println("\tOpcija broj 2 - Spisak prijavljenih predmeta za odredjenog studenta u odredjenom roku");
		//		System.out.println("\tOpcija broj 3 - brisanje podataka o Predmetu");
		//		System.out.println("\tOpcija broj 4 - ispis podataka svih predmeta");
		//		System.out.println("\tOpcija broj 5 - ispis podataka o odredenom Predmetu i svih studenta koji pohašaju predmet");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
}
