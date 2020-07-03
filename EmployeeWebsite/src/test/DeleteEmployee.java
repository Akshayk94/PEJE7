package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletelink")
public class DeleteEmployee extends HttpServlet
{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		ServletContext context=config.getServletContext();
		
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		
		try 
		{
			Class.forName(driver);
			
			con=DriverManager.getConnection(url, user, password);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the data from html
		String id=req.getParameter("empid");
		
		//parsing
		int employeeId=Integer.parseInt(id);
		
		//declare db resources
		PreparedStatement pstmt=null;
		PrintWriter pw=resp.getWriter();
		
		//create sql query
		String query="delete from employee_data where employee_id=?";
		
		//follow connectivity steps
		
		try
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, employeeId);
			
			int count=pstmt.executeUpdate();
			
			if(count==0)
			{
				pw.print("<h1 style='color:red'>RECORD NOT FOUND</h1>");
			}
			else
			{
				pw.print("<h1>"+count+" EMPLOYEE DELETED</h1>");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
