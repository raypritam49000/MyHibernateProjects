package collection;

import java.util.HashMap;
import java.util.function.BiFunction;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		HashMap map1 = new HashMap();
		
		map.put(1,"Pritam Ray");
		map.put(2,"Protima Ray");
		map.put(3,"Rohit Sharma");
		map.put(4,"Raj Kishor");
		map.put(5,"Ram Gupta");
		
	    boolean b = map.isEmpty();
	    System.out.println("HashMap is empty or not = "+map);
	    
	    System.out.println("EnterySet = "+map.entrySet());
	    
	    System.out.println("Result1 = "+map.containsValue("Ram Gupta"));
	    
	    System.out.println("Result2 = "+map.containsKey(4));
	    
	    System.out.println("Value = "+map.get(5));
	    
	    System.out.println("Class Name = "+map.getClass());
	    
	    System.out.println("HaspMap Size = "+map.size());
	    
	    System.out.println("KeySet = "+map.keySet());
	    
	    System.out.println("MapHashCode = "+map.hashCode());
	    
	    System.out.println("Resut3 = "+map.putIfAbsent(4,50));
	    
	    System.out.println("Value = "+map.values());
	    
	    map1.putAll(map);
	    
	    System.out.println("map1 = "+map1);
	    
	    HashMap map3 = (HashMap) map.clone();
	    System.out.println("Map3 = "+map3);
	    
	   // map.merge(7,"RajniKant Gupta", );
	    
	  
	}

}
