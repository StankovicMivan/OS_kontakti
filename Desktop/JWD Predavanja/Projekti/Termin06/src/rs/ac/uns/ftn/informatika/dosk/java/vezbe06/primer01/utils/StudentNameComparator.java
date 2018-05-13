package rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.utils;

import java.util.Comparator;

import rs.ac.uns.ftn.informatika.dosk.java.vezbe06.primer01.model.Student;

public class StudentNameComparator implements Comparator<Student>{

	int direction = 1;
	
	public StudentNameComparator(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}

	@Override
	public int compare(Student ob1, Student ob2) {
		int retVal = 0;
		if(ob1!= null && ob2!=null){
			retVal = ob1.getIme().compareTo(ob2.getIme());
		}
		return retVal * direction;
	}
}