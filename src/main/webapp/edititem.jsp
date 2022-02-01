<%@page import="com.ty.stockwebapp.dto.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="navbar.jsp" %>
<body>
<%
	String names = (String)session.getAttribute("name"); 
	if(names == null) {
		response.sendRedirect("login.jsp");
	}
%>
<h1>Edit Student</h1>

<%Item item=(Item)session.getAttribute("myItem");  %>
	<form action="edititem" method="post">
		
		ID : <input type="number" name="id" value="<%=item.getId() %>" readonly="readonly"> </br></br>
		Name : <input type="text" name="name" value="<%=item.getName()%>"> </br></br>
		Cost : <input type="number" name="cost" value="<%=item.getCost() %>"> </br></br>
		Quantity : <input type="number" name="quantity" value="<%=item.getQuantity() %>"> </br></br>
		Type : <input type="text" name="type" value="<%=item.getType() %>"> </br></br>
		
		<input type="submit" value="Update Item">
	
	</form>
</body>
</html>