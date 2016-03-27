<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h1>
		Products: <br>
	</h1>
	<c:forEach items="${products}" var="product">
		<div>
			<ul style="marks: none;">
				<li>Name: ${product.name}</li>
				<li>Price: ${product.price} Ft</li>
			</ul>
		</div>
	</c:forEach>
	<br></br>
	<form action="/jdbcHomeworkSpring/home/products/createProduct" method="get"><input type="submit" value="Create a new product" name="Submit" id="rm1_submit"></form>
		<br></br>
	<footer>
	<form action="/jdbcHomeworkSpring/" method="get"><input type="submit" value="Back to homepage" name="Submit" id="rm1_submit"></form>
	</footer>
</body>
</html>