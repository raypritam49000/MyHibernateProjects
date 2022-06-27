package com.hibernate.main;

import com.hibernate.model.Area;
import com.hibernate.model.Country;
import com.hibernate.model.State;
import com.hibernate.session.SessionProvider;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting the Projects......");
		Session session = SessionProvider.getSession();
		System.out.println(session);

		session.beginTransaction();
		State s1 = new State(1, 1, Area.LARGE, "UP");
		State s2 = new State(2, 1, Area.MEDIUM, "MP");
		State s3 = new State(3, 1, Area.SMALL, "HP");

		Map<Area, State> map = new HashMap<>();
		map.put(Area.LARGE, s1);
		map.put(Area.MEDIUM, s2);
		map.put(Area.SMALL, s3);

		Country c = new Country(1, "India", map);
		session.persist(c);

		session.getTransaction().commit();
		System.out.println("Projects are run sucessfully.....");
	}

}
