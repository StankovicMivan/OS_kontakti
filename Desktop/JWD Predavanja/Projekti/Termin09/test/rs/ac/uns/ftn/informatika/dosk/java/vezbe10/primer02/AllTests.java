package rs.ac.uns.ftn.informatika.dosk.java.vezbe10.primer02;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	PredmetDAOTest.class, 
	StudentDAOTest.class, 
	PohadjaDAOTest.class})
public class AllTests {}
