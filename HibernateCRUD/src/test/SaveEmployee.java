package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.Employee;

public class SaveEmployee 
{
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER EMPLOYEE ID");
		int id=sc1.nextInt();
		
		System.out.println("ENTER EMPLOYEE NAME");
		String name=sc1.next();
		
		System.out.println("ENTER EMPLOYEE SALARY");
		double salary=sc1.nextDouble();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		//create an object of employee class
		
		Employee e1=new Employee(id, name, salary);
		
		tx=ses.beginTransaction();
		
		ses.save(e1);
		
		tx.commit();
		
		System.out.println("EMPLOYEE INSERTED SUCCESSFULLY");
	}

}
