package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties 
{
	public static void main(String[] args) 
	{
		FileReader frd=null;
		
		Properties prop=new Properties();
		
		try 
		{
			frd=new FileReader("G:\\PEJE7\\data\\demo.properties");
		
			prop.load(frd);
			
			String cityName=prop.getProperty("city","KEY NOT FOUND");
			String stateName=prop.getProperty("state");
			
			System.out.println("CITY NAME IS "+cityName);
			System.out.println("STATE NAME IS "+stateName);
		} 
		catch (IOException e) 
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
