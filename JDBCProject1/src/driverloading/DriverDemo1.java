package driverloading;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DriverDemo1
{
	public static void main(String[] args) 
	{
		//create object of driver class
		
		try 
		{
			Driver d1=new Driver();
			
			DriverManager.registerDriver(d1);
			
			System.out.println("DRIVER LOADED AND REGISTERED");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
