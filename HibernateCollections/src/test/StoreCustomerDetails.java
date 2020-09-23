package test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Customer;

public class StoreCustomerDetails 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Customer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//CREATE AN OBJECT OF CUSTOMER CLASS
		
		Customer c1=new Customer();
		c1.setCustomerName("ASHWIN");
		c1.setCustomerContact(986478);
		
		Set<String> accountset=c1.getAccountnumbers();
		accountset.add("GHE698741");
		accountset.add("JKL147853");
		accountset.add("CVB235893");
		accountset.add("NMO478963");
		accountset.add("SDR365782");
		
		tx=ses.beginTransaction();
		
		ses.save(c1);
		
		tx.commit();
		
		System.out.println("CUSTOMER AND ACCOUNT DETAILS ARE STORED SUCCESSFULLY");

	}

}
