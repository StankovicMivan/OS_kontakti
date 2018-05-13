package studentskaSluzba;


public class StudSluzbaTermin02 {
	
	public static void ucitajPodatkeNastavnik(String [] sviRedoviNastavnici, int [] nastavnik_id, String [] nastavnik_ime,
			String [] nastavnik_prezime, String [] nastavnik_zvanje){
		
		System.out.println("\n\nNASTAVNICI---------------------------------");
		for (int i = 0; i < sviRedoviNastavnici.length; i++) {
			System.out.println("\n************************************");
			System.out.println("Red ->" + sviRedoviNastavnici[i]);
			
			String [] nastavnikPodaciTekst = sviRedoviNastavnici[i].split(",");
//			System.out.println("Preuzimanje i ispis podataka o nastavniku");
			
			nastavnik_id[i] = Integer.parseInt(nastavnikPodaciTekst[0]);
			nastavnik_ime[i] = nastavnikPodaciTekst[1];
			nastavnik_prezime[i] = nastavnikPodaciTekst[2];
			nastavnik_zvanje[i] = nastavnikPodaciTekst[3];
			
//			System.out.println("Nastavnik " + nastavnik_ime[i] + " " + nastavnik_prezime[i] + " sa id " 
//					+ nastavnik_id[i] + " ima zvanje " + nastavnik_zvanje[i]);
		}
	}
	
	public static void ucitajPodatkePredmet(String [] sviRedoviPredmeti, int [] predmet_id, String [] predmet_naziv){
		
		System.out.println("\n\nPREDMETI---------------------------------");
		for (int i = 0; i < sviRedoviPredmeti.length; i++) {
			System.out.println("\n************************************");
			System.out.println("Red ->" + sviRedoviPredmeti[i]);
			
			String [] predmetPodaciTekst = sviRedoviPredmeti[i].split(",");
//			System.out.println("Preuzimanje i ispis podataka o predmetu");
			
			predmet_id[i] = Integer.parseInt(predmetPodaciTekst[0]);
			predmet_naziv[i] = predmetPodaciTekst[1];
			
//			System.out.println("Predmet " + predmet_naziv[i] + " sa id " + predmet_id[i]);
		}
	}
	
	public static void ucitajPodatkeStudent(String [] sviRedoviStudenti, int [] student_id, String [] student_indeks,
			String [] student_prezime, String [] student_ime, String [] student_grad){
		
		System.out.println("\n\nSTUDENTI---------------------------------");
		for (int i = 0; i < sviRedoviStudenti.length; i++) {
			System.out.println("\n************************************");
			System.out.println("Red ->" + sviRedoviStudenti[i]);
			
			String [] studentPodaciTekst = sviRedoviStudenti[i].split(",");
//			System.out.println("Preuzimanje i ispis podataka o studentu");
			
			student_id[i] = Integer.parseInt(studentPodaciTekst[0]);
			student_indeks[i] = studentPodaciTekst[1];
			student_prezime[i] = studentPodaciTekst[2];
			student_ime[i] = studentPodaciTekst[3];
			student_grad[i] = studentPodaciTekst[4];
			
//			System.out.println("Student " + student_ime[i] + " " + student_prezime[i] + " sa id " 
//					+ student_id[i] + " i indeksom " + student_indeks[i] + " dolazi iz grada " + student_grad[i]);
		}
	}
	
	public static void ispisiSvePodatkeNastavnika(int [] nastavnik_id, String [] nastavnik_ime,
			String [] nastavnik_prezime, String [] nastavnik_zvanje) {
		
		System.out.println("\n\nNASTAVNICI---------------------------------");
		for (int i = 0; i < nastavnik_id.length; i++) {
			
			System.out.println("Nastavnik " + nastavnik_ime[i] + " " + nastavnik_prezime[i] + " sa id " 
					+ nastavnik_id[i] + " ima zvanje " + nastavnik_zvanje[i]);
		}
	}
	
	public static void ispisiSvePodatkePredmeta(int [] predmet_id, String [] predmet_naziv) {
		
		System.out.println("\n\nPREDMETI---------------------------------");
		for (int i = 0; i < predmet_id.length; i++) {
			
			System.out.println("Predmet " + predmet_naziv[i] + " sa id " + predmet_id[i]);
		}
	}
	
