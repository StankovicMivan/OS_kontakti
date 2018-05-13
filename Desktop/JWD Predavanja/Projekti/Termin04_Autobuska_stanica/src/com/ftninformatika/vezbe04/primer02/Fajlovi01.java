package com.ftninformatika.vezbe04.primer02;

import java.io.File;
import java.io.IOException;

public class Fajlovi01 {

	static void izlistajSadrzajFoleraStatic(String putanja) {

		// kreiranje File objekta koji reprezentuje current folder
		File current = new File(putanja);
		// Prikaz absolutne putanje ovog foldera
		System.out.println(current.getAbsolutePath());
		// provera da li folder
		if (current.isDirectory()) {
			// prikaz sadrzaja ovog foldera
			for (File file : current.listFiles()) {
				if (file.isDirectory())
					System.out.println(file.getName() + ", folder");
				else if (file.isFile()) // da li je potrebna ova provera?
					System.out.println(file.getName() + ", size (bytes): " + file.length());
			}
		}
	}

	void izlistajSadrzajFolera(String putanja) {

		// kreiranje File objekta koji reprezentuje current folder
		File current = new File(putanja);
		// Prikaz absolutne putanje ovog foldera
		System.out.println(current.getAbsolutePath());
		// provera da li folder
		if (current.isDirectory()) {
			// prikaz sadrzaja ovog foldera
			for (File file : current.listFiles()) {
				if (file.isDirectory())
					System.out.println(file.getName() + ", folder");
				else if (file.isFile()) // da li je potrebna ova provera?
					System.out.println(file.getName() + ", size (bytes): " + file.length());
			}
		}
	}

	// o izuzecima cemo kasnije u toku kursa, ovde mora da se doda throws
	// IOException
	public static void main(String[] args) throws IOException {

		String putanja = ".";
		Fajlovi01.izlistajSadrzajFoleraStatic(putanja);
		//samo ako se nalayimo u ustoj klasi
//		izlistajSadrzajFoleraStatic(putanja);
		
		//preko objekta
//		Fajlovi01 fajloviTest = new Fajlovi01();
//		fajloviTest.izlistajSadrzajFolera(putanja);

		// separator putanje se pribavlja iz OS
		String sP = System.getProperty("file.separator");
		System.out.println("\nSeparator je " + sP);

		// TODO prikazati sadrzaj foldera materijali

	}
	/*
	 * Vise o sistemskim propertijima na
	 * https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.
	 * html "file.separator" Character that separates components of a file path.
	 * This is "/" on UNIX and "\" on Windows. "java.class.path" Path used to
	 * find directories and JAR archives containing class files. Elements of the
	 * class path are separated by a platform-specific character specified in
	 * the path.separator property. "java.home" Installation directory for Java
	 * Runtime Environment (JRE) "java.vendor" JRE vendor name "java.vendor.url"
	 * JRE vendor URL "java.version" JRE version number "line.separator"
	 * Sequence used by operating system to separate lines in text files
	 * "os.arch" Operating system architecture "os.name" Operating system name
	 * "os.version" Operating system version "path.separator" Path separator
	 * character used in java.class.path "user.dir" User working directory
	 * "user.home" User home directory "user.name" User account name
	 */

}
