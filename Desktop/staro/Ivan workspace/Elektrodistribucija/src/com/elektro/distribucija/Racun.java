package com.elektro.distribucija;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Racun {
	
	private int id;
	private String vlasnik;
	private int nizaPotrosnja;
	private int visaPotrosnja;
	private double ukupanRacun;
	private int mesecRacuna;
	private LocalDate datumPlacanja;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	
	public DateTimeFormatter getDtf() {
		return dtf;
	}

	public void setDtf(DateTimeFormatter dtf) {
		this.dtf = dtf;
	}
	

	public Racun() {
		
	}
	
	
	public Racun(int id, String vlasnik, int nizaPotrosnja, int visaPotrosnja, int mesecRacuna,
			LocalDate datumPlacanja) {

		this.id = id;
		this.vlasnik = vlasnik;
		this.nizaPotrosnja = nizaPotrosnja;
		this.visaPotrosnja = visaPotrosnja;
		this.mesecRacuna = mesecRacuna;
		this.datumPlacanja = datumPlacanja;
	}
	

	public Racun(int id, String vlasnik, int nizaPotrosnja, int visaPotrosnja, double ukupanRacun, int mesecRacuna,
			LocalDate datumPlacanja) {

		this.id = id;
		this.vlasnik = vlasnik;
		this.nizaPotrosnja = nizaPotrosnja;
		this.visaPotrosnja = visaPotrosnja;
		this.ukupanRacun = ukupanRacun;
		this.mesecRacuna = mesecRacuna;
		this.datumPlacanja = datumPlacanja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(String vlasnik) {
		this.vlasnik = vlasnik;
	}

	public int getNizaPotrosnja() {
		return nizaPotrosnja;
	}

	public void setNizaPotrosnja(int nizaPotrosnja) {
		this.nizaPotrosnja = nizaPotrosnja;
	}

	public int getVisaPotrosnja() {
		return visaPotrosnja;
	}

	public void setVisaPotrosnja(int visaPotrosnja) {
		this.visaPotrosnja = visaPotrosnja;
	}

	public double getUkupanRacun() {
		return ukupanRacun;
	}

	public void setUkupanRacun(double ukupanRacun) {
		this.ukupanRacun = ukupanRacun;
	}

	public int getMesecRacuna() {
		return mesecRacuna;
	}

	public void setMesecRacuna(int mesecRacuna) {
		this.mesecRacuna = mesecRacuna;
	}

	public LocalDate getDatumPlacanja() {
		return datumPlacanja;
	}

	public void setDatumPlacanja(LocalDate datumPlacanja) {
		this.datumPlacanja = datumPlacanja;
	}

	@Override
	public String toString() {
		return "Racun [id=" + id + ", vlasnik=" + vlasnik + ", nizaPotrosnja=" + nizaPotrosnja + ", visaPotrosnja="
				+ visaPotrosnja + ", ukupanRacun=" + ukupanRacun + ", mesecRacuna=" + mesecRacuna + ", datumPlacanja="
				+ datumPlacanja + "]";
	}
	
	

}

