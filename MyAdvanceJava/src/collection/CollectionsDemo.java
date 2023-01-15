package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {
	
		ArrayList list = new ArrayList();
		
		list.add(10);
		list.add(60);
		list.add(30);
		list.add(50);
		list.add(40);
		list.add(70);
		list.add(80);
		list.add(45);
		list.add(130);
		
		ArrayList list1 = new ArrayList();
		list1.add(101);
		list1.add(602);
		list1.add(303);
		list1.add(506);
		list1.add(406);
		list1.add(705);
		list1.add(801);
		list1.add(451);
		list1.add(1301);
		list1.add(234);
		
		
		System.out.println("List Size = "+list.size());
		//System.out.println("List1 ");
		/*
		System.out.println("List = "+list);
		
		Collections.reverse(list);
		System.out.println("Reverse List = "+list);
		
		Collections.shuffle(list);
		System.out.println("List = "+list);
		
		Collections.sort(list);
		System.out.println("Sorted List = "+list);
		
        Object max = Collections.max(list);
        System.out.println("Maximun Value = "+max);
        
        Object min = Collections.min(list);
        System.out.println("Minimun Value = "+min);
        
        Collections.swap(list,0,2);
        System.out.println("Swap List = "+list);
        
        int index = Collections.binarySearch(list,30);
        System.out.println("Index = "+index);
        
        Collections.checkedList(list,Object.class);
        System.out.println("Typesafe view of List = " + list); 
        
        Collections.checkedCollection(list,Object.class);
        System.out.println("Typesafe view of Collection = "+list);
        
        List emptyList = Collections.emptyList();
        System.out.println("Empty List = "+emptyList);
        */
        
        Collections.copy(list1,list);
        System.out.println("List1 = "+list1);
        
      
        
        List l = Collections.unmodifiableList(list);
        System.out.println("List = "+l);
        
       System.out.print("List = ");
       Iterator iterator =  l.iterator();
       while(iterator.hasNext()) {
    	   System.out.print(" "+iterator.next());
       }
       
        //  l.add(45);    //UnsupportedOperationException
       }
}
