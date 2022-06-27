package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetDemos {

	public static void main(String[] args) {
		HashSet h = new HashSet();
		LinkedHashSet h1 = new LinkedHashSet();
		
        h.add(20);
        h.add(30);
        h.add(60);
        h.add(70);
        h.add(10);
        h.add(90);
        
        System.out.println("HashSet = "+h);
        
        
        h1.add(20);
        h1.add(30);
        h1.add(60);
        h1.add(70);
        h1.add(10);
        h1.add(90);
        
        System.out.println("LinkedHasSet = "+h1);
 
	}

}
