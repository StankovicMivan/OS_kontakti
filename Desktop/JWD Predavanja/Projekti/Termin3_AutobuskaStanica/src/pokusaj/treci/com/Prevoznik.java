package pokusaj.treci.com;

import java.util.ArrayList;

public class Prevoznik {

	private int id;
	private String naziv;
	private String sediste;
	private ArrayList<Autobus> autobusi;
	
	public Prevoznik() {
		super();
		this.autobusi = new ArrayList<>();
	}

	public Prevoznik(int id, String naziv, String sediste) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.sediste = sediste;
		this.autobusi = new ArrayList<>();
	}

	public Prevoznik(int id, String naziv, String sediste, ArrayList<Autobus> autobusi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.sediste = sediste;
		this.autobusi = autobusi;
	}

	
	@Override
	public String toString() {
		return "Prevoznik [id=" + id + ", naziv=" + naziv + ", sediste=" + sediste + ", autobusi=" + autobusi + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

	public ArrayList<Autobus> getAutobusi() {
		return autobusi;
	}

	public void setAutobusi(ArrayList<Autobus> autobusi) {
		this.autobusi = autobusi;
	}
	
	
	
	
}
