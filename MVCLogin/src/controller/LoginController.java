package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginService;

//CONTROLLER LAYER

@WebServlet("/loginlink")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the data from html page
		String user=req.getParameter("user");
		String password=req.getParameter("password");
		
		//call the method of service class
		LoginService service=new LoginService();
		boolean result=service.validation(user, password);
		
		if(result==true)
		{
			resp.sendRedirect("welcome.jsp");
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}
