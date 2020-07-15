package domain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginlink")
public class Validation extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String user=req.getParameter("user");
		
		String password=req.getParameter("password");
		
		PrintWriter pw=resp.getWriter();
		
		if(user.equals("rahul") && password.equals("root"))
		{
			pw.print("<form action='nextlink' method='post'>");
			pw.print("<input type='hidden' value='"+user+"' name='enduser' />");
			pw.print("<input type='submit' value='NEXT' />");
			pw.print("</form>");
		}
		else
		{
			resp.sendRedirect("login.html");
		}
	}
}
