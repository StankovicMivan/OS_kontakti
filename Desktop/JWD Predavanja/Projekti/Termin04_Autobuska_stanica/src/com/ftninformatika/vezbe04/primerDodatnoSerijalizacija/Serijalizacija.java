package com.ftninformatika.vezbe04.primerDodatnoSerijalizacija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serijalizacija {

	public static void sinimiOsobu(Osoba o, String fileName) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Osoba ucitajOsobu(String fileName) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Osoba) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String [] args) {
		String sP = System.getProperty("file.separator");
		
		String source = "."+sP+"materijali"+sP+"osoba.dat";

		sinimiOsobu(new Osoba("Sima", "Simic"), source);
		Osoba o = ucitajOsobu(source);
		System.out.println(o);
	}
}
