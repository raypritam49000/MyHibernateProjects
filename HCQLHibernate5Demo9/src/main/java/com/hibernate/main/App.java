package com.hibernate.main;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Partner;
import com.hibernate.model.Person;
import com.hibernate.model.Phone;
import com.hibernate.session.SessionProvider;

public class App {
	public static void main(String[] args) {
		Session session = SessionProvider.getSession();
		System.out.println(session);

		Person person1 = new Person("Pritam Ray", "ray123@gmail.com", "Prem Nagar");
		Person person2 = new Person("Raj Kumar", "raj720@gmail.com", "Ropar");

		Phone phone1 = new Phone("8699535682", "mobile");
		Phone phone2 = new Phone("7658340987", "mobile");
		Phone phone3 = new Phone("9834569765", "landline");

		List<Phone> phone = Arrays.asList(phone1);
		List<Phone> phones = Arrays.asList(phone2, phone3);

		person1.setPhone(phone);
		person2.setPhone(phones);

		phone1.setPerson(person1);
		phone2.setPerson(person2);
		phone3.setPerson(person2);

		Partner partner = new Partner("Chandan Kumar", 46);

		Transaction transaction = session.beginTransaction();

		session.save(person1);
		session.save(person2);
		session.save(phone1);
		session.save(phone2);
		session.save(phone3);
		session.save(partner);

		transaction.commit();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Person> personRoot = criteriaQuery.from(Person.class);
		Root<Partner> partnerRoot = criteriaQuery.from(Partner.class);
		criteriaQuery.multiselect(personRoot, partnerRoot);

		Predicate personRestictions = criteriaBuilder.and(criteriaBuilder.equal(personRoot.get("address"), "Ropar"),
				criteriaBuilder.isNotEmpty(personRoot.get("phone")));

		Predicate partnerRestictions = criteriaBuilder.and(criteriaBuilder.like(partnerRoot.get("name"), "%Chandan%"),
				criteriaBuilder.equal(partnerRoot.get("age"), 46));

		criteriaQuery.where(criteriaBuilder.and(personRestictions, partnerRestictions));

		Query<Tuple> query = session.createQuery(criteriaQuery);
		List<Tuple> tuples = query.getResultList();
		
		for(Tuple tuple : tuples) {
			Person person = (Person)tuple.get(0);
			if(person!=null) {
				System.out.println(person.getId()+" "+person.getName()+" "+person.getEmail());
				List<Phone> phonesList = person.getPhone();
				for(Phone ph:phonesList) {
					System.out.println(ph.getId()+" "+ph.getNumber()+" "+ph.getPhoneType());
				}
			}
			
			Partner part = (Partner)tuple.get(1);
			System.out.println(partner);
		}

	}
}
