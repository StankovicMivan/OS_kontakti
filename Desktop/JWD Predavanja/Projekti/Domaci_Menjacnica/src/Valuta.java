import java.time.LocalDate;
import java.util.ArrayList;

public class Valuta {

	private String oznaka;
	private String naziv;
	private ArrayList<VrednostValuta> vredValuta = new ArrayList<>();

	
	//CONSTRUCTORS
	public Valuta() {
		super();
	}
	public Valuta(String oznaka, String naziv, ArrayList<VrednostValuta> vredValuta) {
		super();
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.vredValuta = vredValuta;
	}
	
	public Valuta(String s) {
		String [] tokeni = s.split(",");
		// id, datum
		
		if(tokeni.length!=2){
			System.out.println("Greska pri ocitavanju studenta "+s);
			//izlazak iz aplikacije
			System.exit(0);
		}
		
		oznaka = (tokeni[0]);
		naziv  =(tokeni[1]);
	}
	
	
	
	public String toFileRepresentation(){

		StringBuilder bild = new StringBuilder(); 
		bild.append(this.oznaka +","+ this.naziv);
		return bild.toString();
	}
	
	//TO STRING
	@Override

	public String toString() {
		return "Valuta [oznaka=" + oznaka + ", naziv=" + naziv + ", vredValuta=" + vredValuta + "]";
	}

	
	//GET SET
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<VrednostValuta> getVredValuta() {
		return vredValuta;
	}
	public void setVredValuta(ArrayList<VrednostValuta> vredValuta) {
		this.vredValuta = vredValuta;
	}


}
