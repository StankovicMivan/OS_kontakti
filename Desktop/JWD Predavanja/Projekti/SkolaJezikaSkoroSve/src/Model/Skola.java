package Model;

public class Skola {

	private int id;
	private String naziv;
	private String adresa;
	private String tel;
	private String eMail;
	private String web;
	private int pib;
	private int matBroj;
	private String ziroRacun;
	public Skola() {
		super();
	}
	public Skola(String naziv, String adresa, String tel, String eMail, String web, int pib, int matBroj,
			String ziroRacun) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.tel = tel;
		this.eMail = eMail;
		this.web = web;
		this.pib = pib;
		this.matBroj = matBroj;
		this.ziroRacun = ziroRacun;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public int getPib() {
		return pib;
	}
	public void setPib(int pib) {
		this.pib = pib;
	}
	public int getMatBroj() {
		return matBroj;
	}
	public void setMatBroj(int matBroj) {
		this.matBroj = matBroj;
	}
	public String getZiroRacun() {
		return ziroRacun;
	}
	public void setZiroRacun(String ziroRacun) {
		this.ziroRacun = ziroRacun;
	}
	@Override
	public String toString() {
		return "Skola [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", tel=" + tel + ", eMail=" + eMail
				+ ", web=" + web + ", pib=" + pib + ", matBroj=" + matBroj + ", ziroRacun=" + ziroRacun + "]";
	}
	
	
	
}
