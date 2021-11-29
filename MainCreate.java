package problem1a;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
			
			Customers client = new Customers("John Smith", "38382 Lincoln Drive, Los Angeles, CA");
			
			session.save(client);
			
			
			Professors professor = new Professors("382", "Astrophysics", client);
			
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
