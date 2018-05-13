package racunMegamarketMetro;

/*
 * Proširiti zadatak sa èasa tako da postoji i informacija o tome u èemu je izražena kolièina (kilogramima, litrima, komadima).
Neki artikli mogu biti na akciji od 10%. 
Neki proizvodi imaju 10%, a neki 20% pdv-a, a neki su osloboðeni pdv-a.
Prilikom obraèuna ukupne cene (bez pdv-a i sa pdv-om) voditi raèuna o akcijama i razlièitim stopama pdv-a.
 */
public class Racun {
	public static void main(String[] args) {
		String nazivi[] = { "Hleb", "Mleko", "Brasno", "Jaja" };
		int kolicina[] = { 2, 3, 5, 10 };
		double cena[] = { 50, 88.99, 50, 116 };
		String jedinicaMere []={"Kg", "litar","Kg", "Pakovanje"};
		boolean akcija []={false,false, true, true};
		int stopaPDV []={0,10,20,20};
		System.out.println("Naziv prodavnice je: " + args[0]);
		System.out.println("===========================================================================");
		System.out.printf("%4s  %-10s  %8s  %-10s  %10s  %-10s  %4s  %10s\n", "Rbr.", "Naziv", "Kolicina","Jed. mere", "Cena", "Akcija", "PDV", "sa PDV");
		System.out.printf("%4s  %-10s  %8s  %-10s  %10s  %-10s  %4s  %10s\n", "====", "=====", "========", "=========","====", "======", "===", "======");
		double ukupnaCena=0, ukupnaCenaSaPDV=0;
		double stavka=0, stvakaPDV=0;
		for (int i = 0; i < nazivi.length; i++) {
			stavka=kolicina[i] * cena[i]*(100-(akcija[i]?10:0))/100.0;
			stvakaPDV = stavka*(1+stopaPDV[i]/100.0);
			
			System.out.printf("%3d.  %-10s  %8d  %-10s  %10.2f  %-10s  %4s  %10.2f\n", i + 1, nazivi[i], kolicina[i], 
					jedinicaMere[i], cena[i], (akcija[i]?"akcija 10%":""), stopaPDV[i]+"%" , stvakaPDV);
			
			ukupnaCena += stavka;
			ukupnaCenaSaPDV += stvakaPDV;
		}
		System.out.println("===================================================");
		System.out.printf("Ukupna cene bez PDV:             %17.2f\n", ukupnaCena);
		System.out.printf("Cena sa PDV:                     %17.2f\n", ukupnaCenaSaPDV);
		System.out.println("===================================================");

	}
}
