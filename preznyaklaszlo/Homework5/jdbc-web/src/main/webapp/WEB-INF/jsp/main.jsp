<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<div>
		<ul>
			<li><h2>
					<a href="/jdbc-web/user/createUser">Create user</a>
				</h2></li>
			<li><h2>
					<a href="/jdbc-web/user/userDetails">Show users</a>
				</h2></li>
			<li><h2>
					<a href="/jdbc-web/product/createProduct">Create product</a>
				</h2></li>
			<li><h2>
					<a href="/jdbc-web/product/productDetails">Show products</a>
				</h2></li>
			<li><h2>
					<a href="/jdbc-web/order/addOrder">Create order</a>
				</h2></li>
		</ul>
	</div>

</body>
</html>