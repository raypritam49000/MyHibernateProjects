package com.hibernate.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Item;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Item item1 = new Item("Laptop", "Hp", 40000);
		Item item2 = new Item("Book", "DS", 400);
		Item item3 = new Item("Chair", "Java", 2000);
		Item item4 = new Item("Mobile", "MI", 16000);
		Item item5 = new Item("Pant", "Denis", 5000);
		Item item6 = new Item("Laptop", "Asus", 35000);

		Transaction transaction = session.beginTransaction();

		session.save(item1);
		session.save(item2);
		session.save(item3);
		session.save(item4);
		session.save(item5);
		session.save(item6);

		transaction.commit();

		// Resticated Query using CriteriaQuery

//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Item> cr = cb.createQuery(Item.class);
//		Root<Item> root = cr.from(Item.class);
		// cr.select(root);
		// cr.where(cb.gt(root.get("itemPrice"), 1000));
		// cr.select(root).where(cb.lt(root.get("itemPrice"), 2000));
		// cr.select(root).where(cb.like(root.get("itemName"), "%Laptop%"));
		// cr.select(root).where(cb.between(root.get("itemPrice"), 300, 5000));
		// cr.select(root).where(root.get("itemName").in("Laptop", "Book","Pant"));
		// cr.select(root).where(cb.isNull(root.get("itemDescription")));
		// cr.select(root).where(cb.isNotNull(root.get("itemDescription")));

//		Predicate[] predicates = new Predicate[2];
//		predicates[0] = cb.isNull(root.get("itemDescription"));
//		predicates[1] = cb.like(root.get("itemName"), "chair%");
//		cr.select(root).where(predicates);

//		Predicate greaterThanPrice = cb.gt(root.get("itemPrice"), 2000);
//		Predicate chairItems = cb.like(root.get("itemName"), "Chair%");
//		//cr.select(root).where(cb.or(greaterThanPrice, chairItems));
//		cr.select(root).where(cb.and(greaterThanPrice, chairItems));

		// cr.orderBy(cb.asc(root.get("itemName")), cb.desc(root.get("itemPrice")));

//		Query<Item> query = session.createQuery(cr);
//		List<Item> results = query.getResultList();
//		for (Item item : results) {
//			System.out.println(item);
//		}
//		

		// Projections, Aggregates, and Grouping Functions

//     	CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
//		Root<Item> root = cr.from(Item.class);
//		cr.select(cb.count(root));
//		Query<Long> query = session.createQuery(cr);
//		List<Long> itemProjected = query.getResultList();
//
//		for (Long item : itemProjected) {
//			System.out.println(item);
//		}

//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Double> cr = cb.createQuery(Double.class);
//		Root<Item> root = cr.from(Item.class);
//		cr.select(cb.avg(root.get("itemPrice")));
//		Query<Double> query = session.createQuery(cr);
//		List avgItemPriceList = query.getResultList();
//		System.out.println(avgItemPriceList);

		// CriteriaUpdate
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		
//		CriteriaUpdate<Item> criteriaUpdate = cb.createCriteriaUpdate(Item.class);
//		Root<Item> root = criteriaUpdate.from(Item.class);
//		criteriaUpdate.set("itemPrice",800);
//		criteriaUpdate.where(cb.equal(root.get("itemPrice"),400));
//
//		Transaction transaction1 = session.beginTransaction();
//		session.createQuery(criteriaUpdate).executeUpdate();
//		transaction1.commit();
		
		//CriteriaDelete
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Item> criteriaDelete = cb.createCriteriaDelete(Item.class);
		Root<Item> root = criteriaDelete.from(Item.class);
		criteriaDelete.where(cb.greaterThan(root.get("itemPrice"),800));

		Transaction transaction1 = session.beginTransaction();
		session.createQuery(criteriaDelete).executeUpdate();
		transaction1.commit();

	}
}
