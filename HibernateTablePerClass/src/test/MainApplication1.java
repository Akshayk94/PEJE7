package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Person;
import domain.Student;
import domain.Trainer;

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
		cfg=cfg.addAnnotatedClass(Person.class);
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Trainer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//CREATE OBJECT OF STUDENT
		Student s1=new Student();
		s1.setPersonName("KEDAR");
		s1.setPersonEmail("k@gmail.com");
		s1.setStudentPercentage(85.25);
		
		//CREATE OBJECT OF TRAINER
		Trainer t1=new Trainer();
		t1.setPersonName("RAHUL");
		t1.setPersonEmail("r@gmail.com");
		t1.setTrainerSalary(25000.25);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		ses.save(t1);
		
		tx.commit();
		
		System.out.println("PERSON DETAILS ARE STORED SUCCESSFULLY");
		
		
	}

}
