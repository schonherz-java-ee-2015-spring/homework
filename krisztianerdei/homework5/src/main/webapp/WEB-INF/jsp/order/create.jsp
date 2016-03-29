<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an order</title>
</head>
<body>
<form:form action="create" method="POST">
	<div>User's id:</div>
	<div><form:input path="user_id"/></div>
	<div>Product's id:</div>
	<div><form:input path="product_id"/></div>
	<div><input type="submit" value="Submit new order"></div>
</form:form>
</body>
</html>