package execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*Q.8 write a jdbc program to accept min price and max price from end user
 * display all the product details within a given price range*/

public class DisplayProducts1
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER THE MIN PRICE");
		double minvalue=sc1.nextDouble();
		
		System.out.println("ENTER THE MAX PRICE");
		double  maxprice=sc1.nextDouble();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from product_data where product_price between "+minvalue+" and "+maxprice+" ";
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			System.out.println("PRODUCT ID\tPRODUCT NAME");
			System.out.println("-----------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
				System.out.println("-----------------------------------------------");

			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
