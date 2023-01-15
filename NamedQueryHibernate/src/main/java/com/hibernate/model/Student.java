package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "student")
//@NamedQuery(name="student.byId",query = "from Student where studentId = : id ")
//@NamedQuery(name="student",query = "from Student ")
@NamedNativeQuery(name = "student.byName", query = "select * from student where studentname = ?", resultClass = Student.class)
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    private String studentCity;
    private long studentMobile;
    private int studentAge;

    public Student() {
    }

    public Student(String studentName, String studentCity, long studentMobile, int studentAge) {
        this.studentName = studentName;
        this.studentCity = studentCity;
        this.studentMobile = studentMobile;
        this.studentAge = studentAge;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

}
