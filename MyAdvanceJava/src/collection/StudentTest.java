package collection;

import java.util.ArrayList;
import java.util.Collections;

public class StudentTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		Test t1 = new Test(60,"Pritam Ray",397);
		Test t2 = new Test(50,"Rahul Kumar",1797);
		Test t3 = new Test(80,"Rohit Raj",457);
		Test t4 = new Test(10,"Omi Verma",897);
		Test t5 = new Test(30,"Vishal Kumar",697);
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		
		Collections.sort(list);
		System.out.println("Increasing Order : "+list);
		
		Collections.sort(list,Collections.reverseOrder());
		
		System.out.println("Decreasing Order : "+list);
	}
}


class Test implements Comparable{
	String name;
	int marks,rollno;
	
	
	Test(int rollno,String name,int marks){
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}


	@Override
	public int compareTo(Object o) {
		Test t = (Test)o;
		if(this.marks>t.marks) {
			return 1;
		}
		else if(this.marks<t.marks) {
			return -1;
		}
		else {
		return 0;
		}
	}
	
	public String toString() {
		return ""+rollno+" "+name+" "+marks;
		
	}
}
