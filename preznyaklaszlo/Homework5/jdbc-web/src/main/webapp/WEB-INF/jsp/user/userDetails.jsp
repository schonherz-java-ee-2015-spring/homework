<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/theme/css/CSStable.css" var="tableCss"  />
<link href="${tableCss}" rel="stylesheet" />
<title>User Details</title>
</head>
<body>
	<div class="CSStable">
		<table>

			<tr>
				<td>Users:</td>
			</tr>
				<c:forEach items="${userVos}" var="user">
				<tr>
					<td>${user.name}</td>
				<tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>