package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class DisplayStudents 
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
		
		//HQL to display all the records from table
		Query q=ses.createQuery("from Student s");

		List<Student> studentlist=q.list();
		
		for(Student s:studentlist)
		{
			System.out.println("STUDENT ID "+s.getStudentId());
			System.out.println("STUDENT NAME "+s.getStudentName());
			System.out.println("STUDENT STREAM "+s.getStudentStream());
			System.out.println("STUDENT PERCENTAGE "+s.getStudentPercentage());
			System.out.println("--------------------------------------");
		}
	}

}
