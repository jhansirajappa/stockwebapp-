<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String names = (String)session.getAttribute("name"); 
	if(names == null) {
		response.sendRedirect("login.jsp");
	}
%>
<%@ include file="navbar.jsp" %>
<body>
	
	<form action="searchitem" method="post">
		Name<input type="text" name="search">
		<select name="type">
						<option value="mobile">mobile</option>
						<option value="book">book</option>
						<option value="tv">tv</option>
		</select>
		<input type="submit">
	</form>

</body>
</html>