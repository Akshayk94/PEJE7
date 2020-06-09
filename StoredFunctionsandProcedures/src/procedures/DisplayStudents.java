package procedures;

import java.sql.*;
import java.util.Scanner;

public class DisplayStudents
{

	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("ENTER THE STREAM OF STUDENT");
		String stream=sc1.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
			
			cstmt=con.prepareCall("{call displaycount(?,?)}");
			
			cstmt.setString(1, stream);//IN PARAMETER
			
			cstmt.registerOutParameter(2, Types.INTEGER);//OUT PARAMETER
			
			cstmt.execute();
			
			System.out.println("TOTAL NO OF STUDENTS ARE "+cstmt.getInt(2));
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		

	}

}
