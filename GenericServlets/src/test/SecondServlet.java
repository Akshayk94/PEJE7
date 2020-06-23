package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//create an object of date class
		
		Date d1=new Date();
		
		//create ref of PrintWriter class
		
		PrintWriter pw=resp.getWriter();
		
		//print the output
		
		pw.print("<h1 style='color:green'>Current Date and time is "+d1+"</h1>");
	}
	
}
