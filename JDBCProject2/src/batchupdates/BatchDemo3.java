package batchupdates;

import java.sql.*;

public class BatchDemo3 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="delete from product_data where product_id=?";
		//String query2="insert"
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
 
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 6);
			pstmt.addBatch();
			
			pstmt.setInt(1, 5);
			
			
			int[] arr=pstmt.executeBatch();
			System.out.println(arr.length+" RECORDS AFFECTED");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		

	}
}
