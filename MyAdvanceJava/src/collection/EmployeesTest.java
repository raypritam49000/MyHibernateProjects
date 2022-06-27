package collection;

import java.util.Iterator;
import java.util.LinkedList;

class Employees{
	int id,age;
	String name;
	Salary sal;
	Address123 add;
	
	
	public Employees(int id,String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		sal = new Salary(10000,15000,25000);
		add = new Address123("Prem Nagar","Punjab","India");
	}
	
	public String toString() 
	{
	return name+" "+id+" "+age+" "+sal.ta+" "+sal.da+" "+sal.hra+" "+add.city+" "+add.state+" "+add.country;
	}
	
	public void show() {
		System.out.println("Employee id = "+id);
		System.out.println("Employee name = "+name);
		System.out.println("Employee Ta = "+sal.ta);
		System.out.println("Employee Da = "+sal.da);
		System.out.println("Emplyee Hra = "+sal.hra);
		System.out.println("Emplyee City = "+add.city);
		System.out.println("Emplyee State = "+add.state);
		System.out.println("Emplyee Country = "+add.country);
	}
	
}

class Salary{
	double ta,da,hra;
	
	public Salary(double ta,double da,double hra) {
		this.ta = ta;
		this.da = da;
		this.hra = hra;
	}
}

class Address123{
	String city,state,country;
	
	public Address123(String city,String state,String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}
}


public class EmployeesTest {

	public static void main(String[] args) {
		
		LinkedList<Employees> list = new LinkedList<Employees>();
		
		Employees e1 = new Employees(123,"Pritam Ray",30);
		Employees e2 = new Employees(321,"Omi Verma",25);
		Employees e3 = new Employees(432,"Chandan Kumar",32);
	     
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
	Iterator iterator = list.iterator();
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
	
		

	}

}
