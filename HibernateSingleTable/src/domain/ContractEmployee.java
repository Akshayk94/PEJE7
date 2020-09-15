package domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_data")
@DiscriminatorValue("CON")
public class ContractEmployee extends Employee
{
	@Column(name="working_days")
	private int workingDays;

	public int getWorkingDays() 
	{
		return workingDays;
	}

	public void setWorkingDays(int workingDays) 
	{
		this.workingDays = workingDays;
	}
	
	
}
