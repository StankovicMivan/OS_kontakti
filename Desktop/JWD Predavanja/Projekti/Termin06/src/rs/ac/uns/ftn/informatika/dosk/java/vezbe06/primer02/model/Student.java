package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer02.model;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer02.IzuzetakNeispravanSlog;

//klasa
public class Student {

	private static int brojacID = 0;
	
	protected int id;
	protected String ime;
	protected String prezime;
	protected String grad;
	protected String indeks;
		
	/** KONSTRUKTORI ****/
	// konstruktor bez parametra
	public Student(){}
	
	//konstruktor sa vise parametara
	public Student(int id, String ime, String prezime, String grad, String indeks) {
		if(id==0){
			brojacID++;
			id = brojacID;
		}
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.grad = grad;
		this.indeks = indeks;
	}

	//konstruktor koji popunjava podatke na osnovu očitanog teksta iz fajla studenti.csv
	public Student(String tekst) throws IzuzetakNeispravanSlog {
		String [] tokeni = tekst.split(",");
		//npr. 		1,E1 01/2011,Srđanov,Konstantin,Loznica
		//tokeni 	0		1		2		3			4
		
		if(tokeni.length!=5){
			System.out.println("Greska pri ocitavanju studenta "+tekst);
			//izlazak iz aplikacije
			System.exit(0);
//			throw new IzuzetakNeispravanSlog(tekst);
		}

		id = Integer.parseInt(tokeni[0]);
//		try {
//			id = Integer.parseInt(tokeni[0]);
//		} catch (NumberFormatException ex) {
//			throw new IzuzetakNeispravanSlog(tekst, tokeni[0]);
//		}
		indeks = tokeni[1];
		prezime = tokeni[2];
		ime = tokeni[3];
		grad = tokeni[4];
		
		if (brojacID<id) {
			brojacID=id;
		}
	}
	//metode
	
	//metoda koja kreira tekstualnu reprezentaciju Studenta za fajl
	public String toFileRepresentation(){
		
		StringBuilder bild = new StringBuilder(); 
		bild.append(id +","+ indeks+","+prezime+","+ime+","+grad);
		return bild.toString();
	}
	
	@Override
	public String toString() {
		String ispis = "Student sa id " + id + " čije je ime i prezime" 
				+ ime + " " + prezime + " ima indeks " + indeks + " i zivi u gradu " + grad;
		return ispis;
	}
	
	public String toStringAllPredmet() {
		StringBuilder sb = new StringBuilder("Student sa id " + id + " čije je ime i prezime" 
				+ ime + " " + prezime + " ima indeks " + indeks + " i zivi u gradu " + grad);
		return sb.toString();
	}
	

	//dva objekta su ista ako imaju isti id
	public boolean isti(Student st) {
		boolean isti = false;
		if(id==st.id)
			isti = true;
		return isti;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	//set i get metode
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

}
