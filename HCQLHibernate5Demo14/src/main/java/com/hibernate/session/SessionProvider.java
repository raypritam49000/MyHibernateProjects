package com.hibernate.session;

import com.hibernate.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class SessionProvider {

    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        configuration.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        configuration.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/orm");
        configuration.setProperty(Environment.USER, "root");
        configuration.setProperty(Environment.PASS, "1998");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "create");
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.FORMAT_SQL, "true");
        configuration.addAnnotatedClass(Teacher.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;

    }
}
