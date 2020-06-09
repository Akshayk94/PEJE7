package model;

//BUSINESS LOGIC CLASS
public class Customer 
{
	public String customerName;
	public String customerAddress;
	
	public Customer(String customerName, String customerAddress) 
	{
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	public void displayCustomerInfo()
	{
		System.out.println("CUSTOMER NAME IS "+customerName);
		System.out.println("CUSTOMER ADDRESS IS "+customerAddress);
	}
}
