<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #000066;
}
</style>
<spring:url value="/resources/css/CSSRollList.css" var="cssRollList" />
<link href="${cssRollList}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>

</body>

<div id="main">
	<div id="first">
		<h1>Styled Drop-Down Field in Form</h1>
		<form id="myform" name="form" action="addOrder" method="POST"
			onsubmit="validateForm()">
			<h2>User:</h2><select name="userId">
				<c:forEach items="${userList}" var="value">
					<option value="${value.id}">${value.name}</option>
				</c:forEach>
			</select> <h2>Product:</h2> <select name="productId">
				<c:forEach items="${productList}" var="value">
					<option value="${value.id}">${value.name}</option>
				</c:forEach>
			</select> <input class="submit" type="submit" value="Submit">
		</form>
	</div>
</div>




</body>
</html>