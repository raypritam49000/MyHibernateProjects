package com.hibernate.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	// same name should be inside persistence.xml
	public static final String PERSISTENCE_UNIT_NAME = "persistence-test";
	private static EntityManager entityManager;

	private EntityManagerUtil() {

	}
	
	public static EntityManager getEntityManager()
	{
		if(entityManager==null) 
		{
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		   entityManager = emFactory.createEntityManager();
		   return entityManager;
		}
		return entityManager;
	}

}
