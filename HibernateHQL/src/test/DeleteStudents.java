package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Student;

public class DeleteStudents 
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
		
		//delete multiple students
		tx=ses.beginTransaction();
		
		Query q=ses.createQuery("delete from Student s where s.studentId<3");

		int count=q.executeUpdate();
		
		tx.commit();
		
		System.out.println(count+" RECORDS DELETED");
	}

}
