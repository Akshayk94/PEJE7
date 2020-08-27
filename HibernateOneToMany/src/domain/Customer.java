package domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="customer_info")
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
	
	//One Customer can place many orders
	//mappedBy attribute provides the ref of customer  present in the order class
	
	@OneToMany(mappedBy="custRef",cascade=CascadeType.ALL)
	private List<Order> orderlist; //default value null

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

	public List<Order> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	
	//add method to support multiple orders
	
	public void addOrders(Order orderref)
	{
		if(orderlist==null)
		{
			orderlist=new LinkedList<Order>();
		}
		orderlist.add(orderref);
		
		orderref.setCustRef(this);
	}
	
}
