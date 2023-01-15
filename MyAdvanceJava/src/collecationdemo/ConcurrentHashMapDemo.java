package collecationdemo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		ConcurrentHashMap map = new ConcurrentHashMap();
		
		map.put(2,"Ram Singh");
		map.put(5, "Raj Kumar");
		map.put(65, "JP Verma");
		map.put(4,"Pritam Ray");
		
		Set s = map.entrySet();
		Iterator it = s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			map.put(100,"Montu Mehta");
			map.put(200,"Omi Verma");
		}
		System.out.println("----------------------------------");
		System.out.println("Map = "+map);

	}

}
