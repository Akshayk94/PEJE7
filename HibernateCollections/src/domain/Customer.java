package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_contact")
	private int customerContact;
	
	@ElementCollection
	@CollectionTable(name="accounts", joinColumns=@JoinColumn(name="cust_ref"))
	@Column(name="account_number")
	private Set<String> accountnumbers=new HashSet<String>();
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(int customerContact) {
		this.customerContact = customerContact;
	}
	public Set<String> getAccountnumbers() {
		return accountnumbers;
	}
	public void setAccountnumbers(Set<String> accountnumbers) {
		this.accountnumbers = accountnumbers;
	}
}
