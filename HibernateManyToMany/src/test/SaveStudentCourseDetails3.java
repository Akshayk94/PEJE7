package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//ADD EXISTING STUDENT FOR EXISTING COURSE

public class SaveStudentCourseDetails3 
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
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//LOAD THE DETAILS OF EXISTING STUDENT
		
		Student s1=ses.load(Student.class, 4);
		
		//LOAD THE DETAILS OF EXISTING COURSE
		
		Course c1=ses.load(Course.class, 4);
		
		s1.addCourses(c1);
		
		tx=ses.beginTransaction();
		
		ses.save(s1);
		
		tx.commit();
		
		System.out.println("COURSE DETAILS ALLOCATED FOR STUDENT");
		
	}

}
