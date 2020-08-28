package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Customer;
import domain.Order;

/*Accept customer id from end user and display all the order details placed
 * by specific customer*/

public class DisplayCustomerDetails 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER CUSTOMER ID");
		int id=sc1.nextInt();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Order.class);
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//load customer details from database table
		
		Customer cust=ses.load(Customer.class, id);
		
		//display customer name
		
		System.out.println("CUSTOMER NAME IS "+cust.getCustomerName());
	
		//get the list of orders placed by customer
		
		List<Order> orders=cust.getOrderlist();
		
		//print list objects
		System.out.println("LIST OF ORDERS");
		for(Order o:orders)
		{
			System.out.println(o.getOrderNumber());
		}
		
	}

}
