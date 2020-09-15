package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="employee_data")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employee_type",discriminatorType=DiscriminatorType.STRING)
public class Employee 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="employee_age")
	private int employeeAge;
	
	public int getEmployeeId()
	{
		return employeeId;
	}
	public void setEmployeeId(int employeeId) 
	{
		this.employeeId = employeeId;
	}
	public String getEmployeeName() 
	{
		return employeeName;
	}
	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}
	public int getEmployeeAge()
	{
		return employeeAge;
	}
	public void setEmployeeAge(int employeeAge) 
	{
		this.employeeAge = employeeAge;
	}
}
