package collecationdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		
		Book1 b1 = new Book1("C++","Chandan Kumar",325);
		Book1 b2 = new Book1("Java","Pritam Ray",225);
		Book1 b3 = new Book1("python","Omi Verma",425);
		Book1 b4 = new Book1("PHP","Suraj Mehta",135);
		Book1 b5 = new Book1("Kotlin","Gautam Kumar",725);
		
		HashMap map = new HashMap();
		
		map.put(34,b1);
		map.put(45,b2);
		map.put(10,b3);
		map.put(5,b4);
		map.put(1,b5);
		
       Set s = map.entrySet();   
       Iterator it = s.iterator();
       while(it.hasNext()) {
    	Map.Entry m = (Map.Entry)it.next();
    	Book1 b = (Book1)m.getValue();
    	b.show();
       }
	}

}

class Book1{
	String name,author;
	double price;
	
	Book1(String name,String author,double price){
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
    public void show() {
    	System.out.println(name+" "+author+" "+price);
    }
}
