package com.ftninformatika.vezbe04.primer02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ftninformatika.vezbe04.primer04.Student;


public class IO02 {

//	ArrayList<Student> sviStudent = new ArrayList<Student>();
	
	void pisiUFajl(File dokument) throws IOException {
		if(!dokument.exists())
			dokument.createNewFile();

		
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		out2.println("Tekst poruke koja se upisuje u fajl");
		out2.println("Red 2");
		out2.println("Red 3");
		
		//IDEJA KAKO DA SE ČUVAJU PODACI O STUDENTIMA U CSV FAJLU
//		for (Student student : sviStudent) {
//			out2.println(student.getId()+","+student.getIndeks()+","
//					+student.getPrezime()+","+student.getIme()+","+student.getGrad());
//		}
		
		out2.flush();
		out2.close();
	}
	
	void citajIzFajla(File dokument) throws IOException {
		if(dokument.exists()){
			//koristimo reader, a ne stream, da bi bilo sve korektno sa UTF8 enkodingom
			//reader je buffer-izovan zbog performansi
			BufferedReader in = new BufferedReader(new FileReader(dokument));
			
			
			FileReader fr = new FileReader(dokument);
			
			//workaround for UTF-8 files and BOM marker
			//BOM (byte order mark) marker may appear on the beginning of the file
			in.mark(1); //zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
			if(in.read()!='\ufeff'){
				in.reset();
			}
			
			String s2;
			while((s2 = in.readLine()) != null) {
				//da bi se videla cirilicna slova, mora se podesiti enkoding 
				//ici na Run->Run configurations->Common->Encoding->Other UTF8
				System.out.println(s2);
				
				//IDEJA KAKO DA SE ČITAJU PODACI O STUDENTIMA IZ CSV FAJLU
//				String [] tokeni = s2.split(",");
//				
//				int id = Integer.parseInt(tokeni[0]);
//				String indeks = tokeni[1];
//				String prezime = tokeni[2];
//				String ime = tokeni[3];
//				String grad = tokeni[4];
//				
//				Student st = new Student(id, ime, prezime, grad, indeks);
//				
//				sviStudent.add(st);
				
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	void citajSaTastaure() throws IOException {
		System.out.println("Unesite tekst sa tasture: ");
		//uz pomoc speznih klasa
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tekst = in.readLine();
		System.out.println("Ucitani tekst sa tasture je");
		
		System.out.println(tekst);
		
//		System.out.print("Unesite celobrojnu vrednost sa tasture: ");
//		int vrednost = Integer.parseInt(in.readLine()); //koristimo vraper klase
//		System.out.println("Uneli ste: " + vrednost);
//		
//		System.out.print("Unesite realnu vrednost sa tasture: ");
//		double vrednostR = Double.parseDouble(in.readLine()); //koristimo vraper klase
//		System.out.println("Uneli ste: " + vrednostR);
		
	}
	
	void ispisNaEkran() throws IOException{
		//moze se i ovako ispisivati na ekran, cak je i bolje jer je ovo writer, a ne stream
		//System.out je stream pa u nekim situacijama moze biti problema sa enkodingom
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF8"));
		out.println("Tekst poruke koja se ispisuje na ekran");
		out.println("Tekst 2");
		out.println("Tekst 3");
		out.flush();
	}
	
	// o izuzecima cemo kasnije u toku kursa, ovde mora da se doda throws IOException 
	public static void main(String[] args) throws IOException {
		
		String sP = System.getProperty("file.separator");
		IO02 testKlasa = new IO02();
		
		//kreiranje File objekta koji reprezentuje studenti.csv fajl
		//citanje podataka iz fajla
		File studFajl = new File("."+sP+"materijali"+sP+"studenti.csv");
		testKlasa.citajIzFajla(studFajl);
		System.out.println("-------------------------------------");
		
		//ovako bi kreirali fajl NOVI.csv i nesto upisali u njega
		File noviF = new File("."+sP+"materijali"+sP+"NOVI.csv");
		testKlasa.pisiUFajl(noviF);

		System.out.println("-------------------------------------");
//		testKlasa.citajSaTastaure();
		System.out.println("-------------------------------------");
//		testKlasa.ispisNaEkran();
		System.out.println("-------------------------------------");
		System.out.println("kraj programa");
	}

}
