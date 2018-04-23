package pokusaj.treci.com;

import autobuskastanica.Autobus;
import autobuskastanica.Peron;

public class PolDol {

	private Autobus autobus;
	private Peron peron;
	private String vreme;
	
	private String gdeSeUputio;
	private boolean smer;
	
	//Jedan konstruktor posto ni polazak ni dolazak ne postoji bez svih ovih atributa;
	public PolDol(Autobus autobus, Peron peron, String vreme, String gdeSeUputio, boolean smer) {
		super();
		this.autobus = autobus;
		this.peron = peron;
		this.vreme = vreme;
		this.gdeSeUputio = gdeSeUputio;
		this.smer = smer;
	}

	@Override
	public String toString() {
		String temp;
		if(smer) {
			temp = "Polazak";
		}else
			temp = "Dolazak";
		return "PolDol [autobus=" + autobus + ", peron=" + peron + ", vreme=" + vreme + ", "
				+ temp + ", " + gdeSeUputio + "]";
	}

	public Autobus getAutobus() {
		return autobus;
	}

	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}

	public Peron getPeron() {
		return peron;
	}

	public void setPeron(Peron peron) {
		this.peron = peron;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public String getGdeSeUputio() {
		return gdeSeUputio;
	}

	public void setGdeSeUputio(String gdeSeUputio) {
		this.gdeSeUputio = gdeSeUputio;
	}

	public boolean isSmer() {
		return smer;
	}

	public void setSmer(boolean smer) {
		this.smer = smer;
	}
	
	
	
}
