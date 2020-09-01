package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//ADD NEW COURSE FOR EXISTING STUDENT

public class SaveStudentCourseDetails2
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
		
		//GET THE DETAILS OF EXISTING STUDENT
		
		Student s1=ses.load(Student.class, 1);
		
		//CREATE OBJECT OF COURSE CLASS
		
		Course c1=new Course();
		c1.setCourseName("SQL");
		c1.setCourseCode("SQ004");
		
		//ADD COURSE FOR STUDENT
		s1.addCourses(c1);
		
		//TRANSACTION
		tx=ses.beginTransaction();
		
		ses.save(c1);
		
		tx.commit();
		
		System.out.println("STUDENT DETAILS INSERTED");
	}

}
