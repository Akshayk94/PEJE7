package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CabService;

//CONTROLLER LAYER

@WebServlet(urlPatterns= {"/autobill","/primebill","/minibill"})
public class CabController extends HttpServlet
{
	CabService cs=new CabService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String choice=req.getServletPath();
		
		switch(choice)
		{
		case "/autobill": calculateAutoBill(req,resp);
							break;
							
		case "/primebill": calculatePrimeBill(req,resp);
							break;
							
		case "/minibill": calculateMiniBill(req,resp);
							break;
		}
	}

	private void calculateMiniBill(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		double totalkm=Double.parseDouble(req.getParameter("km"));
		int totalminutes=Integer.parseInt(req.getParameter("minutes"));
		
		double billamount=cs.miniBill(totalkm, totalminutes);
	
		req.setAttribute("total", billamount);
		
		RequestDispatcher rd=req.getRequestDispatcher("bill.jsp");
		rd.forward(req, resp);
	}

	private void calculatePrimeBill(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		double totalkm=Double.parseDouble(req.getParameter("km"));
		int totalminutes=Integer.parseInt(req.getParameter("minutes"));
		
		double billamount=cs.primeBill(totalkm, totalminutes);
		
		req.setAttribute("total", billamount);
		
		RequestDispatcher rd=req.getRequestDispatcher("bill.jsp");
		rd.forward(req, resp);
	}

	private void calculateAutoBill(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		double totalkm=Double.parseDouble(req.getParameter("km"));
		int totalminutes=Integer.parseInt(req.getParameter("minutes"));
	
		double billamount=cs.autoBill(totalkm, totalminutes);
		
		req.setAttribute("total", billamount);
		
		RequestDispatcher rd=req.getRequestDispatcher("bill.jsp");
		rd.forward(req, resp);
	}
}
