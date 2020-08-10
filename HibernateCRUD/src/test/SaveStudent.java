package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class SaveStudent 
{
	public static void main(String[] args)
	{
		//declare resources
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		//STEP-1 ACTIVATE HIBERNATE FRAMEWORK
		cfg=new Configuration();
		
		//STEP-2 READ THE DATA FROM CFG AND MAPPING FILE
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		//STEP-3 BUILD THE CONNECTION WITH DB VENDOR
		factory=cfg.buildSessionFactory();
		
		//STEP-4 START THE SESSION WITH DB VENDOR
		ses=factory.openSession();
		
		//STEP-5 CREATE AN OBJECT OF DOMAIN CLASS
		
		Student s1=new Student();
		s1.setStudentId(1);
		s1.setStudentName("RAHUL");
		s1.setStudentStream("COMPUTER");
		s1.setStudentPercentage(61.25);
		
		//STEP-6 START THE TRANSACTION WITH DB VENDOR
		tx=ses.beginTransaction();
		
		//STEP-7 SAVE THE OBJECT OF DOMAIN CLASS
		ses.save(s1);
		
		//STEP-8 COMMIT THE TRANSACTION
		tx.commit();
		
		System.out.println("STUDENT DETAILS INSERTED SUCCESSFULLY");
	}
}
