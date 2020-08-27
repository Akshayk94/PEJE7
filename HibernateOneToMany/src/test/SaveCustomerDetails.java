package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

public class SaveCustomerDetails
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
		
		//CREATE OBJECT OF CUSTOMER
		Customer c1=new Customer();
		c1.setCustomerName("AJIT");
		c1.setCustomerContact(25896);
		
		//CREATE OBJECT OF ORDER
		Order o1=new Order();
		o1.setOrderNumber("FR2566314");
		
		Order o2=new Order();
		o2.setOrderNumber("ED2151556");
		
		//ADD ORDERS FOR SPECIFIC CUSTOMER
		c1.addOrders(o1);
		c1.addOrders(o2);
		
		tx=ses.beginTransaction();
		ses.save(c1);
		ses.save(o1);
		ses.save(o2);
		tx.commit();
		
		System.out.println("CUSTOMER DETAILS INSERTED");

	}

}
