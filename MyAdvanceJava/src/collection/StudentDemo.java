package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentDemo {
	String name;
	int rollno;
	
	StudentDemo(String name,int rollno){
		this.name = name;
		this.rollno = rollno;
	}
	
	public String toString() {
		return String.valueOf(rollno)+" : "+name;
		
	}

	public static void main(String[] args) {

    ArrayList<StudentDemo> list = new ArrayList<StudentDemo>();
    
    StudentDemo s1 = new StudentDemo("Protima Ray",1710432);
    StudentDemo s2 = new StudentDemo("Pritam Ray",1710421);
	StudentDemo s3 = new StudentDemo("Omi Verma",1710417);
	StudentDemo s4 = new StudentDemo("Chandan Kumar",1710383);
	StudentDemo s5 = new StudentDemo("Prabhdeep Kaur",1710419);
	StudentDemo s6 = new StudentDemo("Priya Sharma",1710422);
	
	list.add(s1);
	list.add(s2);
	list.add(s3);
	list.add(s4);
	list.add(s5);
	list.add(s6);
	
	Iterator iterator = list.iterator();
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
	

	}

}
