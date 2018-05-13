package Model;

import java.util.ArrayList;

public class Nastavnik {
	
	private int id;
	private String ime;
	private String prezime;
	private ArrayList<Kurs> kursevi = new ArrayList<>();
	public Nastavnik() {
		super();
	}
	public Nastavnik(int id, String ime, String prezime, ArrayList<Kurs> kursevi) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.kursevi = kursevi;
	}
	public Nastavnik( String ime, String prezime) {
		super();
	
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public Nastavnik(int id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}
	@Override
	public String toString() {
		return  ime + " " + prezime ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ArrayList<Kurs> getKursevi() {
		return kursevi;
	}
	public void setKursevi(ArrayList<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nastavnik other = (Nastavnik) obj;
		if (id != other.id)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	

}
