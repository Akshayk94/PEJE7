package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

public class SaveCustomerDetails2 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENETR YOUR CUSTOMER ID");
		int id=sc1.nextInt();
		
		System.out.println("ENTER ORDER NUMBER");
		String orderno=sc1.next();
		
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
		
		//LOAD EXISTING CUSTOMER
		
		Customer c1=ses.load(Customer.class, id);
		
		//CREATE AN OBJECT OF ORDER
		
		Order o1=new Order();
		o1.setOrderNumber(orderno);
		
		//ASSOCIATION
		
		c1.addOrders(o1);
		
		tx=ses.beginTransaction();
		
		ses.save(o1); //SAVE ORDER DETAILS
		
		tx.commit();
		
		System.out.println("ORDER PLACED SUCCESSFULLY");

	}

}
