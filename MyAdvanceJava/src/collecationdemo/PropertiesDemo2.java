package collecationdemo;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo2 {

	public static void main(String[] args) {
		try{
			Properties p = System.getProperties();
			Set s = p.entrySet();
			
		    Iterator iterator = s.iterator();
		    while(iterator.hasNext()) {
		    Map.Entry m	= (Map.Entry)iterator.next();
		    System.out.println(m.getKey()+" "+m.getValue());
		    }
		}
		catch(Exception e) {
			
		}

	}

}
