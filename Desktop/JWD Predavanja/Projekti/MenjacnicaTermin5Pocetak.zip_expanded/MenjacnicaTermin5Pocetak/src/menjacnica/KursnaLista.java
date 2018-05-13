package menjacnica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KursnaLista {
	
	long id;
	Date datum;
	ArrayList<VrednostValute> vrednostValute = new ArrayList<VrednostValute>();
	
	public KursnaLista(long id,Date datum) {
		super();
		this.id = id;
		this.datum = datum;
	}
	
	public KursnaLista(long id,Date datum, ArrayList<VrednostValute> vrednostValute) {
		super();
		this.id = id;
		this.datum = datum;
		this.vrednostValute = vrednostValute;
	}
	

	public KursnaLista(String tekst){
		String [] tokeni = tekst.split(",");
		//izgled fajla
		//1,20.10.2016

		if(tokeni.length!=2){
			System.out.println("Greska pri ocitavanju Kursne Liste "+tekst);
			//izlazak iz aplikacije
			System.exit(0);
		}
		
		id = Long.parseLong(tokeni[0]);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		try {
			datum = sdf.parse(tokeni[1]);
		} catch (ParseException e) {
			System.out.println("Datum nije u formatu dd.MM.yyyy. " + tekst);
			System.exit(0);
		} 

	}
	
	public String toFileRepresentation(){

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
		
		StringBuilder bild = new StringBuilder(id+","+sdf.format(datum)); 
		
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
		KursnaLista other = (KursnaLista) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public ArrayList<VrednostValute> getVrednostValute() {
		return vrednostValute;
	}

	public void setVrednostValute(ArrayList<VrednostValute> vrednostValute) {
		this.vrednostValute = vrednostValute;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Kursna lista ID:%5d Datum:%15s", this.id, this.datum);
	}
	
	public String toStringAllVrednostValuta() {
		StringBuilder sb = new StringBuilder(toString() + " \n");
		sb.append("---------------------------------------------------------------\n");
     	sb.append("Valute:\n");
		sb.append("Oznaka       Naziv    Kupovni  Prodajni     Srednji \n");
		sb.append("---------------------------------------------------------------\n");
		for(int x=0; x<vrednostValute.size(); x++) {
			sb.append(vrednostValute.get(x));
		}
		return sb.toString();
	}
	
	
	
	
	

}
