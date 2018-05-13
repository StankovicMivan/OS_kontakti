package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoEksel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Rezultat implements Comparable<Rezultat> {

	private static final int IDX_INDEKS = 0;
	private static final int IDX_IME_I_PREZIME = 1;
	private static final int IDX_ZADACI = 2;
	private static final int IDX_TEORIJA = 3;
	private static final int IDX_UKUPNO = 4;
	private static final int IDX_OCENA = 5;

	private String index;
	private String imeIPrezime;
	private int brojBodovaTeorija;
	private int brojBodovaZadaci;
	
	private int ukupanBrojBodova;
	private int konacnaOcena;

	public Rezultat() {

	}

	public Rezultat(String index, String imeIPrezime, int brojBodovaTeorija,
			int brojBodovaZadaci) {
		super();
		this.index = index;
		this.imeIPrezime = imeIPrezime;
		this.brojBodovaTeorija = brojBodovaTeorija;
		this.brojBodovaZadaci = brojBodovaZadaci;
		izracunajOcenu();
	}

	public Rezultat(Row row) {
		Cell indeks = row.getCell(IDX_INDEKS);
		this.index = indeks.getStringCellValue();

		Cell imeIPrezime = row.getCell(IDX_IME_I_PREZIME);
		this.imeIPrezime = imeIPrezime.getStringCellValue();

		Cell predispitneObaveze = row.getCell(IDX_ZADACI);
		this.brojBodovaZadaci = (int) predispitneObaveze.getNumericCellValue();

		Cell zavrsniIspit = row.getCell(IDX_TEORIJA);
		this.brojBodovaTeorija = (int) zavrsniIspit.getNumericCellValue();

		Cell ukupno = row.getCell(IDX_UKUPNO);
		this.ukupanBrojBodova = (int) ukupno.getNumericCellValue();

		Cell ocena = row.getCell(IDX_OCENA);
		try {
			this.konacnaOcena = (int) ocena.getNumericCellValue();
		} catch (Exception ex) {
			this.konacnaOcena = 0;
		}
	}

	public void toExcelRow(Row row) {
		row.getCell(IDX_INDEKS).setCellValue(index);
		row.getCell(IDX_IME_I_PREZIME).setCellValue(imeIPrezime);
		row.getCell(IDX_ZADACI).setCellValue(brojBodovaZadaci);
		row.getCell(IDX_TEORIJA).setCellValue(brojBodovaTeorija);
		row.getCell(IDX_UKUPNO).setCellFormula("C" + (row.getRowNum()+1) + "+D"+ (row.getRowNum()+1));
		//ocenu samo vrednost
		row.getCell(IDX_OCENA).setCellValue(konacnaOcena);
		//fali formula za ocenu umesto vrednosti
	}
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public int getBrojBodovaTeorija() {
		return brojBodovaTeorija;
	}

	public void setBrojBodovaTeorija(int brojBodovaTeorija) {
		this.brojBodovaTeorija = brojBodovaTeorija;
		izracunajOcenu();
	}

	public int getBrojBodovaZadaci() {
		return brojBodovaZadaci;
	}

	public void setBrojBodovaZadaci(int brojBodovaZadaci) {
		this.brojBodovaZadaci = brojBodovaZadaci;
		izracunajOcenu();
	}

	public int getUkupanBrojBodova() {
		return ukupanBrojBodova;
	}

	public void setUkupanBrojBodova(int ukupanBrojBodova) {
		this.ukupanBrojBodova = ukupanBrojBodova;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public int getUkupnoBodova() {
		return brojBodovaTeorija + brojBodovaZadaci;
	}

	public int izracunajOcenu() {
		ukupanBrojBodova = brojBodovaTeorija + brojBodovaZadaci;
		int ocena;
		if (ukupanBrojBodova >= 95)
			ocena = 10;
		else if (ukupanBrojBodova >= 85)
			ocena = 9;
		else if (ukupanBrojBodova >= 75)
			ocena = 8;
		else if (ukupanBrojBodova >= 65)
			ocena = 7;
		else if (ukupanBrojBodova >= 55)
			ocena = 6;
		else
			ocena = 5;
		konacnaOcena=ocena;
		return ocena;
	}

	@Override
	public String toString() {
		return "Student sa indeksom:" + index + " cije je ime " + imeIPrezime
				+ " ostvario je sledeci rezultat - teorija: "
				+ brojBodovaTeorija + ", zadaci:  " + brojBodovaZadaci
				+ ", ukupno: " + ukupanBrojBodova + ", ocena: " + konacnaOcena;
	}

	// metoda odgovara da li su dva objekta Rezultat ista (isti su ako imaju
	// isti index studenta ciji je to rezultat),
	// ali moze i Rezultat da se poredi sa String-om koji je broj indeksa
	@Override
	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof Rezultat) {
			Rezultat objRezultat = (Rezultat) obj;
			if (this.index.equals(objRezultat.index))
				return true;
		}
		// poredjenje Rezultata i Stringa koji je broj indeksa
		if (obj instanceof String) {
			if (this.index.equals(obj))
				return true;
		}
		return isti;
	}

	// ovo ce nam omoguciti da sortiramo rezultate po ukupnim bodovima
	@Override
	public int compareTo(Rezultat anotherRez) {
		//ako je objekat u zagradi null onda je this veci od njega
		if(anotherRez == null)
			return 1;

		int retVal = 0;
		if(ukupanBrojBodova> anotherRez.ukupanBrojBodova)
			retVal = 1;
		else if(ukupanBrojBodova> anotherRez.ukupanBrojBodova)
			retVal = -1;
		
		return retVal * (-1); //-1 za opadajuce
	}
}
