package com.hibernate.main;

import com.hibernate.model.Emp;
import com.hibernate.session.SessionProvider;
import static com.hibernate.session.SessionProvider.getSession;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.jandex.Main;

public class App {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);

        Emp e1 = new Emp("Pritam Ray", 25, 45000, "Asron", "Ropar", "Punjab", "India");
        Emp e2 = new Emp("Pritam Ray", 25, 35000, "Prem Nagar", "Ropar", "Punjab", "India");
        Emp e3 = new Emp("Suraj Mehta", 25, 15000, "UK", "Ropar", "Punjab", "India");
        Emp e4 = new Emp("Omi Verma", 25, 25000, "Bihar", "Ropar", "Punjab", "India");
        Emp e5 = new Emp("Chandan Kumar", 25, 65000, "RamNagar", "Ropar", "Punjab", "India");
        Emp e6 = new Emp("Gautam Kumar", 25, 65000, "Rail", "Ropar", "Punjab", "India");
        Emp e7 = new Emp("Sham Kumar", 25, 65000, "Asron", "Ropar", "Punjab", "India");
        Emp e8 = new Emp("Rajesh Kumar", 25, 95000, "Asron", "Ropar", "Punjab", "India");
        Emp e9 = new Emp("Ajit Kumar", 25, 65000, "Asron", "Ropar", "Punjab", "India");

        session.beginTransaction();

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        session.persist(e4);
        session.persist(e5);
        session.persist(e6);
        session.persist(e7);
        session.persist(e8);
        session.persist(e9);

        session.getTransaction().commit();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Emp> criteriaQuery = criteriaBuilder.createQuery(Emp.class);
        Root<Emp> root = criteriaQuery.from(Emp.class);
        criteriaQuery.select(root);
       

        Query<Emp> query = session.createQuery(criteriaQuery);
        query.setFirstResult(2);
        query.setMaxResults(4);

        List list = query.list();
        for (int i = 0; i <= list.size() - 1; i++) {
            System.out.println(list.get(i));
        }

        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Emp> q = builder.createQuery(Emp.class);
        Root<Emp> usr = q.from(Emp.class);

        ParameterExpression<String> p = builder.parameter(String.class);
        q.orderBy(builder.asc(usr.get("name")));

        TypedQuery<Emp> query1 = getSession().createQuery(q);
        List<Emp> list1 = query1.getResultList();

        for (int i = 0; i <= list1.size() - 1; i++) {
            System.out.println(list1.get(i));
        }
    }

}
