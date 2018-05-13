package menjacnica.model;

public class VrednostValute {

	private Valuta valuta;
	private KursnaLista kursnaLista;

	private double kupovniKurs;
	private double prodajniKurs;

	public VrednostValute(Valuta valuta, KursnaLista kursnaLista, double kupovniKurs, double prodajniKurs) {
		this.valuta = valuta;
		this.kursnaLista = kursnaLista;
		this.kupovniKurs = kupovniKurs;
		this.prodajniKurs = prodajniKurs;
	}

	@Override
	public String toString() {
		return "VrednostValute [valuta=" + valuta + ", kupovniKurs=" + kupovniKurs
				+ ", srednjiKurs=" + getSrednjiKurs() + ", prodajniKurs=" + prodajniKurs + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VrednostValute other = (VrednostValute) obj;
		if (!(valuta.equals(other.valuta) && kursnaLista.equals(other.kursnaLista)))
			return false;
		return true;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}

	public double getKupovniKurs() {
		return kupovniKurs;
	}

	public double getSrednjiKurs() {
		return (kupovniKurs + prodajniKurs) / 2.0;
	}
	
	public double getProdajniKurs() {
		return prodajniKurs;
	}

}
