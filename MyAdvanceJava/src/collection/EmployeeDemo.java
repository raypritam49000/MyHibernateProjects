package collection;

import java.util.ArrayList;
import java.util.Iterator;

class EmployeeTest{
	 String name;
		int id;
		float salary;
		Address addr;

		 EmployeeTest(int id,String name,float salary){
			this.id = id;
			this.name = name;
			this.salary = salary;
			addr = new Address("Prem Nagar","Punjab","India");
		}
		
		public String toString() {
			return id+" ; "+name+" ; "+salary+" ; "+addr.city+" ; "+addr.state+" ; "+addr.country; 
		}
		
		  public void show() {
				System.out.println("Employee id = "+id);
				System.out.println("Employee name = "+name);
				System.out.println("Employee salary = "+salary);
				System.out.println("Emplyee City = "+addr.city);
				System.out.println("Emplyee State = "+addr.state);
				System.out.println("Emplyee Country = "+addr.country);
			  }
			
		
}

class Address{
	String city,state,country;
	
	Address(String city,String state,String country){
		this.city = city;
		this.state = state;
		this.country = country;
	}
}

public class EmployeeDemo{
	
	public static void main(String[] args) {
		
	ArrayList<EmployeeTest>	list = new ArrayList<EmployeeTest>();
	
	EmployeeTest e1 = new EmployeeTest(123,"Pritam Ray",30000.0f);
	EmployeeTest e2 = new EmployeeTest(321,"Omi Verma",20000.4f);
	EmployeeTest e3 = new EmployeeTest(432,"Chandan Kumar",32000.54f);
     
	list.add(e1);
	list.add(e2);
	list.add(e3);
	
    Iterator iterator =	list.iterator();
    while(iterator.hasNext()) {
    	System.out.println(iterator.next());
    }
	
	}
	
}