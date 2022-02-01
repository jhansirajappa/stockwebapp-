<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}
li {
  display: inline;
}
</style>
</head>
<body>
<%
	String name = (String)session.getAttribute("name"); 
	if(name == null) {
		response.sendRedirect("login.jsp");
	}
%>

<ul style="background-color: bisque; font-size: 36px">
<li><a href="login.jsp" target="_blank">Login</a></li> &nbsp;&nbsp;
<li><a href="home.jsp" target="_blank">Home</a></li> &nbsp;&nbsp;
<li><a href="createitem.jsp" target="_blank">Create</a></li>&nbsp;&nbsp;
<li><a href="getallitems" target="_blank">View</a></li>&nbsp;&nbsp;
<li><a href="searchitem.jsp" target="_blank">search</a></li>
<li style="float: right;" target="_blank"><a href="logout">Logout</a></li>
</ul>

</body>
</html>