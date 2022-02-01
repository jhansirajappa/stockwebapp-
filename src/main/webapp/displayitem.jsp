<%@page import="com.ty.stockwebapp.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Item</title>
</head>
<%@ include file="navbar.jsp" %>
<body>



<%
	String names = (String)session.getAttribute("name"); 
	if(names == null) {
		response.sendRedirect("login.jsp");
	}
%>
	<%
	List<Item> items = (List<Item>)session.getAttribute("myItem");
if(items != null){
%>

<table border="3">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Cost</th>
		<th>Type</th>
		<th>Quantity</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	
	<%
		for(Item item : items) {
			%>
			
			<tr>
				<td><%=item.getId() %></td>
				<td><%=item.getName() %></td>
				<td><%=item.getCost() %></td>
				<td><%=item.getType() %></td>
				<td><%=item.getQuantity() %></td>
				<td>
					<a href="delete?id=<%=item.getId() %>">Delete</a>
				</td>
				<td>
					<a href="getitem?id=<%=item.getId() %>">Edit</a>
				</td>
			</tr>
			
	<%
		}
}
else
{
	%>
	<a href="searchitem.jsp">redirect</a>
	<%} 
	%>
	
		
</table>


</body>
</html>