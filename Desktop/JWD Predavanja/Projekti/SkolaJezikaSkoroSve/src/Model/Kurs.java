package Model;

import java.util.ArrayList;

public class Kurs {
	
	private int id;
	private String naziv;
	private String tip;
	private double cena;
	private ArrayList<Ucenik> ucenici = new ArrayList<>();
	private Nastavnik nastavnik;
	public Kurs() {
		super();
	}
	
	public Kurs(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	

	

	public Kurs(String naziv, String tip, double cena) {
		super();
		this.naziv = naziv;
		this.tip = tip;
		this.cena = cena;
	}

	public Kurs(int id, String jezik, String tip, double cena, ArrayList<Ucenik> ucenici, Nastavnik nastavnik) {
		super();
		this.id = id;
		this.naziv = jezik;
		this.tip = tip;
		this.cena = cena;
		this.ucenici = ucenici;
		this.nastavnik = nastavnik;
	}
	public Kurs(int id, String jezik, String tip, double cena, Nastavnik nastavnik) {
		super();
		this.id = id;
		this.naziv = jezik;
		this.tip = tip;
		this.cena = cena;
		this.nastavnik = nastavnik;
	}
	public Kurs(int id, String jezik, String tip, double cena ) {
		super();
		this.id = id;
		this.naziv = jezik;
		this.tip = tip;
		this.cena = cena;
	
	}

	public Kurs(int id, String naziv, String tip) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tip = tip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
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
		Kurs other = (Kurs) obj;
		if (id != other.id)
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return naziv +" "+ tip  ;
	}
	public String toStringSaCenom() {
		return naziv +" "+ tip + " " + cena ;
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

	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public ArrayList<Ucenik> getUcenici() {
		return ucenici;
	}
	public void setUcenici(ArrayList<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	
	
	
}
	