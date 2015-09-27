package by.academy.tikhomirov.dao.utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;




public class HibernateUtil {
	   private static SessionFactory sessionFactory = buildSessionFactory();;
	    
	   public static SessionFactory buildSessionFactory() {
	       try {
	    	   Configuration configuration = new Configuration().configure();
	    	   StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
	    	   applySettings(configuration.getProperties());
	    	   sessionFactory = configuration.buildSessionFactory(builder.build());
	    	   System.out.println("Session Factory created");
	        return sessionFactory;
	      
	       } catch (Throwable ex) {
	         System.err.println("Initial SessionFactory creation failed." + ex);
	         throw new ExceptionInInitializerError(ex);
	       }
	     }

	     public static SessionFactory getSessionFactory() {
	       return sessionFactory;
	     }
	 }

