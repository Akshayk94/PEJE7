package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import domain.Course;
import domain.Student;

//DISPLAY LIST OF ALL THE COURSES ALONG WITH STUDENTS

public class DisplayStudentDetails3 
{

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		
		cfg=new Configuration();
		cfg=cfg.configure("cfgs/hibernate.cfg.xml");
		cfg=cfg.addAnnotatedClass(Student.class);
		cfg=cfg.addAnnotatedClass(Course.class);
		
		factory=cfg.buildSessionFactory();
		
		ses=factory.openSession();
		
		Criteria crt=ses.createCriteria(Course.class);

		List<Course> courses=crt.list();
		
		for(Course c:courses)
		{
			System.out.println("COURSE NAME ::"+c.getCourseName());
			System.out.println("COURSE CODE ::"+c.getCourseCode());
		
			System.out.println("********************************");
			
			List<Student> students=c.getStudentlist();
	
			int count=students.size();
			
			System.out.println("TOTAL NUMBER OF STUDENTS ::"+count);
			/*System.out.println("NAME\t\tEMAIL");
			System.out.println("---------------------------");
			for(Student s:students)
			{
				System.out.println(s.getStudentName()+"\t\t"+s.getStudentEmail());
				System.out.println("---------------------------");
			}*/
			
			System.out.println("*******************************************");
		}
	}

}
