package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextlink")
public class BillCalculation extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		
		//fetch the values from html page
		//current reading, previous reading and customer type
		String reading1=req.getParameter("current");
		String reading2=req.getParameter("previous");
		String type=req.getParameter("customertype");
		
		//parsing
		double currentreading=Double.parseDouble(reading1);
		double previousreading=Double.parseDouble(reading2);
		
		
		//fetch the values from first servlet
		//unit rate for commercial user and residential user
		double unitforcommercial=(double) req.getAttribute("unit1");
		double unitforresidential=(double) req.getAttribute("unit2");
		
		//calculate electricity bill
		
		double totalReading=currentreading-previousreading;
		
		pw.print("<h1>BILL DETAILS</h1>");
		
		pw.print("<h2>CURRENT READING IS "+currentreading+"</h2>");
		
		pw.print("<h2>PREVIOUS READING IS "+previousreading+"</h2>");
		
		pw.print("<h2>TOTAL READING IS "+totalReading+"</h2>");
		
		if(type.equals("commercial"))
		{
			double billAmount=totalReading*unitforcommercial;
			
			pw.print("<h1 style='color:red'>FINAL BILL AMOUNT IS "+billAmount+"</h1>");
		}
		else if(type.equals("residential"))
		{
			double billAmount=totalReading*unitforresidential;
			
			pw.print("<h1 style='color:red'>FINAL BILL AMOUNT IS "+billAmount+"</h1>");
		}
	}
}
