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

@WebServlet("/displaylink")
public class DisplayEmployee extends HttpServlet
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
		//declare database resources
		Statement stmt=null;
		ResultSet rs=null;
		PrintWriter pw=resp.getWriter();
		
		//create sql query
		String query="select * from employee_data";
		
		//follow jdbc connectivity steps
		
		try 
		{
			stmt=con.createStatement();
			
			rs=stmt.executeQuery(query);
			
			//table tag of html
			pw.print("<table style='letter-spacing:5px' border='2' width='50%'>");
			pw.print("<thead>");
			pw.print("<tr>");
			pw.print("<th>ID</th>");
			pw.print("<th>NAME</th>");
			pw.print("<th>DESIGNATION</th>");
			pw.print("<th>SALARY</th>");
			pw.print("</tr>");
			pw.print("</thead>");
			pw.print("<tbody>");
			while(rs.next())
			{
				//fetch the data from columns
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String designation=rs.getString(3);
				double salary=rs.getDouble(4);
				
				pw.print("<tr>");
				pw.print("<td>"+id+"</td>");
				pw.print("<td>"+name+"</td>");
				pw.print("<td>"+designation+"</td>");
				pw.print("<td>"+salary+"</td>");
				pw.print("</tr>");
			}
			pw.print("</tbody>");
			pw.print("</table>");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
