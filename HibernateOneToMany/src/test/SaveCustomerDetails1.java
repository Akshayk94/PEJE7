package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

public class SaveCustomerDetails1 
{
	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Order.class);
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//OBJECTS OF CUSTOMER CLASS
		
		Customer c1=new Customer();
		c1.setCustomerName("RAHUL");
		c1.setCustomerContact(45896);
		
		Customer c2=new Customer();
		c2.setCustomerName("DINESH");
		c2.setCustomerContact(36985);
		
		//OBJECTS OF ORDER CLASS
		
		Order o1=new Order();
		o1.setOrderNumber("LY3697125");
		
		Order o2=new Order();
		o2.setOrderNumber("DS2458963");
		
		Order o3=new Order();
		o3.setOrderNumber("RF7455636");
		
		//ALLOCATE ORDERS FOR THE RESPECTIVE CUSTOMER
		// ASSOCIATE ORDER OBJECT WITH CUSTOMER OBJECT
		c1.addOrders(o1);
		c1.addOrders(o2);
		c2.addOrders(o3);
		
		tx=ses.beginTransaction();
		
		ses.save(c1);   // CUSTOMER 1 ===> ORDER 1, ORDER 2
		ses.save(c2);   // CUSTOMER 2 ===> ORDER 3
		
		tx.commit();
		
		System.out.println("CUSTOMER DETAILS ARE INSERTED");
		
	}
}
