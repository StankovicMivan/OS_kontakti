package com.elektro.distribucija;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Elektrodistribucija {

	private String naziv;
	private String adresa;
	private String telefon;
	private ArrayList<Racun> listaRacuna;
	public Elektrodistribucija() {

	}
	public Elektrodistribucija(String naziv, String adresa, String telefon, ArrayList<Racun> listaRacuna) {

		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.listaRacuna = listaRacuna;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public ArrayList<Racun> getListaRacuna() {
		return listaRacuna;
	}
	public void setListaRacuna(ArrayList<Racun> listaRacuna) {
		this.listaRacuna = listaRacuna;
	}
	@Override
	public String toString() {
		return "Elektrodistribucija [naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon + ", listaRacuna="
				+ listaRacuna + "]";
	}
	public void load(String path) {

		this.listaRacuna = new ArrayList<Racun>();

		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());

			for (String line: lines) {
				String[] attributes = line.split(";");

				int id = Integer.parseInt(attributes[0]); 
				String vlasnik = attributes[1];
				int nizaPotrosnja = Integer.parseInt(attributes[2]);
				int visaPotrosnja = Integer.parseInt(attributes[3]);
				double ukupanRacun = Double.parseDouble(attributes[4]); 
				int mesecRacuna = Integer.parseInt(attributes[5]);
				String datum = attributes[6];
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				LocalDate datumZaCuvanje = LocalDate.parse(datum, dtf);

				Racun racuni = new Racun ( id, vlasnik, nizaPotrosnja, visaPotrosnja, ukupanRacun, mesecRacuna, datumZaCuvanje);
				this.listaRacuna.add(racuni);

			}
		} catch (java.io.IOException e) {
			System.out.println("Datoteka " + path + " nije pronađena.");
		} catch (Exception e) {
			System.out.println("Desila se greška pri parsiranju datuma.");
		}
	}
	public void save(String path) {
		
		ArrayList<String> lines = new ArrayList<String>();

		for (int i = 0; i < this.listaRacuna.size(); i++) {
			Racun racuni = this.listaRacuna.get(i); //o�?itavamo objekat tipa Inventar
			int id = racuni.getId(); 
			String vlasnik = racuni.getVlasnik();
			int nizaPotrosnja = racuni.getNizaPotrosnja();
			int visaPotrosnja = racuni.getVisaPotrosnja();
			double ukupanRacun = racuni.getUkupanRacun(); 
			int mesecRacuna = racuni.getMesecRacuna();
			LocalDate datum = racuni.getDatumPlacanja();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
			String datumUplate = dtf.format(datum);
			String line = id  + ";" + vlasnik + ";" + nizaPotrosnja + ";" + visaPotrosnja + ";" + ukupanRacun + ";" + mesecRacuna + ";" + datumUplate;
			lines.add(line);
		}

		try {
			Files.write(Paths.get(path), lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (java.io.IOException e) {
			System.out.println("Datoteka " + path + " nije pronađena.");
		}
	}
	public void unosNovogRacuna(int id, String vlasnik, int nizaPotrosnja, int visaPotrosnja, int mesecRacuna,
			LocalDate datumPlacanja) {
		
		Racun noviRacun = new Racun(id, vlasnik, nizaPotrosnja, visaPotrosnja, mesecRacuna, datumPlacanja);
		listaRacuna.add(noviRacun);
	}
	public void ispisRacuna() {
		
		for (int i = 0; i < listaRacuna.size(); i++) {
			Racun ispis = listaRacuna.get(i);
			System.out.println(ispis);
		}
	}
	
	
}
