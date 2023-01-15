package collection;

import java.util.Hashtable;

public class HashTableDemo {

	public static void main(String[] args) {
		Hashtable map = new Hashtable();
        Hashtable map1 = new Hashtable();
		
		map.put(1,"Pritam Ray");
		map.put(2,"Protima Ray");
		map.put(3,"Rohit Sharma");
		map.put(4,"Raj Kishor");
		map.put(5,"Ram Gupta");
		//map.put(null, "s");
		
	    boolean b = map.isEmpty();
	    System.out.println("HashTable is empty or not = "+map);
	    
	    System.out.println("EnterySet = "+map.entrySet());
	    
	    System.out.println("Result1 = "+map.containsValue("Ram Gupta"));
	    
	    System.out.println("Result2 = "+map.containsKey(4));
	    
	    System.out.println("Value = "+map.get(5));
	    
	    System.out.println("Class Name = "+map.getClass());
	    
	    System.out.println("HashTable Size = "+map.size());
	    
	    System.out.println("KeySet = "+map.keySet());
	    
	    System.out.println("MapHashTable = "+map.hashCode());
	    
	    System.out.println("Resut3 = "+map.putIfAbsent(4,50));
	    
	    System.out.println("Value = "+map.values());
	    
	    map1.putAll(map);
	    
	    System.out.println("map1 = "+map1);
	    
	    Hashtable map3 = (Hashtable) map.clone();
	    System.out.println("Map3 = "+map3);
	    
	}
}
