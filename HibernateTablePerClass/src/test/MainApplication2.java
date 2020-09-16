package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Person;
import domain.Student;
import domain.Trainer;

public class MainApplication2 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Person.class);
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Trainer.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Person p=ses.load(Person.class, 1);
		
		System.out.println(p.getPersonName());
		System.out.println(p.getPersonEmail());
		
		System.out.println("*********************************");
		
		Student s=ses.load(Student.class, 1);
		System.out.println(s.getPersonName());
		System.out.println(s.getPersonEmail());
		System.out.println(s.getStudentPercentage());
		
		System.out.println("*********************************");

		Trainer t=ses.load(Trainer.class, 2);
		System.out.println(t.getPersonName());
		System.out.println(t.getPersonEmail());
		System.out.println(t.getTrainerSalary());
	}

}
