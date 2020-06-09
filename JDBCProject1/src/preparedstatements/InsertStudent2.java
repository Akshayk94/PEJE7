package preparedstatements;
/*Q.12 write a jdbc program to insert 3 students at a same 
 * time by using prepared statement*/

import java.sql.*;

public class InsertStudent2
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		//sql query
		String query="insert into student_data values(?,?,?,?)";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
			
			pstmt=con.prepareStatement(query);//compilation
			pstmt.setInt(1, 0);
			pstmt.setString(2, "NIKHIL");
			pstmt.setDouble(3, 85.36);
			pstmt.setString(4, "CIVIL");
			
			int count1=pstmt.executeUpdate();//execution 1
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, "DINESH");
			pstmt.setDouble(3, 55.25);
			pstmt.setString(4, "IT");
			
			int count2=pstmt.executeUpdate();// execution 2
			
			System.out.println(count1+count2+" RECORD INSERTED");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
