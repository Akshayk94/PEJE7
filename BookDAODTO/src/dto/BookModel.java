package dto;

//JAVA BEAN CLASS OR DTO CLASS
public class BookModel 
{
	private int bookId;
	private String bookName;
	private double bookPrice;
	private String bookAuthor;
	private int bookQty;
	
	
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
	public String getBookAuthor() 
	{
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) 
	{
		this.bookAuthor = bookAuthor;
	}
	public int getBookQty() 
	{
		return bookQty;
	}
	public void setBookQty(int bookQty) 
	{
		this.bookQty = bookQty;
	}
}
