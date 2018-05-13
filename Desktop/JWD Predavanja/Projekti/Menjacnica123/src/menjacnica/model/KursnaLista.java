package menjacnica.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import menjacnica.utils.PomocnaKlasa;

public class KursnaLista {

	private int id;
	private Date datum;
	
	private List<VrednostValute> vrednostiValuta = new ArrayList<>();

	public KursnaLista(int id, Date datum) {
		this.id = id;
		this.datum = datum;
	}

	@Override
	public String toString() {
		StringBuilder strVrednostiValute =new StringBuilder();
		String newLine = System.getProperty("line.separator");
		for (VrednostValute ir : vrednostiValuta) {
			strVrednostiValute.append(newLine);
			strVrednostiValute.append(ir);
			
		}
		return "KursnaLista [id=" + id + ", datum=" + PomocnaKlasa.FORMAT_DATUMA.format(datum)  + "]" +strVrednostiValute;
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

	public int getId() {
		return id;
	}

	public Date getDatum() {
		return datum;
	}

	public List<VrednostValute> getVrednostiValuta() {
		return vrednostiValuta;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
