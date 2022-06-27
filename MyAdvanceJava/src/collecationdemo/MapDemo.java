package collecationdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put(1, "Ram");
		map.put(1, "Ram");
		map.put(1, "Ram");
		map.put(2, "Raj");
		map.put(2, "Raj");
		map.put(2, "Raj");
		
		Set s = map.entrySet();
		Iterator iterator = s.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		

	}

}
