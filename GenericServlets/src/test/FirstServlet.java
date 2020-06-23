package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//business logic
		
		//create a reference of PrintWriter class.
		PrintWriter pw=resp.getWriter();
		
		pw.print("THIS IS THE RESPONSE FROM SERVLET APPLICATION");
	}
}
