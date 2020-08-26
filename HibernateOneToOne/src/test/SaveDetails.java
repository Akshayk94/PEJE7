package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Passport;
import domain.Person;

public class SaveDetails 
{
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PERSON NAME");
		String name=sc1.next();
		
		System.out.println("ENTER PERSON AGE");
		int age=sc1.nextInt();
		
		System.out.println("ENTER PASSPORT NUMBER");
		String passno=sc1.next();
		
		System.out.println("ENTER THE NAME OF COUNTRY");
		String country=sc1.next();
		
		
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
		
		//CREATE OBJECT OF PASSPORT CLASS
		
		Passport passObj=new Passport();
		passObj.setPassportNo(passno);
		passObj.setCountryName(country);
		
		//CREATE OBJECT OF PERSON CLASS
		
		Person perObj=new Person();
		perObj.setPersonName(name);
		perObj.setPersonAge(age);
		
		//ASSOCIATE PASSPORT OBJECT WITH PERSON OBJECT
		perObj.setPassRef(passObj); //CALL BY REF VARIABLE
	
		tx=ses.beginTransaction();
		
		ses.save(perObj);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS INSRTED SUCCESSFULLY");
	}
}
