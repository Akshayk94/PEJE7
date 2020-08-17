package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import domain.Student;

public class HcqlDemo1 
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
		
		//display all the objects from database table
		
		Criteria crt1=ses.createCriteria(Student.class);
		
		List<Student> studentlist1=crt1.list();
		
		for(Student s:studentlist1)
		{
			System.out.println(s);
		}
		
		System.out.println("***************************************************");
		//display data from specific column
		
		Criteria crt2=ses.createCriteria(Student.class);
		crt2.setProjection(Projections.property("studentName"));
	
		List<String> studentlist2=crt2.list();
		
		for(String s:studentlist2)
		{
			System.out.println(s);
		}
		System.out.println("***************************************************");

		//display data from two or more columns
		
		Criteria crt3=ses.createCriteria(Student.class);
		
		ProjectionList plist=Projections.projectionList();
		plist.add(Projections.property("studentName"));
		plist.add(Projections.property("studentPercentage"));
		
		crt3.setProjection(plist);
	
		List studentlist3=crt3.list();
		
		Iterator itr=studentlist3.iterator();
		
		System.out.println("NAME\tPERCENTAGE");
		System.out.println("--------------------------------");
		while(itr.hasNext())
		{
			Object[] arr1=(Object[]) itr.next();
			
			System.out.println(arr1[0]+"\t"+arr1[1]);
		}
	}
}
