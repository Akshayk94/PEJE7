package transactions;

import java.sql.*;
import java.util.Scanner;

public class DeletRecord 
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER PRODUCT ID");
		int id=sc1.nextInt();
		
		Connection con=null;
		Statement stmt=null;
		
		String query="delete from product_data where product_id="+id;
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");

			con.setAutoCommit(false);
			
			stmt=con.createStatement();
			
			int count=stmt.executeUpdate(query);
			
			System.out.println("ARE YOU SURE?");
			System.out.println("1: YES");
			System.out.println("2: NO");
			int choice=sc1.nextInt();
			
			if(choice==1)
			{
				con.commit();
				System.out.println(count+" PRODUCT DELETED");
			}
			else if(choice==2)
			{
				con.rollback();
				System.out.println("TRANSACTION CANCELLED");
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
