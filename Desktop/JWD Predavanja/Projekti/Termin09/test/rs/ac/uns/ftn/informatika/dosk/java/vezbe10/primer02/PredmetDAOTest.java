package rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.dao.PredmetDAO;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.model.Predmet;

public class PredmetDAOTest {

	private Connection conn;
	
	@Before
	public void setUp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentskasluzba?useSSL=false", 
					"root", 
					"root");
		} catch (Exception ex) {
			ex.printStackTrace();

			// kraj testa
			assertTrue("Neuspela konekcija na bazu!", false);
		}
	}

	@After
	public void tearDown() throws Exception {
		Predmet predmet = PredmetDAO.getPredmetByNaziv(conn, "Naziv");
		assertTrue("delete", PredmetDAO.delete(conn, predmet.getId()));
		predmet = PredmetDAO.getPredmetByID(conn, predmet.getId());
		assertTrue("delete", predmet == null);

		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testAll() {
		Predmet predmet = new Predmet(0, "Matematika");

		assertTrue("add", PredmetDAO.add(conn, predmet));	
		predmet = PredmetDAO.getPredmetByNaziv(conn, "Matematika");
		assertNotNull("add, getByNaziv", predmet);

		predmet.setNaziv("Naziv");
		assertTrue("update", PredmetDAO.update(conn, predmet));

		predmet = PredmetDAO.getPredmetByID(conn, predmet.getId());
		assertNotNull("getByID", predmet);
		assertTrue("update", predmet.getNaziv().equals("Naziv"));
	}

}
