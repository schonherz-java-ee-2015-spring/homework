<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create product</title>
</head>
<body>
<form:form action="create" method="POST">
	<div>Name:</div>
	<div><form:input path="name"/></div>
	<div>Price</div>
	<div><form:input path="price"/></div>
	<div><input type="submit" value="Submit new product"></div>
</form:form>
</body>
</html>