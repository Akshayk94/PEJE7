package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

public class DisplayCustomerDetails1 
{
	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Order.class);
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create a criteria for customer class
		
		Criteria crt=ses.createCriteria(Customer.class);
		
		
		//fetch the data from all the columns
		List<Customer> customers=crt.list();
		
		for(Customer c:customers)
		{
			System.out.println(c.getCustomerName());
			System.out.println(c.getCustomerContact());
			List<Order> orders=c.getOrderlist();
			
			System.out.println("ORDERS PLACED ARE");
			for(Order o:orders)
			{
				System.out.println(o.getOrderNumber());
			}
			System.out.println("------------------------------");
		}
	}
}
