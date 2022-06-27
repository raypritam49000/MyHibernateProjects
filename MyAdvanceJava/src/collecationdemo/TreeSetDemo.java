package collecationdemo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) 
    {
      Student1 st1 = new Student1(123,"Prem",25);
      Student1 st2 = new Student1(45,"Ram",30);
      Student1 st3 = new Student1(543,"Sham",50);
      Student1 st4 = new Student1(132,"Raj",65);

     Comparator c1 = new NameComprater();
     Comparator c2 = new AgeComprater();
     Comparator c3 = new IdComprater();

      TreeSet set = new TreeSet(c1);
      set.add(st1);
      set.add(st2);
      set.add(st3);
      set.add(st4);

     // System.out.println(set);
      
     Iterator iterator = set.iterator();
     while(iterator.hasNext()) {
    	Student1 s =(Student1)iterator.next();
    	s.show();
     }
      

    }
    
}

class Student1
{
    String name;
    int id;
    int age;

    Student1(int id, String name, int age){
       this.name = name;
       this.id = id;
       this.age = age;
    }
    
    public void show() {
    	System.out.println(id+" "+name+" "+age);
    }

}

class IdComprater implements Comparator{

    public int compare(Object o1, Object o2){
        Student1 s1 = (Student1)o1;   
        Student1 s2 = (Student1)o2;
        if(s1.id>s2.id)  return 1;
        else if(s1.id<s2.id)  return -1;
         return 0;
        }
}

class AgeComprater implements Comparator{

    public int compare(Object o1, Object o2){
        Student1 s1 = (Student1)o1;   
        Student1 s2 = (Student1)o2;
        if(s1.age>s2.age)  return 1;
        else if(s1.age<s2.age)  return -1;
         return 0;
        }
}

class NameComprater implements Comparator{

    public int compare(Object o1, Object o2){
        Student1 s1 = (Student1)o1;   
        Student1 s2 = (Student1)o2;
         return s1.name.compareTo(s2.name);
        }
}