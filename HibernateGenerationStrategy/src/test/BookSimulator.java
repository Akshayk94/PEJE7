package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book4;

public class BookSimulator
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Book4.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Book4 b=new Book4();
		b.setBookName("ANGULAR");
		b.setBookPrice(8000.25);
		
		tx=ses.beginTransaction();
		
		ses.save(b);
		
		tx.commit();
		
		System.out.println("BOOK INSERTED SUCCESSFULLY");

	}

}
