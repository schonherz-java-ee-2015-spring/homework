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
	function allnumeric() {
		var numbers = /^[0-9]+$/;
		var inputtxt = document.forms["form"]["price"].value;
		if (inputtxt.match(numbers) && Number(inputtxt) > 0) {
			
			return true;
		} else {
			
			return false;
		}
	}
</script>

<script>
	function validateName() {
		var x = document.forms["form"]["name"].value;
		if (x == null || x.trim().length < 3) {
			return false;
		}
	}

</script>

<script>
function validateForm() {
	if (validateName() == false) {
		alert("Product name must be at least three characters");
		return false;
	}
	else if (allnumeric() == false) {
		alert('Price must be zero or greater');
		document.form.price.focus();
		return false;
	}
	else {
		alert('Succes....');
		document.form.name.focus();
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
			<h2>Create product</h2>
		</div>
		<div class="form-title">Product</div>
		<input class="form-field" type="text" name="name" /><br />
		<div class="form-title">Price ($)</div>
		<input class="form-field" type="text" name="price" /><br />
		<div class="submit-container">
			<input class="submit-button" type="submit" value="Submit" />
		</div>
	</form>
</body>
</html>