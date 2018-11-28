package com.yuen.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// A SessionFactory is set up once for an application!
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml. 
								 // In Maven project, this xml file is in src/main/resources.
					.build();
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		
		return sessionFactory;
	}
			 
}
