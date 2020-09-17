package domain;

import javax.persistence.*;

@Entity
@Table(name="product_data")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private double productPrice;
	
	public int getProductId() 
	{
		return productId;
	}
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public double getProductPrice() 
	{
		return productPrice;
	}
	public void setProductPrice(double productPrice) 
	{
		this.productPrice = productPrice;
	}
}
