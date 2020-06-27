package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo5 extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetch the values from html page
		String num1=req.getParameter("no1");
		String num2=req.getParameter("no2");
		String choice1=req.getParameter("add");
		String choice2=req.getParameter("multiply");
		
		//parsing
		double n1=Double.parseDouble(num1);
		double n2=Double.parseDouble(num2);
		
		PrintWriter pw=resp.getWriter();
		
		if(choice1!=null)
		{
			pw.print("<h1>"+(n1+n2)+"</h1>");
		}
		else if(choice2!=null)
		{
			pw.print("<h1>"+(n1*n2)+"</h1>");
		}
	}
}
