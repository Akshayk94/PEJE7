package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class UpdateStudents 
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
		
		//update multiple students
		// update student_data set student_stream='COMPUTER';
		tx=ses.beginTransaction();
		
		Query q=ses.createQuery("update Student s set s.studentStream='COMPUTER'");

		int count=q.executeUpdate();
		
		tx.commit();
		
		System.out.println(count+" RECORDS UPDATED");
	}

}
