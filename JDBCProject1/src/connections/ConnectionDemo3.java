package connections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo3 
{
	public static void main(String[] args) 
	{
		FileReader frd=null;
		Properties prop=new Properties();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER LOADED");
			
			frd=new FileReader("G:\\PEJE7\\data\\login.properties");
			prop.load(frd);
			
			DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7", prop);
			System.out.println("CONNECTION ESTABLISHED");
			
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(frd!=null)
			{
				try
				{
					frd.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
