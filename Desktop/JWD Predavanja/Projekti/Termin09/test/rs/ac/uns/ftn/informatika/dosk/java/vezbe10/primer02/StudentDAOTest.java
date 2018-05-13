package rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.dao.StudentDAO;
import rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02.model.Student;

public class StudentDAOTest {

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
		Student student = StudentDAO.getStudentByIndeks(conn, "Indeks");
		assertTrue("delete", StudentDAO.delete(conn, student.getId()));
		student = StudentDAO.getStudentByID(conn, student.getId());
		assertTrue("delete", student == null);

		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testAll() {	
		Student student = new Student(0, "T 1/12", "Pera", "Peric", "Novi Sad");

		assertTrue("add", StudentDAO.add(conn, student));
		student = StudentDAO.getStudentByIndeks(conn, "T 1/12");
		assertNotNull("add, getByIndeks", student);

		student.setIndeks("Indeks");
		student.setIme("Ime");
		student.setPrezime("Prezime");
		student.setGrad("Grad");
		assertTrue("update", StudentDAO.update(conn, student));	

		student = StudentDAO.getStudentByID(conn, student.getId());
		assertNotNull("getByID", student);
		assertTrue("update", student.getIndeks().equals("Indeks"));
		assertTrue("update", student.getIme().equals("Ime"));
		assertTrue("update", student.getPrezime().equals("Prezime"));
		assertTrue("update", student.getGrad().equals("Grad"));
	}

}
	
