<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
</head>
<body>
	<%-- VIEW LAYER=======> PRESENTATION LOGIC --%>
	
	<% double finalAmount=(double)request.getAttribute("total"); %>
	<div class="container">
		<div class="card text-white bg-info">
			<div class="card-header">
				<h2>BILL DETAILS</h2>
			</div>
			<div class="card-body">
				<h1>FINAL BILL AMOUNT IS <%=finalAmount %></h1>
			</div>
		</div>
	</div>
</body>
</html>