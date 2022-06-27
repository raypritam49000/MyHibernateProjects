package collection;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
	 LinkedHashSet set = new LinkedHashSet();
	 LinkedHashSet set1 = new LinkedHashSet();
	 
	 
	    set.add(45);
	    set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(50);
		set.add(60);
		set.add(70);
		set.add(80);
		set.add(90);
		set.add(100);
		set.add(110);
		set.add(120);
		
		System.out.println("Set = "+set);
		
		System.out.print("Set = ");
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.print(" "+iterator.next());
		}
		System.out.println();
		
		boolean b = set.contains(10);
		System.out.println("Result1 = "+b);
		
		   set1.add(35);
			set1.add(22);
			set1.add(12);
			set1.add(65);
			set1.add(55); 
			set1.add(10);
			set1.add(20);
			set1.add(30);
			set1.add(40);
			set1.add(50);
		
		System.out.print("Set1 = ");
		Iterator iterator1 = set1.iterator();
		while(iterator1.hasNext()) {
			System.out.print(" "+iterator1.next());
		}
		System.out.println();
		
		//set.toArray();
		System.out.print("Array = ");
		for(Object x : set.toArray()) {
			System.out.print(" "+x);
		}
		System.out.println();
		
		System.out.println("Result2 = "+set.containsAll(set1));
		
		System.out.println("Set is Empty ? : "+set.isEmpty());
		
		System.out.println("Class name : "+set.getClass());
		
		System.out.println("HashCode = "+set.hashCode());
		
		System.out.println("Set size = "+set.size());
		
		System.out.println("set and set1 is equal or not ? "+set.equals(set1));
		
		System.out.println("Common Elements Present or not ? : "+set.retainAll(set1));
		
		set.retainAll(set1);
		System.out.println("Set = "+set);
		
		set1.addAll(set);
		System.out.println("Set1 = "+set1);
		
		set.remove(10);
		System.out.println("Set = "+set);
		
		set.removeAll(set1);
		System.out.println("Set = "+set);
		
		set1.clear();
		
		System.out.println("Set1 = "+set1);
		
		

	}

}
