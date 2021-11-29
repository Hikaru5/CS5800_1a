package problem1a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
	
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Customers.class)
			.addAnnotatedClass(Professors.class)
			.buildSessionFactory();
	
	public static Session getSession() {	
		return factory.getCurrentSession();
	}

}
