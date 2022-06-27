package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

import javax.sound.midi.spi.SoundbankReader;
import javax.swing.plaf.synth.SynthStyle;

public class VectorDemo {

	public static void main(String[] args) {
		Vector v = new Vector(11,40);
		
		System.out.println(v.isEmpty());
		System.out.println(v.capacity());
		System.out.println(v.size());
		
		
		v.add("10");
		v.add(20);
		v.add(23.54);
		v.add("Ram");
		v.add(45.5f);
		v.add(34);
		v.add(45);
		v.add('c');
		v.add('c');
		v.add('c');
		v.add('c');
		v.add('c');
		
		System.out.println("List = ");
		Iterator iterator = v.iterator();
		while(iterator.hasNext()) {
			System.out.print(" "+iterator.next());
		}
		
		System.out.println(v.isEmpty());
		System.out.println(v.capacity());
		System.out.println(v.size());
		
		System.out.println(v.get(3));
		System.out.println(v.contains(45.5f));
		
		v.addElement(23);
		v.add(6, 125);
		
		System.out.print("List = ");
	    Enumeration enumeration = v.elements();
	    while(enumeration.hasMoreElements()) {
	    	System.out.print(" "+enumeration.nextElement());
	    }
	    System.out.println();
		
	   System.out.print("List = ");
	   ListIterator listIterator = v.listIterator();
	   while(listIterator.hasNext()) {
		   System.out.print(" "+listIterator.next());
	   }
	   
	   System.out.println();
	   System.out.print("List = ");
	   while(listIterator.hasPrevious()) {
		  System.out.print(" "+listIterator.previous());
	  }
	   
}

}
