package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class UpdatePersonDetails 
{

	public static void main(String[] args)
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Passport.class);
		cfg=cfg.addAnnotatedClass(Person.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Person p=ses.load(Person.class, 3);
		p.setPersonAge(35);
		p.getPassRef().setCountryName("USA");
		
		tx=ses.beginTransaction();
		
		ses.update(p);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS ARE UPDATED");

	}

}
