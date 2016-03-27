<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Order</title>
</head>
<body>
	<table>
		<tr>
			<td><c:forEach items="${users}" var="user">
					<div>
						<ul style="marks: none;">
							<li>${user.id}-${user.name}</li>
						</ul>
					</div>
				</c:forEach></td>
			<td><c:forEach items="${products}" var="product">
					<div>
						<ul style="marks: none;">
							<li>${product.id}-${product.name}</li>
						</ul>
					</div>
				</c:forEach></td>
		</tr>
	</table>
	<br></br>
	<% if (request.getParameter("count") != null) {
	 int count = Integer.parseInt(request.getParameter("count"));  
	 if (count == 0){ 
	 %>
		<font color="red">Bad user ID or product ID!!</font>
	 <%
	}} %>
	<form:form action="createOrder" method="POST">
				<div>
			<form:input  path="userId" />
		</div>
		<div>
			<form:input path="productId" />
		</div>
		<div>
			<input type="submit" value="Submit your order">
		</div>
	</form:form>

		</body>
</html>