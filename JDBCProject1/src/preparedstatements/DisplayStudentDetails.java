package preparedstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*Q.14 display the names of all students based on user values
 *  Accept student stream from end user 
 *  display only those students having percentage greater than
 *  70 and matching the given stream*/

public class DisplayStudentDetails
{
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("ENTER STUDENT STREAM");
		String stream=sc1.next();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String query="select student_name from student_data where student_stream=? and student_percentage>70.0";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, stream);
			
			rs=pstmt.executeQuery();
			
			System.out.println("FOLLOWING ARE THE STUDENTS");
			while(rs.next())
			{
				String name=rs.getString("student_name");
				System.out.println(name);
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
