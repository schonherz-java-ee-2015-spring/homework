<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/style.css" type="text/css"/>
</head>
<body>

<h1>Welcome!</h1>
<ul>
<%--TODO <%=request.getContextPath()%> --%>
	<li><a href="${pageContext.request.contextPath}/user">Show users</a></li>
    <li><a href="${pageContext.request.contextPath}/newuser">Add user</a></li>
    <li><a href="${pageContext.request.contextPath}/product">Show products</a></li>
    <li><a href="${pageContext.request.contextPath}/newproduct">Add product</a></li>
    <li><a href="${pageContext.request.contextPath}/neworder">Add order</a></li>
</ul>

<c:choose>
		<c:when test="${not empty users}">
			<c:forEach items="${users}" var="user">
				<div>
				<p>	${user.name} </p>	
				</div>
			</c:forEach>
		</c:when>
		
		<c:when test="${not empty products}">
			<c:forEach items="${products}" var="product">
				<div>
				<p>	${product.name} <br /> ${product.price} </p>	
				</div>
			</c:forEach>
		</c:when>
		
		<c:when test="${not empty user}">
			<form:form action="newuser" method="POST" modelAttribute="user">
				<form:input path="name"/>
				<input type="submit" value="Add user"></input>	
			</form:form>
		</c:when>
		
		<c:when test="${not empty product}">
			<form:form action="newproduct" method="POST" modelAttribute="product">
				<form:input path="name"/>
				<input type="submit" value="Add product"></input>	
			</form:form>
		</c:when>
		
		<c:when test="${not empty order}">
			<form:form action="neworder" method="POST" modelAttribute="order">
	
				<form:select path="user_id">
					<c:forEach items="${users_}" var="user_">
						<form:option value="${user_.id}">
							${user_.name}
						</form:option>
					</c:forEach>
				</form:select>
				
				<form:select path="product_id">
					<c:forEach items="${products_}" var="product_">
						<form:option value="${product_.id}">
						${product_.name}
						</form:option>
					</c:forEach>
				</form:select>
				
				<input type="submit" value="Add order"></input>	
				
			</form:form>
		</c:when>
		
		<c:otherwise>
 <!-- 			<h2>There is no user!</h2> -->
		</c:otherwise>
	</c:choose>
</body>
</html>