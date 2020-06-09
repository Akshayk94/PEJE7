package execution;

import java.sql.*;
import java.util.Scanner;

//Q.2 Write a jdbc program to accept the values from end user and insert into the database table


public class StoreProductDetails 
{
	public static void main(String[] args)
	{
		//accept the values from end user
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		System.out.println("ENTER PRODUCT NAME");
		String name=sc1.next();
		
		System.out.println("ENTER PRODUCT PRICE");
		double price=sc1.nextDouble();
		
		Connection con=null;
		Statement stmt=null;
		
		String query="insert into product_data values("+id+",'"+name+"',"+price+")";

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
			sc1.close();
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
