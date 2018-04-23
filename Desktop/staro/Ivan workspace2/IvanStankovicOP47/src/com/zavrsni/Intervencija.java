package com.zavrsni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Intervencija {

	private int identifikator;
	private String imePacijenta;
	private String prezimePacijenta;
	private String imeLekara;
	private String prezimeLekara;
	private String tipIntervencije;
	private String opisIntervencije;
	private LocalDate datum;
	private double cena;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");


	public Intervencija() {

	}

	public Intervencija(int identifikator, String imePacijenta, String prezimePacijenta, String imeLekara,
			String prezimeLekara, String tipIntervencije, String opisIntervencije, LocalDate datum, double cena) {

		this.identifikator = identifikator;
		this.imePacijenta = imePacijenta;
		this.prezimePacijenta = prezimePacijenta;
		this.imeLekara = imeLekara;
		this.prezimeLekara = prezimeLekara;
		this.tipIntervencije = tipIntervencije;
		this.opisIntervencije = opisIntervencije;
		this.datum = datum;
		this.cena = cena;
	}

	public int getIdentifikator() {
		return identifikator;
	}

	public void setIdentifikator(int identifikator) {
		this.identifikator = identifikator;
	}

	public String getImePacijenta() {
		return imePacijenta;
	}

	public void setImePacijenta(String imePacijenta) {
		this.imePacijenta = imePacijenta;
	}

	public String getPrezimePacijenta() {
		return prezimePacijenta;
	}

	public void setPrezimePacijenta(String prezimePacijenta) {
		this.prezimePacijenta = prezimePacijenta;
	}

	public String getImeLekara() {
		return imeLekara;
	}

	public void setImeLekara(String imeLekara) {
		this.imeLekara = imeLekara;
	}

	public String getPrezimeLekara() {
		return prezimeLekara;
	}

	public void setPrezimeLekara(String prezimeLekara) {
		this.prezimeLekara = prezimeLekara;
	}

	public String getTipIntervencije() {
		return tipIntervencije;
	}

	public void setTipIntervencije(String tipIntervencije) {
		this.tipIntervencije = tipIntervencije;
	}

	public String getOpisIntervencije() {
		return opisIntervencije;
	}

	public void setOpisIntervencije(String opisIntervencije) {
		this.opisIntervencije = opisIntervencije;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return String.format( "|%14d | %19s | %14s | %14s | %12s| %17s| %16s | %15s | %15s |",this.getIdentifikator(), this.getImePacijenta(), this.getPrezimePacijenta(), this.getImeLekara(), this.getPrezimeLekara(), this.getTipIntervencije(),this.getOpisIntervencije(), dtf.format(this.getDatum()), this.getCena());


	}



}
