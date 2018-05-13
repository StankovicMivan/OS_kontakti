package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer03;

import rs.ac.uns.informatika.doobuka.UtilityTextConverter;

public class Test {
	
	public static void main(String[] args) throws Exception{

		String tekst = "NIJE BROJ NEGO TEKST";
		
		if(UtilityTextConverter.isInteger(tekst)==false)
			System.out.println("NIJE BROJ");
		else
			System.out.println("BROJ");
		
	}

}
