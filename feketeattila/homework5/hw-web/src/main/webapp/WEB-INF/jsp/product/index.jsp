<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Products</title>
<spring:url value="/resources/css/CSSTable.css" var="tableCss" />
<link type="text/css" rel="stylesheet" href="${tableCss}" />
<spring:url value="/resources/css/button.css" var="button" />
<link type="text/css" rel="stylesheet" href="${button}" />
</head>
<body>
	<h1 align="center">Products</h1>
	<hr />
	<div class="CSSTable">
		<table>
			<tr>
				<td>ID</td>
				<td>Product</td>
				<td>Price</td>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}$</td>
				<tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<a href="${pageContext.request.contextPath}"><button class="button">
				<span>Back</span>
			</button></a> <a href="${pageContext.request.contextPath}/addproduct"><button class="button">
				<span>New product</span>
			</button></a>
	</div>
</body>
</html>