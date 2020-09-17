package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Book;
import domain.Mobile;
import domain.Product;

public class MainApplication1
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		cfg=cfg.addAnnotatedClass(Book.class);
		cfg=cfg.addAnnotatedClass(Mobile.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//CREATE OBJECT OF BOOK
		Book b1=new Book();
		b1.setProductName("JAVA BLACK BOOK");
		b1.setProductPrice(2500.36);
		b1.setBookAuthor("JAMES");
		b1.setBookPublication("SITE POINT");
		
		//CREATE OBJECT OF MOBILE
		Mobile m1=new Mobile();
		m1.setProductName("SMART PHONE");
		m1.setProductPrice(45000.25);
		m1.setMobileBrand("SAMSUNG");
		m1.setOsType("ANDROID");
		
		tx=ses.beginTransaction();
		ses.save(b1);
		ses.save(m1);
		tx.commit();
		
		System.out.println("PRODUCT DETAILS STORED SUCCESSFULLY");
		

	}

}
