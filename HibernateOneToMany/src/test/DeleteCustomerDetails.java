package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

/*Accept customer id from user and delete the customer
 * details along with orders*/

public class DeleteCustomerDetails
{
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER CUSTOMER ID");
		int id=sc1.nextInt();
		
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
		
		//load the customer details
		Customer c=ses.load(Customer.class, id);
		
		//delete the customer details
		
		tx=ses.beginTransaction();
		
		ses.delete(c);
		
		tx.commit();
		
		System.out.println("CUSTOMER DETAILS ARE DELETED SUCCESSFULLY");
	}

	
		
	
}
