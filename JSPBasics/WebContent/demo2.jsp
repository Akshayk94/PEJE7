<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	table,td
	{
		border: 5px solid red;
		margin:10px;
		padding:10px;
		border-collapse: collapse;
	}
</style>

</head>
<body>
	<%-- FETCH THE VALUES FROM HTML --%>
	
	<%
		String n1=request.getParameter("no1");
		String n2=request.getParameter("no2");
		
		int num1=Integer.parseInt(n1);
		int num2=Integer.parseInt(n2);
	%>
	
	<table>
	
	<h1><%
		for(int i=num1;i<=num2;i++)
		{
			if(i%2!=0)
			{
				out.print("<tr>");
				out.print("<td>"+i+"</td>");
				out.print("</tr>");
			}
		}
	%></h1>
	</table>
	
	
	
</body>
</html>