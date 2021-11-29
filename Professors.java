package problem1a;

import javax.persistence.*;

@Entity
@Table(name="professors")
public class Professors
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="office_number")
	private String office;
	
	@Id
	@Column(name="research_area")
	private String research;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customers customers;
	
	public Professors()
	{
		
	}
	
	public Professors(String office, String research, Customers customer)
	{
		this.office = office;
		this.research = research;
		customers = customer;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getOffice()
	{
		return office;
	}
	
	public String getResearch()
	{
		return research;
	}
	
	public void setCustomer(Customers client)
	{
		customers = client;
	}

}
