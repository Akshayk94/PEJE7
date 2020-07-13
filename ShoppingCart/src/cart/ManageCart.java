package cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demolink")
public class ManageCart extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("productname");
		String price=req.getParameter("productprice");
		String add=req.getParameter("add");
		String view=req.getParameter("view");
		PrintWriter pw=resp.getWriter();
		
		if(add!=null)
		{
			//create an object of cookie class
			Cookie c1=new Cookie(name,price);
			resp.addCookie(c1);
			resp.sendRedirect("index.html");
		}
		else if(view!=null)
		{
			//display all the cookies
			Cookie[] carray=req.getCookies();
			
			for(int i=0;i<carray.length;i++)
			{
				pw.print("<h1>"+carray[i].getName()+":"+carray[i].getValue()+"</h1>");
			}
		}
	}
}
