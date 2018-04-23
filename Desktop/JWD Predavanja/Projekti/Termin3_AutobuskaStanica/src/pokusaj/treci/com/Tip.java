package pokusaj.treci.com;

import java.util.ArrayList;

public class Tip {

	private String sifra;
	private String naziv;
	
	
	
	public Tip() {
		super();
	}



	public Tip(String sifra, String naziv) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
	}



	@Override
	public String toString() {
		return "Tip [sifra=" + sifra + ", naziv=" + naziv + "]";
	}



	public String getSifra() {
		return sifra;
	}



	public void setSifra(String sifra) {
		this.sifra = sifra;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
