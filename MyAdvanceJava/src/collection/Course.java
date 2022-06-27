package collection;

import java.util.ArrayList;

public class Course {
private String courseName;
private int noOfStudents;
private String teacher;
public static int instances;
private ArrayList<StudentsDemo> list;


public Course() {
	instances++;
	this.noOfStudents = 0;
	this.courseName = "Not Set";
	this.teacher = "Not Set";
}

public Course(int noOfStuents, String couseName, String teacher) {
	this.list = new ArrayList<StudentsDemo>();
	this.courseName = courseName;
	this.teacher = teacher;
}

	public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public int getNoOfStudents() {
	return noOfStudents;
}

public void setNoOfStudents(int noOfStudents) {
	this.noOfStudents = noOfStudents;
}

public String getTeacher() {
	return teacher;
}

public void setTeacher(String teacher) {
	this.teacher = teacher;
}


public boolean addStudent(StudentsDemo student) {
	if(student==null || list.contains(student)) {
		return false;
	}
	else{
	list.add(student);
	return true;
	}
}

public void printStudents() {
	for(StudentsDemo s : list) {
		System.out.println(s.getName()+", with "+s.getAge()+" year(s)");
	}
}

public static class StudentsDemo{
	private int number;
	private String name;
	private int age;
	
	public StudentsDemo(int number,String name,int age) {
		this.number = number;
		this.name = name;
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
	public static void main(String[] args) {
		Course oop = new Course(37,"Java","Pritam Ray");
	    Course.StudentsDemo s1 = new Course.StudentsDemo(6,"Pritam Ray",23);
	    Course.StudentsDemo s2 = new Course.StudentsDemo(5,"RajniKant",19);
	    Course.StudentsDemo s3 = new Course.StudentsDemo(10,"Omi Verma",24);
	    Course.StudentsDemo s4 = new Course.StudentsDemo(9,"Chandan Kumar",23);
	    Course.StudentsDemo s5 = new Course.StudentsDemo(13,"Prabhdeep Kaur",28);
        Course.StudentsDemo s6 = new Course.StudentsDemo(18,"Suray Parkaash Tripathi",26);
        Course.StudentsDemo s7 = new Course.StudentsDemo(17,"Raj Kumar",29);
         
        oop.addStudent(s1);
        oop.addStudent(s2);
        oop.addStudent(s3);
        oop.addStudent(s4);
        oop.addStudent(s5);
        oop.addStudent(s6);
        oop.addStudent(s7);
        
        oop.setCourseName("Java");
        
        System.out.println(oop.getCourseName()+" has the following students");
        oop.printStudents();

	}

}
