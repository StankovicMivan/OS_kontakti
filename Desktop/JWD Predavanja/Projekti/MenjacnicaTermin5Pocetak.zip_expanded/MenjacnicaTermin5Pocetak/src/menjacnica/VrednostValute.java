package menjacnica;

public class VrednostValute {

	Valuta valuta;
	KursnaLista kl;
	double kupovniKurs;
	double prodajniKurs;
	
	public VrednostValute(Valuta valuta, KursnaLista kl, double kupovniKurs, double prodajniKurs) {
		super();
		this.valuta = valuta;
		this.kl = kl;
		this.kupovniKurs = kupovniKurs;
		this.prodajniKurs = prodajniKurs;
	}

	public VrednostValute(String tekst){
		String [] tokeni = tekst.split(",");

		//izgled fajla
		//1,eur,123,123.5

		if(tokeni.length!=4){
			System.out.println("Greska pri ocitavanju vrednost valute "+tekst);
			//izlazak iz aplikacije
			System.exit(0);
		}
		
		kl = Meni.pronadjiKursnuListu(Long.parseLong(tokeni[0]));
		valuta = Meni.pronadjiValutu(tokeni[1]);
		kupovniKurs = Double.parseDouble(tokeni[2]);
		prodajniKurs = Double.parseDouble(tokeni[3]);
		
		kl.getVrednostValute().add(this);

	}

	public String toFileRepresentation(){

		StringBuilder bild = new StringBuilder(); 
		bild.append(kl.id +","+ valuta.oznakaValute +","+kupovniKurs+","+prodajniKurs );
		return bild.toString();
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
		if (kl == null) {
			if (other.kl != null)
				return false;
		} else if (!kl.equals(other.kl))
			return false;
		if (Double.doubleToLongBits(kupovniKurs) != Double.doubleToLongBits(other.kupovniKurs))
			return false;
		return true;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public KursnaLista getKl() {
		return kl;
	}

	public void setKl(KursnaLista kl) {
		this.kl = kl;
	}

	public double getKupovniKurs() {
		return kupovniKurs;
	}

	public void setKupovniKurs(double kupovniKurs) {
		this.kupovniKurs = kupovniKurs;
	}

	public double getProdajniKurs() {
		return prodajniKurs;
	}

	public void setProdajniKurs(double prodajniKurs) {
		this.prodajniKurs = prodajniKurs;
	}

	public double getSrednjiKurs() {
		return (kupovniKurs + prodajniKurs) /2;
	}

	@Override
	public String toString() {
		return String.format("%-12s %5s %10.2f %10.2f %10.2f \n", valuta.getOznakaValute() , valuta.getNazivValute(), this.kupovniKurs , this.prodajniKurs , getSrednjiKurs());
	}
	
	
	
	
}
