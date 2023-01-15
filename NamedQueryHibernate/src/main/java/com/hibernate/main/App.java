package com.hibernate.main;

import com.hibernate.model.Student;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Student st1 = new Student("Pritam Ray", "Ropar", 869953568l, 25);
        Student st2 = new Student("Omi Verma", "Prem Nagar", 653333568l, 21);
        Student st3 = new Student("Chandan Kumar", "Rail", 869953568l, 23);
        Student st4 = new Student("Raj Kumar", "UK", 869953568l, 28);
        Student st5 = new Student("Suarj Kumar", "UK", 745443438l, 38);
        Student st6 = new Student("Amit Kumar", "RB Colony", 544333568l, 38);
        Student st7 = new Student("Ajit Kumar", "Ram Pur", 869544568l, 28);
        Student st8 = new Student("Rahul Kumar", "UK", 868664568l, 28);

        session.beginTransaction();

        session.persist(st1);
        session.persist(st2);
        session.persist(st3);
        session.persist(st4);
        session.persist(st5);
        session.persist(st6);
        session.persist(st7);
        session.persist(st8);

        session.getTransaction().commit();

//      Query query = session.getNamedQuery("student.byId");
//      query.setInteger("id",3);
//          Query query = session.getNamedQuery("student");
        Query query = session.getNamedQuery("student.byName");
        query.setString(1, "Amit Kumar");

        List<Student> students = query.list();
        for (Student st : students) {
            System.out.println(st.getStudentId() + " " + st.getStudentName() + " " + st.getStudentCity() + " " + st.getStudentAge() + " " + st.getStudentMobile());
        }
    }

}
