package com.drugi.pokusaj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class IspitniRokUI {

	public static ArrayList<IspitniRok> sviRokovi = new ArrayList<IspitniRok>();

	public static void meniIspitniRokUI(){
		int odluka = -1;
		while (odluka != 0) {
			ispisiIsptniRokOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				unosIspitnogRoka();
				break;
			case 2:
				izmenaIspitnogRoka();
				break;
			case 3:
				ispisiSveIspitnogRoka();
				break;
			case 4:
				IspitniRok ir = pronadjiIspitniRok();
				if(ir!=null){
					System.out.println(ir.toStringAllIspitnaPrijava());
				}	
				break;
			case 5:
				nekiMojTest();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}



	private static void nekiMojTest() {
		for (int i = 0; i < sviRokovi.size(); i++) {
			for (int j = 0; j < sviRokovi.get(i).ispitnePrijave.size(); j++) {
				System.out.println(sviRokovi.get(i).ispitnePrijave.get(j));
			}
		}
		System.out.println(sviRokovi.get(0).getIspitnePrijave());
	}



	private static void ispisiSveIspitnogRoka() {

		for (int i = 0; i < sviRokovi.size(); i ++) {
			System.out.println(sviRokovi.get(i));
		}

	}



	private static void izmenaIspitnogRoka() {

		IspitniRok ir = pronadjiIspitniRok();
		if(ir != null){
			System.out.print("Unesi novi naziv :");
			String irNaziv = PomocnaKlasa.ocitajTekst();
			ir.setNaziv(irNaziv);
			System.out.print("Unesi novi pocetak roka :");
			String irPocetak = PomocnaKlasa.ocitajTekst();
			ir.setPocetak(irPocetak);
			System.out.print("Unesi novi kraj roka :");
			String irKraj = PomocnaKlasa.ocitajTekst();
			ir.setKraj(irKraj);

			//			
			//			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("ukloniti ispitne roko da ne pohađaju predmet") == 'Y') {
			//				PohadjaUI.dodajStudentaNaPredmet(pred);
			//			}
			//			
			//			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studente da pohađaju predmet") == 'Y') {
			//				PohadjaUI.dodajStudentaNaPredmet(pred);

		}

	}



	private static void unosIspitnogRoka() {

		System.out.print("Naziv:");
		String irNaziv= PomocnaKlasa.ocitajTekst();
		System.out.print("od:");
		String irPocetak = PomocnaKlasa.ocitajTekst();
		System.out.print("do:");
		String irKraj = PomocnaKlasa.ocitajTekst();
		IspitniRok ir = new IspitniRok(0, irNaziv, irPocetak, irKraj);
		sviRokovi.add(ir);

		//		while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati ispitni rok") == 'Y') {
		//			IspitniRokUI.dodajIspitniRok(ir);
		//		}

	}



	public static IspitniRok pronadjiIspitniRok() {
		IspitniRok retVal = null;
		System.out.print("Unesi id ispitnog roka:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		retVal = pronadjiIspitniRokID(id);
		if (retVal == null)
			System.out.println("Ispitni rok sa id-om " + id
					+ " ne postoji u evidenciji");
		return retVal;
	}



	public static IspitniRok pronadjiIspitniRokID(int id) {

		IspitniRok retVal = null;
		for (int i = 0; i < sviRokovi.size(); i++) {
			IspitniRok pr = sviRokovi.get(i);
			if (pr.getId() ==id) {
				retVal = pr;
				break;
			}
		}
		return retVal;	
	}



	public static void ispisiIsptniRokOpcije() {
		System.out.println("Rad sa predmetima - opcije:");
		System.out.println("\tOpcija broj 1 - unos podataka o ispitnom roku");
		System.out.println("\tOpcija broj 2 - izmena podataka o ispitnom roku");
		System.out.println("\tOpcija broj 3 - ispis podataka svih podataka");
		System.out.println("\tOpcija broj 4 - ispis podataka o odredenom ispitnom roku");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}



	public static void citajIzFajlaIspitneRokove(File dokument) throws IOException {

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
				
				sviRokovi.add(new IspitniRok(s2));
			}
			in.close();
		} else {
			System.out.println("File ne postoji.");
		}

	}



	public static void pisiUFajlIspitneRokove(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (IspitniRok ir : sviRokovi) {
			out2.println(ir.toFileRepresentation());
		}

		out2.flush();
		out2.close();
	}



	public static ArrayList<IspitniRok> getSviRokovi() {
		return sviRokovi;
	}



	public static void setSviRokovi(ArrayList<IspitniRok> sviRokovi) {
		IspitniRokUI.sviRokovi = sviRokovi;
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
//				if(s2.equals("")) {
//					continue;
//				}
				String [] tokeni = s2.split(",");
				for (int i = 0; i <sviRokovi.size() ; i++) {
					if((((Integer.parseInt(tokeni[2]))) == (sviRokovi.get(i).id))) {
						sviRokovi.get(i).ispitnePrijave.add(new IspitnaPrijava(s2));
					}
				}
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}

}
