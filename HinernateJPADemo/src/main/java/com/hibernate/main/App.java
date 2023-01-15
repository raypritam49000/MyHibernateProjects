package com.hibernate.main;

import javax.persistence.EntityManager;

import com.hibernate.connection.EntityManagerUtil;
import com.hibernate.model.User;

public class App {

	public static void main(String[] args) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		User user = new User();
		user.setId(344);
		user.setName("Raj Kumar");
		
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		

	}

}
