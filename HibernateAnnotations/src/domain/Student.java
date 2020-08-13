package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//ANNOTED DOMAIN CLASS OR POJO CLASS

@Entity
@Table(name="student_data")
public class Student 
{
	@Id
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_stream")
	private String studentStream;
	
	@Column(name="student_percentage")
	private double studentPercentage;
	
	
	public int getStudentId() {
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
	public String getStudentStream() 
	{
		return studentStream;
	}
	public void setStudentStream(String studentStream)
	{
		this.studentStream = studentStream;
	}
	public double getStudentPercentage()
	{
		return studentPercentage;
	}
	public void setStudentPercentage(double studentPercentage) 
	{
		this.studentPercentage = studentPercentage;
	}
}
