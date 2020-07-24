package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginDAO;
import model.LoginDTO;

//CONTROLLER LAYER

@WebServlet("/loginlink")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//FTECH THE VALUES FROM HTML PAGE
		String username=req.getParameter("user");
		String password=req.getParameter("password");
		
		//ADD THE DATA INSIDE THE DTO
		LoginDTO dto=new LoginDTO();
		dto.setUsername(username);
		dto.setPassword(password);
		
		//CALL THE VALIDATION METHOD OF DAO CLASS
		LoginDAO dao=new LoginDAO();
		boolean b=dao.validation(dto);
		
		if(b==true)
		{
			resp.sendRedirect("welcome.jsp");
		}
		else
		{
			resp.sendRedirect("index.html");
		}
	}
}
