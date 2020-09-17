package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Book;
import domain.Mobile;
import domain.Product;

public class MainApplication2 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Product.class);
		cfg=cfg.addAnnotatedClass(Book.class);
		cfg=cfg.addAnnotatedClass(Mobile.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Book b1=ses.load(Book.class, 1);
		System.out.println(b1.getProductName());
		System.out.println(b1.getProductPrice());
		System.out.println(b1.getBookAuthor());
		System.out.println(b1.getBookPublication());

	}

}
