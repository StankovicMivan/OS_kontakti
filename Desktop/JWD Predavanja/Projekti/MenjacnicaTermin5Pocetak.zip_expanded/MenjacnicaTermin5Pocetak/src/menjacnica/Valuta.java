package menjacnica;

public class Valuta {

	String oznakaValute;
	String nazivValute;


	public Valuta(String oznakaValute, String nazivValute) {
		super();
		this.oznakaValute = oznakaValute;
		this.nazivValute = nazivValute;
	}

	public Valuta(String tekst){
		String [] tokeni = tekst.split(",");


		if(tokeni.length!=2){
			System.out.println("Greska pri ocitavanju valute "+tekst);
			//izlazak iz aplikacije
			System.exit(0);
		}
		this.oznakaValute= tokeni[0];
		this.nazivValute = tokeni[1];

	}

	public String toFileRepresentation(){

		StringBuilder bild = new StringBuilder(); 
		bild.append(this.oznakaValute +","+ this.nazivValute);
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
		Valuta other = (Valuta) obj;
		if (oznakaValute == null) {
			if (other.oznakaValute != null)
				return false;
		} else if (!oznakaValute.equals(other.oznakaValute))
			return false;
		return true;
	}

	public String getOznakaValute() {
		return oznakaValute;
	}
	public void setOznakaValute(String oznakaValute) {
		this.oznakaValute = oznakaValute;
	}
	public String getNazivValute() {
		return nazivValute;
	}
	public void setNazivValute(String nazivValute) {
		this.nazivValute = nazivValute;
	}

	@Override
	public String toString() {
		return String.format("Oznaka:%-3s Naziv:%-10s ", this.oznakaValute, this.nazivValute);
	}



}
