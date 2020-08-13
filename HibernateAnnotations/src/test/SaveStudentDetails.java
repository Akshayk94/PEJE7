package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class SaveStudentDetails 
{
	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Student s1=new Student();
		s1.setStudentId(3);
		s1.setStudentName("DINESH");
		s1.setStudentStream("COMPUTER");
		s1.setStudentPercentage(85.25);
		
		Student s2=new Student();
		s2.setStudentId(4);
		s2.setStudentName("KARAN");
		s2.setStudentStream("CIVIL");
		s2.setStudentPercentage(55.25);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		ses.save(s2);
		
		tx.commit();
		
		System.out.println("STUDENT DETAILS INSERTED SUCCESSFULLY");
	}
}
