<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create user</title>
</head>
<body>
<% if (request.getParameter("count") != null) {
int count = Integer.parseInt(request.getParameter("count"));  
	 if (count == 0){ 
	 %>
		<font color="red">Empty text area!!</font>
	 <%
	} }%>
<form:form action="createUser" method="POST">
	<div><form:input path="name"/></div>
	<div><input type="submit" value="Submit new user"></div>
</form:form>
</body>
</html>