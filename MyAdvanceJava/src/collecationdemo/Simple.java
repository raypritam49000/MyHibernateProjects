package collecationdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Student{
	int rollno;
	int age;
	String name;
	
	Student(int rollno,String name,int age){
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}

class RollNoComprator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		if(s1.rollno>s2.rollno) return 1;
		else if(s1.rollno<s2.rollno) return -1;
		else return 0;
		
	}
	
}

class AgeComprator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		if(s1.age>s2.age) return 1;
		else if(s1.age<s2.age) return -1;
		else return 0;
		
	}
	
}


class NameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		return s1.name.compareTo(s2.name);
	}
	
}

public class Simple {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add(new Student(102,"Pritam Ray",25));
		list.add(new Student(420,"Raj Kumar",39));
		list.add(new Student(312,"Suraj Kumar",23));
		list.add(new Student(552,"Vishal Sharma",45));
		list.add(new Student(250,"Omi Verma",32));
		
		
		System.out.println("Sorting by Rollno :");
		Collections.sort(list,new RollNoComprator());
		Iterator iterator2 = list.iterator();
		while(iterator2.hasNext()) {
			Student st = (Student)iterator2.next();
			System.out.println(st.rollno+" "+st.name+" "+st.age);
		}
		System.out.println();
		
		System.out.println("Sorting by Name :");
		Collections.sort(list,new NameComparator());
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Student st = (Student)iterator.next();
			System.out.println(st.rollno+" "+st.name+" "+st.age);
		}
		System.out.println();
		

		System.out.println("Sorting by Age :");
		Collections.sort(list,new AgeComprator());
		Iterator iterator1 = list.iterator();
		while(iterator1.hasNext()) {
			Student st = (Student)iterator1.next();
			System.out.println(st.rollno+" "+st.name+" "+st.age);
          }

    }
}