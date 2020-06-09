package admin;

import java.sql.*;

public class AdminOperations
{
	static Connection con;
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peje7?user=root&password=akshay");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//add new flight details into the database table
	public void insertFlightDetails(String source,String destination,String serviceprovider,int tickets)
	{
		PreparedStatement pstmt=null;
		
		String query="insert into flight_data values(?,?,?,?,?)";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			//set the values for placeholders
			pstmt.setInt(1, 0);
			pstmt.setString(2, source);
			pstmt.setString(3, destination);
			pstmt.setString(4, serviceprovider);
			pstmt.setInt(5, tickets);
			
			int count=pstmt.executeUpdate();
			
			System.out.println(count+" FLIGHT INSERTED SUCCESSFULLY");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, null);
		}
	}
	
	//remove the details of specific flight from database table
	public void removeFlightDetails(int id)
	{
		PreparedStatement pstmt=null;
		
		String query="delete from flight_data where flight_id=?";
		
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			int count=pstmt.executeUpdate();
			
			if(count==0)
			{
				System.out.println("FLIGHT NOT FOUND");
			}
			else
			{
				System.out.println(count+" FLIGHT DELETED SUCCESSFULLY");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, pstmt, null);
		}
		
	}
	
	//display all the flight details
	public void showFlightDetails()
	{
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from flight_data";
		
		try
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			System.out.println("ID\tSOURCE\tDESTINATION\tSERVICE\tTICKETS");
			System.out.println("----------------------------------------------------------------");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String source=rs.getString(2);
				String destination=rs.getString(3);
				String service=rs.getString(4);
				int tickets=rs.getInt(5);
				
				System.out.println(id+"\t"+source+"\t"+destination+"\t\t"+service+"\t"+tickets);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			closeCostlyResources(con, stmt, rs);
		}
	}
	
	static void closeCostlyResources(Connection con,Statement stmt,ResultSet rs)
	{
		//UPCASTING Statement stmt=pstmt
		if(con!=null)
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(stmt!=null)
		{
			try 
			{
				stmt.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if(rs!=null)
		{
			try
			{
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
