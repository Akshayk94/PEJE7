package domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="student_master")
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_email")
	private String studentEmail;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
				name="student_course",
				joinColumns=@JoinColumn(name="student_ref"),
				inverseJoinColumns=@JoinColumn(name="course_ref")
			  )
	private List<Course> courselist;
	
	public int getStudentId()
	{
		return studentId;
	}
	public void setStudentId(int studentId) 
	{
		this.studentId = studentId;
	}
	public String getStudentName() 
	{
		return studentName;
	}
	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail)
	{
		this.studentEmail = studentEmail;
	}
	public List<Course> getCourselist() 
	{
		return courselist;
	}
	public void setCourselist(List<Course> courselist) 
	{
		this.courselist = courselist;
	}
	
	//add multiple courses for single student
	
	public void addCourses(Course courseRef)
	{
		if(courselist==null)
		{
			courselist=new LinkedList<Course>();
		}
		
		courselist.add(courseRef);
	}
}
