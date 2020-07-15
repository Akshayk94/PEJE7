package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondlink")
public class HrDepartment extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		
		String employeeName=req.getParameter("resource");
		
		pw.print("<h1>Hello "+employeeName+"</h1>");
		
		pw.print("<h1>Welcome to HR PANEL</h1>");
	}
}
