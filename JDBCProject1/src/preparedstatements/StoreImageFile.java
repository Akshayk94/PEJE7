package preparedstatements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

/* Write a program to insert image file into the database table*/


public class StoreImageFile 
{
	public static void main(String[] args) 
	{
		//declare resources
		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream fin=null;
		
		//prepare sql query
		String query="insert into course_data values(?,?,?)";
		
		//connectivity steps
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, "WT");
			
			//locate the image file
			fin=new FileInputStream("G:\\PEJE7\\data\\ui.jpg");
			
			pstmt.setBinaryStream(3, fin);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" RECORD INSERTED SUCCESSFULLY");
		} 
		catch (ClassNotFoundException | SQLException | FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

}
