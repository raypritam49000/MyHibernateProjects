package collecationdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
	
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
	       Integer n = iterator.next();
	       System.out.println(n);
	       //iterator.remove();
	       //list.add(70);	
		}
		System.out.println("----------------------------------------");
		System.out.println("List = "+list);

	}

}
