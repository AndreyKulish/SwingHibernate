package ua.kiev.andersen.andrey.swing.project.dbadd.dbconfig;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SQLConection {
	
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory(){
	return sessionFactory = new Configuration().configure().buildSessionFactory();
	}
}
