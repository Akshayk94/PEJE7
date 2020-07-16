<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	#msg1
	{
		border:5px solid green;
		color:green;
		padding:20px;
	}
	#msg2
	{
		border:5px solid red;
		color:red;
		padding:20px;
	}
</style>

</head>
<body>
	<%-- FETCH THE VALUES FROM HTML --%>
	
	<%
		String username=request.getParameter("user");
		String password=request.getParameter("password");
	%>
	
	<%
		if(username.equals("ashwin") && password.equals("123"))
		{ %>
			<h1 id="msg1">LOGIN SUCCESSFUL</h1>
		<%}
		else
		{%>
			<h1 id="msg2">INVALID LOGIN DETAILS</h1>
		<%}%>
	
</body>
</html>