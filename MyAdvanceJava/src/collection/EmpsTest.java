package collection;

import java.util.Iterator;
import java.util.TreeSet;

 public class EmpsTest {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		
		Emps e1 = new Emps(12,"Pritam Ray");
		Emps e2 = new Emps(22,"Protima Ray");
		Emps e3 = new Emps(5,"Amit Kumar");
		Emps e4 = new Emps(15,"Suraj Mehta");
		Emps e5 = new Emps(10,"Raj Kumar");
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		//System.out.println(set);
		
	    Iterator iterator =	set.iterator();
	    while(iterator.hasNext()) {
	    	System.out.println(iterator.next());
	    }

	}

}
 
 class Emps implements Comparable{
	 String name;
	 int id;
	 
	 Emps(int id,String name){
		this.id = id;
		this.name = name;
	 }

	@Override
	public int compareTo(Object o) {
	 Emps e = (Emps)o;
       if(this.id>e.id)	
    	   return 1;
       else if(this.id<e.id)
    	   return -1;
       else
		return 0;
	}
	 
	public String toString() {
		return ""+id+" "+name;
	}
	 
}
