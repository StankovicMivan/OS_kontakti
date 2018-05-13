package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoEksel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {

	public static ArrayList<Rezultat> svirezultati = new ArrayList<Rezultat>();
	public static Workbook wb = null;
	
	public static void ucitavanjePodataka() {

		try {
			String sP = System.getProperty("file.separator");
			FileInputStream in = new FileInputStream("."+sP+"materijali"+sP+"rezultati.xlsx");
			wb = WorkbookFactory.create(in);
			Sheet sheet = wb.getSheetAt(0); // wb.getSheet("Sheet1")
			// prolaz
			for (Row row : sheet) {
				// izbegnemo prvu vrstu (zaglavlje)
				if (row.getRowNum() == 0)
					continue;
				svirezultati.add(new Rezultat(row));
			}
			in.close();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void snimanjePodataka() {
		
		//snimamo u vec ocitani eksel fajl 
		
		// prebacimo iz ArrayListe objekata u Excel sheet
		Sheet sheet = wb.getSheetAt(0); // wb.getSheet("Sheet1")
		// prolaz kroz sve studente
		for (int i = 0; i < svirezultati.size(); i++) {
			Rezultat r = svirezultati.get(i);
			Row row = sheet.getRow(i + 1); // preskocimo prvu vrstu (zaglavlje)
			// ako dobijemo null, ovo je nov red
			if (row == null) {
				row = sheet.createRow(i + 1);
				// kreiramo cetiri celije za podatke
				//
				for (int j = 0; j < 6; j++) {
					row.createCell(j);
				}
			}
			r.toExcelRow(row);
		}

		// snimamo u studenti.xlsx
		FileOutputStream fileOut;
		try {
			String sP = System.getProperty("file.separator");
			fileOut = new FileOutputStream("."+sP+"materijali"+sP+"rezultati.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		System.out.println("*********CITANJE***********");
		ucitavanjePodataka();
		for (int i = 0; i < svirezultati.size(); i++) {
			System.out.println(svirezultati.get(i).toString());
		}
		System.out.println("*********ZAVRSIO CITANJE***********");
		
		System.out.println("*********IZMENA***********");
		
		Rezultat rez =  svirezultati.get(1);
		rez.setBrojBodovaZadaci(40);
		rez.setBrojBodovaTeorija(30);
		rez.izracunajOcenu();
		
		System.out.println("*********ZAVRSIO IZMENA***********");

		System.out.println("*********SNIMANJE***********");
		snimanjePodataka();
		System.out.println("*********SNIMANJE IZMENA***********");
	}
}
