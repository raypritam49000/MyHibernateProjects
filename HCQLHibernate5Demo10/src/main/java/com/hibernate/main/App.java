package com.hibernate.main;

import com.hibernate.model.Teacher;
import com.hibernate.session.SessionProvider;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Teacher t1 = new Teacher("Pritam Ray", "Ropar", "pray4900@gmail.com", 27, "Punjab");
        Teacher t2 = new Teacher("Omi Verma", "Rail", "OmiVrema8745@gmail.com", 23, "Punjab");
        Teacher t3 = new Teacher("Chandan Kumar", "Prem Nagar", "Chandu120@gmail.com", 33, "Punjab");
        Teacher t4 = new Teacher("Deepak Kumar", "Asron", "Deepak432@gmail.com", 20, "Delhi");
        Teacher t5 = new Teacher("Ajit Kumar", "Prem Nagar", "Ajit765@gmail.com", 33, "Punjab");
        Teacher t6 = new Teacher("Amit Kumar", "RB Colony", "AmitSahani7860@gmail.com", 32, "Punjab");
        Teacher t7 = new Teacher("Chandan Sharma", "Shiv Mandir", "Chandu860@gmail.com", 30, "Punjab");

        session.beginTransaction();

        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        session.persist(t5);
        session.persist(t6);
        session.persist(t7);

        session.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Teacher> root = criteriaQuery.from(Teacher.class);

        Path<Object> teacherIdPath = root.get("id");
        Path<Object> teacherNamePath = root.get("name");
        Path<Object> teacherEmailPath = root.get("email");
        Path<Object> teacherAgePath = root.get("age");
        Path<Object> teacherCityPath = root.get("city");

        //criteriaQuery.select(criteriaBuilder.array(teacherIdPath, teacherNamePath, teacherEmailPath, teacherAgePath, teacherCityPath));
          criteriaQuery.multiselect(teacherIdPath, teacherNamePath, teacherEmailPath, teacherAgePath, teacherCityPath);
          
        Query query = session.createQuery(criteriaQuery);
        List<Object[]> teacherList = query.getResultList();

        for (Object[] objects : teacherList) {
            System.out.println("TeacherId : " + (Integer)objects[0]);
            System.out.println("TeacherName : " + (String)objects[1]);
            System.out.println("TeacherEmail : " + (String)objects[2]);
            System.out.println("TeacherAge : " + (Integer)objects[3]);
            System.out.println("TeacherCity : " + (String)objects[4]);
        }

    }

}
