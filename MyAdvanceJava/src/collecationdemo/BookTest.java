package collecationdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		
		Book b1 = new Book("C++","Chandan Kumar",325);
		Book b2 = new Book("Java","Pritam Ray",225);
		Book b3 = new Book("python","Omi Verma",425);
		Book b4 = new Book("PHP","Suraj Mehta",135);
		Book b5 = new Book("Kotlin","Gautam Kumar",725);
		
		List list = new ArrayList();
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		
       Iterator iterator = list.iterator();
       while(iterator.hasNext()) {
    	   Book b = (Book)iterator.next();
    	   b.show();
       }
		

	}

}

class Book{
	String name,author;
	double price;
	
	Book(String name,String author,double price){
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	Comparable c = new Comparable() {

		@Override
		public int compareTo(Object o) {
			Book b = (Book)o;
			return name.compareTo(b.name);
		}
		
	};
	
    public void show() {
    	System.out.println(name+" "+author+" "+price);
    }
}