package collecationdemo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Student2 {
	String name;
	int id;
	int age;

	
	Student2(int id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
		
	}
	
	public void show() {
		System.out.println(id+" "+name+" "+age);
	}
}

public class TreeSetDemo2 {

	public static void main(String[] args) {
		
		 Student2 s1 = new Student2(123,"Prem",25);
	     Student2 s2 = new Student2(45,"Ram",30);
	     Student2 s3 = new Student2(543,"Sham",50);
	     Student2 s4 = new Student2(132,"Raj",65);
	
	 System.out.println("Sorting acc to id : ");
	 TreeSet set1 = new TreeSet(new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			if(s1.id>s2.id) {
				return 1;
			}else if(s1.id<s2.id) {
				return -1;
			}else {
				return 0;
			}
	}
	}); 
	 
	 set1.add(s1);
	 set1.add(s2);
	 set1.add(s3);
	 set1.add(s4);
	 
	 Iterator iterator1 = set1.iterator();
	 while(iterator1.hasNext()) {
		 Student2 s = (Student2)iterator1.next();
		 s.show();
	 }
	 System.out.println();
	 
	System.out.println("Sorting Acc to name : ");
	TreeSet set2 = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Student2 s1 = (Student2)o1;
				Student2 s2 = (Student2)o2;
				return s1.name.compareTo(s2.name);
		}
		});
	 
	 set2.add(s1);
	 set2.add(s2);
	 set2.add(s3);
	 set2.add(s4);
	 
	 
	 Iterator iterator2 = set2.iterator();
	 while(iterator2.hasNext()) {
		 Student2 s = (Student2)iterator2.next();
		 s.show();
	 }
	 System.out.println();
	 
	 System.out.println("Sorting acc to age : ");
	 TreeSet set3 = new TreeSet(new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			if(s1.age>s2.age) {
				return 1;
			}else if(s1.age<s2.age) {
				return -1;
			}else {
				return 0;
			}
	}
	}); 
	 
	 set3.add(s1);
	 set3.add(s2);
	 set3.add(s3);
	 set3.add(s4);
	 
	 Iterator iterator3 = set3.iterator();
	 while(iterator3.hasNext()) {
		 Student2 s = (Student2)iterator3.next();
		 s.show();
	 }
	 System.out.println();
	

	}

}

