package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//ADD NEW STUDENTS FOR AN EXISTING COURSE

public class SaveStudentCourseDetails1 
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
		
		//GET THE DETAILS OF EXISTING COURSE
		
		Course c1=ses.load(Course.class, 2);
		
		//CREATE OBJECT OF STUDENT CLASS
		
		Student s1=new Student();
		s1.setStudentName("ASHWIN");
		s1.setStudentEmail("a@gmail.com");
		
		//ADD STUDENT FOR COURSE
		c1.addStudents(s1);
		
		//TRANSACTION
		tx=ses.beginTransaction();
		
		ses.save(s1);
		
		tx.commit();
		
		System.out.println("STUDENT DETAILS INSERTED");
	}

}
