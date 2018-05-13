package com.ftninformatika.vezbe04.primerDodatnoSerijalizacija;

import java.io.Serializable;
import java.util.Comparator;

public class Osoba implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime;
	private String prezime;
	private double plata;
	
	public Osoba() {
		
	}
	public Osoba(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}
	
	
	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
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
	
	@Override
	public String toString() {
		return this.ime + "|" + prezime;
	}
	
}
