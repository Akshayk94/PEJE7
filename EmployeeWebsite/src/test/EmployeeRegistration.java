package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerlink")
public class EmployeeRegistration extends HttpServlet
{
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		//db resource initialization
		ServletContext context=config.getServletContext();
		String drivername=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		
		try 
		{
			Class.forName(drivername);
			
			con=DriverManager.getConnection(url, user, password);
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//FETCH THE VALUES FROM HTML
		String empname=req.getParameter("empname");
		String empdesg=req.getParameter("empdesignation");
		String empsalary=req.getParameter("empsalary");
		
		double salary=Double.parseDouble(empsalary);
		
		//DECLARE JDBC RESOURCES
		PreparedStatement pstmt=null;
		
		//CREATE SQL QUERY
		String query="insert into employee_data values(?,?,?,?)";
		
		//FOLLOW JDBC CONNECTIVITY STEPS
		try 
		{
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, empname);
			pstmt.setString(3, empdesg);
			pstmt.setDouble(4, salary);
			
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			pw.print("<h1>"+count+" EMPLOYEE REGISTERED SUCCESSFULLY</h1>");
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
