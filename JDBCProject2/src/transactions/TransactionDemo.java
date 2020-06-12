package transactions;

import java.sql.*;

public class TransactionDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		
		String query="delete from flight_data where flight_id=2";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");

			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			int count=stmt.executeUpdate(query);
			
			System.out.println(count+" RECORD DELETED");
			
			con.rollback();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
		

	}
}
