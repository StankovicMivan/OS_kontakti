package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.util.Comparator;

public class StudentBrojPredmetaComparator implements Comparator<Student>{

	int direction = 1;
	
	public StudentBrojPredmetaComparator(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}

	public int compare(Student st1, Student st2) {
		int retVal = 0;
		if(st1!= null && st2!=null){
			int st1BrPred = st1.getOcene().size();
			int st2BrPred = st2.getOcene().size();
			retVal = st1BrPred-st2BrPred;
		}
		return retVal * direction;
	}
}
