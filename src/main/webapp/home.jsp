<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<%
	String names = (String)session.getAttribute("name"); 
	if(names == null) {
		response.sendRedirect("login.jsp");
	}
%>

<%@ include file="navbar.jsp" %>
<h1>Hi You are in home page</h1>


</body>
</html>