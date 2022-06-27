package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GfG {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		
		map.put(1,"Pritam Ray");
		map.put(2,"Protima Ray");
		map.put(3,"Rohit Sharma");
		map.put(4,"Raj Kishor");
		map.put(5,"Ram Gupta");
		
		System.out.println("Created hashmap is : "+map);
		
		System.out.println("Iterator = ");
		System.out.print("Map = ");
		Iterator iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
		Map.Entry m	= (Map.Entry)iterator.next();
		System.out.print(m.getKey()+" : "+m.getValue()+" ; ");
		}
		System.out.println();
		
		System.out.println("Enhance For Loop = ");
		System.out.print("Map = ");
		for(Map.Entry m1 : map.entrySet()) {
			System.out.print(m1.getKey()+" : "+m1.getValue()+" ; ");
		}

	}

}
