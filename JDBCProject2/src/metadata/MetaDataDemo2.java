package metadata;

import java.sql.*;

public class MetaDataDemo2 
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from flight_data";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");

			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			ResultSetMetaData rsmeta=rs.getMetaData();
			
			System.out.println(rsmeta.getColumnCount());
			
			System.out.println(rsmeta.getColumnLabel(3));
			
			System.out.println(rsmeta.getColumnTypeName(2));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
}
