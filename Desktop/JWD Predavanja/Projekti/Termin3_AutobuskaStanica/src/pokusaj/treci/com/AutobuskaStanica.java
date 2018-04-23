package pokusaj.treci.com;

import java.util.ArrayList;

public class AutobuskaStanica {

	private String sediste;
	private int id;
	private ArrayList<Peron> peroni = new ArrayList<>();

	
	
	public AutobuskaStanica() {
		super();
	}



	public AutobuskaStanica(String sediste, int id, ArrayList<Peron> peroni) {
		super();
		this.sediste = sediste;
		this.id = id;
		this.peroni = peroni;
	}



	@Override
	public String toString() {
		return "AutobuskaStanica [sediste=" + sediste + ", id=" + id + ", peroni=" + peroni + "]";
	}



	public String getSediste() {
		return sediste;
	}



	public void setSediste(String sediste) {
		this.sediste = sediste;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ArrayList<Peron> getPeroni() {
		return peroni;
	}



	public void setPeroni(ArrayList<Peron> peroni) {
		this.peroni = peroni;
	}
	
	
	
	
}
