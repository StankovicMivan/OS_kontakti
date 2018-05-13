package rs.ac.uns.ftn.informatika.dosk.java.vezbe08.primer02.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

	protected int id;
	protected String ime;
	protected String prezime;
	protected String indeks;
	protected String grad;

	protected List<Predmet> predmeti = new ArrayList<Predmet>();

	public Student(int id, String indeks, String ime, String prezime, String grad) {
		this.id = id;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.grad = grad;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + ", grad=" + grad
				+ ", predmeti=" + predmeti + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Predmet)) return false;

		Student that = (Student) obj;
		return that.id == this.id;
	}
	
	public int getId() {
		return id;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String index) {
		this.indeks = index;
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

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	
}
