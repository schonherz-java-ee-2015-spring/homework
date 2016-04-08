<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/theme/css/CSSlist.css" var="listCss" />
<link href="${listCss}" rel="stylesheet" />
<title>Create Order</title>
</head>
<body>
	<div>
		<div >
			<h1>Create Order Form</h1>
			<form id="myform" name="form" action="addOrder" method="POST"
				onsubmit="validateForm()">

				<h2>User:</h2>
				<select name="userId">
					<c:forEach items="${userVos}" var="user">
						<option value="${user.id}">${user.name}</option>
					</c:forEach>
				</select>

				<h2>Product:</h2>
				<select name="productId">
					<c:forEach items="${productVos}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select> <input class="submit" type="submit" value="Submit">
			</form>

		</div>
	</div>
</body>
</html>