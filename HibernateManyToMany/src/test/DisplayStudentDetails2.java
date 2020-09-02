package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//ACCEPT COURSE ID FROM END USER AND DISPLAY LIST OF STUDENTS

public class DisplayStudentDetails2
{
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER COURSE ID");
		int id=sc1.nextInt();
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Course c=ses.get(Course.class, id);
		
		if(c!=null)
		{
			System.out.println("COURSE NAME :: "+c.getCourseName());
			System.out.println("COURSE CODE :: "+c.getCourseCode());
			
			System.out.println("*************************************");
			
			System.out.println("LIST OF ENROLLED STUDENTS");
			
			System.out.println("*************************************");

			List<Student> students=c.getStudentlist();
			System.out.println("NAME\t\tEMAIL");
			System.out.println("-----------------------------------------");
			for(Student s:students)
			{
				System.out.println(s.getStudentName()+"\t\t"+s.getStudentEmail());
				System.out.println("-----------------------------------------");

			}
		}
		else
		{
			System.out.println("COURSE DETAILS NOT FOUND");
		}
	}
}
