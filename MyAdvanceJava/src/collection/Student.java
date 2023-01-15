package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Student {
	
String name;
int rollno;

public Student(String name,int rollno) {
	this.name = name;
	this.rollno = rollno;
}


 public String toString() {
 
	return ""+name+" : "+rollno;
}


public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		Student s1 = new Student("Pritam Ray",1710421);
		Student s2 = new Student("Omi Verma",1710417);
		Student s3 = new Student("Chandan Kumar",1710383);
		Student s4 = new Student("Prabhdeep Kaur",1710419);
		Student s5 = new Student("Priya Sharma",1710422);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		

		Iterator  iterator  =list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		/*
		  for(int i=0; i<list.size(); i++) {
		 
			System.out.println(list.get(i));
		}
		
		*/
		
		/*
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).name+" : "+list.get(i).rollno);
		};
       */
		
		/*
		for(Student student : list) {
			System.out.println(student.name+" : "+student.rollno);
		}
		
		*/
		
	}
	

}
