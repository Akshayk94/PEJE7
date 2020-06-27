package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo4 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the values from html page
		
		String student=req.getParameter("studentname");
		
		String[] courses=req.getParameterValues("course");
		
		String gender=req.getParameter("gender");
		
		//print the values
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>STUDENT NAME IS "+student.toUpperCase()+"</h1>");
		
		pw.print("<h1>GENDER IS "+gender.toUpperCase()+"</h1>");
		
		pw.print("<h1>SELECTED COURSES ARE:</h1>");
		
		for(int i=0;i<courses.length;i++)
		{
			pw.print("<h1>"+courses[i].toUpperCase()+"</h1>");
		}
		
		
	}
}
