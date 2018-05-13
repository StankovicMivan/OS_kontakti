package menjacnica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class Meni {

	public static ArrayList<Valuta> valute = new ArrayList<Valuta>();

	public static ArrayList<KursnaLista> kursneListe = new ArrayList<KursnaLista>();

	public static void ispisiMeni() {
		System.out.println("M E Nj A C N I C A ");
		System.out.println("---------------------------------------");
		System.out.println("\t 1. Ispisi sve valute");
		System.out.println("\t 2. Prikaz odredjene kursne liste sa vrednostima valuta");
		System.out.println("\t 3. Kreiranje nove kursne liste");
		System.out.println("\t 4. Ispisi sve Kursne liste");
		System.out.println("---------------------------------------");
		System.out.println("\t 0. Izlaz iz programa");
	}

	public static void ispisValuta() {
		for (int x = 0; x < valute.size(); x++) {
			System.out.println(valute.get(x).toString());
		}
	}
	
	public static void ispisiSveKursneListe() {
		for (int x = 0; x < kursneListe.size(); x++) {
			System.out.println(kursneListe.get(x).toString());
		}
	}

	public static void ispisiOdredjenuKursnuListu() {
		System.out.println("Unesite ID liste: ");
		long id = PomocnaKlasa.ocitajCeoBrojLong();
		KursnaLista kl = pronadjiKursnuListu(id);
		if(kl!=null)
			System.out.println(kl.toStringAllVrednostValuta());
		else
			System.out.println("Kursna lista za uneti id ne postoji u sistemu");
	}

	public static Valuta pronadjiValutu() {
		System.out.println("Unesite valutu: ");
		String oznaka = PomocnaKlasa.ocitajTekst();
		Valuta valuta = null;
		valuta = pronadjiValutu(oznaka);
		return valuta;
	}

	public static Valuta pronadjiValutu(String oznaka) {
		String Valute = oznaka;
		Valuta valuta = null;
		for (int x = 0; x < valute.size(); x++) {
			if (valute.get(x).getNazivValute().equalsIgnoreCase(Valute)
					|| valute.get(x).getOznakaValute().equalsIgnoreCase(Valute)) {
				valuta = valute.get(x);
			}
		}
		return valuta;
	}

	public static KursnaLista pronadjiKursnuListu(long id) {
		KursnaLista kl = null;
		for (int x = 0; x < kursneListe.size(); x++) {
			if (kursneListe.get(x).getId() == id) {
				kl = kursneListe.get(x);
			}
		}
		return kl;
	}

	public static void kreiranjeKursneListe() {

		System.out.println("Unesite ID Kursne liste");
		long id = PomocnaKlasa.ocitajCeoBrojLong();
		
		while (pronadjiKursnuListu(id)!=null) {
			System.out.println("Id kursne liste je već zauzet, pokušajte opet");
			System.out.println("Unesite ID Kursne liste");
			id = PomocnaKlasa.ocitajCeoBrojLong();
		}

		Date datum = PomocnaKlasa.proveriDatum();
		KursnaLista novaLista = new KursnaLista(id, datum);
		
		System.out.println("Unosite vrednost valuta za kursnu listu");
		
		while (PomocnaKlasa.ocitajOdlukuOPotvrdi("uneti vrednosti valuta")=='Y') {
			ispisValuta();
			
			Valuta valuta1 = pronadjiValutu();
			if (valuta1 != null) {
				System.out.println("Unesi kupovni kurs:");
				double kupovni = PomocnaKlasa.ocitajDouble();
				System.out.println("Unesi prodajni kurs:");
				double prodajni = PomocnaKlasa.ocitajDouble();
				VrednostValute vrednostV = new VrednostValute(valuta1, novaLista, kupovni, prodajni);
				if(novaLista.getVrednostValute().contains(vrednostV)==true){
					System.out.println("Vrednost valute je već uneta za kursnu listu");
					continue;
				}
				novaLista.getVrednostValute().add(vrednostV);
			} else {
				System.out.println("Tražena valuta ne postoji u sitemu");
			}
		}

		if(novaLista.getVrednostValute().size()==0){
			System.out.println("Kursna lista bez ijedne vrednosti valute ne može se uneti u sistem");
			return;
		}
		
		kursneListe.add(novaLista);
		System.out.println("Kursna lista je uspesno kreirana");
	}
	
	static void citajIzFajlaValute(File dokument) throws IOException {
		if (dokument.exists()) {

			BufferedReader in = new BufferedReader(new FileReader(dokument));

			in.mark(1);
			if (in.read() != '\ufeff') {
				in.reset();
			}

			String s2;
			while ((s2 = in.readLine()) != null) {
				valute.add(new Valuta(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}

	static void pisiUFajlValute(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (Valuta valuta : valute) {
			out2.println(valuta.toFileRepresentation());
		}

		out2.flush();
		out2.close();
	}

	static void citajIzFajlaKursneListe(File dokument) throws IOException {
		if (dokument.exists()) {

			BufferedReader in = new BufferedReader(new FileReader(dokument));

			in.mark(1);
			if (in.read() != '\ufeff') {
				in.reset();
			}

			String s2;
			while ((s2 = in.readLine()) != null) {
				kursneListe.add(new KursnaLista(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}

	static void pisiUFajlKursneListe(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (KursnaLista kl : kursneListe) {
			out2.println(kl.toFileRepresentation());
		}

		out2.flush();
		out2.close();
	}

	static void citajIzFajlaVrednostValute(File dokument) throws IOException {
		if (dokument.exists()) {

			BufferedReader in = new BufferedReader(new FileReader(dokument));

			in.mark(1);
			if (in.read() != '\ufeff') {
				in.reset();
			}

			String s2;
			while ((s2 = in.readLine()) != null) {
				new VrednostValute(s2);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}

	static void pisiUFajlVrednostValute(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));

		for (KursnaLista kl : kursneListe) {
			for (VrednostValute vv : kl.getVrednostValute()) {
				out2.println(vv.toFileRepresentation());
			}
		}
		out2.flush();
		out2.close();
	}

	public static void main(String[] args) {

		String sP = System.getProperty("file.separator");
		File valute = new File("." + sP + "files" + sP + "valute.csv");
		try {
			citajIzFajlaValute(valute);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ne postoji fajl!");
		}

		// ispisValuta();

		File kursneListeF = new File("." + sP + "files" + sP + "kursneliste.csv");
		try {
			citajIzFajlaKursneListe(kursneListeF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ne postoji fajl!");
		}

		// ispisiSveKursneListe();

		File vrednostiValuteF = new File("." + sP + "files" + sP + "vrednostiValute.csv");
		try {
			citajIzFajlaVrednostValute(vrednostiValuteF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ne postoji fajl!");
		}

		int odluka = -1;
		while (odluka != 0) {
			ispisiMeni();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:
				ispisValuta();
				break;
			case 2:
				ispisiOdredjenuKursnuListu();
				break;
			case 3:
				kreiranjeKursneListe();
				break;
			case 4:
				ispisiSveKursneListe();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}

		try {
			pisiUFajlValute(valute);
			pisiUFajlKursneListe(kursneListeF);
			pisiUFajlVrednostValute(vrednostiValuteF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
