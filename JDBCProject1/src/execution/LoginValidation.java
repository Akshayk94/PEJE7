package execution;

import java.sql.*;
import java.util.Scanner;

/*Q.9 Accept username and password from end user
 * compare your details with db table records\
 * print msg of confirmation*/


public class LoginValidation
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
		
		//sql query to fetch username & password from db table
		String query="select username,password from login_data";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			boolean b=false;
			
			while(rs.next())
			{
				String dbuser=rs.getString("username");
				String dbpassword=rs.getString("password");
				
				//dynamic validation
				if(user.equals(dbuser) && password.equals(dbpassword))
				{
					b=true;
				}
			}
			if(b==true)
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
