package collection;

import java.util.ArrayDeque;

public class ArrayDequeueDemo {

	public static void main(String[] args) {
		
		ArrayDeque queue = new ArrayDeque();
		
		queue.add("10");
		queue.add("Amit");  
		queue.add("Vijay");  
		queue.add("Karan");  
		queue.add("Jai");  
		queue.add("Rahul");  
		queue.add("45.65");
		queue.add("34l");
		queue.add("34.65f");
		queue.add("q");
		
		System.out.println("Queue = "+queue);
		
		queue.addFirst(30);
		queue.addLast(100);
		System.out.println("Queue = "+queue);
		
		System.out.println("First Element = "+queue.element());
		
		System.out.println("First Element = "+queue.getFirst());
		System.out.println("Last Element = "+queue.getLast());
		System.out.println("Class = "+queue.getClass());
		System.out.println("Hashcode = "+queue.hashCode());
		
		

	}

}
