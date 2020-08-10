package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class DisplayStudent 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//LOAD THE OBJECT FROM DATABASE TABLE
		
		Student s1=ses.load(Student.class, 1);
		
		System.out.println(s1);
		
		System.out.println("STUDENT ID IS "+s1.getStudentId());

		System.out.println("STUDENT NAME IS "+s1.getStudentName());
	
		System.out.println("STUDENT STREAM IS "+s1.getStudentStream());
	
		System.out.println("STUDENT PERCENTAGE IS "+s1.getStudentPercentage());
	}

}
