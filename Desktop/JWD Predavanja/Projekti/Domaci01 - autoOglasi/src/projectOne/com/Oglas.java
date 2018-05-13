package projectOne.com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Oglas {
	
	private int sifraOglasa;
	private String naslovOglasa;
	private Double cena;
	private int godinaProizvodnje;
	private ArrayList<String> oprema;
	String []oprema1 = {"ABS", "ESP", "Alarm","Airbag","Klima","Servo volan", "Putni racunar", "Tempomat" };
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	
	//konstruktori
	
	public Oglas() {
		super();
		this.oprema = new ArrayList<>();
	}

	public Oglas(int sifraOglasa, String naslovOglasa, Double cena, int godinaProizvodnje,
			ArrayList<String> oprema) {
		super();
		this.sifraOglasa = sifraOglasa ;
		this.naslovOglasa = naslovOglasa;
		this.cena = cena;
		this.godinaProizvodnje = godinaProizvodnje;
		this.oprema = oprema;
	}



	
	public Oglas( String naslovOglasa, Double cena, int godinaProizvodnje,
			ArrayList<String> oprema) {
		super();
		
		this.naslovOglasa = naslovOglasa;
		this.cena = cena;
		this.godinaProizvodnje = godinaProizvodnje;
		this.oprema = oprema;
	}



	
	//geteri i seteri 
	
	public int getSifraOglasa() {
		return sifraOglasa;
	}



	public void setSifraOglasa(int sifraOglasa) {
		this.sifraOglasa = sifraOglasa;
	}



	public String getNaslovOglasa() {
		return naslovOglasa;
	}



	public void setNaslovOglasa(String naslovOglasa) {
		this.naslovOglasa = naslovOglasa;
	}



	public Double getCena() {
		return cena;
	}



	public void setCena(Double cena) {
		this.cena = cena;
	}



	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}



	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}



	public ArrayList<String> getOprema() {
		return oprema;
	}



	public void setOprema(ArrayList<String> oprema) {
		this.oprema = oprema;
	}

	@Override
	
	public String toString() {
		String temp = "Sifra oglasa: " + sifraOglasa + ".\n";
		temp += "Naslov Oglasa: " + naslovOglasa + ".\n";
		temp += "Cena Oglasa: " + cena + ".\n";
		temp += "Godina Proizvodnje: " + godinaProizvodnje + ".\n";
		temp += "Oprema vozila: \n";
		for(int i =0; i<oprema.size();i++) {
			temp += oprema1[i] + ": " + oprema.get(i) + "\n";
		}
		return temp;
		
	//	return "Oglas [sifraOglasa=" + sifraOglasa + ", naslovOglasa=" + naslovOglasa + ", cena=" + cena
	//			+ ", godinaProizvodnje=" + godinaProizvodnje + ", oprema=" + oprema + "]";
	}
	
	
}
