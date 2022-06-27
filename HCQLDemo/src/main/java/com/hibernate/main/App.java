package com.hibernate.main;

import com.hibernate.model.User;
import com.hibernate.session.SessionProvider;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class App {

	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		User user1 = new User("Pritam Ray", 24, "Ropar", 869953562);
		User user2 = new User("Omi Verma", 28, "Asron", 700953562);
		User user3 = new User("Raj Kumar", 32, "Rail", 980323562);
		User user4 = new User("Chandan Kumar", 54, "Raj Pura", 683423562);
		User user5 = new User("Suraj Mehta", 25, "UK", 700053562);
		User user6 = new User("Ram Singh", 34, "Power Colony", 673233562);
		User user7 = new User("Omi Verma", 14, "Asron", 904141562);
		User user8 = new User("Pritam Ray", 26, "Prem Nagar", 764353562);

		Transaction transaction = session.beginTransaction();

		session.persist(user1);
		session.persist(user2);
		session.persist(user3);
		session.persist(user4);
		session.persist(user5);
		session.persist(user6);
		session.persist(user7);
		session.persist(user8);

		transaction.commit();

		Criteria criteria = session.createCriteria(User.class);

//        criteria.setFirstResult(1);
//        criteria.setMaxResults(3);
//        criteria.add(Restrictions.eq("id", 2));
//        criteria.add(Restrictions.gt("id", 5));
//        criteria.add(Restrictions.eq("city", "Ropar"));
//        criteria.add(Restrictions.between("id", 1, 5));
//        criteria.add(Restrictions.like("name", "Pritam%"));
//        criteria.addOrder(Order.asc("id"));
//        criteria.addOrder(Order.desc("id"));
//        criteria.add(Restrictions.lt("id", 4));
//        criteria.add(Restrictions.idEq(3));

//        Criterion id = Restrictions.eq("id", 1);
//        Criterion name = Restrictions.ilike("name", "Raj%");
//
//        LogicalExpression orExp = Restrictions.or(id, name);
//        criteria.add(orExp);
//        
		Criterion id = Restrictions.eq("id", 1);
		Criterion name = Restrictions.ilike("name", "%Ray");

		LogicalExpression andExp = Restrictions.and(id, name);
		criteria.add(andExp);

		List<User> users = criteria.list();
		for (User u : users) {
			System.out.println(
					u.getId() + " " + u.getName() + " " + u.getAge() + " " + u.getCity() + " " + u.getMobile());
		}
	}
}
