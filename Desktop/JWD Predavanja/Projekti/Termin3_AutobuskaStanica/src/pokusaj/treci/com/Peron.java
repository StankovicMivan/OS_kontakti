package pokusaj.treci.com;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Peron {

	private int redBroj;
	private ArrayList<PolDol> polasciIDolasci ;
	private AutobuskaStanica stanica;
	public Peron() {
		super();
		this.polasciIDolasci = new ArrayList<>();
	}
	public Peron(int redBroj, ArrayList<PolDol> polasciIDolasci, AutobuskaStanica stanica) {
		super();
		this.redBroj = redBroj;
		this.polasciIDolasci = polasciIDolasci;
		this.stanica = stanica;
	}
	@Override
	public String toString() {
		return "Peron [redBroj=" + redBroj + ", polasciIDolasci=" + polasciIDolasci + ", stanica=" + stanica + "]";
	}
	public int getRedBroj() {
		return redBroj;
	}
	public void setRedBroj(int redBroj) {
		this.redBroj = redBroj;
	}
	public ArrayList<PolDol> getPolasciIDolasci() {
		return polasciIDolasci;
	}
	public void setPolasciIDolasci(ArrayList<PolDol> polasciIDolasci) {
		this.polasciIDolasci = polasciIDolasci;
	}
	public AutobuskaStanica getStanica() {
		return stanica;
	}
	public void setStanica(AutobuskaStanica stanica) {
		this.stanica = stanica;
	}
	
	
	
}
