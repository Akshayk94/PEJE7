package metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataDemo1
{
	public static void main(String[] args) 
	{
		Connection con=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		
			DatabaseMetaData dmeta=con.getMetaData();
			
			
			System.out.println(dmeta.getDatabaseProductName());
			System.out.println(dmeta.getDatabaseProductVersion());
			System.out.println(dmeta.getDriverName());
			System.out.println(dmeta.getDriverVersion());
			System.out.println(dmeta.getURL());
			System.out.println(dmeta.getJDBCMajorVersion());
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
