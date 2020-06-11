package batchupdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo1 
{

	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		
		String query1="insert into login_data values(0,'root','mysql')";
		String query2="update login_data set username='pune' where id=1";
		String query3="delete from login_data where id=5";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		
			stmt=con.createStatement();
			
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			
			int[] arr=stmt.executeBatch();
			
			System.out.println(arr.length+" RECORDS AFFECTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try 
				{
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
