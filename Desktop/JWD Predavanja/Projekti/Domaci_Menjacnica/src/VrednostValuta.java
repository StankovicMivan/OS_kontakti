

public class VrednostValuta {

	private double kupovina;
	private double prodaja;
	private double srVrednost;
	private Valuta valuta;
	private KursnaLista kursnaLista;
	
	//CONSTRUCTORS
	public VrednostValuta() {
		super();
	}
	public VrednostValuta(double kupovina, double prodaja, double srVrednost, Valuta valuta, KursnaLista kursnaLista) {
		super();
		this.kupovina = kupovina;
		this.prodaja = prodaja;
		this.srVrednost = srVrednost;
		this.valuta = valuta;
		this.kursnaLista = kursnaLista;
	}
	
	public VrednostValuta(String s) {
		String [] tokeni = s.split(",");
		
		if(tokeni.length!=4){
			System.out.println("Greska pri ocitavanju vrednost valute "+s);
			System.exit(0);
		}
		
		kursnaLista = Test.pronadjiKursnuListu(Integer.parseInt(tokeni[0]));
		valuta = Test.pronadjiValutu(tokeni[1]);
		kupovina = Double.parseDouble(tokeni[2]);
		prodaja = Double.parseDouble(tokeni[3]);
		
		kursnaLista.getValute().add(this);
		
	}
	//TO STRING
	@Override
	public String toString() {
		return "VrednostValuta [kupovina=" + kupovina + ", prodaja=" + prodaja + ", srVrednost=" + srVrednost
				+ ", valuta=" + valuta + ", kursnaLista=" + kursnaLista + "]";
	}

	
	
	
	
	
	
	
	// GET SET
	public double getKupovina() {
		return kupovina;
	}
	public void setKupovina(double kupovina) {
		this.kupovina = kupovina;
	}

	public double getProdaja() {
		return prodaja;
	}
	public void setProdaja(double prodaja) {
		this.prodaja = prodaja;
	}

	public double getSrVrednost() {
		return srVrednost;
	}
	public void setSrVrednost(double srVrednost) {
		this.srVrednost = srVrednost;
	}

	public Valuta getValuta() {
		return valuta;
	}
	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}
	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}


}
