package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.util.Comparator;

public class OsobaNameComparator implements Comparator<Osoba>{

	int direction = 1;
	
	public OsobaNameComparator(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}

	public int compare(Osoba os1, Osoba os2) {
		int retVal = 0;
		if(os1!= null && os2!=null){
			retVal = os1.getImeIPrezime().compareTo(os2.getImeIPrezime());
		}
		return retVal * direction;
	}
}