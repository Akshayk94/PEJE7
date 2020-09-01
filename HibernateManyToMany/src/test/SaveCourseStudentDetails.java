package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//SAVE STUDENT AND COURSE DETAILS
//ADD MULTIPLE STUDENTS FOR SINGLE COURSE

public class SaveCourseStudentDetails 
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
		
		//CREATE OBJECT OF COURSE
		
		Course c1=new Course();
		c1.setCourseName("FRAMEWORK");
		c1.setCourseCode("FR0003");
		
		//CREATE OBJECTS OF STUDENT 
		
		Student s1=new Student();
		s1.setStudentName("SURESH");
		s1.setStudentEmail("s@gmail.com");
		
		Student s2=new Student();
		s2.setStudentName("MAYUR");
		s2.setStudentEmail("m@gmail.com");
		
		//ADD STUDENTS FOR COURSE
		c1.addStudents(s1);
		c1.addStudents(s2);
		
		//TRANSACTION
		
		tx=ses.beginTransaction();
		
		ses.save(c1);
		ses.save(s1);
		ses.save(s2);

		tx.commit();
		
		System.out.println("COURSE DETAILS INSERTED");
	}

}
