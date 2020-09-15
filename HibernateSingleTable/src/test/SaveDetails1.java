package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import domain.ContractEmployee;
import domain.Employee;
import domain.PermanentEmployee;

public class SaveDetails1 
{

	public static void main(String[] args) 
	{
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
		
		//CREATE OBJECT OF CONTRACT EMPLOYEE
		
		ContractEmployee c1=new ContractEmployee();
		c1.setEmployeeName("ROHAN");
		c1.setEmployeeAge(27);
		c1.setWorkingDays(250);
		
		//CREATE OBJECT OF PERMANENT EMPLOYEE
		PermanentEmployee p1=new PermanentEmployee();
		p1.setEmployeeName("DINESH");
		p1.setEmployeeAge(31);
		p1.setEmployeeDesignation("DEVELOPER");
		
		tx=ses.beginTransaction();
		
		ses.save(c1);
		ses.save(p1);
		
		tx.commit();
		
		System.out.println("EMPLOYEE DETAILS STORED SUCCESSFULLY");

	}

}
