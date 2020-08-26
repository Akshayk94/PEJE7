package domain;

import javax.persistence.*;

//CHILD TABLE DOMAIN CLASS
@Entity
@Table(name="person")
public class Person 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="person_id")
	private int personId;
	
	@Column(name="person_name")
	private String personName;
	
	@Column(name="person_age")
	private int personAge;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="passport_ref")
	private Passport passRef;  //HAS-A relationship
	
	public int getPersonId() 
	{
		return personId;
	}
	public void setPersonId(int personId) 
	{
		this.personId = personId;
	}
	public String getPersonName()
	{
		return personName;
	}
	public void setPersonName(String personName) 
	{
		this.personName = personName;
	}
	public int getPersonAge() 
	{
		return personAge;
	}
	public void setPersonAge(int personAge) 
	{
		this.personAge = personAge;
	}
	public Passport getPassRef() 
	{
		return passRef;
	}
	public void setPassRef(Passport passRef) 
	{
		this.passRef = passRef;
	}
}
