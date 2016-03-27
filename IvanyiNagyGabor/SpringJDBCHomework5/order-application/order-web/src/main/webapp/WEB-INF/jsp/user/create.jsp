<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<spring:url value="/resources/css/CSSForm.css" var="cssForm" />

<link href="${cssForm}" rel="stylesheet" />
<script>
	function validateForm() {
		var x = document.forms["form"]["name"].value;
		if (x == null || x.trim().length < 2) {
			alert("User name must be at least two characters");
			return false;
		} else {
			alert("Succes...");
			return true;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form class="form-container" name = "form" action="create" method="POST" onsubmit="return validateForm()">
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