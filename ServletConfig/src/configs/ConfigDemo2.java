package configs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemo2 extends HttpServlet
{
	String value1;
	String value2;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		value1=config.getInitParameter("language");
		value2=config.getInitParameter("version");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>LANGUAGE NAME IS "+value1+"</h1>");
		pw.print("<h1>VERSION NO IS "+value2+"</h1>");
	}
}
