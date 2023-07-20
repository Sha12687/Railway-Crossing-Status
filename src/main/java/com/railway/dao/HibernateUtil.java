  package com.railway.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	private  static Session session;
	  static {
	        try {
	        	//activate Connection with database
				  SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				// Require to start session
				 session = factory.openSession();
				//Transaction start
			
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	  public static Session getSessionFactory() {
	        return session;
	    }
}
