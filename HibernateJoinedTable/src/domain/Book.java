package domain;

import javax.persistence.*;

@Entity
@Table(name="book_data")
@PrimaryKeyJoinColumn(name="id")
public class Book extends Product
{
	@Column(name="book_author")
	private String bookAuthor;
	
	@Column(name="book_publication")
	private String bookPublication;
	
	public String getBookAuthor()
	{
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) 
	{
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublication()
	{
		return bookPublication;
	}
	public void setBookPublication(String bookPublication)
	{
		this.bookPublication = bookPublication;
	}
}
