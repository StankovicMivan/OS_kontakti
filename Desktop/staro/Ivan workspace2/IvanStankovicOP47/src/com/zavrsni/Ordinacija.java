package com.zavrsni;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ordinacija {

	private String naziv;
	private String adresa;
	private String pib;
	private ArrayList<Intervencija> listaInterverncija;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");


	public Ordinacija() {
		listaInterverncija = new ArrayList<>();
	}
	public Ordinacija(String naziv, String adresa, String pib, ArrayList<Intervencija> listaInterverncija) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.pib = pib;
		this.listaInterverncija = listaInterverncija;
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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public ArrayList<Intervencija> getListaInterverncija() {
		return listaInterverncija;
	}

	public void setListaInterverncija(ArrayList<Intervencija> listaInterverncija) {
		this.listaInterverncija = listaInterverncija;
	}


	public String toString() {


		String temp = "";
		temp += "Naziv ordinacije: " + this.naziv + ".\n";
		temp += "Adresa ordinacije: " + this.adresa + ".\n";
		temp += "PIB" + this.pib + ".\n";
		temp += "Ukupan broj intervencija: " + this.getListaInterverncija().size() + ".\n";
		temp += "Ukupan broj lekara koji rade u ordinaciji: "  + 0 + ".\n";
		temp += "Ukupan prihod ordinacije:" + this.ukupanPrihod() + ".\n";


		return temp;
	}


	public double ukupanPrihod() {
		double prihod = 0.0;
		for(int i =0; i< this.getListaInterverncija().size(); i++) {
			prihod += this.getListaInterverncija().get(i).getCena();
		}
		return prihod;
	}
	
	public void save(String path) {

		ArrayList<String> lines = new ArrayList<String>();
		String line= "";
		lines.add(this.getNaziv());
		lines.add(this.getAdresa());
		lines.add(this.getPib());

		for (int i = 0; i < listaInterverncija.size(); i++) {
			Intervencija intervencija;
			intervencija = listaInterverncija.get(i);
			line = intervencija.getIdentifikator() + ";" + intervencija.getImePacijenta()+ ";" + intervencija.getPrezimePacijenta() + ";" + intervencija.getImeLekara() + ";" + intervencija.getPrezimeLekara() + ";" + intervencija.getTipIntervencije() + ";" + intervencija.getOpisIntervencije() + ";" + dtf.format(intervencija.getDatum()) + ";" + intervencija.getCena() ;

			lines.add(line);
		}
		try {
			Files.write(Paths.get(path), lines, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
		} catch (IOException e) {
			System.out.println("File " + path + " not found.");
		}

	}
	//load
	public void load(String path) {

		List<String> lines = new ArrayList<>();
		listaInterverncija.clear();

		try {
			lines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());

			this.setNaziv(lines.get(0));
			this.setAdresa(lines.get(1));
			this.setPib(lines.get(2));

			for(int i=3;i<lines.size();i++) {
				String line= lines.get(i);
				String[] part = line.split(";");

				int id =Integer.parseInt(part[0]);
				String imePacijenta = part[1];
				String prezimePacijenta = part[2];
				String imeLekara = part[3];
				String prezimeLekara = part[4];
				String tip = part[5];
				String opis = part[6];
				LocalDate datum= null;
				try {
					datum = LocalDate.parse(part[7],dtf);
				} catch (Exception e) {
					e.printStackTrace();
				}

				double cena =Double.parseDouble(part[8]);


				Intervencija novaIntervencija = new Intervencija(id, imePacijenta,prezimePacijenta,imeLekara,prezimeLekara,tip,opis,datum,cena);
				this.listaInterverncija.add(novaIntervencija);
			}
		} catch (java.io.IOException e) {
			System.out.println("Datoteka " + path + " nije pronadjena.");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void unosNoveIntervencije(Intervencija novaIntervencija) {

		this.listaInterverncija.add(novaIntervencija);

	}
	public void izmenaIntervencije(Intervencija novaIntervencija) {

		for(int i = 0 ; i < this.getListaInterverncija().size();i++) {
			if(novaIntervencija.getIdentifikator() == this.getListaInterverncija().get(i).getIdentifikator()) {
				this.listaInterverncija.set(i, novaIntervencija);
				break;
			}
		}

	}
	public void brisanje(int id) {

		for(int i = 0 ; i< this.listaInterverncija.size();i++) {
			if(id == this.getListaInterverncija().get(i).getIdentifikator()) {
				this.listaInterverncija.remove(i);
				break;
			}
		}
	}
	public void ispis6(String imePacijenta, String prezimePacijenta) {
		zaglavlje();
		for(int i = 0 ; i< this.getListaInterverncija().size(); i++) {
			if(imePacijenta.equalsIgnoreCase(this.getListaInterverncija().get(i).getImePacijenta()) && prezimePacijenta.equalsIgnoreCase(this.getListaInterverncija().get(i).getPrezimePacijenta())) {
				System.out.println(this.getListaInterverncija().get(i));
			}
		}

	}


	public static void zaglavlje() {
		System.out.println("_________________________________________________________________________________________________________________________________________________________________");
		System.out.println(String.format( "|%14s | %19s | %14s | %14s | %11s | %17s| %16s | %15s | %15s |","Identifikator", "I pacijenta", "P pacijenta","I lekara" , "P Lekara" , "Tip " ,"Opis ","Datum", "Cena"));
		System.out.println("_________________________________________________________________________________________________________________________________________________________________");
	}
	public void ispis7(String tipIntervencije, LocalDate donjaGranica, LocalDate gornjaGranica) {
		ArrayList<Intervencija> temp = new ArrayList<>();

		for(int i = 0; i < this.getListaInterverncija().size(); i++) {
			if(tipIntervencije.equals(this.getListaInterverncija().get(i).getTipIntervencije()) && this.getListaInterverncija().get(i).getDatum().compareTo(donjaGranica) >= 0 &&	
					this.getListaInterverncija().get(i).getDatum().compareTo(gornjaGranica) <= 0) {
				temp.add(this.getListaInterverncija().get(i));
			}
		}
		zaglavlje();
		for(int i =0; i < temp.size();i++) {
			System.out.println(temp.get(i));
		}

	}
	public void pretraga8(String imeLekara, String prezimeLekara) {
		ArrayList<Intervencija> lekar = new ArrayList<>();
		for(int i =0 ; i< this.getListaInterverncija().size();i++ ) {
			if(imeLekara.equalsIgnoreCase(this.getListaInterverncija().get(i).getImeLekara()) && prezimeLekara.equalsIgnoreCase(this.getListaInterverncija().get(i).getPrezimeLekara())) {
				lekar.add(this.getListaInterverncija().get(i));
			}
		}

		int procena1 = lekar.size();
		int procena2 = this.getListaInterverncija().size();
		double procenat = (double)(100/procena2) * procena1;

		System.out.printf("Procenta koje je primio zadati lekar iznosi %.0f od ukupnog broja pacijenata.",procenat);
		System.out.println();
	}
	public void pretraga9(String tipIntervencije, LocalDate donjaGranica, LocalDate gornjaGranica) {
		ArrayList<Intervencija> temp = new ArrayList<>();

		for(int i = 0; i < this.getListaInterverncija().size(); i++) {
			if(tipIntervencije.equals(this.getListaInterverncija().get(i).getTipIntervencije()) && this.getListaInterverncija().get(i).getDatum().compareTo(donjaGranica) >= 0 &&	
					this.getListaInterverncija().get(i).getDatum().compareTo(gornjaGranica) <= 0) {
				temp.add(this.getListaInterverncija().get(i));
			}
		}


		try {
			Intervencija najskuplja = temp.get(0);
			for(int i =1; i < temp.size();i++) {
				if(najskuplja.getCena() < temp.get(i).getCena()) {
					najskuplja = temp.get(i);
				}
			}
			System.out.printf("Najskuplja intervencija za zadati period [ %s - %s ] iznosi %.0f", dtf.format(donjaGranica), dtf.format(gornjaGranica), najskuplja.getCena());
			System.out.println();
			System.out.println();
			zaglavlje();
			System.out.println(najskuplja);
			System.out.println();
		} catch (Exception e) {

		}

	}




}
