package batchupdates;

import java.sql.*;

public class BatchDemo2 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="delete from peje7.product_data where product_id=7";
		String query2="insert into peje7.student_data values(0,'SURESH',45.25,'ETC')";
		//String query2="insert into demo.testtable values(1,'asjcv')";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","akshay");
			
			stmt=con.createStatement();
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			
			
			int[] arr1=stmt.executeBatch();
			
			System.out.println(arr1.length+" RECORDS AFFECTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	
	}
}
