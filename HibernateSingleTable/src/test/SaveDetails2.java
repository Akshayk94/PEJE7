package test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.ContractEmployee;
import domain.Employee;
import domain.PermanentEmployee;

public class SaveDetails2 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER EMPLOYEE NAME");
		String name=sc1.next();
		
		System.out.println("ENTER EMPLOYEE AGE");
		int age=sc1.nextInt();
		
		System.out.println("SELECT EMPLOYEE TYPE");
		System.out.println("1: CONTRACT EMPLOYEE");
		System.out.println("2: PERMANENT EMPLOYEE");
		
		int choice=sc1.nextInt();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Employee.class);
		cfg=cfg.addAnnotatedClass(ContractEmployee.class);
		cfg=cfg.addAnnotatedClass(PermanentEmployee.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		tx=ses.beginTransaction();
		
		if(choice==1)
		{
			System.out.println("ENTER WORKING DAYS");
			int days=sc1.nextInt();
			
			ContractEmployee c1=new ContractEmployee();
			c1.setEmployeeName(name);
			c1.setEmployeeAge(age);
			c1.setWorkingDays(days);
			ses.save(c1);
		}
		else if(choice==2)
		{
			System.out.println("ENTER DESIGNATION");
			String desg=sc1.next();
			
			PermanentEmployee p1=new PermanentEmployee();
			p1.setEmployeeName(name);
			p1.setEmployeeAge(age);
			p1.setEmployeeDesignation(desg);
			ses.save(p1);
		}
		tx.commit();
		
		System.out.println("EMPLOYEE DETAILS STORED SUCCESSFULLY");
	}

}
