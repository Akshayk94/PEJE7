package execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveProductDetails 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		
		//create sql query
		String query="insert into product_data values(2,'MOBILE',35000.25)";
		
		//connectivity steps
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		
			stmt=con.createStatement();
			
			int count=stmt.executeUpdate(query);
			
			System.out.println(count+" PRODUCT INSERTED SUCCESSFULLY");
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
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
