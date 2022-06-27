package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class HashMapSortedDemo {

	public static void main(String[] args) {
    HashMap<Integer,String> map = new HashMap<>();
		
		map.put(1,"Pritam Ray");
		map.put(8,"Protima Ray");
		map.put(7,"Rohit Sharma");
		map.put(4,"Raj Kishor");
		map.put(5,"Ram Gupta");   
		
		System.out.println("Before Sorting Hashmap = "+map);
		
		  
	TreeMap<Integer,String> sortedmap = new TreeMap<>();
		  
	sortedmap.putAll(map);
		  
    System.out.println("Sorted Map = "+sortedmap);
    
    ArrayList<Integer> sortedKeys = new ArrayList<Integer>(map.keySet());
    
    Collections.sort(sortedKeys);
    
    for(Integer x : sortedKeys) {
    	System.out.println("Key = "+x+", Value = "+map.get(x));
    }
		  

	}

}
