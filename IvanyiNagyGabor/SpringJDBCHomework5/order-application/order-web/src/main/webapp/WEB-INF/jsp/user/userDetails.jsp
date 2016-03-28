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
	background-color: #003333;
}
</style>
<spring:url value="/resources/css/CSSTable.css" var="tableCss" />
<link href="${tableCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User details</title>
</head>

<body>

	<div class="CSSTable">
		<table>

			<tr>
				<td>User</td>
			</tr>

			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.name}</td>
				<tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>