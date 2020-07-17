<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />

</head>
<body>
	<%
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String message=request.getParameter("msg");
		
		Date d1=new Date();
	%>
	<h1>CUSTOMER FEEDBACK</h1>
	<table class="table table-bordered table-info">
		<tr>
			<td>NAME</td>
			<td><%=username %></td>
		</tr>
		<tr>
			<td>EMAIL</td>
			<td><%=email %></td>
		</tr>
		<tr>
			<td>CONTACT</td>
			<td><%=contact %></td>
		</tr>
		<tr>
			<td>MESSAGE</td>
			<td><%=message %></td>
		</tr>
		<tr>
			<td>DATE & TIME</td>
			<td><%=d1 %></td>
		</tr>
	</table>
</body>
</html>