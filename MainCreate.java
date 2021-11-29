import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.entities.Customers;
import model.entities.Professors;

public class MainCreate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customers.class)
				.addAnnotatedClass(Professors.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//create Student customer
			Customers client = new Customers("John Smith", "38382 Lincoln Drive, Los Angeles, CA");
			
			//persist Student Customer to database
			session.save(client);
			
			
			//create Professor customer
			Professors professor = new Professors("382", "Astrophysics", client);
			
			//persist Professor Customer to database
			session.save(professor);
		}catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        }finally {
			session.close();
			factory.close();
		}
		
	}

}
