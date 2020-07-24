package model;

import java.sql.*;

//DAO CLASS ========> JDBC CODE

public class LoginDAO 
{
	public boolean validation(LoginDTO dto)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String endusername=dto.getUsername();
		String enduserpassword=dto.getPassword();
		boolean b=false;
		
		String query="select username,password from login_data";
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7","root","akshay");
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				String dbuser=rs.getString("username");
				String dbpassword=rs.getString("password");
				
				if(endusername.equals(dbuser) && enduserpassword.equals(dbpassword))
				{
					b=true;
				}
			}
			
			if(b==true)
			{
				return true;
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
