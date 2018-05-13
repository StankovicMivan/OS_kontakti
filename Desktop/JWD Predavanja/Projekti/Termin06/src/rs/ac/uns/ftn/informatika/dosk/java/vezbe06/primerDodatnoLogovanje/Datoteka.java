package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

//klasa koja ima dve staticke metode za rad sa CSV datotekom - ucitavanje i snimanje
public class Datoteka {
	
	/**
	 * METODE ZA UCITAVANJE I SNIMANJE PODATAKA
	 * 
	 ****/
	
	public static HashMap<String, Student> ucitavanjePodatakaCVS() throws FileNotFoundException, IOException{

		HashMap<String, Student> sviStudenti = new HashMap<String, Student>();
		String sP = System.getProperty("file.separator");
		
		File studenti = new File("."+sP+"materijali"+sP+"studenti.csv"); 
//		File studenti = new File("."+sP+"materijali"+sP+"ispravljenCSV"+sP+"studenti.csv"); 

		BufferedReader in = new BufferedReader(
				new FileReader(studenti));
		
		//workaround for UTF-8 files and BOM marker
		//BOM (byte order mark) marker may appear on the beginning of the file
		//BOM can signal which of several Unicode encodings (8-bit, 16-bit, 32-bit) that text is encoded as
		
		in.mark(1); //zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
		if(in.read()!='\ufeff'){
			in.reset();
		}
		
		String s2;
		while((s2 = in.readLine()) != null) {
			Student st = new Student(s2);
			sviStudenti.put(st.getIndex(), st);
		}
		in.close();
		
		return sviStudenti;
	}
	
	public static void snimanjePodatakaCSV(HashMap<String, Student> sviStudenti) throws FileNotFoundException, IOException {

		String sP = System.getProperty("file.separator");
		File studenti = new File("."+sP+"materijali"+sP+"ispravljenCSV"+sP+"studenti.csv"); 
		PrintWriter out = new PrintWriter(new FileWriter(studenti));
		for (Student student : sviStudenti.values()) {
			out.println(student.toFileRepresentation());
		}
		out.flush();
		out.close();
	}
}
