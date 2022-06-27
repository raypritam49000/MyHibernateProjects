package collection;

import java.util.ArrayList;

public class Students {
String name;
int rollno;

public Students(String name,int rollno) {
	this.name = name;
	this.rollno = rollno;
}

public String toString() {
	return this.name+" : "+this.rollno;
	
}

	public static void main(String[] args) {
		
    ArrayList<Students> list = new ArrayList<Students>();

	Students s1 = new Students("Pritam Ray",1710421);
	Students s2 = new Students("Omi Verma",1710417);
	Students s3 = new Students("Chandan Kumar",1710383);
	Students s4 = new Students("Prabhdeep Kaur",1710419);
	Students s5 = new Students("Priya Sharma",1710422);
	
	list.add(s1);
	list.add(s2);
	list.add(s3);
	list.add(s4);
	list.add(s5);
	
	for(Students student : list) {
		System.out.println(student.toString());
	}
	}

}
