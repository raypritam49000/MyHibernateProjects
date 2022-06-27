package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Set s = new HashSet();
		HashSet<Set> set = new HashSet<>();
		
		System.out.println("Set is Empty ? : "+s.isEmpty());
		System.out.println("Set Size : "+s.size());
		System.out.println("Result : "+s.contains(10));
		System.out.println("Set : "+s);
		
		s.add(10);
		s.add(10);
		s.add(20);
		s.add(39);
		s.add(40);
		s.add(203);
		s.add(23);
		s.add(2);
		
		
		System.out.println("Set is Empty ? : "+s.isEmpty());
		System.out.println("Set Size : "+s.size());
		System.out.println("Result1 : "+s.contains(10));
		System.out.println("Set : "+s);
		
		s.remove(10);
		System.out.println("Set : "+s);
		System.out.println("Result2 : "+s.remove(10));
		
		set.addAll(s);
		System.out.println("Set : "+set);
		
		boolean b = s.equals(set);
		System.out.println("s is equal or not equal to set  = "+b);
		
		
		

	}

}
