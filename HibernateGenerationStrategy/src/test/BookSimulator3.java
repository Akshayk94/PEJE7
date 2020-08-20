package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book3;

public class BookSimulator3 
{

	public static void main(String[] args) 
	{

		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Book3.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Book3 b=new Book3();
		b.setBookName("WT");
		b.setBookPrice(1500.25);
		
		tx=ses.beginTransaction();
		
		ses.save(b);
		
		tx.commit();
		
		System.out.println("BOOK INSERTED SUCCESSFULLY");
	}

}
