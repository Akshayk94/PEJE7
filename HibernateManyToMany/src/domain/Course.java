package domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course_master")
public class Course 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_code")
	private String courseCode;
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(
				name="student_course",
				joinColumns=@JoinColumn(name="course_ref"),
				inverseJoinColumns=@JoinColumn(name="student_ref")
			  )
	private List<Student> studentlist;
	
	public int getCourseId() 
	{
		return courseId;
	}
	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}
	public String getCourseName() 
	{
		return courseName;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}
	public String getCourseCode()
	{
		return courseCode;
	}
	public void setCourseCode(String courseCode) 
	{
		this.courseCode = courseCode;
	}
	public List<Student> getStudentlist() 
	{
		return studentlist;
	}
	public void setStudentlist(List<Student> studentlist) 
	{
		this.studentlist = studentlist;
	}
	
	//add multiple students for single course
	
	public void addStudents(Student studentRef)
	{
		if(studentlist==null)
		{
			studentlist=new LinkedList<Student>();
		}
		
		studentlist.add(studentRef);
	}
}
