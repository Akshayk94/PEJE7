<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP APP</title>

<style>
	h1
	{
		background-color: teal;
		color:white;
		padding:10px;
		margin:10px;
		border:5px solid black;
	}
</style>

</head>
<body>
	<%-- FETCH THE VALUE FROM HTML PAGE --%>
	
	<h1><%
		String name=request.getParameter("username");
	
		out.print("Welcome "+name);
	%></h1>
</body>
</html>