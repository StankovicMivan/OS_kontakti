import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;








public class Test {

	public static ArrayList<KursnaLista> liste = new ArrayList<>();
	public static ArrayList<Valuta> valute = new ArrayList<Valuta>();

	public  static void main(String args[]) throws IOException  {
		
		load();
		
		int odluka = -1;
		while (odluka != 0) {
			meni();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:
//				ispisValuta();
				break;
			case 2:
//				ispisiOdredjenuKursnuListu();
				break;
			case 3:
//				kreiranjeKursneListe();
				break;
			case 4:
//				ispisiSveKursneListe();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}

//		try {
//			pisiUFajlValute(valute);
//			pisiUFajlKursneListe(kursneListeF);
//			pisiUFajlVrednostValute(vrednostiValuteF);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}




	}
	private static void meni() {
		System.out.println("M E N I ");
		System.out.println("---------------------------------------");
		System.out.println("\t 1. Ispisi sve valute");
		System.out.println("\t 2. Prikaz odredjene kursne liste sa vrednostima valuta");
		System.out.println("\t 3. Kreiranje nove kursne liste");
		System.out.println("\t 4. Ispisi sve Kursne liste");
		System.out.println("---------------------------------------");
		System.out.println("\t 0. Izlaz iz programa");
		
	}
	public static void load()throws IOException {
		String sP = System.getProperty("file.separator");
		
		File kursneListeFile = new File("."+sP+"files"+sP+"kursneliste.csv");
		citajIzFajlaKursnaLista(kursneListeFile);

		File valuteFile = new File("." + sP + "files" + sP + "valute.csv");
		citajIzFajlaValute(valuteFile);
		
		File vrednostValute = new File("." + sP + "files" + "vrednostiValuta.csv");
		citajIzFajlaVrednost(vrednostValute);
		
	}

	private static void citajIzFajlaVrednost(File dokument) throws IOException {
		if(dokument.exists()) {

			BufferedReader in = new BufferedReader( new FileReader(dokument));

			in.mark(1);
			if(in.read() != '\ufeff') {
				in.reset();
			}

			String s;
			while((s = in.readLine()) != null) {
				new VrednostValuta(s);
			}
			in.close();
		}else {
			System.out.println("Ne postoji file.");
		}
		
	}

	private static void citajIzFajlaValute(File dokument) throws IOException {

		if(dokument.exists()) {

			BufferedReader in = new BufferedReader( new FileReader(dokument));

			in.mark(1);
			if(in.read() != '\ufeff') {
				in.reset();
			}

			String s;
			while((s = in.readLine()) != null) {
				valute.add(new Valuta(s));
			}
			in.close();
		}else {
			System.out.println("Ne postoji file.");
		}

	}

	public static void citajIzFajlaKursnaLista(File dokument) throws IOException {

		if(dokument.exists()) {

			BufferedReader in = new BufferedReader( new FileReader(dokument));

			in.mark(1);
			if(in.read() != '\ufeff') {
				in.reset();
			}

			String s;
			while((s = in.readLine()) != null) {
				liste.add(new KursnaLista(s));
			}
			in.close();
		}else {
			System.out.println("Ne postoji file.");
		}

	}

	public static KursnaLista pronadjiKursnuListu(int parseInt) {
		KursnaLista k = null;
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getId() == parseInt) {
				k = liste.get(i);
			}
		}
		return k;
	}

	public static Valuta pronadjiValutu(String string) {
		String Valute = string;
		Valuta valuta = null;
		for (int x = 0; x < valute.size(); x++) {
			if (valute.get(x).getNaziv().equalsIgnoreCase(Valute)
					|| valute.get(x).getOznaka().equalsIgnoreCase(Valute)) {
				valuta = valute.get(x);
			}
		}
		return valuta;
	}	
}
