package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListDemo1 {

	public static void main(String[] args) throws Exception{

    ArrayList<Integer>list = new ArrayList<Integer>();
    
    list.add(10);
    list.add(70);
    list.add(30);
    list.add(50);
    list.add(400);
    list.add(100);
    list.add(450);
    list.add(550);
    list.add(100);
    
    
    System.out.println("List = "+list);
    
    //for loop for iterating ArrayList
    System.out.println("For Loop ->");
	System.out.print("List = ");
    for(int i=0; i<list.size(); i++) {
    	System.out.print(" "+list.get(i));
    }
    System.out.println();
    
    //Advance for loop for iterating ArrayList
    System.out.println("Advance for Loop ->");
	System.out.print("List = ");
    for(Integer num : list) {
    	System.out.print(" "+num);
    }
    System.out.println();
    
    
    //while loop for iterating ArrayList
    System.out.println("while Loop ->");
	System.out.print("List = ");
    int i = 0;
    while(list.size()>i) {
    	System.out.print(" "+list.get(i));
		i++;
    }
    System.out.println();
    
    

   //looping array  list using iterator
	System.out.println("Iterator->");
    System.out.print("List = ");
    Iterator iterator = list.iterator();
    while(iterator.hasNext()) {
   	 System.out.print(" "+iterator.next());
    }
    System.out.println();
    
     
     System.out.println();
     Collections.sort(list);
     System.out.println("Increments Order = "+list);
      
     Collections.sort(list,Collections.reverseOrder());
     System.out.println("Decrements Order = "+list);
      
     }
	
}


