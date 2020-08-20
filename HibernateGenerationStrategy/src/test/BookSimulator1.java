package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book1;

public class BookSimulator1 
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Book1.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//CREATE AN OBJECT OF DOMAIN CLASS
		
		Book1 b=new Book1();
		b.setBookName("JAVA");
		b.setBookPrice(1500.14);
		
		tx=ses.beginTransaction();
		
		ses.save(b);
		
		tx.commit();
		
		System.out.println("BOOK INSERTED SUCCESSFULLY");

	}

}
