package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpDemo3 extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the values from html page
		String name=req.getParameter("employeename");
		
		String salary=req.getParameter("employeesalary");
		
		String designation=req.getParameter("designation");
		
		double empsalary=Double.parseDouble(salary);
		
		double updatedSalary;
		
		if(designation.equals("developer"))
		{
			updatedSalary=empsalary+5000;
		}
		else
		{
			updatedSalary=empsalary+4000;
		}
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>EMPLOYEE NAME IS "+name+"</h1>");
		pw.print("<h2>UPDATED SALARY AMOUNT IS "+updatedSalary+"</h2>");
	}
}
