package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_data")
@DiscriminatorValue("PER")
public class PermanentEmployee extends Employee
{
	@Column(name="designation")
	private String employeeDesignation;

	public String getEmployeeDesignation()
	{
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation)
	{
		this.employeeDesignation = employeeDesignation;
	}
}
