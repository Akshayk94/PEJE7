package test;

public class MainApp1 
{

	public static void main(String[] args) 
	{
		System.out.println("MAIN METHOD STARTED");
		
		try 
		{
			Class.forName("test.Central1");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("MAIN METHOD ENDED");

	}

}
