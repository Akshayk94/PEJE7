package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo2 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//step 1: fetch the values from html page.
		String name=req.getParameter("studentname");
		
		String stream=req.getParameter("studentstream");
		
		//step 2: print information with welcome message.
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>Welcome "+name.toUpperCase()+"</h1>");
		
		pw.print("<h1>YOUR STREAM IS "+stream.toUpperCase()+"</h1>");
	}
}
