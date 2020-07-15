package domain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextlink")
public class Welcome extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String user=req.getParameter("enduser");
		
		PrintWriter pw=resp.getWriter();
		
		pw.print("<h1>Welcome "+user+"</h1>");
	}
}
