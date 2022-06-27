package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class EmpTests{
	int id,age;
	String name;
	SalaryDemo sal;
	AddressDemo addr;
	
	EmpTests(int id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
		sal = new SalaryDemo(10000,20000,25000);
		addr = new AddressDemo("Prem Nagar","Punjab","India");
		
	}
	
	/*
	 public void show() {
		System.out.println("Id = "+id);
		System.out.println("Name = "+name);
		System.out.println("Age = "+age);
		System.out.println("Ta = "+sal.ta);
		System.out.println("Da = "+sal.da);
		System.out.println("Hra = "+sal.hra);
		System.out.println("City = "+addr.city);
		System.out.println("State = "+addr.state);
		System.out.println("Country = "+addr.country);
	}
	*/
	
 @Override
    public int hashCode()
   {
	return id*10;
   }
 
 @Override
public boolean equals(Object obj) {
	Emp e = (Emp)obj;
	if(e.id==this.id) {
		return true;
	}
	else {
		return false;
	}
}
 
 public String toString() {
	 return "Id = "+id+" Name = "+name+" Age = "+age+"\n"+"Ta = "+sal.ta+" Da = "+sal.da+" Hra = "+sal.hra+"\n"+"City = "+addr.city+" State = "+addr.state+" Country = "+addr.country;
 }
}

class SalaryDemo{
	double ta,da,hra;
	
	SalaryDemo(double ta,double da,double hra){
		this.ta = ta;
		this.da = da;
		this.hra = hra;
	}
}

class AddressDemo{
	String city,state,country;
	
	AddressDemo(String city,String state,String country){
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
}

public class EmpDemo {

	public static void main(String[] args) {
		HashMap<Integer,EmpTests> map = new HashMap<Integer,EmpTests>();
		
		EmpTests e1 = new EmpTests(1,"Pritam Ray",23);
		EmpTests e2 = new EmpTests(1,"Protima Ray",43);
		EmpTests e3 = new EmpTests(2,"Omi Verma",25);
		EmpTests e4 = new EmpTests(3,"Ram Kumar",28);
		EmpTests e5 = new EmpTests(6,"Chandan Kumar",38);
		EmpTests e6 = new EmpTests(3,"Sham Kumar",18);
		
		map.put(1,e1);
		map.put(1,e2);
		map.put(3,e3);
		map.put(4,e4);
		map.put(5,e5);
		map.put(6,e6);
		
       Iterator iterator = map.entrySet().iterator();
       while(iterator.hasNext()) {
       Map.Entry mapElement = (Map.Entry)iterator.next();
       System.out.println(mapElement.getKey()+" : "+mapElement.getValue());
       }
       
        System.out.println("2way ");
        Set s = map.entrySet();
        Iterator iterator2 = s.iterator();
        while(iterator2.hasNext()) {
        	System.out.println(iterator2.next());
        }
        

	}

}