	public static void ispisiSvePodatkeStudenta(int [] student_id, String [] student_indeks,
			String [] student_prezime, String [] student_ime, String [] student_grad) {
		
		System.out.println("\n\nSTUDENTI---------------------------------");
		for (int i = 0; i < student_id.length; i++) {
			
			System.out.println("Student " + student_ime[i] + " " + student_prezime[i] + " sa id " 
					+ student_id[i] + " i indeksom " + student_indeks[i] + " dolazi iz grada " + student_grad[i]);
		}
	}
	
	public static void ispisiPodatkeNastavnika(int [] nastavnik_id, String [] nastavnik_ime,
			String [] nastavnik_prezime, String [] nastavnik_zvanje) {
		
		System.out.println("\n\nUNESI ID NASTAVNIKA:");
		int unetiID = 0;
		int brojac = 0;
		
		boolean nasao = false;
		while (nasao==false) {
			unetiID = (int)(Math.random()*10/Math.random()); //treba zameniti sa skenerom
			for (int i = 0; i < nastavnik_id.length; i++) {
				if(nastavnik_id[i]==unetiID){
					nasao = true;
					brojac=i;
					break;
				}
			}
		}
		
		System.out.println("Nastavnik " + nastavnik_ime[brojac] + " " + nastavnik_prezime[brojac] + " sa id " 
					+ nastavnik_id[brojac] + " ima zvanje " + nastavnik_zvanje[brojac]);
	}
	
	public static void ispisiPodatkePredmeta(int [] predmet_id, String [] predmet_naziv) {
		
		System.out.println("\n\nUNESI ID PREDMETA:");
		int unetiID = 0;
		int brojac = 0;
		
		boolean nasao = false;
		while (nasao==false) {
			unetiID = (int)(Math.random()*10/Math.random()); //treba zameniti sa skenerom
			for (int i = 0; i < predmet_id.length; i++) {
				if(predmet_id[i]==unetiID){
					nasao = true;
					brojac=i;
					break;
				}
			}
		}
			
		System.out.println("Predmet " + predmet_naziv[brojac] + " sa id " + predmet_id[brojac]);

	}
	
	public static void ispisiPodatkeStudenta(int [] student_id, String [] student_indeks,
			String [] student_prezime, String [] student_ime, String [] student_grad) {
		
		System.out.println("\n\nUNESI ID STUDENTA:");
		int unetiID = 0;
		int brojac = 0;
		
		boolean nasao = false;
		while (nasao==false) {
			unetiID = (int)(Math.random()*10/Math.random()); //treba zameniti sa skenerom
			for (int i = 0; i < student_id.length; i++) {
				if(student_id[i]==unetiID){
					nasao = true;
					brojac=i;
					break;
				}
			}
		}
		System.out.println("Student " + student_ime[brojac] + " " + student_prezime[brojac] + " sa id " 
					+ student_id[brojac] + " i indeksom " + student_indeks[brojac] + " dolazi iz grada " + student_grad[brojac]);
		
	}
	
	public static void ispisiSvePodatkeStudentaSaSmera(String smer, int [] student_id, String [] student_indeks,
			String [] student_prezime, String [] student_ime, String [] student_grad) {
		
		System.out.println("\n\nSTUDENTI SA SMERA "+smer+"---------------------------------");
		for (int i = 0; i < student_id.length; i++) {
			
			if(student_indeks[i].startsWith(smer))
			System.out.println("Student " + student_ime[i] + " " + student_prezime[i] + " sa id " 
					+ student_id[i] + " i indeksom " + student_indeks[i] + " dolazi iz grada " + student_grad[i]);
		}
	}
	
	public static void ispisStatistikeBrojaUpisanihStudenataPoGodinamaUpisa(String [] student_indeks) {
		
		//muka sa nizovima jer imaju fiksnu dužinu
		//problem je da neznamo koliko imamo različitih godina upisa, tako da ne možemo da definišemo unapred dužinu niza
		//moramo niz da "proširujemo"
		String [] godine = new String[1];
		int [] godineBrojac = new int[1];
		
		godine[0] = student_indeks[0].substring(student_indeks[0].length()-4, student_indeks[0].length());
		godineBrojac[0] = 1;
		
		for (int i = 1; i < student_indeks.length; i++) {
			String index = student_indeks[i];
			String god = index.substring(index.length()-4, index.length());
			
			boolean found = false;
			for (int j = 0; j < godine.length; j++) {
				if(godine[j].equals(god)){
					godineBrojac[j]+=1;
					found = true;
					break;
				}
			}
			
			if(!found){
				String [] godineNoviNiz = new String[godine.length+1];
				int [] godineBrojacNoviNiz = new int[godineBrojac.length+1];
				for (int j = 0; j < godine.length; j++) {
					godineNoviNiz[j]=godine[j];
					godineBrojacNoviNiz[j]=godineBrojac[j];
				}
				godineNoviNiz[godineNoviNiz.length-1] = god;
				godineBrojacNoviNiz[godineBrojacNoviNiz.length-1] = 1;
				
				godine = godineNoviNiz;
				godineBrojac = godineBrojacNoviNiz;
			}
			
		}
		

		System.out.println("\n\nSTATISTIKA---------------------------------");
		for (int i = 0; i < godine.length; i++) {
			System.out.printf("U %s je upisalo fakultet %d studenta\n",godine[i], godineBrojac[i]);
		}
	}
	
