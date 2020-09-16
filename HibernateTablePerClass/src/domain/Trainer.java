package domain;

import javax.persistence.Entity;

@Entity
public class Trainer extends Person
{
	private double trainerSalary;

	public double getTrainerSalary() 
	{
		return trainerSalary;
	}

	public void setTrainerSalary(double trainerSalary) 
	{
		this.trainerSalary = trainerSalary;
	}
}
