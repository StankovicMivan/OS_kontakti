package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primerDodatnoLogovanje;

import java.util.Comparator;

public class StudentIndexComparator implements Comparator<Student>{

	int direction = 1;
	
	public StudentIndexComparator(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}

	public int compare(Student st1, Student st2) {
		int retVal = 0;
		if(st1!= null && st2!=null){
			retVal = st1.getIndex().compareTo(st2.getIndex());
		}
		return retVal * direction;
	}
}
