package com.TelefonskiImenik;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Kontakt {

	private int identifikator;
	private String ime;
	private String prezime;
	private String nazRadMesta;
	private String brojProstorije;
	private int brojLokala;
	private LocalDate datumUnosaKontakta;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public Kontakt() {
		super();
	}

	public Kontakt(int identifikator, String ime, String prezime, String nazRadMesta, String brojProstorije,
			int brojLokala, LocalDate datumUnosaKontakta) {
		super();
		this.identifikator = identifikator;
		this.ime = ime;
		this.prezime = prezime;
		this.nazRadMesta = nazRadMesta;
		this.brojProstorije = brojProstorije;
		this.brojLokala = brojLokala;
		this.datumUnosaKontakta = datumUnosaKontakta;
	}

	public int getIdentifikator() {
		return identifikator;
	}

	public void setIdentifikator(int identifikator) {
		this.identifikator = identifikator;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getNazRadMesta() {
		return nazRadMesta;
	}

	public void setNazRadMesta(String nazRadMesta) {
		this.nazRadMesta = nazRadMesta;
	}

	public String getBrojProstorije() {
		return brojProstorije;
	}

	public void setBrojProstorije(String brojProstorije) {
		this.brojProstorije = brojProstorije;
	}

	public int getBrojLokala() {
		return brojLokala;
	}

	public void setBrojLokala(int brojLokala) {
		this.brojLokala = brojLokala;
	}

	public LocalDate getDatumUnosaKontakta() {
		return datumUnosaKontakta;
	}

	public void setDatumUnosaKontakta(LocalDate datumUnosaKontakta) {
		this.datumUnosaKontakta = datumUnosaKontakta;
	}

	@Override
	public String toString() {
		return String.format( "|%14d | %10s | %10s | %16s | %25s | %12s| %17s|",this.getIdentifikator(), this.getIme(),this.getPrezime(), this.getNazRadMesta(),this.brojProstorije, this.getBrojLokala(), dtf.format(this.getDatumUnosaKontakta()));
	
	}
	
	
	
	


}
