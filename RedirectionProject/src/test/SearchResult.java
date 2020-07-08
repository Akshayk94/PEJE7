package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchlink")
public class SearchResult extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch the search query from html page
		String searchquery=req.getParameter("searchfactor");
		
		//redirect the response to google application
		
		resp.sendRedirect("https://www.google.com/#q="+searchquery);
	}
}
