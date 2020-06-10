package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.BookModel;

//DAO CLASS 
public class BookDao 
{
	static Connection con;
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public int addBooks(BookModel bm)//call by ref var
	{
		//insert query
		int count=0;
		PreparedStatement pstmt=null;
		
		String query="insert into book_data values(?,?,?,?,?)";
		
		try
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, bm.getBookName());
			pstmt.setDouble(3, bm.getBookPrice());
			pstmt.setString(4, bm.getBookAuthor());
			pstmt.setInt(5, bm.getBookQty());
			
			count=pstmt.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public int deleteBooks(BookModel bm)
	{
		int count=0;
		PreparedStatement pstmt=null;
		
		//delete query
		String query="delete from book_data where book_id=?";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, bm.getBookId());
			
			count=pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public List<BookModel> showBooks() 
	{
		Statement stmt=null;
		ResultSet rs=null;
		
		List<BookModel> booklist=new ArrayList<BookModel>();
		
		String query="select * from book_data";
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				String author=rs.getString(4);
				int qty=rs.getInt(5);
				
				//create object DTO Class
				BookModel bm=new BookModel();
				bm.setBookId(id);
				bm.setBookName(name);
				bm.setBookPrice(price);
				bm.setBookAuthor(author);
				bm.setBookQty(qty);
				
				booklist.add(bm);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return booklist;
	}
}
