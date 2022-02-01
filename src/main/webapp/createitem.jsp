<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Item</title>
</head>
<%@ include file="navbar.jsp" %>
<body>
<%
	String names = (String)session.getAttribute("name"); 
	if(names == null) {
		response.sendRedirect("login.jsp");
	}
%>
<form action="createitem" method="post" >

		Name : <input type="text" name="name"> <br></br>
		Type : <input type="text" name="type"> <br></br>
		Cost : <input type="number" name="cost"><br></br>
		Quantity : <input type="number" name = "quantity"><br></br>
		
		<input type="submit" value="Create Item">

	</form>
</body>
</html>