package execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* validate username and password by using dynamic sql query*/
public class LoginValidation2 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER USERNAME");
		String user=sc1.next();
		
		System.out.println("ENTER PASSWORD");
		String password=sc1.next();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select username,password from login_data where username='"+user+"' and password='"+password+"' ";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println("LOGIN SUCCESSFUL");
			}
			else
			{
				System.err.println("INVALID LOGIN DETAILS");
			}

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	
		
		
	}

}
