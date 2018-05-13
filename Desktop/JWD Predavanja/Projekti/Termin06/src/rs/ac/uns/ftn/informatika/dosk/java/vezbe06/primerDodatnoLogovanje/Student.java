package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//klasa
class Student extends Osoba{

	Logger logger = LogManager.getLogger(Student.class.toString());	//definisanje logera
	
	//atributi
	protected String index;
	protected ArrayList<Ocena> ocene = new ArrayList<Ocena>();
	
	/** KONSTRUKTORI ****/
	
	// konstruktor bez parametra
	public Student(){
		super();
	}
	
	public Student(String tekst){
		String [] tokeni = tekst.split(",");
		//npr. 012345678910,e10002,Marko Markovic,Loznica,Matematika;9!Fizika;7!Biologija;10
		//tokeni 	0			1		2			3				4
		
		if(tokeni.length!=5){
//			System.out.println("Greska pri ocitavanju "+tekst);
			logger.error("Greska pri ocitavanju "+tekst);
			System.exit(0);
		}
		JMBG = tokeni[0];
		index = tokeni[1];
		imeIPrezime = tokeni[2];
		grad = tokeni[3];
		
		String [] studentSveOceneTekst = tokeni[4].split("!");
		//npr. 		"Matematika;9!Fizika;7!Biologija;10"
		//tokeni 	 0 				1 			3

		for (int i = 0; i < studentSveOceneTekst.length; i++) {
			try {
				ocene.add(new Ocena(studentSveOceneTekst[i]));
			} catch (NumberFormatException e) {
//				System.out.println("Greska pri parsiranju ocene studenta \n" + tekst);
				logger.error("Greska pri parsiranju ocene studenta \n" + tekst);
				System.exit(0);
			} catch (Exception e) {
//				System.out.println("Greska pri parsiranju ocene studenta \n" + tekst);
				logger.error("Greska pri parsiranju ocene studenta \n" + tekst);
				System.exit(0);
			}
		}
		
		//logger info
		logger.info("Uspesno ocitani podaci o studentu\n"+toString());
	}
	
	//konstruktor sa vise parametara
	public Student(String JMBG, String imeIPrezime, String grad, String index,
			ArrayList<Ocena> ocene) {
		super(JMBG, imeIPrezime, grad);
		this.index = index;
		this.ocene = ocene;
	}
	
	public Student(String JMBG, String imeIPrezime, String grad, String index) {
		super(JMBG, imeIPrezime, grad);
		this.index = index;
	}

	//metoda koja kreira tekstualnu reprezentaciju Studenta za fajl
	public String toFileRepresentation(){
		
		StringBuilder bild = new StringBuilder(); 
		bild.append(JMBG +"," + index +","+ imeIPrezime +","+ grad +","); 		//ubaci indeks, ime studenta, grad
		
		if(ocene.size() == 0)
			bild.append("!");
		else
			for (int i = 0; i < ocene.size(); i++) {
				bild.append(ocene.get(i).toFileRepresentation() +"!");
			}
		
		return bild.toString();
	}
	
	@Override
	public String toString() {
		return "Student " + imeIPrezime + " JMBG " + JMBG + " sa indeksom " + index + " zivi u gradu " + grad +
				" ima prosecnu ocenu:" + izracunajProsek();
	}
	
	//da li su dva objekta Student ista (isti su ako imaju isti index), 
	@Override
	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof Student) {
			Student objStudent = (Student) obj;
			if(this.index.equals(objStudent.index))
				return true;
		}
		return isti;
	}
	
	public double izracunajProsek(){	
		double retVal = 0;
		if(ocene.isEmpty())
			return retVal;
		
		int suma = 0;
		for (int i = 0; i < ocene.size(); i++) {
			suma+=ocene.get(i).studentskaOcena;
		}
		//zasto stoji (double)?
		retVal = (double)suma/ocene.size();
		return retVal;
	}
	
	//dodao metodu koja ce ispisati sve studentove ocene
	public void ispisiOcene(){
		if(ocene.isEmpty())
			return;
		
		for (int i = 0; i < ocene.size(); i++) {
			System.out.println(ocene.get(i).toString());
		}
	}

	//set i get metode
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public ArrayList<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(ArrayList<Ocena> ocene) {
		this.ocene = ocene;
	}
}
