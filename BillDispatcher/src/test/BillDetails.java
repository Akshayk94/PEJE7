package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstlink")
public class BillDetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//declare unit rates for customer
		
		double unitforcommercial=10.20;
		
		double unitforresidential=4.20;
		
		//Attribute
		req.setAttribute("unit1", unitforcommercial);
		
		req.setAttribute("unit2", unitforresidential);
		

		//forward the request to next servlet
		RequestDispatcher rd=req.getRequestDispatcher("nextlink");
		rd.include(req, resp);
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h3>PLEASE PAY YOUR BILL BEFORE DUE DATE</h3>");
	}
}
