package com.ftninformatika.vezbe04.primer04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.ftninformatika.vezbe04.primer02.IO02;

public class Test1 {
	
	public ArrayList<Student> sviStudenti = new ArrayList<Student>();
	
	void citajIzFajlaStudente(File dokument) throws IOException {
		if(dokument.exists()){

			BufferedReader in = new BufferedReader(new FileReader(dokument));
			
			//workaround for UTF-8 files and BOM marker
			//BOM (byte order mark) marker may appear on the beginning of the file
			//BOM can signal which of several Unicode encodings (8-bit, 16-bit, 32-bit) that text is encoded as
			
			in.mark(1); //zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
			if(in.read()!='\ufeff'){
				in.reset();
			}
			
			String s2;
			while((s2 = in.readLine()) != null) {
				sviStudenti.add(new Student(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	void pisiUFajlStudente(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (Student student : sviStudenti) {
			out2.println(student.toFileRepresentation());
		}
		
		out2.flush();
		out2.close();
	}
	
	/*** ISPIS***/
	void ispisiStudente(){
		for (Student st : sviStudenti) {
			System.out.println(st.vratiTekstualnuReprezentacijuZaIspis());
		}
	}
	
	static void main(String[] args) throws IOException {

		String sP = System.getProperty("file.separator");
		Test1 testKlasa = new Test1();
		
		File studentiFajl = new File("."+sP+"materijali"+sP+"studenti.csv");
		testKlasa.citajIzFajlaStudente(studentiFajl);
		
		//ispis svih studenata
		testKlasa.ispisiStudente();
		
		Student st = testKlasa.sviStudenti.get(6);
		System.out.println("Unesi novi grad za studenta " +st.ime + " "+st.prezime + " ");
		Scanner sc = new Scanner(System.in);
		st.grad = sc.nextLine();
		sc.close();
		
		testKlasa.pisiUFajlStudente(studentiFajl);
		
		System.out.println("Kraj programa");
	}
}
