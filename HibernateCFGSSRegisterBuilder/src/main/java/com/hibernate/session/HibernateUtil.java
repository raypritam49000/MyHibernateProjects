package com.hibernate.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory()
	{
		if (sessionFactory == null) 
		{
			try 
			{
				  // create the registry
				 registry = new StandardServiceRegistryBuilder().configure().build();
				 
				 // create the MetaDataResource
				 MetadataSources metadataSource = new MetadataSources(registry);
				 
				 //create the MetaData
				 Metadata metaData = metadataSource.getMetadataBuilder().build();
				 
				 //create the sessionFactory
				 sessionFactory = metaData.buildSessionFactory();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				if(registry!=null) 
				{
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}
	
	public static void shutdown() 
	{
		if(registry!=null) 
		{
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
