package model.entities;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="name")
	private String name;
	
	@Id
	@Column(name="address")
	private String address;
	
	public Customers()
	{
		
	}
	
	public Customers(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}

}
