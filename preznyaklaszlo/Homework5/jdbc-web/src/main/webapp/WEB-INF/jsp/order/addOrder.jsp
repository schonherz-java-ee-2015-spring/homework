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
<title>Create Order</title>
</head>
<body>
	<div id="main">
		<div id="first">
			<h1>Create order form</h1>
			<form:form action="addOrder" method="POST" modelAttribute="order">
	
				<form:select path="userId">
					<c:forEach items="${userVos}" var="user">
						<form:option value="${user.id}">
							${user.name}
						</form:option>
					</c:forEach>
				</form:select>
				
				<form:select path="productId">
					<c:forEach items="${productVos}" var="product">
						<form:option value="${product.id}">
						${product.name}
						</form:option>
					</c:forEach>
				</form:select>
				
				<input type="submit" value="Add order"></input>	
				
			</form:form>

		</div>
	</div>
</body>
</html>