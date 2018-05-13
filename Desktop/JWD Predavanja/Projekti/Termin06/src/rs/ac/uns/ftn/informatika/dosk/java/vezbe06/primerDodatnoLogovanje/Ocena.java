package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

class Ocena {

	public int studentskaOcena;
	public String predmet;
	
	/** KONSTRUKTORI ****/
	public Ocena() {
		super();
	}

	public Ocena(String tekst) throws NumberFormatException{
		String [] tokeni = tekst.split(";");
		//npr. Matematika;9
		//tokeni 	0	  1
		
		if(tokeni.length!=2){
			System.out.println("Greska pri ocitavanju " + tekst);
			System.exit(0);
		}
		
		predmet = tokeni[0];
		studentskaOcena = Integer.parseInt(tokeni[1]);
		
//		try {
//			studentskaOcena = Integer.parseInt(tokeni[1]);
//		}catch(Exception ex){
//			studentskaOcena = 0;
//		}
	}
	
	public Ocena(String predmet, int studentskaOcena) {
		this.studentskaOcena = studentskaOcena;
		this.predmet = predmet;
	}
	
	public Ocena(Ocena original) {
		studentskaOcena = original.studentskaOcena;
		predmet = original.predmet;
	}
	
	public String toFileRepresentation(){	
		return predmet+";"+studentskaOcena;
	}
	
	@Override
	public String toString() {
		return "Iz predmeta " + predmet + " je dobio " + studentskaOcena;
	}
	
	//set i get metode
	public int getStudentskaOcena() {
		return studentskaOcena;
	}

	public void setStudentskaOcena(int studentskaOcena) {
		this.studentskaOcena = studentskaOcena;
	}

	public String getPredmet() {
		return predmet;
	}

	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}
}
