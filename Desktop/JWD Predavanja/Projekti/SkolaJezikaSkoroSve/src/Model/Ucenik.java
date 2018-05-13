package Model;

public class Ucenik {

	private int id;
	private String ime;
	private String prezime;
	private Kurs kurs;
	public Ucenik() {
		super();
	}
	
	public Ucenik(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public Ucenik(int id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		
	}
	public Ucenik(int id, String ime, String prezime, Kurs kurs) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.kurs = kurs;
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
	public Kurs getKurs() {
		return kurs;
	}
	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}
	@Override
	public String toString() {
		return  ime + " " + prezime ;
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
		Ucenik other = (Ucenik) obj;
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
