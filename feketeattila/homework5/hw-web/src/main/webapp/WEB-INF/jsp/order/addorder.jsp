<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new order</title>
</head>
<body>
<form:form action="addorder" method="POST" modelAttribute="order">
	<div>ID of product: <form:input path="productId"/></div>
	<div>ID of user: <form:input path="userId"/></div>
	<div><input type="submit" value="Submit new order"></div>
</form:form>
</body>
</html>