package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test_Ver_HashMap {
	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void main(String[] args) throws Exception {
		
		Logger logger = LogManager.getLogger(Test_Ver_HashMap.class.toString());
		
		logger.entry();
		
		try {
			//namerno postoji greska u fajlu
			StudentUI_Ver_HashMap.sviStudenti = Datoteka.ucitavanjePodatakaCVS(); 
		} catch (FileNotFoundException e) {
//			System.out.println("Fajl za citanje podataka o studentima nije proznadjen na zadatoj lokaciji");
			logger.error("Fajl za citanje podataka o studentima nije proznadjen na zadatoj lokaciji");
			System.exit(0);
		}
		catch (IOException e) {
//			System.out.println("Greska pri preuzimanju podataka iz fajla o studentima");
			logger.error("Greska pri preuzimanju podataka iz fajla o studentima");
			System.exit(0);
		}
		
		//logger info
		logger.info("Uspesno ocitani svi podaci iz fajla o studentima");
			
		int odluka = -1;
		while(odluka!= 0){
			ispisiTekstOsnovneOpcije();
			System.out.print("opcija:");
			odluka = Utility.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					StudentUI_Ver_HashMap.meniStudentUI();
					break;
				case 2:
//					rad sa drugim entitetima;
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}

		try {
			Datoteka.snimanjePodatakaCSV(StudentUI_Ver_HashMap.sviStudenti);
		} catch (FileNotFoundException e) {
			//logger error
			System.exit(0);
		}
		catch (IOException e) {
			//logger error
			System.exit(0);
		}
		
		//logger info
		
		logger.exit(true);

		System.out.print("Program izvrsen");
	}
}
