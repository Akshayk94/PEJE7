package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

/*Accept order id from end user and delete order details
 * without affecting customer details*/

public class DeleteOrderDetails 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER THE ORDER ID");
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
		
		//load the order details from database table.
		
		Order orderref=ses.load(Order.class, id);
		
		tx=ses.beginTransaction();
		
		ses.delete(orderref);
		
		tx.commit();
		
		System.out.println("ORDER DETAILS ARE DELETED");
	}
}
