package collection;

import java.util.Enumeration;
import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack s = new Stack();
		
		System.out.println("Stack = "+s);
		System.out.println("Capacity = "+s.capacity());
		System.out.println("is Stack empty = "+s.isEmpty());
		
		s.push(10);
		s.push(20);
		s.push(40);
		s.push(70);
		s.push(760);
		s.push(250);
		s.push(20);
		
		System.out.println("Stack = "+s);
		System.out.println("Capacity = "+s.capacity());
		System.out.println("is Stack empty = "+s.isEmpty());
		
		s.add(100);
		s.add(123);
		s.add(345);
		s.add(2, 400);
		s.add(5,453);
		s.push(67);
		s.push(567);
		
		System.out.println("Stack = "+s);
		System.out.println("Capacity = "+s.capacity());
		System.out.println("is Stack empty = "+s.isEmpty());
		
		System.out.print("Stack = ");
		Enumeration enumeration = s.elements();
		while(enumeration.hasMoreElements()) {
			System.out.print(" "+enumeration.nextElement());
		}
		
		System.out.println();
		Object index = s.get(4);
		System.out.println("Index = "+index);
		
       s.addElement(4646);
       s.addElement(57);
       System.out.println("Stack = "+s);
       
       
       Object e = s.elementAt(0);
       System.out.println("e = "+e);
       
       System.out.println("Last Element = "+s.peek());
       
       Object[] obj = s.toArray();
       
       System.out.print("Array = ");
       for(Object x : obj) {
    	  System.out.print(" "+x); 
       }
       System.out.println();
       System.out.println("First Element = "+s.firstElement()+", Last Element = "+s.lastElement());
       
       Object[] ob = new Object[s.size()];
       s.copyInto(ob);
       
       
	}

}
