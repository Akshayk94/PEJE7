package domain;

import javax.persistence.*;

@Entity
@Table(name="order_info")
public class Order
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_number")
	private String orderNumber;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="customer_ref")
	private Customer custRef;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Customer getCustRef() {
		return custRef;
	}
	public void setCustRef(Customer custRef) {
		this.custRef = custRef;
	}
}
