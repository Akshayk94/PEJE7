package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstlink")
public class EmployeeHome extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the values from html page
		
		String name=req.getParameter("empname");
		String designation=req.getParameter("designation");
		
		if(designation.equals("hr"))
		{
			resp.sendRedirect("secondlink?resource="+name);
		}
		else if(designation.equals("admin"))
		{
			resp.sendRedirect("thirdlink?resource="+name);
		}
	}
}
