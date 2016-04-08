<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/resources/js/validate.js" var="validateJs" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/theme/css/CSScreate.css" var="createCss" />
<link href="${createCss}" rel="stylesheet" />
<title>Create User</title>
</head>
<body>
<form class="form-container" name="form" action="createUser"
		method="POST" onsubmit="return validateFormForUser()">
		<div class="form-title">
			<h2>Create user</h2>
		</div>
		<div class="form-title">Name</div>
		<input class="form-field" type="text" name="name" /><br />
		<div class="submit-container">
			<input class="submit-button" type="submit" value="Submit" />
		</div>
	</form>

</body>
</html>