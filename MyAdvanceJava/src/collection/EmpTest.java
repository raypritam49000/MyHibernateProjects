package collection;

import java.util.HashSet;
import java.util.Iterator;

class Emp{
	int id,age;
	String name;
	Salary123 sal;
	Address12 addr;
	
	Emp(int id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
		sal = new Salary123(10000,20000,25000);
		addr = new Address12("Prem Nagar","Punjab","India");
		
	}
	
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
	
 @Override
    public int hashCode()
   {
	return id*100;
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
	return ""+id+" "+name+" "+age+" "+"\n"+addr.city+" "+addr.state+" "+addr.country+"\n"+sal.da+" "+sal.ta+" "+sal.hra;
	 
 }
 
}

class Salary123{
	double ta,da,hra;
	
	Salary123(double ta,double da,double hra){
		this.ta = ta;
		this.da = da;
		this.hra = hra;
	}
}

class Address12{
	String city,state,country;
	
	Address12(String city,String state,String country){
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
}

public class EmpTest {

	public static void main(String[] args) {
		HashSet<Emp> set = new HashSet<Emp>();
		
		Emp e1 = new Emp(1,"Pritam Ray",23);
		Emp e2 = new Emp(1,"Protima Ray",43);
		Emp e3 = new Emp(2,"Omi Verma",25);
		Emp e4 = new Emp(3,"Ram Kumar",28);
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
        Iterator<Emp> iterator = set.iterator();
        while(iterator.hasNext()) {
        	Emp emp = (Emp)iterator.next();
        	emp.show();
        	
        }

	}

}
