package execution;

import java.sql.*;
import java.util.Scanner;

/*Q.7 write a jdbc program to accept product id from end user
 * and display all the details of specific product
 * if product id is invalid then show product not found msg*/

public class SearchProduct 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		//declare resources
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		//sql query
		String query="select * from product_data where product_id="+id;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				int pid=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				
				System.out.println(pid+"\t"+name+"\t"+price);
			}
			else
			{
				System.out.println("PRODUCT NOT FOUND");
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
