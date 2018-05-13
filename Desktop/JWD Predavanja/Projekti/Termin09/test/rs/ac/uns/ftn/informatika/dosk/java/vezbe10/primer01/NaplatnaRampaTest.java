package rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer01;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer01.NaplatnaRampa;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer01.model.Automobil;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer01.model.Kamion;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer01.model.Vozilo;

public class NaplatnaRampaTest {

	@BeforeClass
	public static void testSetup() {
		// akcija pre pokretanja testa
	}

	@Test
	public void testNaplatiPutarinuVoziloArray() {
		NaplatnaRampa testee = new NaplatnaRampa();

		Vozilo[] vozila = new Vozilo[] {
				new Automobil(), 
				new Automobil(), 
				new Kamion()};
		assertEquals("naplatiPutarinu", 1480, testee.naplatiPutarinu(vozila), 1E-6);
	}

	@AfterClass
	public static void testCleanup() {
		// da dovedemo sistem u konzistentno stanje
	}

}
