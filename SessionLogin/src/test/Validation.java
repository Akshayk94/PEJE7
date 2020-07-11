package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginlink")
public class Validation extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the values from HTML page
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		
		//validation
		
		if(username.equals("admin") && password.equals("india"))
		{
			//create a new session
			HttpSession ses=req.getSession(true);
			ses.setAttribute("enduser", username);
			
			//forward the request to profile page
			RequestDispatcher rd=req.getRequestDispatcher("profilelink");
			rd.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}
