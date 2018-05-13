package com.drugi.pokusaj;




public class IspitnaPrijava {

	protected Student st;
	protected Predmet pr;
	protected IspitniRok ir;
	protected int teorija;
	protected int zadaci;
	
	public IspitnaPrijava(Student st, Predmet pr, IspitniRok ir, int teorija, int zadaci) {
		this.st = st;
		this.pr = pr;
		this.ir = ir;
		this.teorija = teorija;
		this.zadaci = zadaci;
	}
	
	public IspitnaPrijava(String tekst){
		String [] tokeni = tekst.split(",");
		
		//student, predmet, ispitni rok, teorija, zadaci
		//npr. 		1,1,1,88,89
		//tokeni 	0 1	2 3  4		
		
		//TO DO
		if(tokeni.length!=5){
			
			System.out.println("Greska pri ocitavanju ispitne prijave "+tekst);
			//			//izlazak iz aplikacije

			System.exit(0);
			

//			if (brojacID<id) {
//				brojacID=id;
//			}
		}
		st = StudentUI.pronadjiStudentaId(Integer.parseInt(tokeni[0]));
		pr = PredmetUI.pronadjiPredmetId(Integer.parseInt(tokeni[1]));
		ir =  IspitniRokUI.pronadjiIspitniRokID(Integer.parseInt(tokeni[2]));
		teorija = Integer.parseInt(tokeni[3]);
		zadaci = Integer.parseInt(tokeni[4]);
		
	}
	
	public String toFileRepresentation(){
		//TO DO
		return st.id + "," + pr.getId() + "," + ir.getId()+ "," + teorija + "," + zadaci;

		
	}
	
	@Override
	public String toString() {
		String ispis = "Ispitna prijava za studenta " +st + " iz predmeta "
				+ pr + " u roku " + ir + ". Osvojio bodova iz teorije " + teorija 
				+ " i iz zadataka " + zadaci;
		return ispis;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IspitnaPrijava other = (IspitnaPrijava) obj;
		if (ir == null) {
			if (other.ir != null)
				return false;
		} else if (!ir.equals(other.ir))
			return false;
		if (pr == null) {
			if (other.pr != null)
				return false;
		} else if (!pr.equals(other.pr))
			return false;
		if (st == null) {
			if (other.st != null)
				return false;
		} else if (!st.equals(other.st))
			return false;
		return true;
	}

	public int sracunajOcenu() {
		double bodovi = sracunajProsek();
		int ocena;
		if (bodovi >= 95)
			ocena = 10;
		else if (bodovi >= 85)
			ocena = 9;
		else if (bodovi >= 75)
			ocena = 8;
		else if (bodovi >= 65)
			ocena = 7;
		else if (bodovi >= 55)
			ocena = 6;
		else
			ocena = 5;

		return ocena;
	}
	
	public double sracunajProsek() {
		int bodovi = teorija + zadaci;
		return bodovi/2;
	}

	public Student getSt() {
		return st;
	}

	public void setSt(Student st) {
		this.st = st;
	}

	public Predmet getPr() {
		return pr;
	}

	public void setPr(Predmet pr) {
		this.pr = pr;
	}

	public IspitniRok getIr() {
		return ir;
	}

	public void setIr(IspitniRok ir) {
		this.ir = ir;
	}

	public int getTeorija() {
		return teorija;
	}

	public void setTeorija(int teorija) {
		this.teorija = teorija;
	}

	public int getZadaci() {
		return zadaci;
	}

	public void setZadaci(int zadaci) {
		this.zadaci = zadaci;
	}
	
}
