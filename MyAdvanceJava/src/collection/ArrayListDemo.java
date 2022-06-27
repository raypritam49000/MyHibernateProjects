package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(50);
		ArrayList list2 = new ArrayList();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		ArrayList list4 = new ArrayList(list3);
	
		System.out.println("ArrayLst Size = "+list1.size());
		System.out.println(list1.isEmpty());
		
		list1.add(5);
		list1.add("Ram Kumar");
		list1.add(56.78);
		list1.add(true);
		list1.add(2,30.5f);
		list1.add(3,'p');
		list1.add(10);
		
		System.out.println("List1 = "+list1);
		
		System.out.println("ArrayLst Size = "+list1.size());
		System.out.println(list1.isEmpty());
		
		list1.set(1,13);
		list1.set(3,15);
		list1.set(5,20);
		
		System.out.println("List1 = "+list1);
		System.out.println(list1.isEmpty());
		
		System.out.println(list1.contains(10));
		System.out.println(list1.get(4));
		System.out.println(list1.indexOf(13));
		//System.out.println(list.retainAll(list));
		
		list1.trimToSize(); // reduce capacity 50 to 10
		System.out.println("List1 = "+list1);
		
		list2.add(5);
		list2.add(10);
		list2.add(40);
		list2.add(54);
		list2.add(13);
		list2.add(3);
		list1.add(20);
		
		System.out.println("List2 = "+list2);
		System.out.println("ArrayList Size = "+list2.size());
		
		ArrayList list5 = new ArrayList();
		ArrayList list6 = new ArrayList();
		
		list5.add(10);
		list5.add(30);
		list5.add(50);
		list5.add(60);
		list5.add(70);
		
		list6.add(210);
		list6.add(100);
		list6.add(30);
		list6.add(60);
		list6.add(50);
		
		list5.removeAll(list6);
		
		System.out.println("List5 = "+list5);
		
		for(Object x : list5) {
			System.out.print(" "+x);
		}
		System.out.println();
		
		list3.add(45);
		list3.add(150);
		list3.add(410);
		list3.add(542);
		list3.add(143);
		list3.add(32);
		list3.add(201);
		
		System.out.println("List3 = "+list3);
		System.out.println("List4 = "+list4);
		
		list1.ensureCapacity(60);
		System.out.println("List1 = "+list1);
		
		list4 = list1;
        System.out.println("List4 = "+list4);
		
		System.out.println(list1.containsAll(list4));
		
		System.out.println(list1.getClass());

		list1.addAll(list2);
		list1.addAll(2,list3);
		
		System.out.println("List1 = "+list1);
		System.out.println("List1 = "+list1.size());
		
		list4.clear();
		
		System.out.println("List4 = "+list4);
		
		list3.remove(0);
		System.out.println("List3 = "+list3);
		
		list1.add(5);
		list1.add("Ram Kumar");
		list1.add(56.78);
		list1.add(true);
		list1.add(2,30.5f);
		list1.add(3,'p');
		list1.add(10);
		
		list1.addAll(list2);
		list1.addAll(2,list3);
		System.out.println("List1 = "+list1);
		list1.removeAll(list3);
		System.out.println("List1 = "+list1);
		
		System.out.print("Elements in list is : ");
		list1.forEach((n)->print(n));
		
		System.out.println();
		System.out.println(list1.equals(list4));
		
		}
	
	public static void print(Object n) {
		System.out.print(" "+n);
	}

}
