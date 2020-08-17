package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class DisplayStudentNames
{
	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//DISPLAY ALL THE STUDENT NAMES
		
		Query q=ses.createQuery("select s.studentName from Student s");
		
		List<String> studentnames=q.list();
		
		System.out.println("STUDENT NAMES");
		System.out.println("---------------------");
		for(String s:studentnames)
		{
			System.out.println(s);
		}
		
		//DISPLAY THE PERCENTAGE OF ALL THE STUDENTS
		
		Query q1=ses.createQuery("select s.studentPercentage from Student s");
		
		List<Double> studentpercentage=q1.list();
		
		System.out.println("PERCENTAGE");
		System.out.println("-------------------");
		for(Double d:studentpercentage)
		{
			System.out.println(d);
		}
	}
}
