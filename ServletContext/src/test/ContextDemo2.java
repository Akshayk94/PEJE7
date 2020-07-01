package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contextlink2")
public class ContextDemo2 extends HttpServlet
{
	String course;
	String branch;
	//init method
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context=config.getServletContext();
		course=context.getInitParameter("course");
		branch=context.getInitParameter("branch");
	}
	
	//doget method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>COURSE NAME IS "+course+"</h1>");
		pw.print("<h1>BRANCH NAME IS "+branch+"</h1>");
	}
}
