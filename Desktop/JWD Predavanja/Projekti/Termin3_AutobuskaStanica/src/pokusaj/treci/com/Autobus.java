package pokusaj.treci.com;

import java.util.ArrayList;

public class Autobus {

	private String regBroj;
	private Tip tip;
	private Prevoznik prevoznik;
	private ArrayList<PolDol> polasciIDolasci ;

	public Autobus() {
		super();
		this.polasciIDolasci = new ArrayList<>();
	}

	public Autobus(String regBroj, Tip tip, Prevoznik prevoznik) {
		super();
		this.regBroj = regBroj;
		this.tip = tip;
		this.prevoznik = prevoznik;
		this.polasciIDolasci = new ArrayList<>();
	}

	public Autobus(String regBroj, Tip tip, Prevoznik prevoznik, ArrayList<PolDol> polasciIDolasci) {
		super();
		this.regBroj = regBroj;
		this.tip = tip;
		this.prevoznik = prevoznik;
		this.polasciIDolasci = polasciIDolasci;
	}

	@Override
	public String toString() {
		return "Autobus [regBroj=" + regBroj + ", tip=" + tip + ", prevoznik=" + prevoznik + ", polasciIDolasci="
				+ polasciIDolasci + "]";
	}

	public String getRegBroj() {
		return regBroj;
	}

	public void setRegBroj(String regBroj) {
		this.regBroj = regBroj;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}

	public ArrayList<PolDol> getPolasciIDolasci() {
		return polasciIDolasci;
	}

	public void setPolasciIDolasci(ArrayList<PolDol> polasciIDolasci) {
		this.polasciIDolasci = polasciIDolasci;
	}
	 
	
	
	
	
}
