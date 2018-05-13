package menjacnica.model;

public class Valuta {

	private int id;
	private String oznaka;
	private String naziv;

	public Valuta(int id, String oznaka, String naziv) {
		this.id = id;
		this.oznaka = oznaka;
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Valuta [id=" + id + ", oznaka=" + oznaka + ", naziv=" + naziv + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valuta other = (Valuta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

}
