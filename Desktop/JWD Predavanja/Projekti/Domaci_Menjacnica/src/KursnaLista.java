
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;


public class KursnaLista {
	
	private int id;
	private LocalDate datum;
	private ArrayList<VrednostValuta> vrValuta = new ArrayList<>();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	//CONSTRUCTORS
	
	public KursnaLista() {
		super();
	}
	
	public KursnaLista(int id, LocalDate datum) {
		super();
		this.id = id;
		this.datum = datum;
	}

	
	public KursnaLista(int id, LocalDate datum, ArrayList<VrednostValuta> valute) {
		super();
		this.id = id;
		this.datum = datum;
		this.vrValuta = valute;
	}

	
	public KursnaLista(String s) {
		String [] tokeni = s.split(",");
		// id, datum
		
		if(tokeni.length!=2){
			System.out.println("Greska pri ocitavanju studenta "+s);
			//izlazak iz aplikacije
			System.exit(0);
		}
		
		id = Integer.parseInt(tokeni[0]);
		datum = LocalDate.parse(tokeni[1], dtf);
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// TO STRING
	@Override
	public String toString() {
		return String.format("Kursna lista %3d, Datum: %10s ", id,datum);
	}

	public String ispisSvih() {
		StringBuilder temp = new StringBuilder(toString() + "\n ");
		temp.append("****************");
		temp.append("\n");
		for (int i = 0; i <vrValuta.size() ; i++) {
			temp.append(vrValuta.get(i));
		}
		return temp.toString();
	}
	//TO FILE REP...
	public String toFileRepresentation(){


		StringBuilder str = new StringBuilder(id+","+dtf.format(datum)); 
		return str.toString();
		
	}
	
	@Override
		public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KursnaLista test = (KursnaLista) obj;
		if (id != test.id)
			return false;
		return true;
	}
	
	
	
	//GET SET
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	
	public ArrayList<VrednostValuta> getValute() {
		return vrValuta;
	}
	public void setValute(ArrayList<VrednostValuta> valute) {
		this.vrValuta = valute;
	}
	
	
}
