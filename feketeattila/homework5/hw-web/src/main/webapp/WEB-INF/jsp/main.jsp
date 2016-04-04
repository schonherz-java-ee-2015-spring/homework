<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Main page</title>
<spring:url value="/resources/css/button.css" var="button" />
<link type="text/css" rel="stylesheet" href="${button}" />
</head>
<body>
<%--TODO <%=request.getContextPath()%> --%>
	<h1 align="center">Main page</h1>
	<hr />
	<div align="center">
		<a href="${pageContext.request.contextPath}/order"><button
				class="button">
				<span>Orders</span>
			</button></a> <a href="${pageContext.request.contextPath}/product"><button
				class="button">
				<span>Products</span>
			</button></a> <a href="${pageContext.request.contextPath}/user"><button
				class="button">
				<span>Users</span>
			</button></a>
	</div>
</body>
</html>