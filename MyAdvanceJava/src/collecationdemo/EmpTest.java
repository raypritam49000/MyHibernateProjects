package collecationdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Emp{
	String name;
	int id;
    double salary;
    
    Emp(int id,String name,double salary){
    	this.id = id;
    	this.name = name;
    	this.salary = salary;
    }
    
    public String toString() {
		return ""+id+" "+name+" "+salary;
    	
    }
    
    void show() {
    	
    }
}

public class EmpTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put(40, new Emp(123,"Pritam Ray",20000.00));
		map.put(12, new Emp(113,"Ram Kumar",14000.00));
		map.put(30, new Emp(13,"Raj Kumar",67400.00));
		map.put(10, new Emp(133,"Suarj Kumar",10000.00));
		
	    Iterator iterator = map.entrySet().iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry m = (Map.Entry)iterator.next();
	    	System.out.println(m.getKey()+" : "+m.getValue());
	    }
	    
	}

}