	public static void main(String[] args) {

		String textNastavnici 	= "1,Petar,Petrović,Docent\n2,Jovan,Jovanović,Docent\n3,Marko,Marković,Asistent\n4,Nikola,Nikolić,Redovni Profesor\n5,Lazar,Lazić,Asistent";
		String textPredmeti 	= "1,Matematika\n2,Fizika\n3,Elektrotehnika\n4,Informatika";
		String textStudenti 	= "1,E1 01/2011,Srđanov,Konstantin,Loznica\n2,E1 02/2012,Baki,Strahinja,Novi Sad\n3,E1 03/2013,Trajković,Nebojša,Inđija\n4,E2 01/2011,Sekulić,Miloš,Vršac\n5,E2 02/2012,Askin,Vuk,Novi Sad\n6,E2 03/2013,Klainić,Marko,Sombor\n7,E2 04/2011,Marko,Panić,Zrenjanin";
		
		String [] sviRedoviNastavnici = textNastavnici.split("\n");
		String [] sviRedoviPredmeti = textPredmeti.split("\n");
		String [] sviRedoviStudenti = textStudenti.split("\n");
		
		int [] nastavnik_id = new int [sviRedoviNastavnici.length];
		String [] nastavnik_ime = new String [sviRedoviNastavnici.length];
		String [] nastavnik_prezime = new String [sviRedoviNastavnici.length];
		String [] nastavnik_zvanje = new String [sviRedoviNastavnici.length];
		
		int [] predmet_id = new int [sviRedoviPredmeti.length];
		String [] predmet_naziv = new String [sviRedoviPredmeti.length];
		
		int [] student_id = new int [sviRedoviStudenti.length];
		String [] student_indeks = new String [sviRedoviStudenti.length];
		String [] student_prezime = new String [sviRedoviStudenti.length];
		String [] student_ime = new String [sviRedoviStudenti.length];
		String [] student_grad = new String [sviRedoviStudenti.length];
		
		//pod 1
		System.out.println("1. Učitaj podatke");
		ucitajPodatkeNastavnik(sviRedoviNastavnici, nastavnik_id, nastavnik_ime, nastavnik_prezime, nastavnik_zvanje);
		ucitajPodatkePredmet(sviRedoviPredmeti, predmet_id, predmet_naziv);
		ucitajPodatkeStudent(sviRedoviStudenti, student_id, student_indeks, student_prezime, student_ime, student_grad);
		
		//pod 2
		System.out.println("2. Ispiši sve podatke");
		ispisiSvePodatkeNastavnika(nastavnik_id, nastavnik_ime, nastavnik_prezime, nastavnik_zvanje);
		ispisiSvePodatkePredmeta(predmet_id, predmet_naziv);
		ispisiSvePodatkeStudenta(student_id, student_indeks, student_prezime, student_ime, student_grad);
		
		//pod 3
		System.out.println("3. Ispiši podatak u donosu na identifikator (predmet_id, nastavnik_id,...)");
		ispisiPodatkeNastavnika(nastavnik_id, nastavnik_ime, nastavnik_prezime, nastavnik_zvanje);
		ispisiPodatkePredmeta(predmet_id, predmet_naziv);
		ispisiPodatkeStudenta(student_id, student_indeks, student_prezime, student_ime, student_grad);
	
		//studenti sa smera E2
		System.out.println("Ispis svih studenta koji dolaze sa smera E2 (Računarstvo i Automatika)");
		ispisiSvePodatkeStudentaSaSmera("E2", student_id, student_indeks, student_prezime, student_ime, student_grad);
	
		//funkcija koja omogućuje ispis statistike broja upisanih studenata po godinama upisa
		System.out.println("Funkcija koja omogućuje ispis statistike broja upisanih studenata po godinama upisa");
		ispisStatistikeBrojaUpisanihStudenataPoGodinamaUpisa(student_indeks);
	}
}
