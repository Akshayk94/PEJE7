package domain;

import javax.persistence.*;

@Entity
@Table(name="book_data1")
public class Book1 
{
	@Id      //Primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //auto generation
	@Column(name="book_id")// column name
	private int bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="book_price")
	private double bookPrice;
	
	
	public int getBookId() 
	{
		return bookId;
	}
	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}
	public String getBookName() 
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public double getBookPrice()
	{
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) 
	{
		this.bookPrice = bookPrice;
	}
	
}
