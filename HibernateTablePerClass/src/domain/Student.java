package domain;

import javax.persistence.Entity;

@Entity
public class Student extends Person
{
	private double studentPercentage;

	public double getStudentPercentage() 
	{
		return studentPercentage;
	}

	public void setStudentPercentage(double studentPercentage) 
	{
		this.studentPercentage = studentPercentage;
	}
}
