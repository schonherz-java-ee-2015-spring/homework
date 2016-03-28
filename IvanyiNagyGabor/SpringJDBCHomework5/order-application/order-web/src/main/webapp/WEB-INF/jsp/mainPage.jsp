<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #000033;
	color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/CSSList.css" var="listCss" />
<link href="${listCss}" rel="stylesheet" />

<title>Welcome</title>
</head>
<body>
	<center>
		<h1>WELCOME</h1>
	</center>
	<br>

	<div class="CSSList">
		<ul>
			<li><h3>
					<a href="/order-web/user/createUser">Create user</a>
				</h3></li>
			<li><h3>
					<a href="/order-web/product/createProduct">Create product</a>
				</h3></li>
			<li><h3>
					<a href="/order-web/order/createOrder">Create order</a>
				</h3></li>
			<li><h3>
					<a href="/order-web/user/userDetails">Show all user</a>
				</h3></li>
			<li><h3>
					<a href="/order-web/product/productDetails">Show all product</a>
				</h3></li>
			<li><h3>
					<a href="/order-web/order/orderDetails">Show all order</a>
				</h3></li>
		</ul>
	</div>

</body>
</html>