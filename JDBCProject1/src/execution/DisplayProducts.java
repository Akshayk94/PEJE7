package execution;

import java.sql.*;

/*Q.6 write a jdbc program to display all the records of product table*/

public class DisplayProducts 
{
	public static void main(String[] args) 
	{
		//declare resources
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_data";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt("product_id");
				String name=rs.getString("product_name");
				double price=rs.getDouble("product_price");
				
				System.out.println("PRODUCT ID IS "+id);
				System.out.println("PRODUCT NAME IS "+name);
				System.out.println("PRODUCT PRICE IS "+price);
				System.out.println("-----------------------------------------------------");
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
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
			
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
