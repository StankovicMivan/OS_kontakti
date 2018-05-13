package rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.dao.PohadjaDAO;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.dao.PredmetDAO;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.dao.StudentDAO;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.model.Predmet;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.model.Student;

public class PohadjaDAOTest {

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

		// dodavanje studenata
		Student s1 = new Student(0, "T 1/12", "Pera", "Peric", "Novi Sad");
		Student s2 = new Student(0, "T 2/12", "Mika", "Mikic", "Novi Sad");					
		assertTrue(StudentDAO.add(conn, s1));	
		assertTrue(StudentDAO.add(conn, s2));
		
		// dodavanje predmeta
		Predmet p1 = new Predmet(0, "Matematika1");
		Predmet p2 = new Predmet(0, "Matematika2");
		assertTrue(PredmetDAO.add(conn, p1));
		assertTrue(PredmetDAO.add(conn, p2));
	}
	
	@After
	public void tearDown() {
		Student s1 = StudentDAO.getStudentByIndeks(conn, "T 1/12");
		assertTrue(StudentDAO.delete(conn, s1.getId()));

		Student s2 = StudentDAO.getStudentByIndeks(conn, "T 2/12");
		assertTrue(StudentDAO.delete(conn, s2.getId()));

		Predmet p1 = PredmetDAO.getPredmetByNaziv(conn, "Matematika1");
		assertTrue(PredmetDAO.delete(conn, p1.getId()));

		Predmet p2 = PredmetDAO.getPredmetByNaziv(conn, "Matematika2");
		assertTrue(PredmetDAO.delete(conn, p2.getId()));

		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testAll() {
		// moraju da postoje prvo studenti i predmeti da bismo testirali pohadjanja
		Student s1 = StudentDAO.getStudentByIndeks(conn, "T 1/12");
		assertNotNull(s1);
		Student s2 = StudentDAO.getStudentByIndeks(conn, "T 2/12");
		assertNotNull(s2);
		
		Predmet p1 = PredmetDAO.getPredmetByNaziv(conn, "Matematika1");
		assertNotNull(p1);
		Predmet p2 = PredmetDAO.getPredmetByNaziv(conn, "Matematika2");
		assertNotNull(p2);

		assertTrue("add", PohadjaDAO.add(conn, s1.getId(), p1.getId()));	
		assertTrue("add", PohadjaDAO.add(conn, s1.getId(), p2.getId()));
		assertTrue("add", PohadjaDAO.add(conn, s2.getId(), p1.getId()));
		
		List<Predmet> predmeti1 = PohadjaDAO.getPredmetiByStudentID(conn, s1.getId());
		assertEquals("getPredmetiByStudentID", 2, predmeti1.size());

		List<Predmet> predmeti2 = PohadjaDAO.getPredmetiByStudentID(conn, s2.getId());
		assertEquals("getPredmetiByStudentID", 1, predmeti2.size());
		
		List<Student> studenti1 = PohadjaDAO.getStudentiByPredmetID(conn, p1.getId());
		assertEquals("getStudentiByPredmetID", 2, studenti1.size());

		List<Student> studenti2 = PohadjaDAO.getStudentiByPredmetID(conn, p2.getId());
		assertEquals("getStudentiByPredmetID", 1, studenti2.size());

		assertTrue(PohadjaDAO.delete(conn, s1.getId(), p1.getId()));
		assertTrue(PohadjaDAO.delete(conn, s1.getId(), p2.getId()));
		assertTrue(PohadjaDAO.delete(conn, s2.getId(), p1.getId()));

		predmeti1 = PohadjaDAO.getPredmetiByStudentID(conn, s1.getId());
		assertEquals("delete", 0, predmeti1.size());

		predmeti2 = PohadjaDAO.getPredmetiByStudentID(conn, s2.getId());
		assertEquals("delete", 0, predmeti2.size());
		
		studenti1 = PohadjaDAO.getStudentiByPredmetID(conn, p1.getId());
		assertEquals("delete", 0, studenti1.size());

		studenti2 = PohadjaDAO.getStudentiByPredmetID(conn, p2.getId());
		assertEquals("delete", 0, studenti2.size());
	}

}
